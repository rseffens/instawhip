package com.robertseffens.instawhip.repositories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertseffens.instawhip.models.Car;
import com.robertseffens.instawhip.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	

	
	//<!-- Create / Update
	
	public Car save(Car s) {
		return carRepository.save(s);
	}
	

	//<!-- Read -->
	
	public List<Car> getAll(){
		return carRepository.findAll();
	}
	
	
	public Car getOne(Long id) {
		Optional<Car>s=carRepository.findById(id);
		if(s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
	

		//<!-- Delete -->
	

	
	public void delete(Long id) {
		carRepository.deleteById(id);
	}
	
}
