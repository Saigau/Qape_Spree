package promotions_action;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreatePromotionAction {
	
	@Test
	public void Promotion_action() throws IOException {
		
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\":23,\r\n"
						+ "  \"promotion_action\": {\r\n"
						+ "    \"type\": \"Spree::Promotion::Actions::FreeShipping\",\r\n"
						+ "    \"promotion_id\": \"15\"\r\n"
						+ "  }\r\n"
						+ "}")
				.when()
				.post("/api/v2/platform/promotion_actions")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}

}
