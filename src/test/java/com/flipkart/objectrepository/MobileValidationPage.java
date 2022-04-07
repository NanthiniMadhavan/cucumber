package com.flipkart.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.resources.CommanActions;

public class MobileValidationPage extends CommanActions{
	
	public MobileValidationPage() {
		
		PageFactory.initElements(driver,this);
		
	}
	
@FindBy(xpath ="//button[text()='✕']")
private WebElement closeIcon;

@FindBy(xpath ="q")
private WebElement searchBox;

public WebElement getCloseIcon() {
	return closeIcon;
}

public WebElement getSearchBox() {
	return searchBox;
}




}
