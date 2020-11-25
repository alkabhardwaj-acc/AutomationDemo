package com.vhm.qa.testcases;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vhm.qa.base.TestBase;
import com.vhm.qa.pages.DashboardPage;
import com.vhm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPage loginPage;
	DashboardPage dashboardPage;

	// creating page constructor
	public LoginPageTest() {
		// calling base class constructor to initialize driver and all variable
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	// @Test(priority = 2)
	public void loginTest() {
		changeLanguage();
		dashboardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		assertNotNull(dashboardPage);
	}

	// @Test(priority = 1)
	public void changeLanguage() {
		loginPage.changeLanguage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
