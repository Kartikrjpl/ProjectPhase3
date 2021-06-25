package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>, JpaRepository<Product,Integer>{
	java.util.List<Product> findByBrand(String name); // fetch list of products which start with
	java.util.List<Product> findBySeason(String name); // fetch list of products which start with
	java.util.List<Product> findByCategory(String name);
	java.util.List<Product> findByColor(String name);

}