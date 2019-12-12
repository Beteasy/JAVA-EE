package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.SqlUtil;

public class UserDao {
	
	static final String driver="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost:3306/easybuy?useSSL=false";
	static final String user="root";
	static final String password="rootcuit";
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//查询操作
	
	public List<User> selectPage(int page,int recordOfPage){
		
		List<User> userList = new ArrayList<User>();
		
		String sql="select * from easybuy_user "
				+ " order by id desc " //分页一定会先排序
				+ SqlUtil.getPageSql(page, recordOfPage);
		//System.out.println(sql);
		try {
			conn = getConn(url,user,password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setLoginName(rs.getString("loginName"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("password"));
				u.setSex(rs.getInt("sex"));
				u.setIdentityCode(rs.getString("identityCode"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setType(rs.getInt("type"));
				userList.add(u);
			}
			return userList;				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn, ps, rs);
		}
	}
	
	/**
	 * 查询记录总数
	 * @return
	 */
	public int getCount() {
		
		String sql="select count(*) from easybuy_user";
		try {
			conn = getConn(url,user,password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn, ps, rs);
		}
	}
	
	/**
	 * 查看所有用户
	 * @return 一个用户列表
	 */
	public List<User> findAll(){
		
		String sql="select * from easybuy_user order by id desc";
		
		try {
			conn = getConn(url,user,password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<User> userList = new ArrayList<User>();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setLoginName(rs.getString("loginName"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("password"));
				u.setSex(rs.getInt("sex"));
				u.setIdentityCode(rs.getString("identityCode"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setType(rs.getInt("type"));
				userList.add(u);
			}
			return userList;				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn, ps, rs);
		}
	}

	public void close(Connection conn,PreparedStatement ps,ResultSet rs) 
			throws RuntimeException {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public Connection getConn(String url, String user, String password) 
			throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * 按姓名模糊查找用户
	 * @param name 姓名
	 * @return 一个用户列表
	 */
	public List<User> findByName(String name) {
		
//		String sql="select * from easybuy_user where name = ?";
		String sql="select * from easybuy_user where userName like ?";
		
		try {
			conn = getConn(url, user, password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			List<User> userList = new ArrayList<User>();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setLoginName(rs.getString("loginName"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("password"));
				u.setSex(rs.getInt("sex"));
				u.setIdentityCode(rs.getString("identityCode"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setType(rs.getInt("type"));
				userList.add(u);
			}
			return userList;				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn,ps,rs);
		}
	}
	
	/**
	 * 按id号查找用户 
	 * @param id 用户id号
	 * @return 一个用户
	 */
	public User findById(Integer id) {
		
		String sql="select * from easybuy_user where id = ?";
		
		try {
			conn = getConn(url,user,password);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setLoginName(rs.getString("loginName"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("password"));
				u.setSex(rs.getInt("sex"));
				u.setIdentityCode(rs.getString("identityCode"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setType(rs.getInt("type"));
				return u;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn,ps,rs);
		}
		return null;	
	}

	
	//更新操作部分
	
	public void deleteUser(Integer id) {
		String sql="delete from easybuy_user where id = ?";
		
		try {
			conn = getConn(url,user,password);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn,ps,null);
		}	
	}
	
	public void updateUser(User u) {

		String sql="update easybuy_user" + 
				" set" + 
				" userName = ?" + 
				" ,password = ?" + 
				" ,sex = ?" + 
				" ,identityCode = ?" + 
				" ,email = ?" + 
				" ,mobile = ?" + 
				" where " + 
				" id = ?";
		
		try {
			conn = getConn(url,user,password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getSex());
			ps.setString(4, u.getIdentityCode());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getMobile());
			ps.setInt(7, u.getId());
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn,ps,null);
		}		
	}
	/**
	 * 插入用户表
	 * @param u 一个新用户
	 */
	public void insertUser(User u) {

		String sql="insert into easybuy_user(" + 
				"loginName,userName,password,sex"
				+ ",identityCode,email,mobile,type"
				+ ") values (" 
				+ "?,?,?,?,?,?,?,?"
				+ ");";
		
		try {
			conn = getConn(url,user,password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getLoginName());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getSex());
			ps.setString(5, u.getIdentityCode());
			ps.setString(6, u.getEmail());
			ps.setString(7, u.getMobile());
			ps.setInt(8, u.getType());
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(conn,ps,null);
		}
		
	}
}



