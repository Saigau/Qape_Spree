package order_types;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreateOptionType {

	@Test
	public void OptionType() throws IOException {
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{    \"store_id\":\"23\",\r\n"
						+ "  \"option_type\": {\r\n"
						+ "    \"name\": \"sdfb\",\r\n"
						+ "    \"presentation\": \"fggfd\",\r\n"
						+ "    \"public_metadata\": {},\r\n"
						+ "    \"private_metadata\": {}\r\n"
						+ "  }\r\n"
						+ "}")
				.when()
				.post("/api/v2/platform/option_types")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}
}
