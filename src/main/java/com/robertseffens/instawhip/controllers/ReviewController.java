package com.robertseffens.instawhip.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robertseffens.instawhip.models.Car;
import com.robertseffens.instawhip.models.Rating;
import com.robertseffens.instawhip.models.Review;
import com.robertseffens.instawhip.models.User;
import com.robertseffens.instawhip.repositories.services.CarService;
import com.robertseffens.instawhip.repositories.services.RatingService;
import com.robertseffens.instawhip.repositories.services.ReviewService;
import com.robertseffens.instawhip.repositories.services.UserService;

@Controller
public class ReviewController {
	@SuppressWarnings("unused")
	private static final Long Long = null;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private RatingService ratingService; 
	
	
	
	@PostMapping("cars/{carId}/rate")
	public String rate(@Valid @ModelAttribute("rating") Rating ratings, BindingResult result, Model model, @PathVariable("carId") Long carId, HttpSession session) {
		User user = userService.getOne((Long) session.getAttribute("uuid"));
		Car car = carService.getOne(carId);
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("car", car);
			return "/show.jsp";
		}else {

			ratings.setUser(user);
			ratings.setCar(car);
	
			System.out.println(ratings.getId());
			System.out.println(ratings.getScore());

			
				ratingService.save(ratings);
				return "redirect:/cars/{carId}";
		}
	}
	
	
	@PostMapping("/cars/{carId}/createReview")
	public String createReview(@Valid @ModelAttribute("review") Review reviews,  BindingResult result, Model model, @PathVariable("carId") Long carId,  HttpSession session) {
		User user = userService.getOne((Long) session.getAttribute("uuid"));
		Car car = carService.getOne(carId);
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("car", car);
			return "/show.jsp";
		}else {

			reviews.setUser(user);
			reviews.setCar(car);
	
			System.out.println(reviews.getId());
			System.out.println(reviews.getContent());

			
				reviewService.save(reviews);
				return "redirect:/cars/{carId}";
		}
	}
}
	
