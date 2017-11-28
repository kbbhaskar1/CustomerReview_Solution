package com.org.customerreviews.search;


import org.springframework.beans.factory.annotation.Autowired;

import com.org.customerreviews.model.Product;
import com.org.customerreviews.repository.ProductRepository;



public class ProductReviewSearch {
	
	
	@Autowired
	ProductRepository productRepository;
	
	
	
public Long getProductReviewsCount(String productName, double min_score, double max_score) {
		
	Product product = productRepository.findByName(productName);
	
	if (product != null && product.getReviews() != null && product.getReviews().size() > 0) {
			
			return product.getReviews().parallelStream().filter(i->i.getRating()<=max_score && i.getRating()>=min_score).count();
		}
		
		else
			return null;
		}
		
		

}
