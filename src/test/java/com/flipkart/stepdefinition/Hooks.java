package com.flipkart.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.resources.CommanActions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class Hooks  extends CommanActions {
		public static  WebDriver driver;
		CommanActions ca = new CommanActions();
		
	@Before
		public void beforeLaunch(){
			ca.browserlaunch("https://www.flipkart.com/");
	

	}
	@After
	public void browserQuit() {
		driver.quit();
	}

	}



