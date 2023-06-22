package zones;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class ReturnaListOfZones {
@Test
public void returnZone() throws IOException {
	
	{
		
		RestAssured.baseURI=Proppery.promp("Url");
		  
		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\": 23,\r\n"
						+ "    \"zone\": {\r\n"
						+ "        \"name\": \"Saigaurav\",\r\n"
						+ "        \"description\": \"Saigaurav is legend\",\r\n"
						+ "        \"default_tax\": \"As per standard taxation \",\r\n"
						+ "        \"kind\": \"U.S.A\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.get("/api/v2/platform/zones")
				.then()
				.log().all().extract().response();
		System.out.println(r.getTime());
		System.out.println(r.getStatusCode());
	}
}
}
