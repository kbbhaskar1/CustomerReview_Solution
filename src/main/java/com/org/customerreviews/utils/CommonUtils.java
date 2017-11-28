package com.org.customerreviews.utils;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.customerreviews.dto.ProductRequestDto;
import com.org.customerreviews.dto.ReviewRequestDto;
import com.org.customerreviews.model.Product;
import com.org.customerreviews.model.Review;
import com.org.customerreviews.service.ProductService;

@Component
public class CommonUtils {

	@Autowired
	private ProductService productService;

	

	public boolean validateProductRequest(ProductRequestDto input) {
		if (input == null) {
			throw new ValidationException("invaild request");
		}
		return true;
	}

	public Product getProductModel(ProductRequestDto input) {
		Product product = new Product();
		product.setName(input.getName());
		return product;
	}

	public Review getReviewModel(ReviewRequestDto input) {
		Review review = new Review();
		review.setRating(input.getRating());
		review.setCommnet(input.getComment());
		review.setProduct(getProduct(input.getProductId()));
		review.setUserId(input.getUserId());
		return review;
	}

	private Product getProduct(Long productId) {
		return productService.getProductById(productId);
	}

	public boolean validateReviewRequest(ReviewRequestDto input) {
		if (input == null)
			throw new ValidationException("Review cannot be null. Please check the request you have posted");
		return true;
	}

	
}
