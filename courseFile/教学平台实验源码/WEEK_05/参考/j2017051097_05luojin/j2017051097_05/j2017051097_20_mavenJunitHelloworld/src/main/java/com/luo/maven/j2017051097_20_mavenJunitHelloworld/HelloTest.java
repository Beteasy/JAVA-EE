package com.luo.maven.j2017051097_20_mavenJunitHelloworld;

import org.junit.Test;

import junit.framework.Assert;

public class HelloTest {
	
	@Test
	public void testHello() {
		HelloMaven hm = new HelloMaven();
		String name = hm.Hello("Tom,Hello!");
		Assert.assertEquals("Tom,Hello!",name);
	}
	
	@Test
	public void testCatHello() {
		HelloMaven hm=new HelloMaven();
		String name1=hm.PeopleHello("张三");
		String name2=hm.EnglishHello("Peter");
		
		System.out.println(name1);
		System.out.println(name2);
	}
}