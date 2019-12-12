package com.junit.maven;

import org.junit.Test;
import junit.framework.Assert;

public class HelloTest {
	
	@Test
	public void testHello() {
		HelloMaven hm = new HelloMaven();
		String name = hm.Hello("MR.JOHN,Hello!");
		Assert.assertEquals("MR.JOHN,Hello!",name);
	}
	
	@Test
	public void testCatHello() {
		HelloMaven hm=new HelloMaven();
		String name1=hm.CatHello("MR.JOHN");
		String name2=hm.DogHello("SMITH");
		
		System.out.println(name1);
		System.out.println(name2);
	}
}
