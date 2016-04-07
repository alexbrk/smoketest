package com.smoketest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends AnyPage {

	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//li[@class='success-msg']/ul/li/span")
	private WebElement confirmationMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='welcome-msg']/p/strong")
	private WebElement loginConfirmationMessage;
	
	public boolean isRegSuccessful() {
		
		return confirmationMessage.getText().equalsIgnoreCase("Thank you for registering with 1949 Deal.");
				
	}
	
	public boolean isLoginSuccessful() {
		
		//checks by customer name
		return loginConfirmationMessage.getText().contains(LoginPage.defaultName);
				
	}

	

}
