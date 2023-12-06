package com.jspiders.cardekhomvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhomvc.pojo.AdminPOJO;
import com.jspiders.cardekhomvc.pojo.CarPOJO;
import com.jspiders.cardekhomvc.service.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repository;

	public AdminPOJO createAccount(String name, String email, String username, String password) {
		AdminPOJO pojo=repository.createAccount(name,email,username,password);
		return pojo;
	}

	public AdminPOJO loginAccount(String username, String password) {
		AdminPOJO pojo=repository.loginAccount(username,password);
		return pojo;
	}

}
