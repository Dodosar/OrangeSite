package com.Orange.Education;

import java.util.concurrent.TimeUnit;
import Pages.Orangehrmlive;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnit5 {
	Orangehrmlive Orangehrmlive;
	WebDriver driver;
	
	@BeforeEach
	public void beforeTest() {
				
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Orangehrmlive = new Orangehrmlive(driver);		
	}
	@AfterEach
	public void Teardown() {
		if(driver != null) {
			driver.quit();
		}
	}


	@ParameterizedTest
	@ValueSource(strings = {"Best Sellers in Beauty & Personal Care"})
	public void mainTest(String input) {
//		Orangehrmlive.mainPage().then().isTextPresentInTheTag(input); 
	}
	

	/*@ParameterizedTest
	@EnumSource(DataValues.class)
    public void CheckByEnumParametersText(DataValues names) {		
		String text = names.get();
//		String sResult= Orangehrmlive.mainPage().then().isTextPresentInThePageToString(text);
//		System.out.println(sResult);
//        Assert.assertEquals("true", sResult);
	}*/
}



