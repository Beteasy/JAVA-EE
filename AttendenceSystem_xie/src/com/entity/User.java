package com.entity;

public class User {
	int useNo;			//用户编号  学生的为学号   教师和辅导员的为对应的编号
	String username;	//用户名
	String password;	//密码
	int permission;		//权限 学生为0  教师为1   辅导员为2
	public int getUseNo() {
		return useNo;
	}
	public void setUseNo(int useNo) {
		this.useNo = useNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "User [useNo=" + useNo + ", username=" + username + ", password=" + password + ", permission="
				+ permission + "]";
	}

	
}
