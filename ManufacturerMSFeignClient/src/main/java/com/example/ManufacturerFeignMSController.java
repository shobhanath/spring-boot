package com.example;

import java.net.URISyntaxException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manufacturer;

@RestController
public class ManufacturerFeignMSController {

	@Autowired
	private ManufacturerFeignClient client;
    /**
     * http://localhost:8899/mfrPost - use rest client
     * @return
     * @throws URISyntaxException
     */
	@RequestMapping(value="/mfrPost",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getData() throws URISyntaxException {

		return client.findAll();
		
	}
	
	/*@RequestMapping(value="/mfrPost",method=RequestMethod.GET)
	public Response getData() throws URISyntaxException {

		return client.findAll();
		
	}*/
	
	/**
	 * http://localhost:8899/getByDate?startDate=2016-01-01 
	 * 
	 * @param date
	 * @return
	 * @throws URISyntaxException
	 */
	@RequestMapping(value="/getByDate",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Resources<Manufacturer> getByDate(@RequestParam("startDate")@DateTimeFormat(iso = ISO.DATE)Date startDate) throws URISyntaxException {

		return client.findByDateBefore(startDate);
		
	}

}
