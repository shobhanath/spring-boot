package com.example;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manufacturer;
import com.example.repository.ManufacturerRepository;

@RestController
public class ManufacturerController {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	/**
	 * http://localhost:8888/sg/datarest POST
	 * 
	 * { "id" : 1234, "startDate": "2015-01-01", "name":"Manufact" }
	 * 
	 */

	/**
	 * http://localhost:8888/sg/findByStartDate/2016-01-01
	 * 
	 * @param date
	 * @return
	 */
	@RequestMapping(value = "/findByStartDate/{date}")
	public List<Manufacturer> findByStartDate(@DateTimeFormat(iso = ISO.DATE) @PathVariable("date") Date date) {
		return manufacturerRepository.findByStartDateBefore(date);
	}
}
