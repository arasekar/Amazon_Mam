package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.basicscript.reusableintroduction.UserDefinedException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver; // null

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void clickOnElement(WebElement element) {
		
		
		
		element.click();
		
		
	}

	public static void clearTheElement(WebElement element) {
		element.clear();

	}

	public static void getAttributePlaceHolder(WebElement element) {
		String attribute = element.getAttribute("placeholder");
		System.out.println(attribute);

	}

	public static void getAttributeValue(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);

	}

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public static boolean isEnable(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;

	}

	public static boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);

	}

	public static WebDriver browserLaunch(String browser) throws UserDefinedException {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("gecko")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else {
				throw new UserDefinedException("invalid browser");
			}
		} catch (UserDefinedException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void fullScreen() {
		driver.manage().window().fullscreen();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String getWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static Set<String> getMultileWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public static void keyDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void keyEnter() {

	}

	public static void acceptSendkeys(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void alert(String option) {

		Alert alert = driver.switchTo().alert();
		try {
			if (option.equalsIgnoreCase("ok")) {
				alert.accept();
			} else if (option.equalsIgnoreCase("cancel")) {
				alert.dismiss();
			}else {
				throw new NoAlertPresentException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void frameSwitch(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static int totalFrame(List<WebElement> element) {
		int size = element.size();
		return size;

	}

	public static void mouseBasedActions(String option, WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		if (option.equalsIgnoreCase("move")) {
			a.moveToElement(element).build().perform();
		} else if (option.equalsIgnoreCase("click")) {
			a.click(element).perform();
		}
	}

	public static void drpDownSelect(WebElement element, String option, String value) {

		Select s = new Select(element);

		if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		} else if (option.equalsIgnoreCase("index")) {
			int p = Integer.parseInt(value);
			s.selectByIndex(p);

		} else {
			System.out.println("invalid select");
		}

	}

	public static void capture(WebDriver driver) throws IOException {

		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("mm/dd/yyyy");
//		d = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String format = d.format(date);
		String r = format.replaceAll("/", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;// narrowing
		File source = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\lenovo\\eclipse-workspace\\Amazon_Project\\ScreenShot\\Amazon" + r + ".png");
		FileUtils.copyFile(source, des);
//		FileHandler.copy(source, des);
	}

}
