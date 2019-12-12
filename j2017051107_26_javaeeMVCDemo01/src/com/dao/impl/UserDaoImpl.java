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
	
//	���ݿ���Ҫ�õ����ĸ�����
	static String dirver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/javaeetest?useSSL=false&serverTimezone=UTC";
	static String username = "root";
	static String password = "123456789";
//	�����ӿڶ���
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	static {
//		step1:��������
		try {
			Class.forName(dirver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	step6:�ͷ���Դ
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

//	step2:��������
	public Connection getConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into users(loginName,username,password,sex,type) values(?,?,?,?,?)";
		int result = 0;
		try {

			connection = getConnection(url, username, password);
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getLoginName());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getSex());
			preparedStatement.setInt(5, user.getType());
//			step4:ִ��sql���
			result = preparedStatement.executeUpdate();
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			step6:�ͷ���Դ
			releaseResource();
		}
		return result;
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
		String sql = "delete from users where id=? ";
		int result = 0;
		try {

			connection = getConnection(url, username, password);
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
//			step4:ִ��sql���
			result = preparedStatement.executeUpdate();
//			step5:����resultSet
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			step6:�ͷ���Դ
			releaseResource();
		}
		return result;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "update users set loginName=?,password=?,userName=?,sex=?,type=? where id=? ";
		int result = 0;
		try {

			connection = getConnection(url, username, password);
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getLoginName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setInt(4, user.getSex());
			preparedStatement.setInt(5, user.getType());
			preparedStatement.setInt(6, user.getId());
//			step4:ִ��sql���
			result = preparedStatement.executeUpdate();
//			step5:����resultSet
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			step6:�ͷ���Դ
			releaseResource();
		}
		return result;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from users where id = ?";
		User user = null;
		System.out.println("�����õ���ID��"+ id);
		try {
			connection = getConnection(url, username, password);
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
//			step4:ִ��sql���
			resultSet = preparedStatement.executeQuery();
//			step5:����resultSet
			while (resultSet.next()) {
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
//			step6:�ͷ���Դ
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
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			System.out.println("preparedStatement:"+preparedStatement.toString());
//			step4:ִ��sql���
			resultSet = preparedStatement.executeQuery();
//			step5:����resultSet
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
//			step6:�ͷ���Դ
			releaseResource();
		}
		return users;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		User user = null;
		List<User> users = new ArrayList<User>();
		try {

			connection = getConnection(url, username, password);
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
//			step4:ִ��sql���
			resultSet = preparedStatement.executeQuery();
//			step5:����resultSet
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
//			step6:�ͷ���Դ
			releaseResource();
		}
//		System.out.println(users.toString());
		return users;
	}

	public List<User> getUserByPage(Integer page) {
		// TODO Auto-generated method stub
		String sql = "select * from users limit ?,3";
//		System.out.println(sql);
//		System.out.println(name);
		User user = null;
		List<User> users = new ArrayList<User>();
		try {

			connection = getConnection(url, username, password);
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (page-1)*3);
//			step4:ִ��sql���
			resultSet = preparedStatement.executeQuery();
//			step5:����resultSet
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
//			step6:�ͷ���Դ
			releaseResource();
		}
		return users;
	}

}
