package Promotion;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class PromotionsCreation {
	@Test
	public void promotion() throws IOException
	{
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.body("{   \"store_id\":\"23\",\r\n"
							+ "  \"promotion\": {\r\n"
							+ "    \"name\": \"Promotions Used in 2021\",\r\n"
							+ "    \"code\": \"BLK-FRI\",\r\n"
							+ "    \"description\": \"Save today with discount code XYZ at checkout.\",\r\n"
							+ "    \"usage_limit\": 100,\r\n"
							+ "    \"advertise\": true,\r\n"
							+ "    \"starts_at\": \"string\",\r\n"
							+ "    \"ends_at\": \"string\",\r\n"
							+ "    \"store_ids\": [\r\n"
							+ "      \"2\"\r\n"
							+ "    ]\r\n"
							+ "  }\r\n"
							+ "}")
					.when()
					.get("/api/v2/platform/promotions")
					.then()
					.log().all().extract().response();
		}
	}

}
