package com.Orange.Education;

import org.testng.annotations.Test;
import Pages.Orangehrmlive;
import Properties.TestData;

public class TestTask extends WebDriverSettings {

	Orangehrmlive Orangehrmlive;

	@Test(priority = 1)
	public void CheckTheText() {
		Orangehrmlive = new Orangehrmlive(driver);
		Orangehrmlive.mainPage().CheckTheTextInMainPage("logintext", TestData.value("loginText"), "id");
	}

	@Test(priority = 1)
	public void CheckTheTitle() {
		Orangehrmlive = new Orangehrmlive(driver);
		Orangehrmlive.mainPage().CheckTheTitle(TestData.value("titleMainPage"));
	}

	@Test(priority = 2)
	public void CheckTheActiveButton() {
		Orangehrmlive = new Orangehrmlive(driver);
		Orangehrmlive.mainPage().CheckTheColor("loginbtn", TestData.value("colorOfLoginBtn"))
				.CheckActiveElement("loginbtn");
	}

	@Test(priority = 4)
	public void CorrectLogin() {
		Orangehrmlive = new Orangehrmlive(driver);
		Orangehrmlive.mainPage().EnterUserName("username", TestData.value("CorrectUsername"), "id").then()
				.EnterPassword("password", TestData.value("CorrectPassword"), "id").then().Click("loginbtn")
				.logout("logout").CheckTheTextInMainPage("logintext", TestData.value("loginText"), "id");

	}
}