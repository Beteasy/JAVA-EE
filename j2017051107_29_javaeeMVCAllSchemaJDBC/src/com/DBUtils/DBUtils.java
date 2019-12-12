package com.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
//	数据库需要用到的四个数据
	static String dirver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/javaeetest?useSSL=false&serverTimezone=UTC";
	static String username = "root";
	static String password = "root";
	
	
	static {
//		step1:加载驱动
		try {
			Class.forName(dirver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	step2:创建连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	
//	step6:释放资源
	public static void releaseResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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

	
}
