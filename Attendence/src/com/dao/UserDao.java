package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.User;
import com.DBUtils.DBUtils;
import com.daoImpl.*;
public class UserDao {
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet res = null;

	public User getUser(String account, String pwd) {

		User user = new User();
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "select * from student";
			pre = conn.prepareStatement(sql);
			//pre.setString(1, account);
			//pre.setString(2, pwd);
			res = pre.executeQuery();
//			while (res.next()) {
//				if( (res.getString("userName")).equals(account) ) {
//					
//					user.setUser_account(res.getString("userName"));
//					if( res.getString("password").equals(pwd) ) {
//						user.setUser_pwd(res.getString("password"));
//						user.setUser_id(res.getInt("stuNo"));
//						user.setPermission(res.getInt("stuPermission"));
//						break;
//					}
//					else {
//						user.setUser_pwd("errorpwd");
//						break;
//					}
//				}
//				else {
//					user.setUser_account("errorname");
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
