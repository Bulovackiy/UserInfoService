package com.griddynamics.reactive.course.userordersinfoproject.service;

import com.griddynamics.reactive.course.userordersinfoproject.model.OrderInfo;
import com.griddynamics.reactive.course.userordersinfoproject.repository.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserInfoService {

    Flux<OrderInfo> getOrderInfoForUser(String userId);
}
