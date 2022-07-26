package com.robertseffens.instawhip.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.robertseffens.instawhip.models.Car;


public interface CarRepository extends CrudRepository<Car, Long>{
	List<Car> findAll();
	
	Optional<Car> findById(Long id);
	
	
	@Query("SELECT d from Car d Join d.reviews n")
	List<Object[]> joinCarsAndReviews();
	
	@Query("SELECT d, n FROM Car d JOIN d.reviews n")
	List<Object[]> joinCarsAndReviews2();
	

	
}
