package com.Orange.Education.ZeroEffortAutomation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Orange.Education.WebDriverSettings;
import com.Orange.Education.GridExamples.GridWebDriverSettings;

import Pages.MainPage;
import Pages.Orangehrmlive;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class SmartCode extends GridWebDriverSettings{
	
	Orangehrmlive or;
	
	@BeforeTest
	public void createObj() {
		or = new Orangehrmlive(driver);
	}
	
	@Epic(value = "Fuctionality Testing")
	@Description("Smart Code")
	@Test
	public void GetFieldAttributes() {
				or.mainPage().getRelevantElemnet(driver,"username", "txtUsername").sendKeys("Admin");
				 System.out.println("Time in California: " +
						 or.mainPage().getZonedDateTime("Blah blah").toString());
	}
}
