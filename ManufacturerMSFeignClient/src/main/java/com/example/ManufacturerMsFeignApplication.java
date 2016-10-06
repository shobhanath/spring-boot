package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients /*To enable @FeignClient*/
@EnableHypermediaSupport(type=HypermediaType.HAL) /*to support hateoas link and url*/
public class ManufacturerMsFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMsFeignApplication.class, args);
	}
}
