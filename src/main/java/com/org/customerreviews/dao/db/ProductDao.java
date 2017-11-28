package com.org.customerreviews.dao.db;

import java.util.List;
import java.util.Set;

import com.org.customerreviews.model.Product;

public interface ProductDao {
	long save(Product product);
	
	void saveAll(Set<Product> setProducts);

	Product getProductById(long id);
	
	Product getProductByName(String name);
	
	List<Product> getAllProducts();
}
