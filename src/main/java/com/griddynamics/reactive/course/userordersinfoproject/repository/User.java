package com.griddynamics.reactive.course.userordersinfoproject.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("users")
public class User {

    @Id
    String id;

    String name;
    String phone;
}
