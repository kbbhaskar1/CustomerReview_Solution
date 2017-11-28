package com.org.customerreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.customerreviews.dao.DataAccessFacade;
import com.org.customerreviews.model.Review;



@Service
public class ReviewService {

	@Autowired
	private DataAccessFacade facade;

	public long saveReview(Review review) {
		return facade.save(review);
	}
}
