package com.Orange.Education;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Pages.Orangehrmlive;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebDriverSettings {

	public WebDriver driver;

	/*
	 * @BeforeClass public static void setupClass() {
	 * ChromeDriverManager.getInstance().setup(); }
	 */

	@BeforeTest
	public void setUp() throws Exception {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * System.getProperty("D:\\browsersDrivers\\chromedriver.exe"));
		 */
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("incognito");

		driver = new ChromeDriver(chromeOptions);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30, 500);
		driver.manage().window().maximize();

		String log4jConfigFile = System.getProperty("user.dir") + File.separator
				+ "\\src\\main\\resources\\log4j.properties";

		PropertyConfigurator.configure(log4jConfigFile);

	}

	@AfterTest
	public void Teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	/*
	 * @BeforeTest public void setUpFF() throws Exception { FirefoxBinary
	 * firefoxBinary = new FirefoxBinary();
	 * firefoxBinary.addCommandLineOptions("--headless"); FirefoxOptions
	 * firefoxOptions = new FirefoxOptions();
	 * firefoxOptions.setBinary(firefoxBinary); driver = new
	 * FirefoxDriver(firefoxOptions);
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //
	 * WebDriverWait wait = new WebDriverWait(driver, 30,500);
	 * driver.manage().window().maximize(); }
	 */

}
