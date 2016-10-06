package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.Customer;
import com.example.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

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
	@RequestMapping(value = "/save",produces={"application/json"},consumes={"application/json"})
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
}
