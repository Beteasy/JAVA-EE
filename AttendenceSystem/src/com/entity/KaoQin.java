package com.entity;

import java.util.Date;

public class KaoQin {
	private int stuNo;	     	
	private String stuName;		
	private int grade;			
	private int classId;	
	private int status;
	private int courNo;
	private Date date;
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCourNo() {
		return courNo;
	}
	public void setCourNo(int courNo) {
		this.courNo = courNo;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "KaoQin [stuNo=" + stuNo + ", stuName=" + stuName + ", grade=" + grade + ", classId=" + classId
				+ ", status=" + status + ", courNo=" + courNo + ", date=" + date + "]";
	}
	
}
