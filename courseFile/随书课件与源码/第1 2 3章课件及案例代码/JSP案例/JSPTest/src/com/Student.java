/*学生实体类*/
package com;

public class Student {
	int id;// 学号
	String name;// 姓名
	String age;// 年龄
	String gender;// 性别
	String major;// 专业
	// 属性值的设置与获取方法

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;

	}

}
