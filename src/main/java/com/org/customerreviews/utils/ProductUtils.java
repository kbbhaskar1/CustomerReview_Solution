package com.org.customerreviews.utils;

import java.text.DecimalFormat;


import org.springframework.stereotype.Component;

import com.org.customerreviews.model.Product;

@Component
public class ProductUtils {
	


	public void setAggregatedRating(Product product) {
		if (product != null && product.getReviews() != null && product.getReviews().size() > 0) {
			DecimalFormat numberFormat = new DecimalFormat("#.0");
			Double average = product.getReviews().parallelStream().mapToDouble(i -> i.getRating()).average()
					.getAsDouble();
			product.setAggregatedRating(Double.parseDouble(numberFormat.format(average)));
		} else
			product.setAggregatedRating(0);
	}

	
	
		


}
