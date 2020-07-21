package com.Orange.Education;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Orangehrmlive;
import Utils.LoadCookieInfo;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(Properties.Listeners.class)	

public class ParametersExampleXML extends WebDriverSettings{
	private Orangehrmlive Orangehrmlive;
	
	@BeforeTest
	public void setUpOrangeLive() {
		Orangehrmlive  = new Orangehrmlive(driver);;
	}
	

	@Epic(value = "Смоук тестирование")
	@Feature(value = "Регистрация2")
	@Story(value = "Регистрация нового пользователя2")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify Sign In fucntionality")
	@Parameters({"CorrectName","CorPassword"})
	@Test
	public void logIn(String CorrectName,String CorPassword) {
		Orangehrmlive.mainPage().EnterUserName("username", CorrectName, "id").then()
				.EnterPassword("password", CorPassword, "id").then().ClickDashBoard("loginbtn");
		System.out.println("CorrectLogin1 with Thread Id:- "
				+ Thread.currentThread().getId());
		//LoadCookieInfo.LoadCookie(driver);
		
		
	}
	
	@Epic(value = "SmokeTesting")
	@Story(value = "Create new User By XML")
	@Description("Create new User by Testng.xml")
	@Parameters({"userRole","employeeName","username","status","password"})
	@Test(dependsOnMethods = { "logIn" })
	public void AddNewUserByParametersInXml(@Optional("Admin")String userRole, String employeeName, String username , String status, String password) {		
		Orangehrmlive.viewUsers().ClickAdd("addbtn")
		.CreateNewUser("userrole", userRole,
				"addempname",  employeeName,
				"addusername", username,"id",
				"addstatus" , status,
				"addpassword", password,
				"addconfpassword", password)
		.ClickSave("addsavebtn");		

	}
	
	@Epic(value = "Смоук тестирование")
	@Feature(value = "Регистрация с параметрами")
	@Story(value = "Регистрация нового c параметрами")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify Sign In fucntionality")
	@Parameters({"inCorrectName","inCorPassword"})
	@Test
	public void logInWithParametrs(String inCorrectName,String inCorPassword) {
		Orangehrmlive.dashboard().logout("logout")
		.EnterUserName("username", inCorrectName, "id").then()
				.EnterPassword("password", inCorPassword, "id").then().ClickDashBoard("loginbtn");
		System.out.println("CorrectLogin1 with Thread Id:- "
				+ Thread.currentThread().getId());
	}

}
