package com.jspiders.springmvc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc2.pojo.EmployeePOJO;
import com.jspiders.springmvc2.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	public EmployeePOJO addEmployee(String name, String email, long contact, double salary, String address) {
		EmployeePOJO pojo=repository.addEmployee(name,email,contact,salary,address);
		return pojo;
	}

	public List<EmployeePOJO> getEmployeeList() {
		List<EmployeePOJO> employees=repository.getEmployeeList();
		return employees;
	}

	public EmployeePOJO removeEmployee(int id) {
		EmployeePOJO pojo=repository.removeEmployee(id);
		return pojo;
	}

	public EmployeePOJO searchEmployee(int id) {
		EmployeePOJO pojo=repository.searchEmployee(id);
		return pojo;
	}

	public EmployeePOJO updateEmployeeData(int id, String name, String email, long contact, double salary, String address) {
		EmployeePOJO pojo=repository.updateEmployeeData(id,name,email,contact,salary,address);
		return pojo;
	}

}
