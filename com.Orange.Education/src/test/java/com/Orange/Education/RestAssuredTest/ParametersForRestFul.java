package com.Orange.Education.RestAssuredTest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ParametersForRestFul {

	private static RequestSpecification requestSpec;
	
	private static ResponseSpecification responseSpec;

	@BeforeClass
	public static void createRequestSpecification() {
		requestSpec = new RequestSpecBuilder().			
				setBaseUri("http://api.zippopotam.us").build();
		
		responseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
	}

	@Test(dataProvider = "zipCodeAbdPlaces")
	public void requestUSZipCode90210_CheckPlaceNameInResponseBody_ExpectBeverlyHills(String countryCode,
			String zipCode, String adress) {
		given()
			.spec(requestSpec)
			.pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).when()
		.get("/{countryCode}/{zipCode}")
			.then()
			.spec(responseSpec)
				.assertThat().body("places[0].'place name'", equalTo(adress));

	}

	@DataProvider(name = "zipCodeAbdPlaces")
	public static Object[][] zipCodeAbdPlaces() {
		return new Object[][] { { "us", "90210", "Beverly Hills" }, { "us", "12345", "Schenectady" },
				{ "ca", "B2R", "Waverley" } };
	}

	@Test
	public void TstDataByJsonFile() {
		JSONParser parser = new JSONParser();

		try {
			String apiBody = "";

			Object obj = parser.parse(new FileReader("D:\\JSON\\post.json"));
			JSONObject jsonObject = (JSONObject) obj;

			apiBody = jsonObject.toJSONString();

			System.out.println(apiBody);

			//List<String> categories = JsonPath.from(apiBody).get("PostCodes.place");
			

			String a = JsonPath.from(apiBody).get("PostCodes[1].countryCode");

			String b = JsonPath.from(apiBody).get("PostCodes[1].zipCode");

			String c = JsonPath.from(apiBody).get("PostCodes[1].place");

			System.out.println(a);

			given().spec(requestSpec).pathParam("countryCode", a).pathParam("zipCode", b).when()
					.get("/{countryCode}/{zipCode}").then().assertThat().body("places[0].'place name'", equalTo(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//The sample code will help you do the authentication before every request you send.
	@Test
	public void Tokenuth() {
		RestAssured.baseURI = System.getProperty("baseurl");
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("admin");
		authScheme.setPassword("password123");
		RestAssured.authentication = authScheme;
	}
	
    @Test
    public void requestUsZipCode90210_extractPlaceNameFromResponseBody_assertEqualToBeverlyHills() {

        String placeName = 
        given().
            spec(requestSpec).
        when().
            get("http://zippopotam.us/us/90210").
        then().
            extract().
            path("places[0].'place name'");

        Assert.assertEquals("Beverly Hills", placeName);
    }
}
