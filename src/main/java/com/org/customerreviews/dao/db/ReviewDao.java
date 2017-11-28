package com.org.customerreviews.dao.db;

import com.org.customerreviews.model.Review;

public interface ReviewDao {
	
	long save(Review review);
}
