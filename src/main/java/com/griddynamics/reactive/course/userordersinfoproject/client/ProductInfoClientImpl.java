package com.griddynamics.reactive.course.userordersinfoproject.client;

import com.griddynamics.reactive.course.userordersinfoproject.model.Product;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Component
public class ProductInfoClientImpl implements ProductInfoClient {

    @Override
    public Flux<Product> getProducts(String productCode) {
        WebClient client = WebClient
                .builder()
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create()
                                .responseTimeout(Duration.ofSeconds(10))))
                .baseUrl("http://localhost:8082")
                .build();

        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/productInfoService/product/names")
                        .queryParam("productCode", productCode)
                        .build())
                .retrieve()
                .bodyToFlux(Product.class);
    }
}
