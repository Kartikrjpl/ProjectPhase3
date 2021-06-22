package com.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.model.Product;


public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private Product product;
	
	
	@Override
	public List<Product> findProductByBrandNameStartingWith(String name){
		
	    return ((ProductService) product).findProductByBrandNameStartingWith(name);
	}
}
