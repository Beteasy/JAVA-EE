/*数据库访问类*/
/*由于建立数据库连接的开销较大，一般采用数据库连接池的方式来处理数据库连接*/
/*鉴于本示例中数据库访问量较小，在这里采用单例模式来构建数据库访问类*/
/*即为该实例中的所有数据库访问只建立一个数据库连接*/
package com;

import java.sql.*;
import java.util.*;

public class DataBaseMethods {
    //数据库连接变量，用来存储建立的数据库连接
	Connection conn = null;
    //构造函数
	public DataBaseMethods() 
	{
		init();
	}
	//初始化方法，在其中建立数据库连接，详见JDBC相关内容
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
	//数据库插入方法，输入参数为学生对象，对象属性包含了所有需要的写生信息。
	public void insert(Student st)
	{
		try {
            //从Student类的实例中获得各个学生信息
			int id=st.getId();
	        String name=st.getName();
	        int age=st.getAge();
	        String gender=st.getGender();
	        String major=st.getMajor();
            //创建插入数据库的SQL语句
			String sql = "insert into student(id,name,age,gender,major)"
							+ " values("+id+",'"+name+"',"+age+",'"
							+gender+"','"+major+"');";
            //执行数据库操作
	      	Statement stat=null;
			stat=conn.createStatement();
			stat.executeUpdate(sql); 
			if(stat!=null){
		    	   stat.close();
		    }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//数据库删除方法，输入参数为需删除的学生的学号
	public void delete(String id)
	{
		try {
			Statement stat=null;			
			stat=conn.createStatement();
			String sql = "delete from student where id="+id;
	 		stat.executeUpdate(sql);
			if(stat!=null){
		    	   stat.close();
		    }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//数据库更新操作，输入参数为更新信息之后的学生对象
	public void update(Student st)
	{
		try {	    	
			//从Student类的实例中获得各个学生信息
			int id=st.getId();
	        String name=st.getName();
	        int age=st.getAge();
	        String gender=st.getGender();
	        String major=st.getMajor();
            //创建更新数据库的SQL语句
			String sql = "update student set id="+id+
					",name='"+name+"',age="+age+
					",gender='"+gender+"',major='"+major+
					"' where id="+id+"";
            //执行数据库操作
            Statement stat=null;
            stat=conn.createStatement();
			stat.executeUpdate(sql);
			if(stat!=null){
		    	   stat.close();
		    }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//数据库查询操作
	//输入查询条件为学号和姓名
	//输出查询结果为查询到的所有学生对象的集合
	public Set<Student> selectStudents(String id, String name)
	{
		try {		
	    	Statement stat=null;
		    ResultSet rs=null;
			stat=conn.createStatement();
			Set<Student> sts= new HashSet<Student>();
	    	if(id==null) id ="";
	    	if(name==null) name ="";
	    	if(id==""&&name==""){//如果学号和姓名都为空，查询所有学生
	    	     rs=stat.executeQuery("select * from student"); 
	    	}
	    	if(id!=""&&name==""){//如果学号不为空并且姓名为空，按学号查询学生
	   	        rs=stat.executeQuery("select * from student where id="+id+""); 
	     	}
	    	if(id==""&&name!=""){ //如果学号为空并且姓名不为空，按姓名查询学生
	   	        rs=stat.executeQuery("select * from student where name='"+name+"'"); 
	   	    }
	    	if(id!=""&&name!=""){ //如果学号和姓名都不为空，按学号和姓名同时匹配查询
	      	    rs=stat.executeQuery("select * from student where id="+id+" and name='"+name+"'"); 
	      	}
	    	//遍历查询结果，依次读取每个学生的信息，创建Student类型的对象
	    	//并将这些学生对象添加的集合中
	    	while(rs.next())
	        {
	        	Student st = new Student();
	        	st.setId(rs.getInt("id"));
	        	st.setName(rs.getString("name"));
	        	st.setAge(rs.getInt("age"));
	        	st.setGender(rs.getString("gender"));
	        	st.setMajor(rs.getString("major"));
	        	sts.add(st);
	        }
		    if(rs!=null){
		    	  rs.close();
		       }
			if(stat!=null){
		    	   stat.close();
		    }
            //返回查询到的所有学生的集合
			return sts ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
