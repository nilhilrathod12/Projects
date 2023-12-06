package com.jspiders.studentmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.studentmvc.pojo.StudentPOJO;
import com.jspiders.studentmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/add")
	public String add() {
		return "Add";
	}

	@GetMapping("/search")
	public String search() {
		return "Search";
	}

	@PostMapping("/add")
	public String addStudent(@RequestParam String name,@RequestParam int marks,ModelMap map) {
		StudentPOJO pojo=service.addStudent(name,marks);
		if (pojo != null) {
			map.addAttribute("msg", "student Added Successfully");
			return "Add";
		}
		map.addAttribute("msg", "student Not Added");
		return "Add";
	}

	@PostMapping("/search")
	public String searchStudent(@RequestParam int lowerMarks,@RequestParam int UpperMarks,ModelMap map) {
		List<StudentPOJO> students=service.searchStudent(lowerMarks,UpperMarks);
		if (students != null) {
			map.add
		}
		return null;
	}

}
