package Adjustments;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreateanAdjustment {

	
	@Test
	public void Adjustment() throws IOException {
		
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\"store_id\": \"23\",\r\n"
						+ "  \"adjustment\": {\r\n"
						+ "    \"order_id\": \"<string>\",\r\n"
						+ "    \"label\": \"<string>\",\r\n"
						+ "    \"adjustable_id\": \"<string>\",\r\n"
						+ "    \"adjustable_type\": \"<string>\",\r\n"
						+ "    \"source_id\": \"<string>\",\r\n"
						+ "    \"source_type\": \"<string>\",\r\n"
						+ "    \"amount\": \"<number>\",\r\n"
						+ "    \"mandatory\": \"<boolean>\",\r\n"
						+ "    \"eligible\": \"<boolean>\",\r\n"
						+ "    \"state\": \"open\",\r\n"
						+ "    \"included\": false\r\n"
						+ "  }\r\n"
						+ "}")
				.when()
				.post("/api/v2/platform/adjustments")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}
}
