package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public static WebDriver driver; //null 

	@FindBy(id = "searchDropdownBox")
	private WebElement dropDown;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement search;

	@FindBy(xpath = "//div[@class='autocomplete-results-container']/child::div")
	private List<WebElement> relevant;

	public HomePage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSearch() {
		return search;
	}

	public List<WebElement> getRelevant() {
		return relevant;
	}

}
