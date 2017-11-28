package com.org.customerreviews.model;

import java.time.Instant;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.org.customerreviews.model.validator.NoCurseWord;



@Entity
@Table(name="review")
public class Review{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=0, message="rating cannot be negative")
	private double rating;
	@NotNull
	@Size(min=1,message="comment cannot be blank")
	@NoCurseWord(message=" message has curse words")
	private String comment;
	private Date dateAdded;
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "product_id")
	@JsonBackReference
	private Product product;
	@Column(name = "user_id", nullable = false)
	private String userId;

	// Constructors
	public Review() {
		this.dateAdded = Date.from(Instant.now());// UTC
	}

	public Review(double score, String comment, Product product, String userId) {
		super();
		this.rating = score;
		this.comment = comment;
		this.userId = userId;
		this.product=product;
		this.dateAdded = Date.from(Instant.now());// UTC
	}

	// getters
	public Long getId() {
		return id;
	}
	
	public Date getDateAdded() {
		return dateAdded;
	}
	
	public double getRating() {
		return rating;
	}
	
	public String getComment() {
		return comment;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public Product getProduct() {
		return product;
	}

	
	//setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	
	public void setRating(double rating) {
		this.rating = rating;
	}

	
	public void setCommnet(String comment) {
		this.comment = comment;
	}

	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String toString(){
    	String info = "";
    	
        JSONObject jsonString = new JSONObject();
        try {
        	jsonString.put("score", this.rating);
			jsonString.put("description", this.comment);
			jsonString.put("user_id", this.userId);
			jsonString.put("date_added", this.dateAdded);
			JSONObject productObj = new JSONObject();
			productObj.put("name", this.product.getName());
			jsonString.put("product", productObj);
	        
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        info = jsonString.toString();
        return info;
    }
}
