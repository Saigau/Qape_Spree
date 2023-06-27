package menu_items;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class ReturnListofMenuItems {
	
	@Test
	public void  return_menuitems() throws IOException {
		
		
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.param("page", 1)
				.param("per_page", 1)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\":23\r\n"
						+ "}")
				.when()
				.get("/api/v2/platform/menu_items?page=1&per_page=1")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}

}
