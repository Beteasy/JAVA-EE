package com.entity;

public class Teacher {
	private int teaNo;				//教师编号
	private String teaName;  		//教师姓名
	
	
	public int getTeaNo() {
		return teaNo;
	}


	public void setTeaNo(int teaNo) {
		this.teaNo = teaNo;
	}


	public String getTeaName() {
		return teaName;
	}


	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}


	@Override
	public String toString() {
		return "Teacher [teaNo=" + teaNo + ", teaName=" + teaName + "]";
	}
	
	
}
