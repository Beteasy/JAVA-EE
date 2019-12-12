package com.service;

import java.util.ArrayList;
import java.util.List;

import com.daoImpl.StuDaoImpl;
import com.entity.Student;

public class StuService {
	StuDaoImpl stuDaoImpl = new StuDaoImpl();
	
//	按照学号查找学生
	public Student getStudentByStuNo(Integer stuNo) {
		Student Student = null;
		Student = stuDaoImpl.getStudentByStuNo(stuNo);
		return Student;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> studentList = null;
		studentList = stuDaoImpl.getAllStudents();
		return studentList;
	}
	
//	按姓名查找学生-包括了模糊查询
	public List<Student> getStudentByName(String stuName){
		List<Student> studentList = new ArrayList<Student>();
		studentList = stuDaoImpl.getStudentByName(stuName);
		return studentList;
	}

//	按班级查找学生
	public List<Student> getStudentsByClassId(Integer classId){
		List<Student> studentList = null;
		studentList = stuDaoImpl.getStudentsByClassId(classId);
		return studentList;
	}

}
