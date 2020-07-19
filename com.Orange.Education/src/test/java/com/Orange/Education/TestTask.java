package com.Orange.Education;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MainPage;
import Pages.Orangehrmlive;
import Properties.TestData;
import Utils.StoreCookieInfo;
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
	  
	  @Test(priority = 0) public void CheckTheText() { log.info("CheckTheText");
	  log.debug("CheckTheText"); log.warn("this is a warning log message");
	  Orangehrmlive.mainPage().CheckTheTextInMainPage("logintext",
	  TestData.value("loginText"), "id");
	  System.out.println("CheckTheText with Thread Id:- " +
	  Thread.currentThread().getId()); }
	  
	  @Epic(value = "Смоук тестирование")
	  
	  @Severity(SeverityLevel.TRIVIAL)
	  
	  @Test(priority = 1) public void CheckTheTitle() { log.info("CheckTheTitle");
	  Orangehrmlive.mainPage().CheckTheTitle(TestData.value("titleMainPage"));
	  System.out.println("CheckTheTitle with Thread Id:- " +
	  Thread.currentThread().getId()); }
	  
	  @Test(priority = 2) public void CheckTheActiveButton() {
	  log.info("CheckTheText"); Orangehrmlive.mainPage().CheckTheColor("loginbtn",
	  TestData.value("colorOfLoginBtn")) .CheckActiveElement("loginbtn");
	  System.out.println("CheckTheActiveButton with Thread Id:- " +
	  Thread.currentThread().getId()); }
	  
	  
	  @Test(priority = 3) public void ForgotPassword() {
	  log.info("ForgotPassword"); //Orangehrmlive = new Orangehrmlive(driver);
	  
	  }
	  
	  @Test(priority = 4) public void JSExecutorTest() {
	  log.info("JSExecutorTest");
	  Orangehrmlive.mainPage().EnterUserName("username",
	  TestData.value("CorrectUsername"), "id").then() .EnterPassword("password",
	  TestData.value("CorrectPassword"), "id").then().ClickDashBoard("loginbtn");
	  Orangehrmlive.dashboard().logoutJSExecutor("logout").CheckTheTextInMainPage("logintext",
	  TestData.value("loginText"), "id");
	  System.out.println("CorrectLogin with Thread Id:- " +
	  Thread.currentThread().getId()); }
	  
	  
	  @Epic(value = "Смоук тестирование")
	  
	  @Feature(value = "Регистрация")
	  
	  @Story(value = "Регистрация нового пользователя")
	  
	  @Severity(SeverityLevel.BLOCKER)
	  
	  @Description("Verify Sign In fucntionality")
	  
	  @Test(priority = 5) public void CorrectLogin() { log.info("CorrectLogin");
	  Orangehrmlive.mainPage().EnterUserName("username",
	  TestData.value("CorrectUsername"), "id").then() .EnterPassword("password",
	  TestData.value("PasswordRegistation"), "id");
	  Orangehrmlive.mainPage().then().ClickDashBoard("loginbtn");
	  
	  //; StoreCookieInfo.StoreCookie(driver);
	  //.logout("logout").CheckTheTextInMainPage("logintext", TestData.value("loginText"), "id");
	  System.out.println("CorrectLogin with Thread Id:- " +
	  Thread.currentThread().getId()); }
	 

	@Test(priority = 6)
	public void CheckErrorByLoginIsDisplayed() {
		Orangehrmlive.mainPage().ClickDashBoard("loginbtn");
		MainPage.isDisplayed("invalidcredentials");
	}
}