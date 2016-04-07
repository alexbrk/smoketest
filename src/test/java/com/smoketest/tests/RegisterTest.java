package com.smoketest.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.smoketest.pages.DashboardPage;
import com.smoketest.pages.HomePage;
import com.smoketest.util.Browser;

public class RegisterTest extends Browser{

	@Test()
	public void registerRandomUSACustomer() {
		
		//sometimes registration just fails with magento error log :)
		homePage.clickSignIn().clickCreateAnAccount().registerRandomUSACustomer();
		assertTrue((new DashboardPage(driver)).isRegSuccessful());
			
	}
}
