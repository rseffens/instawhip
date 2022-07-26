package com.robertseffens.instawhip.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Size(min=2, max=45, message="First name must be between 2 and 45 characters")
	    private String firstName;
	    
	    @Size(min=2, max=45, message="Last name must be between 2 and 45 characters")
	    private String lastName;
	    
	    @NotEmpty(message="Please Enter a Valid Email")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="Confirm Password is required you fool!")
	    private String confirmPassword;
	  
	    //<!-- Data Creation Trackers -->

	    @Column(updatable = false)
	    private Date createdAt;
		private Date updatedAt;


		@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
		private List<Car> cars;
		
		@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
		private List<Review> reviews;
		
		@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
		private List<Rating> ratings;
		
		//<!-- Constructors -->
		
		public List<Rating> getRatings() {
			return ratings;
		}


		public void setRatings(List<Rating> ratings) {
			this.ratings = ratings;
		}


		public User() {}
		
		
		//<!-- Date Creation Element -->
		
		@PrePersist
		protected void onCreate(){
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdated(){
			this.updatedAt = new Date();
		}
	    //<!-- Relationships -->

	    public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getConfirmPassword() {
			return confirmPassword;
		}


		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


		public List<Car> getCars() {
			return cars;
		}


		public void setCars(List<Car> cars) {
			this.cars = cars;
		}


		public List<Review> getReviews() {
			return reviews;
		}


		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}



	    //<!-- Getters and Setter -->

}
