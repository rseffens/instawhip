package com.robertseffens.instawhip.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.robertseffens.instawhip.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{
	List<Review> findAll();
}
