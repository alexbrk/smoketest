package com.smoketest.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.smoketest.pages.CartPage;
import com.smoketest.pages.HomePage;
import com.smoketest.pages.WishlistPage;
import com.smoketest.util.Browser;

public class WishlistTest extends Browser {
	
	  @Test
	  public void addItemsToWishlist() {
		  
		  homePage.clickSignIn().loginDefaultCorrect();
		  WishlistPage wish = homePage.clickMyWishlist().addItemsToWishlist();
		  assertTrue(wish.isWishlistContainsItems());


	  }

}
