package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon1 {
	WebDriver driver = null; // null
	String searchProduct = "Soft Toys";

	private static ChromeOptions desiredOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		return options;

	}

	@BeforeTest
	private void browserLaunch() {
		WebDriverManager.chromedriver().setup(); // chrome
		driver = new ChromeDriver(desiredOptions()); // local - null - chrome
	}

	@BeforeClass
	private void launchURL() {
		driver.get("https://www.amazon.in/"); // chrome - amazon - chrome driver

	}

	@Test(timeOut = 1000,expectedExceptions = ThreadTimeoutException.class) // wait 1 
	private void dropDown() throws InterruptedException {

		Thread.sleep(3000); //3 - test fail 
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

		Select s = new Select(dropDown);

		s.selectByVisibleText("Baby");

	}

	@AfterTest
	private void BrowserClose() {
		driver.close();
	}
	
	
	

}
