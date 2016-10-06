package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import com.example.dao.ManufacturerFeignClient;
import com.example.model.Manufacturer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService{

	@Autowired
	private ManufacturerFeignClient manufacturerFeignClient;
	
	@Override
	@HystrixCommand(fallbackMethod="findAllFallback")
	public Resources<Manufacturer> findAll() {
		return manufacturerFeignClient.findAll();
	}
	
	public Resources<Manufacturer> findAllFallback(){
		return new Resources<Manufacturer>(){};
	}

}
