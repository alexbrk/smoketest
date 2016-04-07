package com.smoketest.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.smoketest.pages.SearchResultPage;
import com.smoketest.pages.WishlistPage;
import com.smoketest.util.Browser;

public class SearchTest extends Browser {
	
	  @Test
	  public void searchDefaultItem() {
		  
		  SearchResultPage result = homePage.searchDefaultItem();

		  assertTrue(result.isSearchSuccessful());

	  }

}
