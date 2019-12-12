package com.lele.my;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitTest {
	public JunitTest() {
	System.out.println("构造函数");
	}

	/**
	 * 测试类准备
	 */
	@BeforeClass
	public static void beforeClass(){
		System.out.println("@BeforeClass");
	}
	
	/**
	 * 测试前准备
	 */
	@Before
	public void befor(){
		System.out.println("@Before");
	}
	
	/**
	 * 功能测试点
	 */
	@Test
	public void test(){
		System.out.println("@Test");
	}
	
	/**
	 * 忽略相应的测试
	 */
	@Ignore
	public void ignore(){
		System.out.println("@Ignore");
	}
	
	/**
	 * 测试后善后
	 */
	@After
	public void after(){
		System.out.println("@After");
	}
	
	/**
	 * 测试后类收尾工作
	 */
	@AfterClass
	public static void afterClass(){
		System.out.println("@AfterClass");
	}

}
