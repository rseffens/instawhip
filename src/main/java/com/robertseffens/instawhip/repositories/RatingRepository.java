package com.robertseffens.instawhip.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.robertseffens.instawhip.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long>{
	List<Rating> findAll();

}
