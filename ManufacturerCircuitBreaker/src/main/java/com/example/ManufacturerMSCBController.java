package com.example;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manufacturer;
import com.example.service.ManufacturerService;

@RestController
public class ManufacturerMSCBController {

	@Autowired
	private ManufacturerService manufacturerService;
    /**
     * http://admin10-PC:59044/mfrPost -- if ManufacturerMS is down it will give empty object because of fallback if instances up it will give the list of object
     * @return
     * @throws URISyntaxException
     */
	@RequestMapping(value="/mfrPost",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getData() throws URISyntaxException {
		
		return manufacturerService.findAll();
		
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
