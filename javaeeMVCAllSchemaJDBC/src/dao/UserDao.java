package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtils.DBUtils;
import javaBean.User;

public class UserDao {

	public User findById(Integer id) 
			throws ClassNotFoundException, SQLException {
		String sql = "select * from easybuy_user where id = ?";
	
		Connection con = DBUtils.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setLoginName(rs.getString("loginName"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getInt("sex"));
		user.setIdentityCode(rs.getString("identityCode"));
		user.setEmail(rs.getString("email"));
		user.setMobile(rs.getString("mobile"));
		user.setType(rs.getInt("type"));
		DBUtils.release(con, ps, rs);
		return user;
	}
	
}
