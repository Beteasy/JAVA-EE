package cn.edu.cuit.fhzheng.service;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.fhzheng.dao.UserDao;
import cn.edu.cuit.fhzheng.pojo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	/**
	 * @return 所有用户信息
	 */
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	/**
	 * 按id返回用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id) {
		UserDao userDao = new UserDao();
		User user = null;
		user = userDao.getUserById(id);
		return user;
	}

	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public List<User> getUserByName(String userName) {
		List<User> userList = new ArrayList<User>();
		userList = userDao.getUserByName(userName);
		return userList;
	}

	public List<User> getPageUsers(Integer page) {
		List<User> userList = new ArrayList<User>();
		userList = userDao.getPageUsers(page);
		return userList;
	}
}
