package com.demwob.training.microservices.product;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestLocalContainerConfig {
    @Bean
    @Profile("tc")
    @ServiceConnection
    public MongoDBContainer mongoDBContainer() {
        try (MongoDBContainer mongodbContainer = new MongoDBContainer("mongo:latest")
//                .withCopyFileToContainer(MountableFile.forHostPath("./docker/tc/mongodb/data"),"/data/db")
//                 .withFileSystemBind("./docker/tc/mongodb/data","/data/db")
                                        // ./docker/mongodb/data:/data/db
                                        //  when run twice ->  Container startup failed for image mongo:latest
             // .withReuse(true)
             // true: To maintain container UP containers are not stopped when the application is shut down
             // false by default: container start when application start-up and shut down when the application is stopped.
        ) {
            mongodbContainer.start();
            return mongodbContainer;
        }
    }
}
