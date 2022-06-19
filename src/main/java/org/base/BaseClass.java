package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver launchBrowser(String BrowserName) {
		// if(BrowserName.equals("chrome")) {
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		// }
		// else if(BrowserName.equals("firefox")) {
		// WebDriverManager.firefoxdriver().setup();
		// driver = new FirefoxDriver();
		// }
		// else if(BrowserName.equals("edge")){
		// WebDriverManager.edgedriver().setup();
		// driver = new EdgeDriver();
		// }
		// return driver;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		switch (BrowserName) {
		
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("invalid Browser");
			break;
		}
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	public static void urlLaunch(String url) {
		driver.get(url);
	}

	public static void implicitWait(long sec) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void btnclick(WebElement e) {
		e.click();
	}

	public static void browserQuit() {
		driver.quit();
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void movetoElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public static void dragAndDrop(WebElement scr, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(scr, des).perform();
	}

	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static String getAttributes(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}

	public static WebElement findElement(String locatorname, String locator) {
		WebElement e = null;
		if (locatorname.equals("id")) {
			e = driver.findElement(By.id(locator));
		}

		else if (locatorname.equals("name")) {
			e = driver.findElement(By.name(locator));
		}

		else if (locatorname.equals("xpath")) {
			e = driver.findElement(By.xpath(locator));
		}
		return e;
	}

	public static void screenshot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);

		File des = new File("C:\\Users\\USER\\eclipse-workspace\\Selenium10am\\Screenshot\\Facebook\\" + name + ".png");
		FileUtils.copyFile(src, des);
	}

	public static void js(String name, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + name + "')", e);
	}

	
}
