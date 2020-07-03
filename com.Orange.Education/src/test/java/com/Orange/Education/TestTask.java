package com.Orange.Education;

import org.testng.annotations.Test;
import Pages.Orangehrmlive;
import Properties.TestData;

public class TestTask extends WebDriverSettings{
	
	Orangehrmlive Orangehrmlive;


	@Test(priority = 0)
	public void CheckTheText() {
		Orangehrmlive = new Orangehrmlive(driver);		
		Orangehrmlive.mainPage().CheckTheTextInMainPage("logintext", TestData.value("loginText"),"id");
	}
	
	@Test(priority = 1)
	public void CheckTheTitle() {
		Orangehrmlive.mainPage().CheckTheTitle(TestData.value("titleMainPage"));
	}
	
	/*@Test(priority = 2)
	public void CheckTheActiveButton() {
		Orangehrmlive.mainPage();
	}*/
	
}