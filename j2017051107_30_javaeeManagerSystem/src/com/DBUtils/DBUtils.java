package com.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/javaee?useSSL=false&serverTimezone=UTC";
	static String username = "root";
	static String password = "123456789";
//	jdbc:mysql://85.10.205.173:3306/javaeetest?useSSL=false&serverTimezone=UTC
//	jdbc:mysql://localhost:3306/javaee?useSSL=false&serverTimezone=UTC
	static {
//		step1:��������
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	��������
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	
//	�ͷ���Դ
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
