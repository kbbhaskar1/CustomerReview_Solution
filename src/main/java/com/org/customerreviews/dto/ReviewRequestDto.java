package com.org.customerreviews.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;



public class ReviewRequestDto {
	@NotNull
	@NotEmpty
	@JsonProperty("comment")
	private String comment;

	@Min(value = 1)
	@Max(value = 5)
	private double rating;

	@Min(value = 1)
	private Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String userId;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
