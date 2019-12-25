package com.entity;

public class Course {
	Integer courNo;
	String courName;
	Integer totalIime;
	public Integer getCourNo() {
		return courNo;
	}
	public void setCourNo(Integer courNo) {
		this.courNo = courNo;
	}
	public String getCourName() {
		return courName;
	}
	public void setCourName(String courName) {
		this.courName = courName;
	}
	public Integer getTotalIime() {
		return totalIime;
	}
	public void setTotalIime(Integer totalIime) {
		this.totalIime = totalIime;
	}
	@Override
	public String toString() {
		return "Course [courNo=" + courNo + ", courName=" + courName + ", totalIime=" + totalIime + "]";
	}
	
	
}
