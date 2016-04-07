package com.smoketest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AnyPage {
	
	public static String randomItemName;
	public static String randomItemPrice;
	public static String defaultCorrectEmail = "ger2383@ua.fm";
	public static String defaultCorrectPass = "german57w43";
	public static String defaultName = "German";
	public static String defaultSearchItem = "asus";
	
	protected WebDriver driver;

	public AnyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='top']//a[@title='Sign In']")
	private WebElement signIn;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Bestselling")
	private WebElement bestselling;
	
	@FindBy(how = How.LINK_TEXT, using = "My Account")
	private WebElement myAccount;
	
	@FindBy(how = How.XPATH, using = "//*[@id='top']//ul[@class='links']/li[3]/a")
	private WebElement myWishlist;
	
	public LoginPage clickSignIn() {
		
		signIn.click();
		return new LoginPage(driver);
		
	}

	public BestsellingPage clickBestselling() {
		
		bestselling.click();
		
		return new BestsellingPage(driver);
		
	}
	
	public DashboardPage clickMyAccount() {
		
		myAccount.click();
		return new DashboardPage(driver);
		
	}
	
	public WishlistPage clickMyWishlist() {
		
		myWishlist.click();
		return new WishlistPage(driver);
		
	}
	

	

}
