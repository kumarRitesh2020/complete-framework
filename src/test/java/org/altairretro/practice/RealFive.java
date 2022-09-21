package org.altairretro.practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RealFive {
	
	@BeforeTest
	public void India() {
		System.out.println("this will be executed before every test cases");
	}
	
	@AfterTest
	public void Delhi() {
		System.out.println("this will be executed after every test cases");
	}
	@Test
	public void test5() {
		System.out.println("test5 of real5 executed");
	}


}
