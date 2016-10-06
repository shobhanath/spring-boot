package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="manufacturers")
public class Manufacturer {

	@Id
	private int id;
	
	public Manufacturer() {
	}

	public Manufacturer(int id, Date startDate, String name) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.name = name;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-mm-dd")
	private Date startDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	
}
