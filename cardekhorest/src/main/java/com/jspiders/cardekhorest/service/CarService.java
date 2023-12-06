package com.jspiders.cardekhorest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhorest.pojo.CarPOJO;
import com.jspiders.cardekhorest.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository repository;

	public CarPOJO addCar(CarPOJO pojo) {
		CarPOJO car=repository.addCar(pojo);
		return car;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO pojo=repository.removeCar(id);
		return pojo;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO pojo=repository.searchCar(id);
		return pojo;
	}

	public List<CarPOJO> searchAll() {
		List<CarPOJO> cars=repository.searchAll();
		return cars;
	}

	public CarPOJO updateCar(CarPOJO pojo) {
		CarPOJO car=repository.updateCar(pojo);
		return car;
	}

}
