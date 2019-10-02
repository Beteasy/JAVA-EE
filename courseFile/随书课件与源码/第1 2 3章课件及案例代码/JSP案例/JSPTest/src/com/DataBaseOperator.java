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
			// �����Ž���
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
		}
	}

	// ��������ֵ���ȡ����ֵ�ķ���
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

	// ��ѯjspdata���ݿ��user��
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

				message = "������û��������벻��ȷ";
				success = "false";
			}
			con.close();
			return message;
		} catch (SQLException e) {
			message = "������û��������벻��ȷ";
			success = "false";
			message = "false";
			return message;

		}
	}

	// ����ѧ��idɾ��ѧ����¼
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

	// ���ѧ����¼
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

	// ����ѧ��id����ѧ����¼
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

	// ����ѧ����ѧ�Ż�������ѯѧ����¼
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
			if (id == "" && name == "") {// ���ѧ�ź�������Ϊ�գ���ѯ����ѧ��
				s = "select * from student";
			}
			if (id != "" && name == "") {// ���ѧ�Ų�Ϊ�ղ�������Ϊ�գ���ѧ�Ų�ѯѧ��
				s = "select * from student where id=" + id + "";
			}
			if (id == "" && name != "") { // ���ѧ��Ϊ�ղ���������Ϊ�գ���������ѯѧ��
				s = "select * from student where name='" + name + "'";
			}
			if (id != "" && name != "") { // ���ѧ�ź���������Ϊ�գ���ѧ�ź�����ͬʱƥ���ѯ
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

	// ��ѯ���ݿ��student���������ѧ����¼
	public Set<Student> searchAllStudents() {
		try {

			Connection conn = null;
			ResultSet rs = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdata?user=root&password=123456");
			java.sql.Statement sql = conn.createStatement();
			String s = "select * from student ";
			Set<Student> sts = new HashSet<Student>();
			rs = sql.executeQuery(s);
			// ������ѯ��������ζ�ȡÿ��ѧ������Ϣ������Student���͵Ķ��󣬲�����Щѧ��������ӵ�����
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

	// ����ѧ��id��ѯѧ����¼
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

	// �����ַ����ķ��������������������
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
