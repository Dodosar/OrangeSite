package com.Orange.Education.RestAssuredTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class ApiTestRestAssure {

	private String url = "http://httpbin.org";

	@Test
	public void TestGetRequest() {
		long threadId = Thread.currentThread().getId();
		System.out.println("Thread Get:" + threadId);
		String response = given()
				.log().all()
				.when()
				.get(url + "/get?a=1")
				.then()
				.statusCode(200)
				.body("headers.Host", equalTo("httpbin.org"))
				.body("args.a", equalTo("1"))
				.extract().response()
				.getBody().print();
	}

	@Test
	public void TestPostRequest() {
		long threadId = Thread.currentThread().getId();
		System.out.println("Thread Post:" + threadId);
		Map<String, String> data = new HashMap<String, String>();
		data.put("orderId", "2");
		data.put("test", "65");
		String response = 
				given()
				.log().all()
				.contentType("application/json")
				.body(data)
				.when().post(url + "/post").then()
				.statusCode(200)
				.body("json.orderId", equalTo("2"))
				.extract()
				.response()
				.getBody().print();

	}
	
	@Test
	public void TestPatch() {
		long threadId = Thread.currentThread().getId();
		System.out.println("Thread Patch:" + threadId);
		
		
	}

}
