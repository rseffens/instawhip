package com.robertseffens.instawhip.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="cars")
public class Car {

	//<!-- Primary Key -->

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    //<!-- Member Variables -->

    @Min(value=1900, message="Vehicle year is required")
    private Integer year;

    @Size(min=2, message="Make required, minimum 2 characters.")
    private String make;
    
    @Size(min=2, message="Model required, minimum 2 characters.")
    private String model;
    
    @Size(min=2, message="Description required, minimum 2 characters.")
    private String description;
    
    @NotEmpty(message="Photo Required")
    private String file;
    
    private String type;
    



    		
    //<!-- Data Creation Trackers -->
    
    @Transient
    private double score;
    


	@Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;


    //<!-- Relationships -->

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @OneToMany(mappedBy="car", fetch = FetchType.LAZY)
    private List<Rating> ratings;
    
    @OneToMany(mappedBy="car", fetch = FetchType.LAZY)
    private List<Review> reviews;

    //<!-- Constructors -->

    public Car() {}
    
    public Car(Integer year, String make, String model, String description, String file, String type) {
    	this.year=year;
    	this.make=make;
    	this.model=model;
    	this.description=description;
    	this.type=type;
    	this.file=file;

    }
    


    //<!-- Date Creation Element -->

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdated(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
    public double getScore() {
    	setScore();
		return score;
	}

	public void setScore() {
		float score = 0;
		if(this.ratings.size()>0) {
			for(Rating rating: this.ratings) {
				score += rating.getScore();
				this.setScore(score);
			}
			score /= this.ratings.size();
			this.setScore(score);
		}
	}
		
	
	
	public void setScore(double score) {
		this.score = score;
	}





}

