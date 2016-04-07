package com.smoketest.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import com.smoketest.pages.DashboardPage;
import com.smoketest.pages.LoginPage;
import com.smoketest.util.Browser;

public class LoginTest extends Browser {

	@Test
	public void testLoginOK() throws Exception {

		DashboardPage dashboardPage = homePage.clickSignIn().loginDefaultCorrect();
		assertTrue(dashboardPage.isLoginSuccessful());

	}

	@Test
	public void testLoginFailed() throws Exception {

		LoginPage loginPage = homePage.clickSignIn().loginDefaultIncorrect();
		assertTrue(loginPage.isLoginNotSuccessful());

	}
}
