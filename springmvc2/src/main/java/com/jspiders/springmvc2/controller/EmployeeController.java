package com.jspiders.springmvc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.jspiders.springmvc2.pojo.EmployeePOJO;
import com.jspiders.springmvc2.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@GetMapping("/home")
	public String homePage() {
		return "Home";
	}
	
	@GetMapping("/add")
	public String addPage(ModelMap map) {
		List<EmployeePOJO> employees=service.getEmployeeList();
		if (!employees.isEmpty()) {
			map.addAttribute("employees", employees);
		}
		return "Add";
	}
	
	@PostMapping("/add")
	public String addEmployee(@RequestParam String name,@RequestParam String email,@RequestParam long contact,@RequestParam double salary,@RequestParam String address,ModelMap map) {
		
		EmployeePOJO pojo=service.addEmployee(name,email,contact,salary,address);
		if (pojo != null) {
			List<EmployeePOJO> employees=service.getEmployeeList();
			map.addAttribute("msg", "Employee Data Added Successfully ..!!!!");
			map.addAttribute("employees", employees);
			return "Add";
		}
		List<EmployeePOJO> employees=service.getEmployeeList();
		map.addAttribute("employees", employees);
		map.addAttribute("msg", "Employee Data Not added....!!");
		return "Add";
	}
	
	@GetMapping("/remove")
	public String removePage(ModelMap map) {
		List<EmployeePOJO > employees=service.getEmployeeList();
		if (!employees.isEmpty()) {
			map.addAttribute("employees", employees);
		}
		return "Remove";
	}
	
	@PostMapping("/remove")
	public String removeEmployee(@RequestParam int id,ModelMap map) {
		EmployeePOJO pojo=service.removeEmployee(id);
		if (pojo != null) {
			List<EmployeePOJO> employees=service.getEmployeeList();
			map.addAttribute("msg","Employee Data Removed Successfully !!!!!");
			map.addAttribute("employees", employees);
			return "Remove";
		}
		@SuppressWarnings("unused")
		List<EmployeePOJO> employees=service.getEmployeeList();
		map.addAttribute("msg","Please Enter Correct Id,try again  !!!!!");
		return"Remove";
	}
	
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}
	
	@PostMapping("/search")
	public String searchEmployee(@RequestParam int id,ModelMap map) {
		EmployeePOJO pojo=service.searchEmployee(id);
		if (pojo != null) {
			map.addAttribute("employee", pojo);
			map.addAttribute("msg", "Employee Data Present !!!!");
			return "Search";
		}
		map.addAttribute("msg", "Enter Correct Id,please try again !!!!!");
		return "Search";
		
	}
	
	@GetMapping("/update")
	public String updatePage(ModelMap map) {
		List<EmployeePOJO> employees=service.getEmployeeList();
		if (!employees.isEmpty()) {
			map.addAttribute("employees", employees);
			return"Update";
		}
		return "Update";
	}
	@PostMapping("/update")
	public String updateData(@RequestParam int id,ModelMap map) {
		EmployeePOJO pojo = service.searchEmployee(id);
		if (pojo != null) {
			map.addAttribute("employee", pojo);
			return "Update";
		}
		map.addAttribute("msg", "Employee Data Not Fount.,Please try again!!!!");
		return "Upadate";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployeeData(ModelMap map,@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam long contact,@RequestParam double salary,@RequestParam String address) {
		EmployeePOJO pojo=service.updateEmployeeData(id,name,email,contact,salary,address);
		if (pojo != null ) {
			List<EmployeePOJO> employees=service.getEmployeeList();
			map.addAttribute("msg", "Data Updated Successfully");
			map.addAttribute("employees", employees);
			return "Update";
		}
		List<EmployeePOJO> employees=service.getEmployeeList();
		map.addAttribute("msg", "Data Not Updated ");
		map.addAttribute("employees", employees);
		return "Update";
	}
}
