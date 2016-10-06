package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="LB1", configuration=CustomLoadBalancerAlgorithm.class) /*To enable load balancer*/
@EnableHypermediaSupport(type=HypermediaType.HAL) /*to support hateoas link and url*/
public class ManufacturerMSLBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMSLBApplication.class, args);
	}
}
