package com.demwob.training.microservices.product.controllers;

import com.demwob.training.microservices.product.dto.ProductRequest;
import com.demwob.training.microservices.product.dto.ProductResponse;
import com.demwob.training.microservices.product.models.Product;
import com.demwob.training.microservices.product.repository.ProductRepository;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @LocalServerPort
    private Integer port;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();

        ProductResponse response = RestAssured.given()
                .contentType("application/json")
                .body(productRequest)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo(productRequest.name()))
                .body("description", Matchers.equalTo(productRequest.description()))
                .body("price", Matchers.is(productRequest.price().intValueExact()))
                .extract().as(ProductResponse.class);

       Product product = productRepository.findAll().stream().findFirst().orElse(Product.builder().build());
        Assertions.assertEquals(product.getId(), response.id());
    }

    private ProductRequest getProductRequest() {
        return new ProductRequest("iPhone 13", "iPhone 13", BigDecimal.valueOf(1200));
    }

}
