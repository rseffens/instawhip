package com.robertseffens.instawhip.repositories.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertseffens.instawhip.models.Rating;
import com.robertseffens.instawhip.repositories.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public Rating save(Rating s) {
		return ratingRepository.save(s);
	}
	
	public Rating getOne(Long id) {
		Optional<Rating>s=ratingRepository.findById(id);
		if(s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
	
	public void delete(Long id) {
		ratingRepository.deleteById(id);
	}
	

}
