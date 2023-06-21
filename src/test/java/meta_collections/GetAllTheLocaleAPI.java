package meta_collections;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class GetAllTheLocaleAPI {
	
	@Test
	public void Get_local () throws IOException
	{
		
		RestAssured.baseURI= Propper.promp("Url");
		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Propper.promp("access_token"))
				.when()
				.get("/api/v2/platform/locales")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());
	}

}
