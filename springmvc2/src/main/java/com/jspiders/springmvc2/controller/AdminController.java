package com.jspiders.springmvc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc2.pojo.AdminPOJO;
import com.jspiders.springmvc2.service.AdminService;

@Controller

public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}
	@GetMapping("/login")
	public String login() {
		return "Home";
	}
	
	@GetMapping("/createAccount")
	public String createAccount() {
		return "CreateAccount";
	}
	
	@PostMapping("/createAccount")
	public String createAdmin(@RequestParam String username,@RequestParam String password,ModelMap map) {
	AdminPOJO admin	=service.createAdmin(username,password);
	
	//success
	if (admin != null) {
		map.addAttribute("msg", "Account Created Successfully....");
		return "Login";
	}
	    map.addAttribute("msg", "Account Not Create");
		return "LOgin";
		
	}

}
