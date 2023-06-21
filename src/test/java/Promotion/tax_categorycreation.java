package Promotion;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;
import utility.RandomStringGenerator;

public class tax_categorycreation {
	@Test
	public void tax_create() throws IOException
	{
		
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.body("{\"store_id\":\"23\",\r\n"
							+ "  \"tax_category\": {\r\n"
							+ "    \"name\": \"Clothing"+RandomStringGenerator.generateRandomString(5)+"\",\r\n"
							+ "    \"is_default\": true,\r\n"
							+ "    \"tax_code\": \"1257L\",\r\n"
							+ "    \"description\": \"Men's, women's and children's branded clothing\"\r\n"
							+ "  }\r\n"
							+ "}")
					.when()
					.post("/api/v2/platform/tax_categories")
					.then()
					.log().all().extract().response();
		}
	}

}
