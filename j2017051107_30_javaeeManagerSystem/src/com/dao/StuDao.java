package com.dao;

import java.util.List;

import com.entity.Student;

public interface StuDao {
//	按照学号查找学生
	public Student getStudentByStuNo(Integer stuNo);
	
//	按姓名查找学生-包括了模糊查询
	public List<Student> getStudentByName(String stuName);
	
//	按班级查找学生
	public List<Student> getStudentsByClassId(Integer classId);
	
//	查询所有学生
	public List<Student> getAllStudents();
}
