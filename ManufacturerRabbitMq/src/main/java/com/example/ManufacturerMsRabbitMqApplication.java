package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // to connect to consul basically it will register to consul
public class ManufacturerMsRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMsRabbitMqApplication.class, args);
	}
}
