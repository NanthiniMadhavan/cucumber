package com.flipkart.stepdefinition;



import java.util.Set;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class TvValidationSteps {
	static WebDriver driver;
	static long startTime;
    static String name1;
    static String mn;



		  
    
	@When("user search TV")
	public void user_search_TV() {
		mn = "SAMSUNG";
		WebElement search = MobileValidation.driver.findElement(By.name("q"));
		 search.sendKeys("SAMSUNG TV",Keys.ENTER);
		
	   }

	@When("user click on the TV name")
	public void user_click_on_the_TV_name() {
		WebElement mobilename = MobileValidation.driver.findElement(By.xpath("(//div[contains(text(),'"+mn+"')])[1]"));
		 name1 = mobilename.getText();
		 System.out.println(name1);
		 mobilename.click();
	  
	}

	@Then("user validate the TV names")
	public void user_validate_the_TV_names() {
		String parent = MobileValidation.driver.getWindowHandle();
		Set<String> children = MobileValidation.driver.getWindowHandles();
			 for (String x : children) {
				 if(!parent.equals(x)) {
					 MobileValidation.driver.switchTo().window(x);
					 
				 }
			 }
			 WebElement mobilename2 = MobileValidation.driver.findElement(By.xpath("//span[contains(text(),'"+mn+"')]"));
			 Assert.assertTrue(mobilename2.isDisplayed());
			 String name2 = mobilename2.getText();
			 System.out.println(name2); 
			
			 
		    Assert.assertEquals(name1, name2);
			 MobileValidation.driver.quit();
		     
			 
	   
	}

	
		
	
}
