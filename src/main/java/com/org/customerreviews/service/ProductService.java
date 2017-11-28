package com.org.customerreviews.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.customerreviews.dao.DataAccessFacade;
import com.org.customerreviews.model.Product;


@Service
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	
	@Autowired
	private DataAccessFacade facade;
	
	public long saveProduct(Product product) {
		
		logger.info("inside save product method of product service");
		return facade.save(product);
	}
	
	public void saveAllProducts(Set<Product> setProducts){
		facade.saveAll(setProducts);
	}

	public Product getProductById(long id) {
		return facade.getProductById(id);
	}
	
	public Product getProductByName(String name) {
		return facade.getProductByName(name);
	}
	
	public List<Product> getAllProducts() {
		return facade.getAllProducts();
	}
}
