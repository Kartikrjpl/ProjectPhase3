package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;


@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserRepository userrepository;
	
	// retrieve all student from database
	@GetMapping("all")
	public List<User> getAllusers()
	{
		List<User> users=(List<User>) userrepository.findAll(); 
		return users;
	}
	
	@PostMapping("add")
	public User addUser(@RequestBody User user)
	{
		return userrepository.save(user);
	}
	
}
