package com.Orange.Education.RestAssuredTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.log.Log;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiTestRestAssure {
	
	private Integer a;
	/*
	 * private static RequestSpecification requestSpec;
	 * 
	 * private static ResponseSpecification responseSpec;
	 * 
	 * @BeforeClass public static void createRequestSpecification() { requestSpec =
	 * new RequestSpecBuilder().setBaseUri("http://httpbin.org").build();
	 * 
	 * responseSpec = new
	 * ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(
	 * 200).build(); }
	 * 
	 * @Test public void TestGetRequest() { long threadId =
	 * Thread.currentThread().getId(); System.out.println("Thread Get:" + threadId);
	 * String response =
	 * given().spec(requestSpec).log().all().when().get("/get?a=1").then().spec(
	 * responseSpec) .statusCode(200).body("headers.Host",
	 * equalTo("httpbin.org")).body("args.a", equalTo("1")).extract()
	 * .response().getBody().print(); }
	 * 
	 * @Test public void TestPostRequest() { long threadId =
	 * Thread.currentThread().getId(); System.out.println("Thread Post:" +
	 * threadId); Map<String, String> data = new HashMap<String, String>();
	 * data.put("orderId", "2"); data.put("test", "65"); data.put("Ret", "775");
	 * String response =
	 * given().spec(requestSpec).log().all().contentType("application/json").body(
	 * data).when() .post("/post").then().spec(responseSpec).body("json.orderId",
	 * equalTo("2")).extract().response() .getBody().print();
	 * 
	 * }
	 * 
	 * 
	 * @Test(dataProvider = "api") public void test(String method) { if
	 * (method.equals("post")) { Date date = new Date();
	 * System.out.println("Начало " + method + " " + new Timestamp(date.getTime()));
	 * TestPostRequest(); date = new Date(); System.out.println("Конец " + method +
	 * " " + new Timestamp(date.getTime())); return; } if (method.equals("get")) {
	 * Date date = new Date(); System.out.println("Начало " + method + " " + new
	 * Timestamp(date.getTime())); TestGetRequest(); date = new Date();
	 * System.out.println("Конец " + method + " " + new Timestamp(date.getTime()));
	 * return; } }
	 * 
	 * @DataProvider(name = "api", parallel = true) public Object[][] provide() {
	 * return new Object[][] { { "post" }, { "get" } }; }
	 * 
	 * @Test public void exampleRestTest() { given().auth().basic("admin",
	 * "password123").when().contentType(ContentType.JSON)
	 * .get("https://restful-booker.herokuapp.com/booking/2").then().log().body(); }
	 * 
	 * @Test public void GetBooking() {
	 * given().when().contentType(ContentType.JSON).get(
	 * "https://restful-booker.herokuapp.com/booking").then().log() .body(); }
	 */
	 @BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/";
	  }
	
	/*@Test(priority = 0)
	public void PostByJSONFile() {

		JSONParser parser = new JSONParser();
		
		String response = null;

		try {

			Object obj = parser.parse(new FileReader("D:\\JSON\\createBook.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String firstName = (String) jsonObject.get("firstname");

			String n = jsonObject.toJSONString();

			// https://stackoverflow.com/questions/21720759/convert-a-json-string-to-a-hashmap/27679348

			// str, your JSON String

			// As Simple as this, if you want emailid,

			Map<String, String> data = new ObjectMapper().readValue(n, HashMap.class);

			System.out.println(firstName);

			response = given().log().all().contentType("application/json").body(data).when()
					.post("/").then().log().all()
					.body("booking.firstname", equalTo("DimaTTTT")).body("booking.totalprice", equalTo(112))
					.body("booking.bookingdates.checkin", equalTo("2019-01-02")).extract().response().getBody().print();

		} catch (Exception e) {
			e.getMessage();
		}
		
		 a = JsonPath.from(response).get("bookingid");
		
		String b = JsonPath.from(response).get("booking.firstname");
		System.out.println(a);
		System.out.println(b);

	}*/

	// The sample code will help you do the authentication before every request you
	// send.
	
	public void Tokenuth() {
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("admin");
		authScheme.setPassword("password123");
		RestAssured.authentication = authScheme;
	}

	@Test(priority = 1)
	public void PatchBooking() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
		
		Object obj = parser.parse(new FileReader("D:\\JSON\\patch.json"));

		JSONObject jsonObject = (JSONObject) obj;

		String firstName = (String) jsonObject.get("firstname");

		String n = jsonObject.toJSONString();

		Map<String, String> data = new ObjectMapper().readValue(n, HashMap.class);

		//String jsonString = "{\r\n" + "    \"firstname\" : \"Amod\",\r\n" + "    \"lastname\" : \"Mahajan\"}";
		//RestAssured.registerParser("text/plain", Parser.JSON);
		//Tokenuth();
		String response = given()
				.contentType(ContentType.JSON).log().all().body(data).when()
				.patch("/6").then().
				log().all()
				.extract()
				.response().getBody().print();
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		
	}
	
	@Test
	public void GetRequest() {
		
		try {
			//Tokenuth();
		String response = given()
				.contentType(ContentType.JSON).log().all().when()
				.get("/6").then().
				log().all()
				.body("booking.firstname", equalTo("Dura")).body("booking.lastname", equalTo("Navernoe")).extract()
				.response().getBody().print();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}


	/*@Test(priority = 2)
	public void delete()

	{
	Response resp = given().  
	 when().      
	delete("/"+a);      

	System.out.println(resp.asString());

	}*/

}
