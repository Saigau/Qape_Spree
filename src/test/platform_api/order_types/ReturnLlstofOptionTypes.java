package order_types;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class ReturnLlstofOptionTypes {
	
@Test
public void return_optiontype() throws IOException {
	
	RestAssured.baseURI=Proppery.promp("Url");

	Response r = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer "+Proppery.promp("access_token"))
			.body("{\r\n"
					+ "    \"store_id\":23\r\n"
					+ "}")
			.when()
			.get("/api/v2/platform/option_types")
			.then()
			.log().all().extract().response();
	System.out.println(r.getStatusCode());

}
}
