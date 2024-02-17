package com.griddynamics.reactive.course.userordersinfoproject.controller;

import com.griddynamics.reactive.course.userordersinfoproject.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
@AllArgsConstructor
public class OrderInfoRouterConfig {

    UserInfoService userInfoService;

    @Bean
    RouterFunction<ServerResponse> getOrderInfo(OrderInfoHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/userOrderInfoService/users/{id}/orders/info"), handler::getOrderInfo);
    }
}
