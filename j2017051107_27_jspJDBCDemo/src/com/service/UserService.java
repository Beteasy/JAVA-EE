package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.impl.UserDaoImpl;
import com.entity.User;

public class UserService {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		users = userDaoImpl.getAllUser();
		return users;
	}
	
}
