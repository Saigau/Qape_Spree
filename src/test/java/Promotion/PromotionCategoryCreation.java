package Promotion;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class PromotionCategoryCreation {
	@Test
	public void Category() throws IOException
	{
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.body("{\r\n"
							+ "    \"store_id\":\"23\",\r\n"
							+ "  \"promotion_category\": {\r\n"
							+ "    \"name\": \"Promotions Used in 2021\",\r\n"
							+ "    \"code\": \"2021-PROMOS\"\r\n"
							+ "  }\r\n"
							+ "}")
					.when()
					.get("/api/v2/platform/promotion_categories")
					.then()
					.log().all().extract().response();
		}
	}
	

}
