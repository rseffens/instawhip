package com.robertseffens.instawhip.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginUser {

    @NotEmpty(message="Email is required you fool!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required you fool!")
    private String password;
    
    public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
