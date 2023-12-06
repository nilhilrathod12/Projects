package com.jspiders.cardekhorest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekhorest.pojo.AdminPOJO;
import com.jspiders.cardekhorest.response.AdminResponse;
import com.jspiders.cardekhorest.service.AdminService;


@RestController
public class AdminController {
	@Autowired
	AdminService service;
	
	
	@PostMapping(path = "/createAccount" ,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAccount(@RequestBody AdminPOJO pojo){
		AdminPOJO admin=service.createAccount(pojo);
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account created Succesfully...", admin),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account Not Create", null),HttpStatus.NOT_ACCEPTABLE);
		
		
	}
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> login(@RequestBody AdminPOJO pojo){
		AdminPOJO admin=service.login(pojo);
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("login Succesful..", admin),HttpStatus.OK);
		}
		return new ResponseEntity<AdminResponse>(new AdminResponse("login Failed..", null),HttpStatus.NOT_FOUND);
	}

}
