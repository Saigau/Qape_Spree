package Promotion;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class PaymentMethodCreation {

	@Test
	public void payment() throws IOException 
	{
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.body("{   \"store_id\":\"23\",\r\n"
							+ "  \"payment_method\": {\r\n"
							+ "    \"name\": \"Test Payment Method\",\r\n"
							+ "    \"active\": true,\r\n"
							+ "    \"auto_capture\": true,\r\n"
							+ "    \"description\": \"This is a test payment method\",\r\n"
							+ "    \"type\": \"Spree::Gateway::Bogus\",\r\n"
							+ "    \"display_on\": \"both\",\r\n"
							+ "    \"store_ids\": [\r\n"
							+ "      \"2\"\r\n"
							+ "    ],\r\n"
							+ "    \"public_metadata\": {},\r\n"
							+ "    \"private_metadata\": {}\r\n"
							+ "  }\r\n"
							+ "}")
					.when()
					.get("/api/v2/platform/payment_methods")
					.then()
					.log().all().extract().response();
		}
		
	}
}
