package com.smoketest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AnyPage {

	private WebDriver driver;


	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='login-form']//button[@title='Create an Account']")
	private WebElement createAnAccount;
	
	@FindBy(how = How.ID, using = "email")
	private WebElement email;
	
	@FindBy(how = How.ID, using = "pass")
	private WebElement pass;
	
	@FindBy(how = How.ID, using = "send2")
	private WebElement submitLogin;
	
	@FindBy(how = How.XPATH, using = "//li[@class='error-msg']//span")
	private WebElement errorMessage;

	public RegisterPage clickCreateAnAccount() {
		
		createAnAccount.click();
		return new RegisterPage(driver);
		
	}
	
	public DashboardPage loginDefaultCorrect() {

		email.clear();
		email.sendKeys(defaultCorrectEmail);
		pass.clear();
		pass.sendKeys(defaultCorrectPass);
		submitLogin.click();
		
		return new DashboardPage(driver);
		
	}
	
	public LoginPage loginDefaultIncorrect() {

		email.clear();
		email.sendKeys(defaultCorrectEmail);
		pass.clear();
		pass.sendKeys(defaultCorrectEmail + defaultCorrectPass);
		submitLogin.click();
		
		return new LoginPage(driver);
	}
	
	public boolean isLoginNotSuccessful() {
		
		return errorMessage.getText().equalsIgnoreCase("Invalid login or password.");
		
	}

	
}
