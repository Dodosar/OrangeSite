package com.Orange.Education;

import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Orange.Education.GridExamples.GridWebDriverSettings;

import Pages.Orangehrmlive;
import Properties.SQLConnection;
import Properties.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class SQLDataTest extends GridWebDriverSettings{
	
	
	@BeforeClass
	@Parameters({"dbUrl","username","password"})	
	public void ConnectionToDb(String dbUrl,String username,String password){
		SQLConnection.connect(dbUrl,username,password);
		System.out.println("test Connection");		
	}
	
	@AfterClass
	public void CloseConnection() {
		SQLConnection.close();
	}
	
	Orangehrmlive or;
	
	@BeforeTest
	public void createObj() {
		or = new Orangehrmlive(driver);
	}
	
	@Epic(value = "Fuctionality Testing")
	@Description("Smart Code")
	@Test
	public void GetFieldAttributes() throws SQLException{
				or.mainPage().getRelevantElemnet(driver,"username", "txtUsername").sendKeys(SQLConnection.select(TestData.value("SqlQuery")).getString(1));
				 System.out.println("Time in California: " +
						 or.mainPage().getZonedDateTime("Blah blah").toString());
	}
}
