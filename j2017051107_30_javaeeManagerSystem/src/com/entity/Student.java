package com.entity;

public class Student {
	private int stuNo;	     	//ѧ��
	private String stuName;		//����
	private int classId;		//�༶
	private int stuPermission;	//Ȩ��
	private String userName;    //�û���
	private String password;  	//����
	private String phoneNumber;	//�ֻ���
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getStuPermission() {
		return stuPermission;
	}
	public void setStuPermission(int stuPermission) {
		this.stuPermission = stuPermission;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", classId=" + classId + ", stuPermission="
				+ stuPermission + ", userName=" + userName + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
