package com.jspiders.cardekhomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhomvc.pojo.CarPOJO;
import com.jspiders.cardekhomvc.service.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	 CarRepository repository;

	public CarPOJO addCar(String name, String brand, double price, String fueltype, int airbags) {
		CarPOJO pojo=repository.addCar(name,brand,price,fueltype,airbags);
		return pojo;
	}

	public List<CarPOJO> getCarData() {
		List<CarPOJO> cars=repository.getCarData();
		return cars;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO car=repository.removeCar(id);
		return car;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO pojo=repository.searchCar(id);
		return pojo;
	}

	public CarPOJO updateCarData(int id, String name, String brand, double price, String fueltype, int airbags) {
		CarPOJO pojo=repository.updateCarData(id,name,brand,price,fueltype,airbags);
		return pojo;
	}

}
