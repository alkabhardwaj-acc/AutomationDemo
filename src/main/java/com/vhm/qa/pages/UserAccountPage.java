package com.vhm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserAccountPage extends LoginPage {

	@FindBy(xpath = "//a[contains(@href,'https://dev.vhmrenovations.jp/profile/edit') and @class='btn btn-default vh-search-btn']")
	WebElement EditProfile;

	@FindBy(name = "first_name")
	WebElement FirstName;

	@FindBy(name = "last_name")
	WebElement LastName;

	@FindBy(id = "username")
	WebElement UserName;

	@FindBy(xpath = "//button[@class='btn btn-default vh-search-btn vh-submit-profile']")
	WebElement Submit;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement Arrow;

	@FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']")
	WebElement Alert;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement OK;

	public UserAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public void Arrow() {
		Arrow.click();
	}

	public void OK() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			//Assert.assertTrue(alert.getText().contains("Success"));
		} catch (Exception e) {
			// exception handling
		}

		// OK.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EditProfile() {
		EditProfile.click();
	}

	public DashboardPage ValidateEditProfile(String frst, String lst, String usrnm) {
		FirstName.clear();
		FirstName.sendKeys(frst);
		LastName.clear();
		LastName.sendKeys(lst);
		UserName.clear();
		UserName.sendKeys(usrnm);
		Submit.click();
		return new DashboardPage();
	}

}