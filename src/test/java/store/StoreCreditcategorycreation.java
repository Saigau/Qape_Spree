package store;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class StoreCreditcategorycreation {
	
	@Test
	public void storeCredit() throws IOException {
		
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.body("{   \"store_id\":\"23\",\r\n"
							+ "  \"store_credit_category\": {\r\n"
							+ "    \"name\": \"refunded\"\r\n"
							+ "  }\r\n"
							+ "}")
					.when()
					.get("/api/v2/platform/store_credit_categories")
					.then()
					.log().all().extract().response();
		}
	}

}
