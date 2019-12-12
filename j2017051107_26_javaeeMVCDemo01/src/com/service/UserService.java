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
	
	public int insertUser(User user) {
		int result = 0;
		result = userDaoImpl.insertUser(user);
		return result;
	}
	
	public int changeUser(User user) {
		int result = 0;
		result = userDaoImpl.updateUser(user);
		return result;
	}

	public List<User> getUserByPage(Integer page) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		users = userDaoImpl.getUserByPage(page);
		return users;
	}
	
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		users = userDaoImpl.getAllUser();
		return users;
	}
	
	public int deleteUser(Integer id) {
		int result = 0;
		result = userDaoImpl.deleteUser(id);
		return result;
	}
	
}
