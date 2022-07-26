package com.robertseffens.instawhip.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.robertseffens.instawhip.models.Car;
import com.robertseffens.instawhip.models.Rating;
import com.robertseffens.instawhip.models.Review;
import com.robertseffens.instawhip.models.UploadCar;
import com.robertseffens.instawhip.models.User;
import com.robertseffens.instawhip.repositories.services.CarService;
import com.robertseffens.instawhip.repositories.services.UserService;

@Controller
@PropertySource("classpath:application-dev.properties")
public class CarController {
	
	
	@Value("${apiKey}")
	private String apiKey;
	@Value("${cloudName}")
	private String cloudName;
	@Value("${apiSecret}")
	private String apiSecret;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;

	
	//<!-- Display -->
	
	@GetMapping("/cars/new")
	public String addCar(@Valid @ModelAttribute("car") UploadCar car, Model model, HttpSession session) {
    	if(session.getAttribute("uuid") == null) {
    		return "redirect:/";
	}
		model.addAttribute("users", userService.getAll());
		return "cars/new.jsp";
	}
	
	
	@GetMapping("/cars/{id}")
	public String show(Model model, @PathVariable("id") Long id, HttpSession session,  @ModelAttribute("review") Review review,  @ModelAttribute("user") User user, @ModelAttribute("rating") Rating rating) {
    	if(session.getAttribute("uuid") == null) {
    		return "redirect:/";
    	}
    	Car car = carService.getOne(id);
    	model.addAttribute("user", userService.getOne((Long) session.getAttribute("uuid")));
    	model.addAttribute("review", review);
    	model.addAttribute("car", car);
    	return "show.jsp";
	}
	
	@RequestMapping("/cars/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("uuid") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("user", userService.getOne((Long) session.getAttribute("uuid")));
    	model.addAttribute("car", carService.getAll());
    	Car car = carService.getOne(id);
    	model.addAttribute("car", car);
    	return "/cars/edit.jsp";
	}
	
	@RequestMapping("cars/{id}/photo")
	public String photo(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("uuid") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("user", userService.getOne((Long) session.getAttribute("uuid")));
    	model.addAttribute("car", carService.getAll());
    	Car car = carService.getOne(id);
    	model.addAttribute("car", car);
    	return "photo.jsp";
	}
	
	//<!-- Action --> 
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/cars/create")
	public String createCar (@Valid @ModelAttribute("car") UploadCar car, BindingResult result, Model model, HttpSession session) throws IOException {

	    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
	    		  "cloud_name", cloudName,
	    		  "api_key", apiKey,
	    		  "api_secret", apiSecret));	
	    
	    Map uploadResult = null;
	    
	    if(car.getFile() != null && !car.getFile().isEmpty()) {
	    	uploadResult = cloudinary.uploader().upload(car.getFile().getBytes(),
	    			ObjectUtils.asMap("public_id", "test"));
	    }else {
	    	return "/cars/new.jsp";
	    }
	    
	    Car c = new Car();
		User user = userService.getOne((Long) session.getAttribute("uuid"));
		c.setUser(user);
	    c.setYear(car.getYear());
	    c.setMake(car.getMake());
	    c.setModel(car.getModel());
	    c.setType(car.getType());
	    c.setDescription(car.getDescription());
	    c.setFile((String) uploadResult.get("url"));
			carService.save(c);
			return "redirect:/dashboard";
		}


	@SuppressWarnings("rawtypes")
	@PutMapping("/cars/{id}/update")
	public String update (@Valid @ModelAttribute("car") UploadCar car, BindingResult result, HttpSession session, @PathVariable("id") Long id) throws IOException {


	    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
	    		  "cloud_name", cloudName,
	    		  "api_key", apiKey,
	    		  "api_secret", apiSecret));	
	    
	    Map uploadResult = null;
	    
	    if(car.getFile() != null && !car.getFile().isEmpty()) {
	    	uploadResult = cloudinary.uploader().upload(car.getFile().getBytes(),
	    			ObjectUtils.asMap("public_id", "test"));
	    }else {
	    	return "/cars/edit.jsp";
	    }
	    
	    Car c = carService.getOne(id);
		User user = userService.getOne((Long) session.getAttribute("uuid"));
		c.setUser(user);
	    c.setYear(car.getYear());
	    c.setMake(car.getMake());
	    c.setModel(car.getModel());
	    c.setType(car.getType());
	    c.setDescription(car.getDescription());
	    c.setFile((String) uploadResult.get("url"));
			carService.save(c);
			return "redirect:/dashboard";
	}


	
	
    @DeleteMapping("/cars/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        carService.delete(id);
        return "redirect:/dashboard";
	 }
}
