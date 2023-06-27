package promotions;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreatePromotion {
	
	@Test
	public void promotion () throws IOException {
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\"store_id\": 23,\r\n"
						+ "  \"promotion\": {\r\n"
						+ "    \"name\": \"Mani new\",\r\n"
						+ "    \"code\": \"1234\",\r\n"
						+ "    \"description\": \"Hello new\",\r\n"
						+ "    \"usage_limit\": \"1000\",\r\n"
						+ "    \"advertise\": true,\r\n"
						+ "    \"starts_at\": \"today\",\r\n"
						+ "    \"ends_at\": \"tomorrow\",\r\n"
						+ "    \"store_ids\": [\r\n"
						+ "      \"1\",\r\n"
						+ "      \"2\"\r\n"
						+ "    ]\r\n"
						+ "  }\r\n"
						+ "}")
				.when()
				.post("/api/v2/platform/promotions")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}

}
