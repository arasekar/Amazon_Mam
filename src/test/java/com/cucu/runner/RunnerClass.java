package com.cucu.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baseclass.BaseClass;
import com.basicscript.reusableintroduction.UserDefinedException;
import com.property.Configurationhelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\cucumber\\feature\\Amzon.feature", 

glue = "com.cucu.stepdefinition" , tags = "@smoke" ,stepNotifications = true , monochrome = true,
plugin = "pretty"
)
public class RunnerClass {

	public static WebDriver driver = null;

	@BeforeClass
	public static void browserLaunch() throws Exception { //setUp

		String browser = Configurationhelper.getInstanceCR().getBrowser();
		driver = BaseClass.browserLaunch(browser); // chrome
	}

	@AfterClass
	public static void browserClose() { //tearDown

//		BaseClass.close();
		driver.close();
	}

}
