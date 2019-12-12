//package com.daoImpl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.DBUtils.DBUtils;
//import com.dao.StuDao;
//import com.entity.Student;
//
//public class StuDaoImpl implements StuDao{
//	
//	Connection connection = null;
//	PreparedStatement preparedStatement = null;
//	ResultSet resultSet = null;
//
//	@Override
//	public Student getStudentByStuNo(Integer stuNo) {
//		// TODO Auto-generated method stub
//		
//		String sql = "select * from student where stuNo = ?";
//		Student student = null;
//		try {
//			connection = DBUtils.getConnection();
//			
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, stuNo);
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				student = new Student();
//				student.setStuNo(resultSet.getInt("stuNo"));
//				student.setStuName(resultSet.getString("stuName"));
//				student.setClassId(resultSet.getInt("classId"));
//				student.setStuPermission(resultSet.getInt("stuPermission"));
//				student.setUserName(resultSet.getString("userName"));
//				student.setPassword(resultSet.getString("password"));
//				student.setPhoneNumber(resultSet.getString("password"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DBUtils.releaseResource(connection, preparedStatement, resultSet);
//		}
//		System.out.println("daoimple get student:"+ student);
//		return student;
//	}
//
//	@Override
//	public List<Student> getStudentByName(String stuName) {
//		// TODO Auto-generated method stub
//		//java.sql.PreparedStatement prep = (PreparedStatement) connection.prepareStatement("select * from student where stuName = ?");
//		String sql = "select * from student where stuName like ?";
//							
//		List<Student> studentList = new ArrayList<Student>();
//				
//		try {
//			connection = DBUtils.getConnection();
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, "%"+stuName+"%");
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				Student student = new Student();
//				student.setStuNo(resultSet.getInt("stuNo"));
//				student.setStuName(resultSet.getString("stuName"));
//				student.setClassId(resultSet.getInt("classId"));
//				student.setStuPermission(resultSet.getInt("stuPermission"));
//				student.setUserName(resultSet.getString("userName"));
//				student.setPassword(resultSet.getString("password"));
//				student.setPhoneNumber(resultSet.getString("password"));
//				studentList.add(student);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DBUtils.releaseResource(connection, preparedStatement, resultSet);
//		}
//		System.out.println("daoimple get student:"+ studentList);
//		return studentList;
//	}
//
//	@Override
//	public List<Student> getStudentsByClassId(Integer classId) {
//		// TODO Auto-generated method stub
//		String sql = "select * from student where classId = ?";
//		List<Student> studentList = new ArrayList<Student>();
//		Student student = null;
//		try {
//			connection = DBUtils.getConnection();
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, classId);
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				student = new Student();
//				student.setStuNo(resultSet.getInt("stuNo"));
//				student.setStuName(resultSet.getString("stuName"));
//				student.setClassId(resultSet.getInt("classId"));
//				student.setStuPermission(resultSet.getInt("stuPermission"));
//				student.setUserName(resultSet.getString("userName"));
//				student.setPassword(resultSet.getString("password"));
//				student.setPhoneNumber(resultSet.getString("password"));
//				studentList.add(student);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DBUtils.releaseResource(connection, preparedStatement, resultSet);
//		}
//		System.out.println("daoimple get student:"+ studentList);
//		return studentList;
//	}
//
//	public List<Student> getAllStudents() {
//		// TODO Auto-generated method stub
//		String sql = "select * from student";
//		Student student = null;
//		List<Student> studentList = new ArrayList<Student>();
//		
//		try {
//			connection = DBUtils.getConnection();
//			preparedStatement = connection.prepareStatement(sql);
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				student = new Student();
//				student.setStuNo(resultSet.getInt("stuNo"));
//				student.setStuName(resultSet.getString("stuName"));
//				student.setClassId(resultSet.getInt("classId"));
//				student.setStuPermission(resultSet.getInt("stuPermission"));
//				student.setUserName(resultSet.getString("userName"));
//				student.setPassword(resultSet.getString("password"));
//				student.setPhoneNumber(resultSet.getString("password"));
//				studentList.add(student);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DBUtils.releaseResource(connection, preparedStatement, resultSet);
//		}
//		System.out.println("daoimple get studentList:"+ studentList);
//		return studentList;
//	}
//
//}
