package com.ecommerce.repository;

import java.util.List;

import com.ecommerce.model.Product;

public interface ProductService{    
	List<Product> findProductByBrandNameStartingWith(String name); 
	}