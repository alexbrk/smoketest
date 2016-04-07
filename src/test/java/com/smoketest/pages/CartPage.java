package com.smoketest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AnyPage {
	
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		if(!driver.getTitle().contains("Shopping Cart")){
			driver.get("http://www.1949deal.com/checkout/cart/");
		}
	}
	
	@FindBy(how = How.XPATH, using = "(//button[@class='button btn-proceed-checkout btn-checkout'])[2]")
	private WebElement proceed;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn-remove2']")
	private List<WebElement> deleteButtons;
	
	public CheckoutPage clickProceedToCheckout() {
		
		proceed.click();
		return new CheckoutPage(driver);
	}
	
	//website has lots of bugs and irrational logic, need to clear cart before adding random item and placing order
	public CartPage clearCart() {
		
		//delete each item one by one as webpage refreshes every time
		while(deleteButtons.size() > 0) {
			deleteButtons.get(0).click();
		}
		
		return new CartPage(driver);
	}

}
