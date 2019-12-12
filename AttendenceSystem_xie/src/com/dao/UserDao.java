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
			String sql = "select * from user";
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				if( (res.getString("username")).equals(account) ) {
					
					user.setUsername(res.getString("username"));
					if( res.getString("password").equals(pwd) ) {
						user.setPassword(res.getString("password"));
						user.setUseNo(res.getInt("userNo"));
						user.setPermission(res.getInt("permission"));
						break;
					}
					else {
						user.setPassword("errorpwd");
						break;
					}
				}
				else {
					user.setUsername("errorname");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
