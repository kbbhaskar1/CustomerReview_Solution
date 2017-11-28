package com.org.customerreviews.repository;

import org.springframework.data.repository.CrudRepository;

import com.org.customerreviews.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	Product findByName(String name);
}
