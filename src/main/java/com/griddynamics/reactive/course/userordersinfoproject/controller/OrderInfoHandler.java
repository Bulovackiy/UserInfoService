package com.griddynamics.reactive.course.userordersinfoproject.controller;

import com.griddynamics.reactive.course.userordersinfoproject.model.OrderInfo;
import com.griddynamics.reactive.course.userordersinfoproject.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class OrderInfoHandler {

    UserInfoService userInfoService;

    public Mono<ServerResponse> getOrderInfo(ServerRequest request) {
        String userId = request.pathVariable("id");

        return ServerResponse
                .ok().body(userInfoService.getOrderInfoForUser(userId), OrderInfo.class);

    }
}
