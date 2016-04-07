package com.smoketest.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.smoketest.pages.HomePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Browser {
	
	protected WebDriver driver;
	protected HomePage homePage;
	
	@BeforeMethod
	public void setUp(){
		
		//launch browser
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
		
		//set implicit timeout and maximize browser window
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//open homepage
		driver.get("http://www.1949deal.com");
		
		//create instance of HomePage
		homePage = new HomePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
		
	}

}
