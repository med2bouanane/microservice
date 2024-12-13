package com.demwob.training.microservice.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;

@Profile("tc")
public class TestInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventoryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
