package com.basicscript.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Basic1 {
	@BeforeClass
	private void browserLaunch() {
		System.out.println("chrome launch");
	}

	@Test(groups = "homepage")
	private void username() {
		System.out.println("user name enter");
	}

	@Test(groups="homepage")
	private void password() {
		System.out.println("password enter");
	}

	@Test(groups="homepage")
	private void loginBtn() {
		System.out.println("log in application");
	}

	@Test(groups="productpage")
	private void productsearch() {
		System.out.println("search the product");
	}

	@Test(groups="productpage")
	private void productSelect() {
		System.out.println("select the product");
	}
	
	@Test(groups="productdelete")
	private void productdelete() {
		System.out.println("delete the product");
	}

	@AfterClass
	private void browserclose() {
		System.out.println("chrome close ");
	}

}
