package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.model.Manufacturer;

@RepositoryRestResource(path="/datarest")
public interface ManufacturerRepository extends MongoRepository<Manufacturer, Integer> {
	/**
	 * http://localhost:8888/sg/datarest - GET,POST,PUT,DELETE for save,findAll etc
	 */
	
	
	/**
	 * http://localhost:8888/sg/datarest/search/findByStartDateBefore?startDate=2015-01-01
	 * pass date before 2015 means 2014
	 * @param date
	 * @return
	 */
	List<Manufacturer> findByStartDateBefore(@Param("startDate")@DateTimeFormat(iso = ISO.DATE) Date date);

}
