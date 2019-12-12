package cn.edu.cuit.fhzheng.pojo;

import java.io.Serializable;

public class User implements Serializable {

	//	  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	private Integer id;
	//	  `loginName` varchar(255) NOT NULL COMMENT '登录名',
	private String loginName;
	//	  `userName` varchar(255) NOT NULL COMMENT '用户名',
	private String userName;
	//	  `password` varchar(255) NOT NULL COMMENT '密码',
	private String password;
	//	  `sex` int(2) NOT NULL DEFAULT '1' COMMENT '性别(1:男 0：女)',
	private Integer sex;
	//	  `identityCode` varchar(60) DEFAULT NULL COMMENT '身份证号',
	private String identityCode;
	//	  `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
	private String email;
	//	  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
	private String mobile;
	//	  `type` int(2) DEFAULT '0' COMMENT '类型（1：后台 0:前台）',
	private Integer type;
	
	// 访问器
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public User(Integer id, String loginName, String userName, String password, Integer sex, String identityCode,
			String email, String mobile, Integer type) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", userName=" + userName + ", password=" + password
				+ ", sex=" + sex + ", identityCode=" + identityCode + ", email=" + email + ", mobile=" + mobile
				+ ", type=" + type + "]";
	}
	
	// 
	
	
}