package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{
	java.util.List<Product> findProductByBrandNameStartingWith(String name); // fetch list of products which start with
}