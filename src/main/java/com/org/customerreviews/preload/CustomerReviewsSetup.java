package com.org.customerreviews.preload;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.org.customerreviews.model.Product;
import com.org.customerreviews.model.Review;
import com.org.customerreviews.repository.ProductRepository;
import com.org.customerreviews.repository.ReviewRepository;


@Component
@ImportResource("classpath:app-config.xml")


public class CustomerReviewsSetup implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CustomerReviewsSetup.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		
				loadSampleData();
		
	}

	

	private void loadSampleData() {
		logger.info("loadSampleData");
		Product iPhone = new Product("iphone");
		Product iPad = new Product("ipad");
		// save products
		productRepository.save(iPhone);
		productRepository.save(iPad);
		/*
		 * Then store reviews with persisted products.
		 */
		Review iPhoneReview1 = new Review(4.0, "Good but edges are sharp", iPhone, "1");
		Review iPhoneReview2 = new Review(3.0, "Decent !!!", iPhone, "2");

		Review iPadReview1 = new Review(3.0, "Decent !!!", iPad, "3");
		Review iPadReview2 = new Review(2.0, "Poor quality. I vote down", iPad, "4");

		// save reviews
		reviewRepository.save(iPhoneReview1);
		reviewRepository.save(iPhoneReview2);

		reviewRepository.save(iPadReview1);
		reviewRepository.save(iPadReview2);

	}

}
