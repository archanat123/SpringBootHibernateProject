package com.example.repository;

import java.util.List;

import com.example.pojo.User;

public interface UserDao {

	public void create(User user);
	public void update(User user);
	public void delete(Integer id);
	public List<User> get();
	
	
}
