package com.jspiders.springmvc.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.AdminService;

@Controller	
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map) {
		StudentPOJO pojo=service.getAdmin();
		if (pojo !=null) {
			map.addAttribute("msg", "Account already exist...");
			return "Login";
		}
		return"CreateAccount";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPOJO pojo=service.createAccount(username,password);
		if (pojo != null) {
			map.addAttribute("msg", "Account is created");
			
			return "Login";
		}
		map.addAttribute("msg", "Account not created");
		return "Login";
		
	}
	
	@PostMapping("/loginAdmin")
	public String loginAdmin(@RequestParam String username,@RequestParam String password,ModelMap map,HttpSession session) {
		AdminPOJO pojo=service.loginAdmin(username,password);
		if (pojo != null) {
			session.setAttribute("login", pojo);
			session.setMaxInactiveInterval(1000);
			return "Home";
		}
		map.addAttribute("msg", "Invalid username/password");
		return "Login";
		
	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Logout succesfully");
		return "Login";
	}

}
