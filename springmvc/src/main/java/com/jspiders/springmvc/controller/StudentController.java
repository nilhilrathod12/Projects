package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Home";
		}

		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";

	}

	@GetMapping("/add")
	public String addPage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {
			List<StudentPOJO> students = service.getStudentList();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);

				return "Add";
			}
			map.addAttribute("msg", "Data Not Presented !!! ");
			return "Add";
		}

		map.addAttribute("msg", "Session inactive,Login to procced...");
		return "Login";

	}

	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {

			StudentPOJO pojo = service.addStudent(name, email, contact, address);

			// success
			if (pojo != null) {
				map.addAttribute("msg", "Data Inserted Sucessfully");
				List<StudentPOJO> students = service.getStudentList();
				map.addAttribute("students", students);

				return "Add";
			}

			// failure
			map.addAttribute("msg", "Data Not Inserted");
			List<StudentPOJO> students = service.getStudentList();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
			}

			return "Add";
		}

		map.addAttribute("msg", "Session Inactive,Login to procced");
		return "Login";

	}

	@GetMapping("/remove")
	public String removePage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {

			List<StudentPOJO> students = service.getStudentList();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);

				return "Remove";
			}
			map.addAttribute("msg", "Data Not Presented !!! ");
			return "Remove";
		}

		map.addAttribute("msg", "Session Inactive,Login to procced");
		return "Login";

	}

	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {

			StudentPOJO pojo = service.removeStudent(id);
			List<StudentPOJO> students = service.getStudentList();

			// success
			if (pojo != null) {

				map.addAttribute("msg", "Data Remove Successfully");
				map.addAttribute("students", students);
				return "Remove";
			}
			map.addAttribute("msg", "Invalid Data/Data Not Found");
			map.addAttribute("students", students);

			return "Remove";
		}
		map.addAttribute("msg", "Session Inactive,Login to procced");
		return "Login";

	}

	@GetMapping("/search")
	public String searchPage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {

		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session Inactive,Login to procced");
		return "Login";

	}

	@PostMapping("/search")
	public String searchStudent(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int id, ModelMap map) {

		if (admin != null) {

			StudentPOJO pojo = service.searchStudent(id);
			// success
			if (pojo != null) {
				map.addAttribute("student", pojo);
				return "Update";
			}
			map.addAttribute("msg", "Data Not Found");
			return "Update";

		}
		map.addAttribute("msg", "Session Inactive,Login to procced");
		return "Login";

	}

	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<StudentPOJO> students = service.getStudentList();
			map.addAttribute("students", students);
			return "Update";

		}

		map.addAttribute("msg", "Session Inactive,Login to procced...");
		return "Login";
	}

	@PostMapping("/update")
	public String updateStudent(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int id, ModelMap map) {
		if (admin != null) {

			StudentPOJO pojo = service.searchStudent(id);
			// success
			if (pojo != null) {
				map.addAttribute("student", pojo);
				return "Update";
			}
			map.addAttribute("msg", "Data Not Found");
			return "Update";

		}

		map.addAttribute("msg", "Session inactive,Login to procced...");
		return "Login";
	}

	@PostMapping("/updateStudent")
	public String updateStudentDetails(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map) {

		if (admin != null) {
			StudentPOJO pojo = service.updateStudentDetails(id, name, email, contact, address);

			if (pojo != null) {
				List<StudentPOJO> students = service.getStudentList();
				map.addAttribute("msg", "Data Updated Successfully");
				map.addAttribute("students", students);
				return "Update";
			}
			List<StudentPOJO> students = service.getStudentList();
			map.addAttribute("msg", "Data Not Updated ");
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive,Login to procced...");
		return "Login";

	}

}
