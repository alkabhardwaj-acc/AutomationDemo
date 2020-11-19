package com.vhm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	static WebDriver driver;
	static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			final FileInputStream ip = new FileInputStream("D:\\JavaLearning\\VillageHouseDemo\\src\\main\\java\\com\\vhm\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(){
			final String browserName = prop.getProperty("Browser");

			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\in198vikkum\\Documents\\Selenium_learning\\chromedriver_win32_version83\\chromedriver.exe");
				driver=new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));

	}



}
