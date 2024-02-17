package com.griddynamics.reactive.course.userordersinfoproject.client;
import static com.github.tomakehurst.wiremock.client.WireMock.*;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.griddynamics.reactive.course.userordersinfoproject.model.Order;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderSearchClientImplTest {

    @Autowired
    OrderSearchClient orderSearchClient;

    private static WireMockServer wireMockServer;

    private final String successPhoneNumber = "1111111";

    @BeforeAll
    public static void init() {
        wireMockServer = new WireMockServer(8083);
        wireMockServer.start();
    }

    @AfterAll
    public static void stop() {
        wireMockServer.stop();
    }

    @Test
    void getOrdersIfSuccess() {
        stubFor(get("/orderSearchService/order/phone")
                .withQueryParam("phone", equalTo(successPhoneNumber))
                .willReturn(okJson(orderSuccessJson())));

        var result = orderSearchClient.getOrders(successPhoneNumber);

        StepVerifier.create(result)
                .expectNext(ordersSuccess())
                .verifyComplete();
    }

    private Order[] ordersSuccess() {

        return new Order[]{
                new Order(successPhoneNumber, "Order_0", "3852"),
                new Order(successPhoneNumber, "Order_1", "5256"),
                new Order(successPhoneNumber, "Order_2", "7894"),
                new Order(successPhoneNumber, "Order_3", "9822")
        };
    }

    private String orderSuccessJson() {
        return """
           [
              {
                "orderNumber": "Order_0",
                "phoneNumber": "1111111",
                "productCode": "3852"
              },{
                "orderNumber": "Order_1",
                "phoneNumber": "1111111",
                "productCode": "5256"
              },{
                "orderNumber": "Order_2",
                "phoneNumber": "1111111",
                "productCode": "7894"
              },{
                "orderNumber": "Order_3",
                "phoneNumber": "1111111",
                "productCode": "9822"
              }
           ]""";
    }
}