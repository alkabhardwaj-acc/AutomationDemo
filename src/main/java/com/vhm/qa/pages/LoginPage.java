package com.vhm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vhm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// page factory (Obj Repo)
	@FindBy(name = "username")
	WebElement username;

//	password
	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='button' and @class='vh-login-btn btn-signin']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[@class='dropdown-item']")
	WebElement englishBtn;

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle flag-link active']")
	WebElement languageSelection;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void openLangChangeTray() {
		languageSelection.click();
	}

	public void changeLanguage() {
		openLangChangeTray();
		englishBtn.click();
	}

	public DashboardPage validateLogin(String unm, String psw) {
		username.sendKeys(unm);
		password.sendKeys(psw);

		LoginBtn.click();
		return new DashboardPage();
	}

}
