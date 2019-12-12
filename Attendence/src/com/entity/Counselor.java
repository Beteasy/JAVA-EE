package com.entity;

public class Counselor {
	private int counNo;			//辅导员编号
	private String counName;	//辅导员姓名
	private int grade;			//管理年级
	public int getCounNo() {
		return counNo;
	}
	public void setCounNo(int counNo) {
		this.counNo = counNo;
	}
	public String getCounName() {
		return counName;
	}
	public void setCounName(String counName) {
		this.counName = counName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Counselor [counNo=" + counNo + ", counName=" + counName + ", grade=" + grade + "]";
	}
	
	
}
