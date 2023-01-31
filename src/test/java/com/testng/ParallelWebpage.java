package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelWebpage {

	WebDriver driver = null; //null 
	String searchProduct ;
	private static ChromeOptions desiredOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		return options;

	}
	@Test
	private void browserLaunch() {
		WebDriverManager.chromedriver().setup(); //chrome
		 driver = new ChromeDriver(desiredOptions()); //local - null - chrome 
			driver.get("https://www.amazon.in/"); //chrome - amazon  - chrome driver
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	private void launchURL() {
		WebDriverManager.chromedriver().setup(); //chrome
		 driver = new ChromeDriver(desiredOptions()); //local - null - chrome 
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //chrome - amazon  - chrome driver
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	
}
