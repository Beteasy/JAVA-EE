package com.dao;

import java.util.List;

import com.entity.Student;

public interface StuDao {
//	����ѧ�Ų���ѧ��
	public Student getStudentByStuNo(Integer stuNo);
	
//	����������ѧ��-������ģ����ѯ
	public List<Student> getStudentByName(String stuName);
	
//	���༶����ѧ��
	public List<Student> getStudentsByClassId(Integer classId);
	
//	��ѯ����ѧ��
	public List<Student> getAllStudents();
}
