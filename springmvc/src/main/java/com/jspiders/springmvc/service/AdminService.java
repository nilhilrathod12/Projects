package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;
 
	public AdminPOJO createAccount(String username, String password) {
		AdminPOJO pojo=repository.createAccount(username,password);
		return pojo;
	}

	public AdminPOJO loginAdmin(String username, String password) {
		AdminPOJO pojo=repository.loginAdmin(username,password);
		return pojo;
	}

	public StudentPOJO getAdmin() {
		StudentPOJO pojo=repository.getAdmin();
		return pojo;
	}

}
