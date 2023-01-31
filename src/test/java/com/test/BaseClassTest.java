package com.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;
import com.java.datadriven.XLXSXReader;
import com.pom.HomePage;
import com.property.Configurationhelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTest extends BaseClass {

	public static WebDriver driver; // null

	public static void main(String[] args) throws Exception {

		String browser = Configurationhelper.getInstanceCR().getBrowser();
		driver = browserLaunch(browser); // chrome
		String url = Configurationhelper.getInstanceCR().getURL();
		launchUrl(url); //
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String name = Configurationhelper.getInstanceCR().getSheet();
		String SelectValue = XLXSXReader.singleData(name, 1, 0);

		HomePage hp = new HomePage(driver);

//		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

		Select s = new Select(hp.getDropDown());

		List<WebElement> dropdownOptions = s.getOptions();

		for (int i = 0; i < dropdownOptions.size(); i++) {

			WebElement eachoption = dropdownOptions.get(i); // index- webelement

			String eachText = eachoption.getText();

			if (eachText.equalsIgnoreCase(SelectValue)) {
				s.selectByVisibleText(eachText);
			}
		}

		String searchProduct = XLXSXReader.singleData(name, 1, 1);

//		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		hp.getSearch().sendKeys(searchProduct);

		Thread.sleep(2000);

//		List<WebElement> relevant = driver
//				.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));

		for (int i = 1; i <= hp.getRelevant().size(); i++) {

			WebElement eachProduct = driver.findElement(By.xpath(
					"//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']"));

			String eachProductText = eachProduct.getText();

			if (eachProductText.equalsIgnoreCase(searchProduct)) {
				eachProduct.click();
				break;
			}

		}
		sleep();

		WebElement firstproduct = driver
				.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", firstproduct);

		String firstProductTitle = getText(firstproduct);

		System.out.println(firstProductTitle);

		WebElement firstProductOffer = driver.findElement(By
				.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']"));

		String fPOP = getText(firstProductOffer);

		System.out.println(fPOP);
		String parentId = getWindow();

		sleep();

		clickOnElement(firstProductOffer);

		String Currenttitle = getTitle();

		System.out.println(Currenttitle);

		Set<String> allId = getMultileWindow();

		System.out.println(allId.size()); // 2

		for (String id : allId) {

			if (!(id.equals(parentId))) {
				driver.switchTo().window(id);
			}

		}

		sleep();

		WebElement selectedProductTitle = driver
				.findElement(By.xpath("//div[@id='titleSection']/child::h1/child::span"));

		String selectedPText = getText(selectedProductTitle);

		if (selectedPText.equalsIgnoreCase(firstProductTitle)) {
			System.out.println("its match");
		} else {
			System.out.println("title doesn't match");
		}

		WebElement selectedProductOfferPrice = driver.findElement(By
				.xpath("//div[@id='title_feature_div']/following-sibling::div[9]/child::div[3]/child::div[1]/span[2]"));

		String selectedPOPriceText = getText(selectedProductOfferPrice);

		if (selectedPOPriceText.equalsIgnoreCase(fPOP)) {
			System.out.println("price match");
		} else {
			System.out.println("price doesn't matcg");
		}

		driver.findElement(By.id("add-to-cart-button")).click();

		// screenshot

		driver.findElement(By.xpath("//div[@id='nav-tools']//a[@id='nav-cart']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Proceed to checkout']")).click();

		Thread.sleep(2000);

		close();

		driver.switchTo().window(parentId);

		capture(driver);
		Thread.sleep(4000);

		quit();

	}
}
