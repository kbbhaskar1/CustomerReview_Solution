package com.org.customerreviews.dao.db.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import com.org.customerreviews.dao.db.ProductDao;
import com.org.customerreviews.model.Product;
import com.org.customerreviews.utils.ProductUtils;

@Component
public class ProductDaoImpl extends AbstractDao implements ProductDao {

	@Autowired
	ProductUtils productUtils;

	@Override
	public long save(Product product) {
		product = productRepository.save(product);
		return product.getId();
	}

	@Override
	public Product getProductById(long id) {
		Product product = productRepository.findOne(id);
		if(product == null)
			throw new ResourceNotFoundException("Given product for identifier "+ id + " not found", null);
		productUtils.setAggregatedRating(product);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> lstProducts = (List<Product>) productRepository.findAll();
		lstProducts.forEach(product -> productUtils.setAggregatedRating(product));
		return lstProducts;
	}

	@Override
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public void saveAll(Set<Product> setProducts) {
		productRepository.save(setProducts);
	}
}
