package com.org.customerreviews.dao;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.customerreviews.dao.db.ProductDao;
import com.org.customerreviews.dao.db.ReviewDao;
import com.org.customerreviews.model.Product;
import com.org.customerreviews.model.Review;

@Component
public class DataAccessFacadeImpl implements DataAccessFacade{
	private static final Logger logger = LoggerFactory.getLogger(DataAccessFacadeImpl.class);

	
	@Autowired
    ProductDao productDao;
	
	@Autowired
    ReviewDao reviewDao;

	@Override
	public long save(Product product) {
		logger.info("inside save method of DataAccessFacadeImpl");
		return productDao.save(product);
	}

	@Override
	public Product getProductByName(String name) {
		return productDao.getProductByName(name);
	}
	
	@Override
	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public void saveAll(Set<Product> setProducts) {
		productDao.saveAll(setProducts);
	}
	
	@Override
	public long save(Review review) {
		return reviewDao.save(review);
	}
}
