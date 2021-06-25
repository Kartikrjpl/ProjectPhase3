package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

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
	
	@GetMapping("all/brand/{brand}")
	public List<Product> findProductByByBrandNameStartingWith(@PathVariable String brand)
	{	
	List<Product> product=(List<Product>) productrepository.findByBrand(brand);
	return product;
	}
	@GetMapping("all/season/{season}")
	public List<Product> findProductByBySeasonNameStartingWith(@PathVariable String season)
	{	
	List<Product> product=(List<Product>) productrepository.findBySeason(season);
	return product;
	}
//	
	@GetMapping("all/category/{category}")
	public List<Product> findProductByByCategoryNameStartingWith(@PathVariable String category)
	{	
	List<Product> product=(List<Product>) productrepository.findByCategory(category);
	return product;
	}
	@GetMapping("all/color/{color}")
	public List<Product> findProductByByColorNameStartingWith(@PathVariable String color)
	{	
	List<Product> product=(List<Product>) productrepository.findByColor(color);
	return product;
	}
	@GetMapping("all/price/asc")
	public List<Product> findProductByPriceAsc()
	{	
	List<Product> product=(List<Product>) productrepository.findAll();
//	TreeMap<Product, Integer> tree_map = new TreeMap<Product, Integer>();
//	for (Product p : product) {
//		tree_map.put(p,(int)p.getPrice());
//		
//	}
//	List<Product> final_product = new ArrayList<Product>();
//	for (Product p : tree_map.keySet()) {
//		final_product.add(p);
//	}
	Collections.sort(product, (o1, o2) -> (int)o1.getPrice() - (int)o2.getPrice());
	return product;
	}
	
	
	
	@GetMapping("all/price/desc")
	public List<Product> findProductByPriceDesc()
	{	

		List<Product> product=(List<Product>) productrepository.findAll();
		Collections.sort(product, (o1, o2) -> (int)o1.getPrice() - (int)o2.getPrice());
		Collections.reverse(product);
		return product;
	}
	
	
	@GetMapping("all/date/asc")
	public List<Product> findProductByDate()
	{	


		List<Product> product=(List<Product>) productrepository.findAll();
		Collections.sort(product, (o1, o2) -> (int)o1.getcreated_date().getTime() - (int)o2.getcreated_date().getTime());
		return product;
	}
	@GetMapping("all/date/desc")
	public List<Product> findProductByDateDesc()
	{	


		List<Product> product=(List<Product>) productrepository.findAll();
		Collections.sort(product, (o1, o2) -> (int)o1.getcreated_date().getTime() - (int)o2.getcreated_date().getTime());
		Collections.reverse(product);
		return product;
	}
	
	
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


