package meta_collections;

import java.io.IOException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;
import utility.RandomStringGenerator;

public class Zones_create {

	
	
	
	@Test
	public void create_zone() throws IOException
	{
		
		RestAssured.baseURI= Propper.promp("Url");
		
		Response r  = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Propper.promp("access_token"))
				.body("{\r\n"
						+ "   \"store_id\": \"23\",\r\n"
						+ "  \"zone\": {\r\n"
						+ "    \"name\": \""+RandomStringGenerator.generateRandomString(8)+"\",\r\n"
						+ "    \"description\": \"All countries in the EU\",\r\n"
						+ "    \"default_tax\": true,\r\n"
						+ "    \"kind\": \"state\"\r\n"
						+ "  }\r\n"
						+ "}")
				.when().post("/api/v2/platform/zones")
				.then().log().all().extract().response();
	}
}
