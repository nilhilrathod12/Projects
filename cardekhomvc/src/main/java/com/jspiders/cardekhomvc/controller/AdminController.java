package com.jspiders.cardekhomvc.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.cardekhomvc.pojo.AdminPOJO;
import com.jspiders.cardekhomvc.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("createAccount")
	public String createAccountPage() {
		return "CreateAccount";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String name,@RequestParam String email,@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPOJO pojo=service.createAccount(name,email,username,password);
		if (pojo != null) {
			map.addAttribute("msg", "Account Created Succesfully....");
			return "Login";
		}
		map.addAttribute("msg", "Account Not Created....");
		return "CreateAccount";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "Login";
	}
	
	@PostMapping("/loginAccount")
	public String loginAccount(ModelMap map,@RequestParam String username,@RequestParam String password,HttpSession session) {
		AdminPOJO admin=service.loginAccount(username,password);
		if (admin != null) {
			session.setAttribute("login", admin);
			session.setMaxInactiveInterval(10000);
			return "Home";
		}
		map.addAttribute("msg", "Invalid Username/Password");
		return "Login";
	}
	@GetMapping("/logout")
	public String logoutPage() {
		return "Login";
	}

}
