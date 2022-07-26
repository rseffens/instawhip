package com.robertseffens.instawhip.models;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.StoredFile;

public class UploadCar extends StoredFile{
	
	private Integer id;
	
	@Min(value=1900, message="Vehicle year is required")
	private Integer year;

    @Size(min=2, message="Make required, minimum 2 characters.")	
	private String make;
    
    @Size(min=2, message="Model required, minimum 2 characters.")
	private String model;

    @Size(min=2, message="Description required, minimum 2 characters.")
	private String description;
    
	private String type;
	
	private MultipartFile file;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
