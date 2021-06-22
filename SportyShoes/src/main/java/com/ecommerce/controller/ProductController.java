package com.ecommerce.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;



@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductRepository productrepository;
	
	// retrieve all student from database
	
//	EntityManager emfactory = (EntityManager) Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
//    EntityManager entitymanager = ((EntityManagerFactory) emfactory).createEntityManager();
//    
	@GetMapping("all")
	public List<Product> getAllProduct()
	{
		List<Product> product=(List<Product>) productrepository.findAll(); 
		return product;
	}
	
	@GetMapping("all/{brand}")
	public List<Product> findProductByByBrandNameStartingWith(@PathVariable String brand)
	{	
	//Query query = entitymanager.createQuery( "Select p " + "from Product p " + "where p.brand = " + brand);
//		
//	@SuppressWarnings("unchecked")
//	List<Product> product=(List<Product>)query.getResultList( );
	List<Product> product=(List<Product>) productrepository.findProductByBrandNameStartingWith(brand);
	return product;
	}
//	
	@PostMapping("add")
	public Product addProduct(@RequestBody Product product)
	{
		return productrepository.save(product);
	}
	
	
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		productrepository.deleteById(id);
	}
	
	@PutMapping("update/{id}")
	public Product updateProduct(@RequestBody Product product)
	{
		return productrepository.save(product);
	}
}


