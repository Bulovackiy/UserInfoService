package com.griddynamics.reactive.course.userordersinfoproject.client;

import com.griddynamics.reactive.course.userordersinfoproject.model.Product;
import reactor.core.publisher.Flux;

public interface ProductInfoClient {

    Flux<Product> getProducts(String productCode);
}
