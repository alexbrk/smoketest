package com.smoketest.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.smoketest.pages.AnyPage;
import com.smoketest.pages.CartPage;
import com.smoketest.pages.DashboardPage;
import com.smoketest.pages.HomePage;
import com.smoketest.util.Browser;

public class OrderTest extends Browser {


	  
	  @Test
	  public void orderRandomItem() {
		  
		  homePage.clickSignIn().loginDefaultCorrect();
		  CartPage cartPage = new CartPage(driver);
		  cartPage.clearCart().clickBestselling().chooseRandomItem().addToCart().clickProceedToCheckout().placeOrder();
		  assertTrue(new HomePage(driver).isOrderSuccessful());

	  }

}
