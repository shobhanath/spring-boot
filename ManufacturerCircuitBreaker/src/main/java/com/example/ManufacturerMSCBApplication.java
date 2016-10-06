package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="LB1", configuration=CustomLoadBalancerAlgorithm.class) /*To enable load balancer*/
@EnableHypermediaSupport(type=HypermediaType.HAL) /*to support hateoas link and url*/
@EnableFeignClients
@EnableHystrix
public class ManufacturerMSCBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerMSCBApplication.class, args);
	}
}
