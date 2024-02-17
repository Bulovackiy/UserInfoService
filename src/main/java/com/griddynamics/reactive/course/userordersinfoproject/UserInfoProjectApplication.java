package com.griddynamics.reactive.course.userordersinfoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class UserInfoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserInfoProjectApplication.class, args);
    }

}
