package com.smoketest.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage extends AnyPage {
	
	private WebDriver driver;

	public WishlistPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='top']//ul[@class='links']/li[3]/a")
	private WebElement myWishlist;
	
	@FindBy(how = How.XPATH, using = "//*[@id='wishlist-table']//td[5]/a")
	private List<WebElement> allItemsX;
	
	@FindBy(how = How.XPATH, using = "//*[@id='wishlist-table']//tr[1]/td[5]/a")
	private WebElement firstItemX;
	
	public WishlistPage addItemsToWishlist() {
		//check if wishlist already contains items, then delete
		if(!(myWishlist.getText().trim().equalsIgnoreCase("My Wishlist"))){
			
			while(allItemsX.size() > 0){
				firstItemX.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		}
		
		//add 3 random items to wishlist
		BestsellingPage bs = new BestsellingPage(driver);
		bs.clickBestselling().chooseRandomItem().clickAddToWishlist().clickBestselling();
		bs.chooseRandomItem().clickAddToWishlist().clickBestselling();
		bs.chooseRandomItem().clickAddToWishlist();
				
		return new WishlistPage(driver);
	}

	public boolean isWishlistContainsItems() {
		//check if there are 3 items in wishlist		
		int allItemsSize = allItemsX.size();
		return  (allItemsSize == 3) && (myWishlist.getText().trim().equalsIgnoreCase("My Wishlist (3 items)"));
	}

}
