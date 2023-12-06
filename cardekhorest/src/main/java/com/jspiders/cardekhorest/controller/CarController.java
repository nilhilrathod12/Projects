package com.jspiders.cardekhorest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekhorest.pojo.CarPOJO;
import com.jspiders.cardekhorest.response.CarResponse;
import com.jspiders.cardekhorest.service.CarService;


@RestController
public class CarController {

	@Autowired
	CarService service;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> addCar(@RequestBody CarPOJO pojo) {
		CarPOJO car = service.addCar(pojo);
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data Added Successfully..", pojo, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Data Not Added..", null, null),
				HttpStatus.NOT_ACCEPTABLE);

	}

	@DeleteMapping(path = "remove/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> removeCar(@PathVariable int id) {
		CarPOJO pojo = service.removeCar(id);
		if (pojo != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car Remove Successfully", pojo, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car Not Removed", null, null), HttpStatus.NO_CONTENT );

	}

	@GetMapping(path = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchCar(@PathVariable int id) {
		CarPOJO pojo = service.searchCar(id);
		if (pojo != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car Data Found", pojo, null), HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car Data Not Found", null, null), HttpStatus.NOT_FOUND);

	}

	@GetMapping(path = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchAll() {
		List<CarPOJO> cars = service.searchAll();
		if (cars != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car Data Found", null, cars), HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car Data Not Found", null, null), HttpStatus.NOT_FOUND);

	}
	
	@PutMapping(path = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> updateStudent(@RequestBody CarPOJO pojo){
		CarPOJO car=service.updateCar(pojo);
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car Data Updated Successfully..", car, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car Data Not Updated..", null, null),HttpStatus.NOT_ACCEPTABLE);
		
	}

}
