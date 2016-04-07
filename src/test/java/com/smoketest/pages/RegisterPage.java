package com.smoketest.pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AnyPage {

	private WebDriver driver;

	public RegisterPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "firstname")
	private WebElement firstName;
	
	@FindBy(how = How.ID, using = "lastname")
	private WebElement lastName;
	
	@FindBy(how = How.ID, using = "email_address")
	private WebElement email;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement pass;
	
	@FindBy(how = How.ID, using = "confirmation")
	private WebElement confirmPass;
	
	@FindBy(how = How.XPATH, using = "//button[@title='Submit']")
	private WebElement submit;
	
	public DashboardPage registerRandomUSACustomer() {
		
		//create most used random USA name, lastname, email, password (fake typo email)
		String [] names = {"Michael", "Matthew", "Anthony", "Daniel", "Ryan", "Joseph", "Jayden", "Christopher", "Jacob", "Alexander", "Isabella", "Olivia", "Sophia", "Madison", "Ava", "Emma", "Emily", "Abigail", "Sarah", "Samantha"};
		String [] lnames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson", "Martinez", "Anderson", "Taylor", "Moore", "Thompson", "Robinson", "Perez", "Adams", "Campbell", "Evans"};
		Random r = new Random();
		int random = r.nextInt(19);
		String randomName = names[random];
		String randomLname = lnames[random];
		String randomEmail = randomName + randomLname + r.nextInt(1000) + "@ggmail.com";
		String randomPass = randomName + r.nextInt(1000);
		System.out.println("email:" + randomEmail);
		System.out.println("password:" + randomPass);
		
		//enter created data and click submit
		firstName.clear();
		firstName.sendKeys(randomName);
		lastName.clear();
		lastName.sendKeys(randomLname);
		email.clear();
		email.sendKeys(randomEmail);
		pass.clear();
		pass.sendKeys(randomPass);
		confirmPass.clear();
		confirmPass.sendKeys(randomPass);
		submit.click();
	
		return new DashboardPage(driver);
		
	}
	
	
}
