package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMethod {
	String url = "jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC";
	String DBUsername = "root";
	String DBPassword = "root";
	Connection connection = null;
	
	public DBMethod() {
		init();
	}
	
	public void init() {
//    	System.out.println("初始化");
		try {
//			加载数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("驱动加载成功");
//			创建数据库连接对象
			connection = DriverManager.getConnection(url, DBUsername, DBPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public String search(User user) {
	    	
	    	String username=null;
	    	String uname = null, pwd = null;
	    	
			try {
				username = user.getUserName();
				
//				创建数据库操作对象
				Statement statement = connection.createStatement();
//				执行查询语句
				ResultSet resultSet = statement.executeQuery("select * from users where username='" + username+"';");
				while (resultSet.next()) {
//			        uname = resultSet.getString("username");
			        pwd = resultSet.getString("password");
			      }
				
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return pwd;
	}
	 
	 public int insert(User user) {
		 
		 String username = null;
		 String password = null;
		 int flag = 0;
		 username = user.getUserName();
		 password = user.getPassword();
		 
		try {
			Statement statement = connection.createStatement();
			flag = statement.executeUpdate("insert into users(username,password) values('" + username + "','" + password +"');");
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}
}
