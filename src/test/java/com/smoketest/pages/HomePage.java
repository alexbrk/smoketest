package com.smoketest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AnyPage {
	
	private WebDriver driver;
	

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		if(!driver.getTitle().contains("Safe,Fast,Professional Android smartphone,tablet pc Retailer,specialized in electronics")){
			driver.get("http://www.1949deal.com/");
		}
	}
	
	@FindBy(how = How.ID, using = "search")
	private WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='search_mini_form search']//button")
	private WebElement searchSubmitButton;
	
	public boolean isOrderSuccessful() {
		
		clickMyAccount();
		//go to last order detailed description
		driver.findElement(By.xpath("//*[@id='my-orders-table']//tr[1]//a[1]")).click();
		//get item full name and grand total price
		String itemName = driver.findElement(By.xpath("//tr[@class='border first last']/td[1]/h3")).getText().trim();
		String grandTotal = driver.findElement(By.xpath("//*[@id='my-orders-table']/tfoot/tr[3]/td[2]/strong/span")).getText().trim();
		//assert name and price are correct
		return itemName.equalsIgnoreCase(randomItemName) && grandTotal.equalsIgnoreCase(randomItemPrice);
		
	}
	
    public SearchResultPage searchDefaultItem() {
  	
    	searchField.clear();
    	searchField.sendKeys(defaultSearchItem);
    	searchSubmitButton.click();
    	
    	return new SearchResultPage(driver);
    	
    }
	






}
