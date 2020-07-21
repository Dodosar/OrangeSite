package com.Orange.Education;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.Orangehrmlive;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(Properties.Listeners.class)	
public class DataProviderExample extends WebDriverSettings {

	private Orangehrmlive Orangehrmlive;
	
	@BeforeTest
	public void setUpOrangeLive() {
		Orangehrmlive  = new Orangehrmlive(driver);;
	}
	


	@Epic(value = "Смоук тестирование")
	@Feature(value = "New Test by Data Provider")
	@Story(value = "logIn by Data Provider")
	@Severity(SeverityLevel.BLOCKER)
	@Description("DataProvider Test")
	@Test(dataProvider = "LogInByDataProvider")
	public void LogInByDataProvider(String username, String password) {
		Orangehrmlive.mainPage().ClearCookie();
		Orangehrmlive.mainPage().EnterUserName("username", username, "id").then()
				.EnterPassword("password", password, "id").then().ClickDashBoard("loginbtn");
				Orangehrmlive.dashboard().logout("logout");
		System.out.println("LogInByDataProvider with Thread Id:- "
				+ Thread.currentThread().getId());
	}


	@DataProvider(name = "LogInByDataProvider")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { { "Admin", "admin123" }, { "Admin1", "admin1234" }, { "Admin", "admin1234" },
				{ "Admin1", "admin123" }, { "Admin", "admin123" }, { null, null },

		};
	}
}
