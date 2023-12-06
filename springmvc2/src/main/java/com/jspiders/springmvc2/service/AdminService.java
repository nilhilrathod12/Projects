package com.jspiders.springmvc2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc2.pojo.AdminPOJO;
import com.jspiders.springmvc2.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;

	public AdminPOJO createAdmin(String username, String password) {
		AdminPOJO admin=repository.createAdmin(username,password);
		return admin;
	}

}
