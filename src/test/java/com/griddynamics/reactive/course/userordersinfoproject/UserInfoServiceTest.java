package com.griddynamics.reactive.course.userordersinfoproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void test() {

        int result = Stream.of("test", "test")
                .map(String::length)
                .reduce(0, Integer::sum);
        System.out.println(result);

//        WebTestClient.bindToApplicationContext(context).build();


    }
}
