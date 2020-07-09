package com.Orange.Education;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.Orangehrmlive;
import Properties.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class TestTask extends WebDriverSettings {
	
	private Orangehrmlive Orangehrmlive;
	private static Logger log = Logger.getLogger(TestTask.class);
	
	@BeforeTest
	public void createObject() {
		Orangehrmlive = new Orangehrmlive(driver);
	}

	
	@Epic(value = "Смоук тестирование")
	@Test//(priority = 4)
	public void CheckTheText() {
		log.info("CheckTheText");
		log.debug("CheckTheText");
		log.warn("this is a warning log message");
		Orangehrmlive.mainPage().CheckTheTextInMainPage("logintext", TestData.value("loginText"), "id");
		System.out.println("CheckTheText with Thread Id:- "
				+ Thread.currentThread().getId());
	}
	
	@Epic(value = "Смоук тестирование")
	@Feature(value = "Регистрация")
	@Story(value = "Регистрация нового пользователя")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify Sign In fucntionality")
	@Test//(priority = 0)
	public void CorrectLogin() {
		log.info("CorrectLogin");
		Orangehrmlive.mainPage().EnterUserName("username", TestData.value("CorrectUsername"), "id").then()
				.EnterPassword("password", TestData.value("CorrectPassword"), "id").then().Click("loginbtn")
				.logout("logout").CheckTheTextInMainPage("logintext", TestData.value("loginText"), "id");
		System.out.println("CorrectLogin with Thread Id:- "
				+ Thread.currentThread().getId());
	}
	
	@Epic(value = "Смоук тестирование")
	@Severity(SeverityLevel.TRIVIAL)
	@Test//(priority = 1)
	public void CheckTheTitle() 
	{
		log.info("CheckTheTitle");
		Orangehrmlive.mainPage().CheckTheTitle(TestData.value("titleMainPage"));
		System.out.println("CheckTheTitle with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	@Test//(priority = 2)
	public void CheckTheActiveButton() {
		log.info("CheckTheText");
		Orangehrmlive.mainPage().CheckTheColor("loginbt", TestData.value("colorOfLoginBtn"))
				.CheckActiveElement("loginbtn");
		System.out.println("CheckTheActiveButton with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	
	
	@Test
	public void ForgotPassword() {
		log.info("ForgotPassword");
		//Orangehrmlive = new Orangehrmlive(driver);
		
	}
	
	@Test//(priority = 5)
	public void JSExecutorTest() {
		log.info("JSExecutorTest");
		Orangehrmlive.mainPage().EnterUserName("username", TestData.value("CorrectUsername"), "id").then()
		.EnterPassword("password", TestData.value("CorrectPassword"), "id").then().Click("loginbtn")
		.logoutJSExecutor("logout").CheckTheTextInMainPage("logintext", TestData.value("loginText"), "id");
System.out.println("CorrectLogin with Thread Id:- "
		+ Thread.currentThread().getId());
	}
}