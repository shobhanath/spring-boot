package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix="newConfig") //newConfig is a key in yml file in github
@RefreshScope // pull service from rabbit mq rather than push
public class RabbitMqMicroService {

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@RequestMapping("/")
	public ResponseEntity<String> loadConfigInfo(){
		
		return new ResponseEntity<String>(getData(),HttpStatus.OK);
	}
	
}
