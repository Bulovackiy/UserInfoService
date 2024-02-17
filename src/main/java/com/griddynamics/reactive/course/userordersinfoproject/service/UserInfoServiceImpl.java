package com.griddynamics.reactive.course.userordersinfoproject.service;

import com.griddynamics.reactive.course.userordersinfoproject.client.OrderSearchClient;
import com.griddynamics.reactive.course.userordersinfoproject.client.ProductInfoClient;
import com.griddynamics.reactive.course.userordersinfoproject.exception.UserNotFoundException;
import com.griddynamics.reactive.course.userordersinfoproject.model.OrderInfo;
import com.griddynamics.reactive.course.userordersinfoproject.model.Product;
import com.griddynamics.reactive.course.userordersinfoproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
@AllArgsConstructor
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    UserRepository userRepository;
    OrderSearchClient orderSearchClient;
    ProductInfoClient productInfoClient;

    @Override
    public Flux<OrderInfo> getOrderInfoForUser(String userId) {
        return userRepository.findById(userId)
                .doOnNext(user -> log.info("Found user in repository: {}", user))
                .flatMapMany(user ->
                        orderSearchClient.getOrders(user.getPhone())
                                .flatMap(order ->
                                        productInfoClient.getProducts(order.getProductCode())
                                                .sort(Comparator.comparing(Product::getScore))
                                                .next()
                                                .map(product -> {
                                                    OrderInfo orderInfo = new OrderInfo();
                                                    orderInfo.setOrderNumber(order.getOrderNumber());
                                                    orderInfo.setProductCode(order.getProductCode());
                                                    orderInfo.setUserName(user.getName());
                                                    orderInfo.setProductId(product.getProductId());
                                                    orderInfo.setProductName(product.getProductName());
                                                    return orderInfo;
                                                })
                                                .switchIfEmpty(Mono.empty()))
                                .switchIfEmpty(Flux.empty()))
                .switchIfEmpty(Flux.error(new UserNotFoundException("User not found!!!")));
    }

}
