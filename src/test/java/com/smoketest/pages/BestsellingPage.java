package com.smoketest.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BestsellingPage extends AnyPage {
	private WebDriver driver;

	
	public BestsellingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "(//div[@class='hot-description']/h3/a)[1]")
	private WebElement firstItem;
	
	@FindBy(how = How.XPATH, using = "//*[@id='products-list']/li/div[1]/div[1]/h2/a")
	private List<WebElement> items;
	
	public ItemPage chooseRandomItem() {
		
		Random random = new Random();
		int randomLi = random.nextInt(8) + 1;
		
		//choose random sidebar menu item
		String xpath1 = "//*[@id='sidebar-nav-menu']/li[" + randomLi + "]/a/span";
		WebElement randomSidebar = driver.findElement(By.xpath(xpath1));
		randomSidebar.click();
		
		//choose random item (soldout items will not be chosen by xpath)
		int randomItemLi = random.nextInt(items.size()) + 1;
		String xpath2 = "//*[@id='products-list']/li[" + randomItemLi + "]/div[1]/div[1]/h2/a";
		WebElement randomItem = driver.findElement(By.xpath(xpath2));
		randomItem.click();
		
		return new ItemPage(driver);
	}
	
	public ItemPage clickFirstItem() {
		
		firstItem.click();
		return new ItemPage(driver);
	}
	
}
