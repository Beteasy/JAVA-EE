package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public int insertUser(User user);
	public int deleteUser(Integer id);
	public int updateUser(User user);

	public User getUserById(Integer id);
	public List<User> getUserByName(String name);
	public List<User> getAllUser();
}
