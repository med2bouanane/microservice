package com.demwob.training.microservice.keycloak.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-admin")
    public String testAdmin(){
        return "Test from Admin";
    }
}
