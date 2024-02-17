package com.griddynamics.reactive.course.userordersinfoproject.client;

import com.griddynamics.reactive.course.userordersinfoproject.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class OrderSearchClientImpl implements OrderSearchClient {

    @Override
    public Flux<Order> getOrders(String phone) {
        WebClient client = WebClient.create("http://localhost:8083");

        return client.get().uri(uriBuilder -> uriBuilder
                        .path("/orderSearchService/order/phone")
                        .queryParam("phoneNumber", phone).build())
                .retrieve()
                .bodyToFlux(Order.class)
                .onErrorResume(e -> Flux.empty());
    }
}
