package com.Orange.Education.RestAssuredTest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredTests {

	
	
	final static String url = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

	@Test
	public void getResponseBody() {
		given().when()
				.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
				.then().log().all();
	}

	@Test
	public void getResponseBodyWithParam() {
		given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234!").queryParam("Account_No", "1").when()
				.get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
	}

	@Test
	public void getResponseStatus() {
		int statusCode = given().queryParam("CUSTOMER_ID", "68194").queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1").when().get("http://demo.guru99.com/V4/sinkministatement.php")
				.statusCode();

		System.out.println("The response status is:" + statusCode);
		
		given().when().get(url).then().assertThat().statusCode(200);
	}
	@Test
	public static void getResponseHeaders(){
		   System.out.println("The headers in the response "+
		                   get(url).then().extract()
		           .headers());
		}
	
	@Test
	public static void getResponseTime(){
		  System.out.println("The time taken to fetch the response "+get(url)
		         .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
		}

	@Test
	public static void getResponseContentType(){
		   System.out.println("The content type of response "+
		           get(url).then().extract()
		              .contentType());
		}
	
	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_Failed() {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'place name'", equalTo("New York"));
		
		///"places[0].'place name'" ----> JsonPath
	}
	
	@Test
	public static void getSpecificPartOfResponseBody(){

		ArrayList<String> amounts = when().get(url).then().extract().path("result.statements.AMOUNT") ;
		int sumOfAll=0;
		for(String a:amounts){

		    System.out.println("The amount value fetched is "+a);
		    sumOfAll=sumOfAll+Integer.valueOf(a);
		}
		System.out.println("The total amount is "+sumOfAll);

		}
	
	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_ExpectBeverlyHills() {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
	}

	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_Expect200() {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'place name'", equalTo("Beverly Hills")).statusCode(200);
	}
	
	@Test
	public void  requestUSZipCode90210_checkContentType_expectApplicationJson() {
		given()
		.when().
			get("http://api.zippopotam.us/us/90210").
		then().
			assertThat().contentType(ContentType.JSON);
		
		//.contentType(application/json);
	}
	
	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_State() {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'state'", equalTo("California"));
	}
	
	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_StateNot() {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'state'", not(equalTo("California")));
	}
	
	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_HasItemCheck() {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places.'place name'", hasItem("Beverly Hills"));
		System.out.println();
	}
	
	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_NotItemCheck() {
		try {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places.'place name'", not(hasItem("Beverly Hills")));
		}
		catch(Exception e) {
			e.getMessage();
		}
		System.out.println();
	}
	
	@Test
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_SizeHasItemCheck() {
		given().when().get("http://api.zippopotam.us/us/90210").then().assertThat().body("places.'place name'", hasSize(1));

	}

	
}