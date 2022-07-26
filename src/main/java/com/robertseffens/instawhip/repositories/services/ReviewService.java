package com.robertseffens.instawhip.repositories.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertseffens.instawhip.models.Review;
import com.robertseffens.instawhip.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	

	
	
	//<!-- Create / Update
	
	public Review save(Review s) {
		return reviewRepository.save(s);
	}

	
	
	public Review getOne(Long id) {
		Optional<Review>s=reviewRepository.findById(id);
		if(s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
	
	public void delete(Long id) {
		reviewRepository.deleteById(id);
	}
	
}
