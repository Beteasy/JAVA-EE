package studentManage;

import java.sql.*;
import java.util.*;

public class DataBaseMethods {
	//数据库连接变量个，用来存储建立的数据库连接
	Connection conn = null;
	
	//构造函数
	public DataBaseMethods() {
		init();
	}
	
	//初始化方法，在其中建立数据库连接，详见JDBC相关内容
//	public void init() {
//		try {
//			//数据库驱动
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			//数据库路径
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
            //数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
            //数据库路径
			String url="jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC"; 
		    String user="root"; //数据库用户名
			String password="root"; //数据库密码
			//建立并获得数据库连接
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	
	//数据库插入方法，输入参数为学生对象，对象属性包含了所有需要的学生信息
	public void insert(Student st) {
		try {
			//从student类的实例中获得各个学生信息
			int id = st.getId();
			String name = st.getName();
			int age = st.getAge();
			String gender = st.getGender();
			String major = st.getMajor();
			
			//创建插入数据库的SQL语句
			String sql = "insert into student(id,name,age,gender,major)"+"values("+ id + "," + name + "," + age + "," 
			+ gender + "," + major + ");";
			
			//执行数据库操作
			Statement stat = null;
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			if(stat != null) {
				stat.close();	//这里为什么要close
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//数据库删除方法，输入参数为需要删除的学生学号
	public void delete(String id) {
		//这里的id为String类型    是否有误？？？？？？？？？
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
	
	//数据库更新操作，输入参数为更新信息之后的学生对象
	public void update(Student st) {
		try {
			//从student类的实例中获得各个学生信息
			//这个函数好像有错   两个id冲突？？？？？？？？？？？？？？？？？？？？？
			int id = st.getId();
			String name = st.getName();
			int age = st.getAge();
			String gender = st.getGender();
			String major = st.getMajor();
			String sql = "update student set id = " + id + ",name=" + name + ",age=" + age 
					+ ",gender=" + gender + ",major=" + major + "where id = " + id + "";	//最后加不加分号？？？
			
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
	
	//数据库查询操作
	//输入查询条件为学号和姓名
	//输出查询结果为查询到的所有学生对象的集合
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
