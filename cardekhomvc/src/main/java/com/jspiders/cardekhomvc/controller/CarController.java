package com.jspiders.cardekhomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.cardekhomvc.pojo.AdminPOJO;
import com.jspiders.cardekhomvc.pojo.CarPOJO;
import com.jspiders.cardekhomvc.service.CarService;

@Controller

public class CarController {
	
	@Autowired
	 CarService service;
	
	@GetMapping("/add")
	public String addPage(@SessionAttribute(required = false,name = "login")AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars=service.getCarData();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
			}
				
			
			return "Add";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@PostMapping("/add")
	public String addCar(@SessionAttribute(required = false,name = "login")AdminPOJO admin,@RequestParam String name,@RequestParam String brand,@RequestParam double price,@RequestParam String fueltype,@RequestParam int airbags,ModelMap map) {
		if (admin != null) {
			CarPOJO pojo=service.addCar(name,brand,price,fueltype,airbags);
			if (pojo != null) {
				List<CarPOJO> cars=service.getCarData();
				map.addAttribute("cars", cars);
				map.addAttribute("msg", "Car Added Successfully......");
				return "Add";
			}
			List<CarPOJO> cars=service.getCarData();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car Not Added......");
			return "Add";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@GetMapping("/home")
	public String homePage(@SessionAttribute(required = false,name = "login")AdminPOJO admin,ModelMap map) {
	
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(required = false,name = "login")AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars=service.getCarData();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
			}
			
			return "Remove";
		}
		
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@PostMapping("/remove")
	public String removeCar(@SessionAttribute(required = false,name = "login")AdminPOJO admin,@RequestParam int id,ModelMap map) {
		if (admin != null) {
			CarPOJO car=service.removeCar(id);
			List<CarPOJO> cars=service.getCarData();
			if (car != null ) {
				map.addAttribute("cars", cars);
				map.addAttribute("msg", "Car Data Removed Successfully....");
				return "Remove";
			}
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car Data Not Removed....");
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(required = false,name = "login")AdminPOJO admin,ModelMap map) {
		
		if (admin != null) {
			List<CarPOJO> cars = service.getCarData();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@PostMapping("/update")
	public String updateCar(@SessionAttribute(required = false,name = "login")AdminPOJO admin,@RequestParam int id,ModelMap map) {
		if (admin != null) {
			CarPOJO pojo=service.searchCar(id);
			if (pojo != null) {
				map.addAttribute("car", pojo);
				return "Update";
			}
			map.addAttribute("msg", "Data Not Found");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@PostMapping("/updateCar")
	public String updateCarData(@SessionAttribute(required = false,name = "login")AdminPOJO admin,@RequestParam int id,@RequestParam String name,@RequestParam String brand,@RequestParam double price,@RequestParam String fueltype,@RequestParam int airbags,ModelMap map) {
		if (admin != null) {
			CarPOJO pojo=service.updateCarData(id,name,brand,price,fueltype,airbags);
			if (pojo != null) {
				List<CarPOJO> cars=service.getCarData();
				map.addAttribute("cars", cars);
				map.addAttribute("msg", "Car Data Updated ......");
				return "Update";
			}
			List<CarPOJO> cars=service.getCarData();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car Data Not Updated ......");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
		
	}
	
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(required = false,name = "login")AdminPOJO admin,ModelMap map) {
	
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	@PostMapping("/search")
	public String searchCar(@RequestParam int id,ModelMap map,@SessionAttribute(required = false,name = "login")AdminPOJO admin) {
		if (admin != null) {
			CarPOJO pojo=service.searchCar(id);
			if (pojo != null) {
				map.addAttribute("msg", "Car Data Found....");
				map.addAttribute("car", pojo);
				return "Search";
			}
			map.addAttribute("msg", "Car Data Not Found....");
			return "Search";
		}
		map.addAttribute("msg", "Session inactive login to procced");
		return "Login";
	}
	
	
}
