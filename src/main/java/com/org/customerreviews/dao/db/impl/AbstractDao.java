package com.org.customerreviews.dao.db.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.customerreviews.repository.ProductRepository;
import com.org.customerreviews.repository.ReviewRepository;

public abstract class AbstractDao {
	@Autowired
	protected ReviewRepository reviewRepository;
	
	@Autowired
	protected ProductRepository productRepository;	
}
