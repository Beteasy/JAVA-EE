package service;

import java.sql.*;

import dao.UserDao;
import javaBean.User;

public class GetUser {
	
	public User getUserById(Integer id) 
			throws ClassNotFoundException, SQLException {
		
		UserDao userDao = new UserDao();
		User user = new User();
		user = userDao.findById(id);
		return user;
	}

}
