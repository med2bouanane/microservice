package com.demwob.training.order;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;

@Profile("tc")
public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
