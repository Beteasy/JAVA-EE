package dbUtils;

import java.sql.*;

public class DBUtils {

	//1 打开连接
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/javaeetest";
		String user = "root";
		String password = "rootcuit";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	//2 关闭连接
	public static void release(
			Connection con,
			Statement stmt,
			ResultSet rs) 
			throws SQLException {
		if (con != null) {
			con.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
	public static void release(
			Connection con,
			PreparedStatement pstmt,
			ResultSet rs) 
			throws SQLException {
		if (con != null) {
			con.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}
