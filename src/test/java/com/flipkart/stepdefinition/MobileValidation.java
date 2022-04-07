package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.objectrepository.MobileValidationPage;
import com.flipkart.resources.CommanActions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileValidation extends CommanActions {
	static WebDriver driver;
	static long startTime;
    static String name1;
    static String mn;
    CommanActions ca = new CommanActions();
    MobileValidationPage m = new  MobileValidationPage();
@Given("user launches flipkart application")
public void user_launches_flipkart_application() {
	WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
}

@Given("user login by entering valid crendentials")
public void user_login_by_entering_valid_crendentials() {
	try {
		ca.button(m.getCloseIcon());;
				
	}catch(Exception e) {
	
	} 
 
}

@When("user search mobile")
public void user_search_mobile() {
	mn = "realme";
	
	
	ca.insertText(m.getSearchBox(), mn);
	
   
}

@When("user click on the mobile name")
public void user_click_on_the_mobile_name() {
	WebElement mobilename = driver.findElement(By.xpath("(//div[contains(text(),'"+mn+"')])[1]"));
	 name1 = mobilename.getText();
	 System.out.println(name1);
	 ca.button(mobilename);
    
}

@Then("user validate the mobile names")
public void user_validate_the_mobile_names() {
	String parent = driver.getWindowHandle();
	Set<String> children = driver.getWindowHandles();
		 for (String x : children) {
			 if(!parent.equals(x)) {
				 driver.switchTo().window(x);
				 
			 }
		 }
		 WebElement mobilename2 = driver.findElement(By.xpath("//span[contains(text(),'"+mn+"')]"));
		 Assert.assertTrue(mobilename2.isDisplayed());
		 String name2 = mobilename2.getText();
		 System.out.println(name2); 
		
		 
	     Assert.assertEquals(name1, name2);
		 driver.quit();
	     
   
}

@When("user search mobile by one dim list")
public void user_search_mobile_by_one_dim_list(DataTable dataTable) {

  List<String> datas =   dataTable.asList();
	mn = datas.get(0);
  
  ca.insertText(m.getSearchBox(), mn);
	
  
}
@When("user search mobile by one dim map")

public void user_search_mobile_by_one_dim_map(DataTable dataTable) {
	
 Map<String, String> datas = dataTable.asMap(String.class, String.class);
   mn = datas.get("1");
   
  
  
  ca.insertText(m.getSearchBox(), mn);
  
}
@When("user search mobile {string}")
public void user_search_mobile(String phone) {
	phone = mn;
	
	
	 
	 ca.insertText(m.getSearchBox(), phone);

	
    
}


}
