package com.Orange.Education.GridExamples;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Orange.Education.TestTask;

import Pages.Orangehrmlive;
import Properties.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class StandAloneExample extends GridWebDriverSettings {

	private Orangehrmlive Orangehrmlive;
	private static Logger log = Logger.getLogger(TestTask.class);

	@BeforeTest
	public void createObject() {
		Orangehrmlive = new Orangehrmlive(driver);
	}

	@Epic(value = "Смоук тестирование")
	@Feature(value = "Регистрация")
	@Story(value = "Регистрация нового пользователя")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify Sign In fucntionality")
	@Test
	public void JSExecutorTest() {
		log.info("JSExecutorTest");
		Orangehrmlive.mainPage().EnterUserName("username", TestData.value("CorrectUsername"), "id").then()
		.EnterPassword("password", TestData.value("CorrectPassword"), "id").then().ClickDashBoard("loginbtn");
		//Orangehrmlive.dashboard().logoutJSExecutor("logout").CheckTheTextInMainPage("logintext", TestData.value("loginText"), "id");
System.out.println("CorrectLogin with Thread Id:- "
		+ Thread.currentThread().getId());
	}

}
