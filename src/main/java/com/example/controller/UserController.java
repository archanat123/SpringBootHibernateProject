package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.User;
import com.example.service.UserService;

@Controller
public class UserController {


	@Autowired
	 private UserService service;
	
	
	
	@PostMapping(path="/create")
	public void createUsers(@RequestBody User user)
	{
	service.create(user);
	}
	
	@PostMapping(path="/update")
	public void updateUser(@RequestBody User user)
	{
	service.update(user);
	}
	@PostMapping(path="/delete/{id}")
	public void deleteUser(@PathVariable Integer id)
	{
    service.delete(id);
		
	}
	@GetMapping
	public List<User> getUsers()
	{
	return service.get();
	}
	 ;
	
	
}
