package com.griddynamics.reactive.course.userordersinfoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OrderInfo {

    private String orderNumber;
    private String userName;
    private String phoneNumber;
    private String productCode;
    private String productName;
    private String productId;

}
