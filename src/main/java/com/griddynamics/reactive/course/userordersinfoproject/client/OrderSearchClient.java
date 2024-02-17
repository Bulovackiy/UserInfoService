package com.griddynamics.reactive.course.userordersinfoproject.client;

import com.griddynamics.reactive.course.userordersinfoproject.model.Order;
import reactor.core.publisher.Flux;

public interface OrderSearchClient {

    Flux<Order> getOrders(String phone);

}
