package com.org.customerreviews.repository;

import org.springframework.data.repository.CrudRepository;

import com.org.customerreviews.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{
	
}
