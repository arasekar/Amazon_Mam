package com.basicscript.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class BasicTestNg {
	@BeforeSuite
	private void subMethod() {
		System.out.println("before suite");
	}
	@BeforeTest
	private void subMethod1() {
		System.out.println("before test");
	}
	@BeforeClass
	private void subMethod2() {
		System.out.println("before class");
	}
	@BeforeMethod
	private void subMethod3() {
		System.out.println("before method");
	}
	@Test(invocationCount = 3)
	private void subMethod4() {
		System.out.println("test 1");
	}
	@Test(timeOut = 2000, expectedExceptions = ThreadTimeoutException.class)
	private void subMethod5() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("test 2");
	}
	@AfterMethod
	private void subMethod6() {
		System.out.println("after method");
	}
	@AfterClass
	private void subMethod7() {
		System.out.println("after class");
	}
	@AfterTest
	private void subMethod8() {
		System.out.println("after test");
	}
	@AfterSuite
	private void subMethod9() {
		System.out.println("after suite");
	}

}
