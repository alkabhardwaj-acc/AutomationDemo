package com.vhm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vhm.qa.base.TestBase;

public class DashboardPage extends TestBase {

	// page factory (Obj Repo)
	@FindBy(xpath = "//img[@alt='Village House']")
	WebElement houseLogo;

	//// p[contains(text(),"物件(部屋)")]
	@FindBy(xpath = "//p[contains(text(),'物件(部屋)')]")
	WebElement units;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement userIcon;

	@FindBy(xpath = "//i[@class='fas fa-sign-out-alt mr-2']")
	WebElement logOutIcon;

	@FindBy(xpath = "//a[@class='nav-link flag-link active']")
	WebElement langugeSelctionIcon;

	@FindBy(xpath = "//a[@class='dropdown-item'] //img")
	WebElement englishJpIcon;

	@FindBy(xpath = "//a[contains(@href,'https://dev.vhmrenovations.jp/profile') and @class='dropdown-item']")
	WebElement Profile;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean homeLogoShowing() {
		return houseLogo.isDisplayed();
	}

	public LoginPage logoutUser() {
		clickOnUserIcon();
		logOutIcon.click();
		return new LoginPage();
	}

	public void clickOnUserIcon() {
		userIcon.click();
	}

	public void openLanguageList() {
		langugeSelctionIcon.click();
	}

	public void selectEngLang() {
		openLanguageList();
		englishJpIcon.click();
	}

	public void Profile() {
		Profile.click();
	}
}
