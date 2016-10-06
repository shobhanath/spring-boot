package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient // to connect to consul basically it will register to consul
@EnableMongoRepositories("com.example.repository") //package because of @RepositoryRestResource but not needed in spring boot
public class ManufacturerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMsApplication.class, args);
	}
}
