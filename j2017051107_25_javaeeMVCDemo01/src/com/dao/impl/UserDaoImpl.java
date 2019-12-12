package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao {
	
//	数据库需要用到的四个数据
	static String dirver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/javaeetest?useSSL=false&serverTimezone=UTC";
	static String username = "root";
	static String password = "root";
//	三个接口对象
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	static {
//		step1:加载驱动
		try {
			Class.forName(dirver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	step6:释放资源
	public void releaseResource() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	step2:创建连接
	public Connection getConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from users where id = ?";
		User user = null;
		try {

			connection = getConnection(url, username, password);
//			step3:创建preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
//			step4:执行sql语句
			resultSet = preparedStatement.executeQuery();
//			step5:处理resultSet
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setLoginName(resultSet.getString("loginName"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setSex(resultSet.getInt("sex"));
				user.setType(resultSet.getInt("type"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			step6:释放资源
			releaseResource();
		}
		return user;
	}

	@Override
	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from users where userName like concat('%',?,'%')";
//		System.out.println(sql);
//		System.out.println(name);
		User user = null;
		List<User> users = new ArrayList<User>();
		try {

			connection = getConnection(url, username, password);
//			step3:创建preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
//			step4:执行sql语句
			resultSet = preparedStatement.executeQuery();
//			step5:处理resultSet
			while(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setLoginName(resultSet.getString("loginName"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setSex(resultSet.getInt("sex"));
				user.setType(resultSet.getInt("type"));
				users.add(user);
				
			}
//			System.out.println(users.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			step6:释放资源
			releaseResource();
		}
		return users;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
