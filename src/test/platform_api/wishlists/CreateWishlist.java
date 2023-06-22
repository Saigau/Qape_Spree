package wishlists;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreateWishlist {
	@Test
	public void wishlist() throws IOException {


		{

			RestAssured.baseURI=Proppery.promp("Url");

			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Proppery.promp("access_token"))
					.body("{\r\n"
							+ "    \"store_id\":22,\r\n"
							+ "  \"wishlist\": {\r\n"
							+ "    \"name\": \"spree commerce is an online store\",\r\n"
							+ "    \"user_id\": \"spree_122\",\r\n"
							+ "    \"is_default\": \"true\",\r\n"
							+ "    \"is_private\": \"true\"\r\n"
							+ "  }\r\n"
							+ "}")
					.when()
					.get("/api/v2/platform/zones")
					.then()
					.log().all().extract().response();
			System.out.println(r.getContentType());

		}
	}
}