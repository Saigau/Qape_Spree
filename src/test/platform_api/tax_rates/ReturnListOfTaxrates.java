package tax_rates;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class ReturnListOfTaxrates {
	@Test
	public void return_taxrate() throws IOException {
		RestAssured.baseURI = Proppery.promp("Url");
		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\":23\r\n"
						+ "}")
				.when()
				.get("/api/v2/platform/tax_rates")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());
	}

}
