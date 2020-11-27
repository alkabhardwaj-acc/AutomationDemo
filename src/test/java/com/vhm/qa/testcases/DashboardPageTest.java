package com.vhm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vhm.qa.base.TestBase;
import com.vhm.qa.pages.DashboardPage;
import com.vhm.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {

	public LoginPage loginPage;
	DashboardPage dashboardPage;

	// creating page constructor
	public DashboardPageTest() {
		// calling base class constructor to initialize driver and all variable
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void testHomeLogo() {
		assertTrue(dashboardPage.homeLogoShowing());
	}

	@Test(priority = 2)
	public void logoutTest() {
		dashboardPage.logoutUser();
	}
	
	@Test
	public void changeLanguageTest() {
		dashboardPage.selectEngLang();		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
