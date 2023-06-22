package zones;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreateZone {


	@Test
	public void zone() throws IOException
	{


		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.when()
				.get("/api/v2/platform/zones")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());
	}

}
