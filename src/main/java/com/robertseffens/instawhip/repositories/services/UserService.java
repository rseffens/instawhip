package com.robertseffens.instawhip.repositories.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.robertseffens.instawhip.models.LoginUser;
import com.robertseffens.instawhip.models.User;
import com.robertseffens.instawhip.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//========== Register and Login =========
	
	public User register(User newUser, BindingResult result) {
		if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "Email is already in use");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Password and Confirmed Password must match" );			
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String hashBrowns= BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashBrowns);
		
		return userRepository.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> optUser = userRepository.findByEmail(newLogin.getEmail());
		if(!optUser.isPresent()) {
			result.rejectValue("email", "Unique", "Invalid Credentials");
			
			return null;
		}
		
		User user = optUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
			result.rejectValue("password","Matches", "Invalid Credentials");
			
			return null;
		}
		
		return user;
	}

	
	//<!-- Create / Update


	//<!-- Read -->
	
	public List<User>getAll(){
		return userRepository.findAll();
	}

	public User getOne(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	//<!-- Delete -->

	}


	//<!-- Relationships -->
	
