package com.bean;

public class Email {
	private String email = null;
	private boolean isEmail = false;
	
	public Email() {
		
	}
	
	public Email(String email) {
		this.email = email;
	}
	
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isEmail() {
		String regex =  "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if (email.matches(regex)) {
			isEmail = true;
		}
		return isEmail;
	}
	
	public void setIsEmail(boolean isEmail) {
		this.isEmail = isEmail;
	}
}
