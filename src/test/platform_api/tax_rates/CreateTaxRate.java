package tax_rates;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreateTaxRate {
	@Test
	public void taxrates() throws IOException {
		
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\": 23,\r\n"
						+ "    \"taxon\": {\r\n"
						+ "        \"name\": \"PREDTORfsssa\",\r\n"
						+ "        \"taxonomy_id\": \"12\",\r\n"
						+ "        \"parent_id\": \"\",\r\n"
						+ "        \"public_metadata\": {},\r\n"
						+ "        \"private_metadata\": {}\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post("/api/v2/platform/tax_rates")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}

}
