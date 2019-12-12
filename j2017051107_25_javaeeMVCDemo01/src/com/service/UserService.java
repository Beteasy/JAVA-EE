package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.impl.UserDaoImpl;
import com.entity.User;

public class UserService {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	public User getUserById(Integer id) {
		User user = null;
		user = userDaoImpl.getUserById(id);
		return user;
	}
	
	public List<User> getUserByName(String name) {
		List<User> users = new ArrayList<User>();
		users = userDaoImpl.getUserByName(name);
		return users;
	}
	
}
