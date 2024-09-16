package com.demwob.training.microservices.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.MongoDBContainer;

@Profile("tc")
public class TestProductServiceApplication {
    public static void main(String[] args) {
//        SpringApplication.Running context =
                SpringApplication.from(ProductServiceApplication::main)
                .with(TestLocalContainerConfig.class)
                .run(args);

//        ConfigurableApplicationContext c = context.getApplicationContext();
//        TestLocalContainerConfig mongodb = c.getBean(TestLocalContainerConfig.class);
//        mongodb.mongoDBContainer().copyFileFromContainer("/data/db", "./docker/tc/mongodb/data/");

    }

    @Autowired
    MongoDBContainer mongoDBContainer;

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            mongoDBContainer.start();
            mongoDBContainer.copyFileFromContainer("/data/db", "./docker/tc/mongodb/data/");
        };
    }
}
