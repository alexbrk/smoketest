package com.smoketest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends AnyPage {
	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "billing:firstname")
	private WebElement nameField;
	
	@FindBy(how = How.ID, using = "billing:lastname")
	private WebElement lnameField;
	
	@FindBy(how = How.ID, using = "billing:telephone")
	private WebElement telephoneField;
	
	@FindBy(how = How.ID, using = "billing:street1")
	private WebElement streetAddressField;
	
	@FindBy(how = How.ID, using = "billing:city")
	private WebElement cityField;
	
	@FindBy(how = How.ID, using = "billing:postcode")
	private WebElement zipField;
	
	@FindBy(how = How.ID, using = "s_method_matrixrate_Air Mail (15-60 days)212130")
	private WebElement shipAirMail;
	
	@FindBy(how = How.ID, using = "p_method_paypal_standard")
	private WebElement paymentPayPalStandard;
	
	@FindBy(how = How.ID, using = "onestepcheckout-place-order")
	private WebElement placeOrder;
	
	@FindBy(how = How.XPATH, using = "//td[@class='name']")
	private WebElement itemFullName;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='grand-total']/td[2]/span")
	private WebElement grandTotal;
	
	public void placeOrderFirstTime() {
		
		randomItemName = itemFullName.getText().trim();
		randomItemPrice = grandTotal.getText().trim();
		
		//populate all mandatory fields with some fake data
		nameField.clear();
		nameField.sendKeys("German");
		lnameField.clear();
		lnameField.sendKeys("Radi");
		telephoneField.clear();
		telephoneField.sendKeys("444688167");
		streetAddressField.clear();
		streetAddressField.sendKeys("Rotten str, 9841");
		Select countries = new Select(driver.findElement(By.id("billing:country_id")));
		countries.selectByValue("UA");
		cityField.clear();
		cityField.sendKeys("Kharkiv");
		zipField.clear();
		zipField.sendKeys("62000");
		//choose airmail and paypal
		shipAirMail.click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		paymentPayPalStandard.click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		placeOrder.click();
		
	}
	
	public void placeOrder() {
		
		randomItemName = itemFullName.getText().trim();
		randomItemPrice = grandTotal.getText().trim();

		shipAirMail.click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		paymentPayPalStandard.click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		placeOrder.click();
		
	}
	

	
	

}
