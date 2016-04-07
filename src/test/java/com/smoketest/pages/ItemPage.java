package com.smoketest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends AnyPage {
	private WebDriver driver;

	
	public ItemPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='product_addtocart_form']//button[@class='button btn-cart']")
	private WebElement add;
	
	@FindBy(how = How.XPATH, using = "//*[@id='product_addtocart_form']//li[@class='wishlist-li']/a")
	private WebElement addToWish;
	
	public CartPage addToCart() {
		
		add.click();
		return new CartPage(driver);
		
	}
	
	public WishlistPage clickAddToWishlist() {
		
		addToWish.click();
		return new WishlistPage(driver);
	}

	
}
