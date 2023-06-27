package menu_items;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreateMenuItem {
	@Test
	public void menu_item() throws IOException
	{
		
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\": \"23\",\r\n"
						+ "    \"menu_item\": {\r\n"
						+ "        \"name\": \"Hub\",\r\n"
						+ "        \"menu_id\": \"1\",\r\n"
						+ "        \"code\": \"sdfv\",\r\n"
						+ "        \"subtitle\": \"salesforce\",\r\n"
						+ "        \"destination\": \"sdfv\",\r\n"
						+ "        \"new_window\": \"true\",\r\n"
						+ "        \"item_type\": \"Container\",\r\n"
						+ "        \"linked_resource_type\": \"Spree::Product\",\r\n"
						+ "        \"linked_resource_id\": \"10\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post("/api/v2/platform/menu_items")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}
	

}
