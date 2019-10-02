package com;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import com.Student;

public class DataBaseOperator {
	String logname, password;
	String success = "false", message = "";
	Connection con;
	Statement sql;
	ResultSet rs;

	public DataBaseOperator() {
		try {
			// 加载桥接器
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
		}
	}

	// 设置属性值与获取属性值的方法
	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	// 查询jspdata数据库的user表
	public String getMessage() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			sql = con.createStatement();
			String condition = "select * from user where logname=" + "'" + logname + "'";
			rs = sql.executeQuery(condition);
			int rowcount = 0;
			String ps = null;

			while (rs.next()) {
				rowcount++;
				logname = rs.getString("logname");
				ps = rs.getString("password");
			}
			if ((rowcount == 1) && (password.equals(ps))) {
				message = "ok";
				success = "ok";

			} else {

				message = "输入的用户名和密码不正确";
				success = "false";
			}
			con.close();
			return message;
		} catch (SQLException e) {
			message = "输入的用户名或密码不正确";
			success = "false";
			message = "false";
			return message;

		}
	}

	// 根据学号id删除学生记录
	public void delete(int id) {
		try {

			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			java.sql.Statement sql = conn.createStatement();
			sql.executeUpdate("delete from student where id=" + id + "");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 添加学生记录
	public void insert(int id, String name, String age, String gender, String major) {

		try {

			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			java.sql.Statement sql = conn.createStatement();
			String s = "insert into  student  values" + "(" + id + ",'" + name + "','" + age + "','" + gender + "','"
					+ major + "'" + ")";
			sql.executeUpdate(s);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 根据学号id更新学生记录
	public void update(int id, String name, String age, String gender, String major) {

		try {

			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			java.sql.Statement sql = conn.createStatement();
			String s = "update student set id=" + id + ",name='" + name + "',age=" + age + ",gender='" + gender
					+ "',major='" + major + "' where id=" + id + "";
			sql.executeUpdate(s);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 根据学生的学号或姓名查询学生记录
	public Set<Student> searchStudents(String id, String name) {
		try {
			String s = null;

			Connection conn = null;
			ResultSet rs = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			java.sql.Statement sql = conn.createStatement();

			if (id.equals(""))
				id = "";
			if (name.equals(""))
				name = "";
			if (id == "" && name == "") {// 如果学号和姓名都为空，查询所有学生
				s = "select * from student";
			}
			if (id != "" && name == "") {// 如果学号不为空并且姓名为空，按学号查询学生
				s = "select * from student where id=" + id + "";
			}
			if (id == "" && name != "") { // 如果学号为空并且姓名不为空，按姓名查询学生
				s = "select * from student where name='" + name + "'";
			}
			if (id != "" && name != "") { // 如果学号和姓名都不为空，按学号和姓名同时匹配查询
				s = "select * from student where id=" + id + " and name='" + name + "'";
			}

			Set<Student> sts = new HashSet<Student>();
			rs = sql.executeQuery(s);
			while (rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAge(rs.getString(3));
				st.setGender(rs.getString(4));
				st.setMajor(rs.getString(5));
				sts.add(st);
			}
			if (rs != null) {
				rs.close();
			}
			if (sql != null) {
				sql.close();
			}
			return sts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 查询数据库的student表，获得所有学生记录
	public Set<Student> searchAllStudents() {
		try {

			Connection conn = null;
			ResultSet rs = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			java.sql.Statement sql = conn.createStatement();
			String s = "select * from student ";
			Set<Student> sts = new HashSet<Student>();
			rs = sql.executeQuery(s);
			// 遍历查询结果，依次读取每个学生的信息，创建Student类型的对象，并将这些学生对象添加到集合
			while (rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAge(rs.getString(3));
				st.setGender(rs.getString(4));
				st.setMajor(rs.getString(5));
				sts.add(st);
			}
			if (rs != null) {
				rs.close();
			}
			if (sql != null) {
				sql.close();
			}
			return sts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 根据学号id查询学生记录
	public Student searchOneStudent(int id) {
		try {

			Connection conn = null;
			ResultSet rs = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			java.sql.Statement sql = conn.createStatement();
			String s = "select * from student where id=" + id;
			Student st = new Student();
			rs = sql.executeQuery(s);
			while (rs.next()) {
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAge(rs.getString(3));
				st.setGender(rs.getString(4));
				st.setMajor(rs.getString(5));
			}
			if (rs != null) {
				rs.close();
			}
			if (sql != null) {
				sql.close();
			}
			return st;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 处理字符串的方法，避免出现中文乱码
	public String codeString(String s) {
		String new_str = s;
		try {
			new_str = new String(new_str.getBytes("ISO-8859-1"), "utf8");
			return new_str;
		} catch (Exception e) {
			return new_str;

		}
	}

}
