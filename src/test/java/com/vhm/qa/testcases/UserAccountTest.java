package com.vhm.qa.testcases;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vhm.qa.pages.LoginPage;
import com.vhm.qa.pages.UserAccountPage;

public class UserAccountTest extends LoginPageTest {

	public UserAccountPage UserAccountPage;

	public UserAccountTest() {
		// TODO Auto-generated constructor stub
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		UserAccountPage = new UserAccountPage();
		changeLanguage();
		loginTest();

	}

	@Test(priority = 1)
	public void OpenEditProfile() {
		// UserAccountPage.Arrow();
		// UserAccountPage.Profile();
		// UserAccountPage.EditProfile();

		// dashboardPage.openLanguageList();
		dashboardPage.selectEngLang();
		dashboardPage.clickOnUserIcon();
		dashboardPage.Profile();

	}

	@Test(priority = 2)
	public void EditProfile() {
		OpenEditProfile();
		UserAccountPage.EditProfile();
		UserAccountPage.ValidateEditProfile(prop.getProperty("FirstName"), prop.getProperty("LastName"),
				prop.getProperty("UserName"));
		UserAccountPage.OK();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
