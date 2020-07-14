package com.Orange.Education.API;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.NoHttpResponseException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class httpsEducation{

	private static String url = "https://opensource-demo.orangehrmlive.com/";
	private static Logger log = Logger.getLogger(httpsEducation.class);
	private StringBuffer buffer;

	@Epic(value = "Restfull testing")
	@Description("My first http test")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void HttpGet() throws IOException {
		long threadId = Thread.currentThread().getId();
		System.out.println("Thread HttpGet:" + threadId);
		if (MainPage.isUrlValid(url)) {
			URL obj = new URL(url);
			// Opening Connection
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			// Sending the request
			connection.setRequestMethod("GET");
			int responce = connection.getResponseCode();
			try {
			if (responce == 200) {
				// Reading the response to a StringBuffer
				Scanner responceReader = new Scanner(connection.getInputStream());
				buffer = new StringBuffer();
				while (responceReader.hasNextLine()) {
					buffer.append(responceReader.nextLine() + "\n");
				}
				responceReader.close();
				// Printing the Response
				System.out.println("Result of test " + responce);
			}
			}
			catch(NoHttpResponseException e) {
				e.getMessage();
			}
		} else {
			System.out.println("Enter valid URL");
		}
	}
	@Description("Search Text by Http Request")
	@Test
	public void CheckTextByHttpGetRequest() {
		long threadId = Thread.currentThread().getId();
		System.out.println("Thread CheckTextByHttpGetRequest:" + threadId);
		try {
			 buffer.toString().contains("LOGIN Panel");			 	
		}
		catch(Exception e) {
			e.getMessage();
		}
		System.out.println("Result of test LOGIN Panel");		
	}
	
	@Description("Search Button by Http Request")
	@Test
	public void CheckButtonByHttpGetRequest() {
		long threadId = Thread.currentThread().getId();
		System.out.println("Thread CheckButtonByHttpGetRequest:" + threadId);
		try {
			 buffer.toString().contains("value=\"LOGIN\"");			 	
		}
		catch(Exception e) {
			e.getMessage();
		}
		System.out.println("Result of test Login button exist" );		
	}
	
	@Description("Test POST METHOD")
	@Test
	public void POSTRequest() {
		
	}
}
