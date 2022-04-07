package com.flipkart.resources;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommanActions {
	public static  WebDriver driver;
	public void browserlaunch(String url1) {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://www.flipkart.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   

	}
	public void insertText(WebElement ele,String value) {
		
		ele.sendKeys(value,Keys.ENTER);
		
	}
	public void button(WebElement ele) {
		ele.click();
	}
	
	public void windowHandling() {
		String parent = driver.getWindowHandle();
		
		Set<String> children = driver.getWindowHandles();
		
			 for (String x : children) {
				 if(!parent.equals(x)) {
					 driver.switchTo().window(x);
					 
				 }
	}
}
	
}
