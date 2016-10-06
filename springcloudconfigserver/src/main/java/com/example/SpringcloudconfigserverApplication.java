package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer /*To enable this project as config server*/

public class SpringcloudconfigserverApplication {
	/*@Value("${newConfig.data}")
	private static String mongodbUrl;*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudconfigserverApplication.class, args);
		
		//System.out.println("Data : " + mongodbUrl);
	}
}
