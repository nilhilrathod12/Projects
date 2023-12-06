package com.jspiders.springcoreannotations.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class EmployeeBean {
	
	@Value("1")
	private int id;
	
	@Value("Amit")
	private String name;
	
	@Value("amit@gmail.com")
	private String email;
	
	@Value("Wakad")
	private String address;

}
