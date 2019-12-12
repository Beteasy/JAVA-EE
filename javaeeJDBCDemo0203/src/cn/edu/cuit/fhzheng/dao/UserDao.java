package cn.edu.cuit.fhzheng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.fhzheng.pojo.User;

public class UserDao {
	
//	public static void main(String[] args) {
//		UserDao userDao = new UserDao();
//		User user = userDao.getUserById(12);
//		System.out.println(user.toString());
//	}
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://222.18.132.125:3306/easybuy?useSSL=true";
	private static final String username = "zfh002";
	private static final String password = "zfh002";
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取所有用户信息
	 * @return userList
	 */
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		String sql = "select * from easybuy_user limit page,5";
		try {
			getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
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
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll();
		}
		
		return userList;
	}
	
	/**
	 * 获取所有用户信息
	 * 页是怎么来的？假设每页5条记录
	 * 
	 * @return userList
	 */
	public List<User> getPageUsers(int page){
		List<User> userList = new ArrayList<User>();
		// 假设每一页3条记录
		String sql = "select * from easybuy_user limit ?,3";
		try {
			getConn();
			ps = conn.prepareStatement(sql);
			// 把相应的页码计算成该页的起始记录的位置
			ps.setInt(1, (page-1)*3);
			rs = ps.executeQuery();
			while (rs.next()) {
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
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll();
		}
		
		return userList;
	}

	/**
	 * 按id取用户信息
	 * @param id 
	 * @return User
	 */
	public User getUserById(Integer id) {
		// 定义一个user
		User user = null;
		// 装填user   DB--->object
		// JDBC六步
		try {
			getConn();
			String sql= "select * from easybuy_user where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginName"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setIdentityCode(rs.getString("identityCode"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setType(rs.getInt("type"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll();
		}
		// 返回 user
		return user;
	}

	private void getConn() throws SQLException {
		conn = DriverManager.getConnection(url, username, password);
	}

	private void releaseAll() {
		//		6释放资源
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveUser(User user) {
		String saveUserSql = "insert into easybuy_user"
				+ "(loginName,userName,password,sex"
				+ ",identityCode,email,mobile,type)"
				+ " values(?,?,md5(?),?,?,?,?,?)";
		try {
			getConn();
			ps = conn.prepareStatement(saveUserSql);
			ps.setString(1, user.getLoginName());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getSex());
			ps.setString(5, user.getIdentityCode());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getMobile());
			ps.setInt(8, user.getType());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll();
		}
		
	}

	public List<User> getUserByName(String userName) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from easybuy_user where username like concat('%',?,'%')";
		try {
			getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {
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
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll();
		}
		
		return userList;
	}
}
