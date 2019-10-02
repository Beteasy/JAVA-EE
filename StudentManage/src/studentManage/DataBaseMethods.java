package studentManage;

import java.sql.*;
import java.util.*;

public class DataBaseMethods {
	//���ݿ����ӱ������������洢���������ݿ�����
	Connection conn = null;
	
	//���캯��
	public DataBaseMethods() {
		init();
	}
	
	//��ʼ�������������н������ݿ����ӣ����JDBC�������
//	public void init() {
//		try {
//			//���ݿ�����
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			//���ݿ�·��
//			String url="jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC";
//			String user="root";
//			String password="root";
//			conn = DriverManager.getConnection(url, user, password);
////			conn = DriverManager.getConnection(
////			          "jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC","root","root");
//		}
//		catch(SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	public void init() 
	{
		try {
            //���ݿ�����
			Class.forName("com.mysql.cj.jdbc.Driver");
            //���ݿ�·��
			String url="jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC"; 
		    String user="root"; //���ݿ��û���
			String password="root"; //���ݿ�����
			//������������ݿ�����
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	
	//���ݿ���뷽�����������Ϊѧ�����󣬶������԰�����������Ҫ��ѧ����Ϣ
	public void insert(Student st) {
		try {
			//��student���ʵ���л�ø���ѧ����Ϣ
			int id = st.getId();
			String name = st.getName();
			int age = st.getAge();
			String gender = st.getGender();
			String major = st.getMajor();
			
			//�����������ݿ��SQL���
			String sql = "insert into student(id,name,age,gender,major)"+"values("+ id + "," + name + "," + age + "," 
			+ gender + "," + major + ");";
			
			//ִ�����ݿ����
			Statement stat = null;
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			if(stat != null) {
				stat.close();	//����ΪʲôҪclose
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//���ݿ�ɾ���������������Ϊ��Ҫɾ����ѧ��ѧ��
	public void delete(String id) {
		//�����idΪString����    �Ƿ����󣿣���������������
		try {
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "delete from student where id = "+ id;
			stat.execute(sql);
			if(stat != null) {
				stat.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//���ݿ���²������������Ϊ������Ϣ֮���ѧ������
	public void update(Student st) {
		try {
			//��student���ʵ���л�ø���ѧ����Ϣ
			//������������д�   ����id��ͻ������������������������������������������
			int id = st.getId();
			String name = st.getName();
			int age = st.getAge();
			String gender = st.getGender();
			String major = st.getMajor();
			String sql = "update student set id = " + id + ",name=" + name + ",age=" + age 
					+ ",gender=" + gender + ",major=" + major + "where id = " + id + "";	//���Ӳ��ӷֺţ�����
			
			Statement stat = null;
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			if(stat != null) {
				stat.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//���ݿ��ѯ����
	//�����ѯ����Ϊѧ�ź�����
	//�����ѯ���Ϊ��ѯ��������ѧ������ļ���
	public Set<Student> selectStudents(String id, String name){
		try {
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			Set<Student> sts = new HashSet<Student>();
			if(id == null) {
				id = "";
			}
			if(name == null) {
				name = "";
			}
			if(id == "" && name == "") {
				rs = stat.executeQuery("select * from student");
			}
			if(id != "" && name == "") {
				rs = stat.executeQuery("select * from student where id = " + id + "");
			}
			if(id == "" && name != "") {
				rs = stat.executeQuery("select * from student where name = " + name + "");
			}
			if(id != "" && name != "") {
				rs = stat.executeQuery("select * from student where id = " + id + "and name = " + name + "");
			}
			
			while(rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("name"));
				st.setAge(rs.getInt("age"));
				st.setGender(rs.getString("gender"));
				st.setMajor(rs.getString("major"));
				sts.add(st);
			}
			if(rs != null) {
				rs.close();
			}
			if(stat != null) {
				stat.close();
			}
			return sts;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
