/*���ݿ������*/
/*���ڽ������ݿ����ӵĿ����ϴ�һ��������ݿ����ӳصķ�ʽ���������ݿ�����*/
/*���ڱ�ʾ�������ݿ��������С����������õ���ģʽ���������ݿ������*/
/*��Ϊ��ʵ���е��������ݿ����ֻ����һ�����ݿ�����*/
package com;

import java.sql.*;
import java.util.*;

public class DataBaseMethods {
    //���ݿ����ӱ����������洢���������ݿ�����
	Connection conn = null;
    //���캯��
	public DataBaseMethods() 
	{
		init();
	}
	//��ʼ�������������н������ݿ����ӣ����JDBC�������
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
	//���ݿ���뷽�����������Ϊѧ�����󣬶������԰�����������Ҫ��д����Ϣ��
	public void insert(Student st)
	{
		try {
            //��Student���ʵ���л�ø���ѧ����Ϣ
			int id=st.getId();
	        String name=st.getName();
	        int age=st.getAge();
	        String gender=st.getGender();
	        String major=st.getMajor();
            //�����������ݿ��SQL���
			String sql = "insert into student(id,name,age,gender,major)"
							+ " values("+id+",'"+name+"',"+age+",'"
							+gender+"','"+major+"');";
            //ִ�����ݿ����
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
	//���ݿ�ɾ���������������Ϊ��ɾ����ѧ����ѧ��
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
	//���ݿ���²������������Ϊ������Ϣ֮���ѧ������
	public void update(Student st)
	{
		try {	    	
			//��Student���ʵ���л�ø���ѧ����Ϣ
			int id=st.getId();
	        String name=st.getName();
	        int age=st.getAge();
	        String gender=st.getGender();
	        String major=st.getMajor();
            //�����������ݿ��SQL���
			String sql = "update student set id="+id+
					",name='"+name+"',age="+age+
					",gender='"+gender+"',major='"+major+
					"' where id="+id+"";
            //ִ�����ݿ����
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
	//���ݿ��ѯ����
	//�����ѯ����Ϊѧ�ź�����
	//�����ѯ���Ϊ��ѯ��������ѧ������ļ���
	public Set<Student> selectStudents(String id, String name)
	{
		try {		
	    	Statement stat=null;
		    ResultSet rs=null;
			stat=conn.createStatement();
			Set<Student> sts= new HashSet<Student>();
	    	if(id==null) id ="";
	    	if(name==null) name ="";
	    	if(id==""&&name==""){//���ѧ�ź�������Ϊ�գ���ѯ����ѧ��
	    	     rs=stat.executeQuery("select * from student"); 
	    	}
	    	if(id!=""&&name==""){//���ѧ�Ų�Ϊ�ղ�������Ϊ�գ���ѧ�Ų�ѯѧ��
	   	        rs=stat.executeQuery("select * from student where id="+id+""); 
	     	}
	    	if(id==""&&name!=""){ //���ѧ��Ϊ�ղ���������Ϊ�գ���������ѯѧ��
	   	        rs=stat.executeQuery("select * from student where name='"+name+"'"); 
	   	    }
	    	if(id!=""&&name!=""){ //���ѧ�ź���������Ϊ�գ���ѧ�ź�����ͬʱƥ���ѯ
	      	    rs=stat.executeQuery("select * from student where id="+id+" and name='"+name+"'"); 
	      	}
	    	//������ѯ��������ζ�ȡÿ��ѧ������Ϣ������Student���͵Ķ���
	    	//������Щѧ��������ӵļ�����
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
            //���ز�ѯ��������ѧ���ļ���
			return sts ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
