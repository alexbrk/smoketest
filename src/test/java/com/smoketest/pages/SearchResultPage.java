package com.smoketest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AnyPage {
	
	private WebDriver driver;
	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='products-list']//h2[@class='product-name']/a")
	private List<WebElement> foundItems;
	
	public boolean isSearchSuccessful() {
		
		//check if each found item (50 items by default) contains search word
		boolean result = true;
		for(WebElement eachItem: foundItems){
			//System.out.println(eachItem.getText());
			if(!(eachItem.getText().toLowerCase().contains(defaultSearchItem))){
				result = false;
			}
			
		}
		
		return result;
	}
	

}
