package Promotion;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class Role_creation {

	
	@Test
	public void role() throws IOException
	{
		
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.body("{\r\n"
							+ "    \"store_id\":\"23\",\r\n"
							+ "  \"role\": {\r\n"
							+ "    \"name\": \"vendor\"\r\n"
							+ "  }\r\n"
							+ "}")
					.when()
					.post("/api/v2/platform/roles")
					.then()
					.log().all().extract().response();
		}
	}
}
