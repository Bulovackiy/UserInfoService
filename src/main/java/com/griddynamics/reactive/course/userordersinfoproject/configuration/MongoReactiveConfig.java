package com.griddynamics.reactive.course.userordersinfoproject.configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.griddynamics.reactive.course.userordersinfoproject.repository")
public class MongoReactiveConfig extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "admin";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.credential(MongoCredential.createCredential("root", "admin", "pwd".toCharArray()));
    }
}
