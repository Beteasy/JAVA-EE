package com.lele.my;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 用传统方式实现测试
 * 
 * @author fhzheng
 * 
 */
public class CalculatorTest {
	Calculator c = null;

	public static void main(String[] args) {
		Calculator c = new Calculator();
		// 测试 add()方法
		int result = c.add(1, 2);
		if (result == 3) {
			System.out.println("add()方法正确");
		}
		// 测试 sub()方法
		int result2 = c.sub(2, 1);
		if (result2 == 1) {
			System.out.println("sub()方法正确");
		}
	}

	@Before
	public void testBeforeClass() {
		c = new Calculator();
	}

	@Test
	// 测试 add()方法
	public void testAdd1() {
		Calculator c = new Calculator();
		int result = c.add(1, 2);
		Assert.assertEquals(result, 3);
	}

	@Test
	// 测试 sub()方法
	public void testSub1() {
		Calculator c = new Calculator();
		int result = c.sub(2, 1);
		Assert.assertEquals(result, 1);
	}

	@Test
	public void testAdd2() {
		int result = c.add(3, 4);
		if (result == 7) {
			System.out.println("add()测试正确");
		}
	}

	@Test
	public void testSub2() {
		int result=c.sub(21, 2);
		if (result == 19) {
			System.out.println("add()测试正确");
		} else {
			System.out.println("add()测试错误");
		}
	}
}
