package com.dao;

import java.util.List;

import com.entity.Student;

public interface StuDao {

	public Student getStudentByStuNo(Integer stuNo);
	

	public List<Student> getStudentByName(String stuName);
	

	public List<Student> getStudentsByClassId(Integer classId);
	

	public List<Student> getAllStudents();
}
