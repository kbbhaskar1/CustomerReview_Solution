package com.org.customerreviews.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.customerreviews.dto.ProductRequestDto;
import com.org.customerreviews.model.Product;
import com.org.customerreviews.service.ProductService;
import com.org.customerreviews.utils.CommonUtils;


@CrossOrigin
@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CommonUtils utils;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> products(@Valid @RequestBody ProductRequestDto input) {		
		if (utils.validateProductRequest(input)) {
			Product product = utils.getProductModel(input);
			return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
		} else
			return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
	public ResponseEntity<Product> products(@PathVariable(value = "id", required = true) Long productId) {
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> products() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
}
