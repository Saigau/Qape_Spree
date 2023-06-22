package store_credits;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreateaStoreCredit {
@Test
public void storecredit() throws IOException {
	
	RestAssured.baseURI=Proppery.promp("Url");

	Response r = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer "+Proppery.promp("access_token"))
			.body("{\r\n"
					+ "    \"store_id\": 23,\r\n"
					+ "    \"store_credit\": {\r\n"
					+ "        \"user_id\": \"104\",\r\n"
					+ "        \"category_id\": \"4\",\r\n"
					+ "        \"type_id\": \"1\",\r\n"
					+ "        \"created_by_id\": \"5\",\r\n"
					+ "        \"currency\": \"USD\",\r\n"
					+ "        \"store_id\": \"23\",\r\n"
					+ "        \"amount\": \"1000\",\r\n"
					+ "        \"amount_used\": \"500\",\r\n"
					+ "        \"memo\": \"This credit was given as a refunD\",\r\n"
					+ "        \"amount_authorized\": \"15.5\",\r\n"
					+ "        \"originator_id\": \"2\",\r\n"
					+ "        \"originator_type\": \"Refund\",\r\n"
					+ "        \"public_metadata\": {},\r\n"
					+ "        \"private_metadata\": {}\r\n"
					+ "    }\r\n"
					+ "}")
			.when()
			.post("/api/v2/platform/store_credits")
			.then()
			.log().all().extract().response();
	System.out.println(r.getStatusCode());

}
}
