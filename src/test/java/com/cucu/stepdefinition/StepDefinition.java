package com.cucu.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;
import com.cucu.runner.RunnerClass;
import com.java.datadriven.XLXSXReader;
import com.pom.SDP;
import com.property.Configurationhelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	public WebDriver driver = RunnerClass.driver; //chrome
	public SDP sdp;
	public String searchProduct ;
	@Given("user Launch The Application Url")
	public void user_launch_the_application_url() throws IOException {

		String url = Configurationhelper.getInstanceCR().getURL();
		
		launchUrl(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("user Selectes The {string} From Dropdown")
	public void user_selectes_the_from_dropdown(String dropDown) {
		
		String SelectValue = dropDown;
		
		sdp= new SDP(driver); //chrome
		Select s = new Select(sdp.getHomePage().getDropDown());

		List<WebElement> dropdownOptions = s.getOptions();

		for (int i = 0; i < dropdownOptions.size(); i++) {

			WebElement eachoption = dropdownOptions.get(i); // index- webelement

			String eachText = eachoption.getText();

			if (eachText.equalsIgnoreCase(SelectValue)) {
				s.selectByVisibleText(eachText);
			}
		}
	}

	@When("user Search The {string} In SearchBox")
	public void user_search_the_in_search_box(String product) throws Exception {
		searchProduct = product;
		sdp.getHomePage().getSearch().sendKeys(searchProduct);

		Thread.sleep(2000);

	}

	@Then("user Click The Searched Product From The Suggestion and It navigates To productPage")
	public void user_click_the_searched_product_from_the_suggestion_and_it_navigates_to_product_page() throws  Exception {

		for (int i = 1; i <= sdp.getHomePage().getRelevant().size(); i++) {

			WebElement eachProduct = driver.findElement(By.xpath(
					"//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']"));

			String eachProductText = eachProduct.getText();

			if (eachProductText.equalsIgnoreCase(searchProduct)) {
				eachProduct.click();
				break;
			}

		}
		sleep();
		capture(driver);
		
		
	}

}
