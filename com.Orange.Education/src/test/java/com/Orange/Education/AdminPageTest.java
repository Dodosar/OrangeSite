package com.Orange.Education;

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

public class AdminPageTest extends WebDriverSettings {

	private Orangehrmlive Orangehrmlive;

	@BeforeTest()
	public void setUpOrangeLive() {
		Orangehrmlive = new Orangehrmlive(driver);
		;
	}

	@Epic(value = "Смоук тестирование")
	@Feature(value = "Регистрация")
	@Story(value = "Регистрация нового пользователя")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify Sign In fucntionality")
	@Test(priority = 0)
	public void CorrectLogin() {
		Orangehrmlive.mainPage().EnterUserName("username", TestData.value("CorrectUsername"), "id").then()
				.EnterPassword("password", TestData.value("CorrectPassword"), "id").then().ClickDashBoard("loginbtn");
		System.out.println("CorrectLogin with Thread Id:- " + Thread.currentThread().getId());
	}

	@Epic(value = "SmokeTesting")
	@Story(value = "Create new User")
	@Description("Create new User by Admin")
	@Test(dependsOnMethods = { "CorrectLogin" })
	public void AddNewUser() {
		Orangehrmlive.viewUsers().ClickAdd("addbtn")
				.CreateNewUser("userrole", "Admin", "addempname", TestData.value("employeeName"), "addusername",
						TestData.value("username"), "id", "addstatus", "Enabled", "addpassword",
						TestData.value("PasswordRegistation"), "addconfpassword", TestData.value("PasswordRegistation"))
				.ClickSave("addsavebtn");
	}

	@Epic(value = "SmokeTesting")
	@Story(value = "Create new User")
	@Description("Create new User by Admin")
	@Test(dependsOnMethods = { "AddNewUser" })
	public void VerifyNewUser() {
		Orangehrmlive.viewUsers().ExistInTable("listoftable", TestData.value("username"));
	}

}
