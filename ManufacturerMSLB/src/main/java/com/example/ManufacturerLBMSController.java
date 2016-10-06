package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Manufacturer;

@RestController
public class ManufacturerLBMSController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
    /**
     * http://localhost:8899/mfrPost - use rest client
     * @return
     * @throws URISyntaxException
     */
	@RequestMapping(value="/mfrPost",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String getData() throws URISyntaxException {
		ServiceInstance serviceInstance = 
		loadBalancerClient.choose("manufacturer-microservice");
		System.out.println("OUTPUT ------> "+serviceInstance.getPort());
		RestTemplate restTemplate = new RestTemplate();
		/*List<Manufacturer> list = new ArrayList<Manufacturer>();
		list.add(new Manufacturer());
		Resources<Manufacturer> listResource = new Resources<Manufacturer>(list);*/
		@SuppressWarnings("unchecked")
		String resources = restTemplate.getForObject(new URI(serviceInstance.getUri().toString().concat("/datarest")), String.class);
		
		return resources;
		
	}
	
	/*@RequestMapping(value="/mfrPost",method=RequestMethod.GET)
	public Response getData() throws URISyntaxException {

		return client.findAll();
		
	}*/
	/*
	*//**
	 * http://localhost:8899/getByDate?startDate=2016-01-01 
	 * 
	 * @param date
	 * @return
	 * @throws URISyntaxException
	 *//*
	@RequestMapping(value="/getByDate",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getByDate(@RequestParam("startDate")@DateTimeFormat(iso = ISO.DATE)Date startDate) throws URISyntaxException {

		return client.findByDateBefore(startDate);
		
	}*/

}
