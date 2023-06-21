package meta_collections;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import Authorization.one_token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class Get_the_countries_list_API_according_to_tenant {
  one_token one;
	@Test
	public void countries() throws IOException
	{ 
		RestAssured.baseURI=Propper.promp("Url");
		
		Response r=given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+ Propper.promp("access_token"))
				

				.when()
				.get("/api/v2/platform/countries")
				.then()
				
				.log().all().extract().response();
		
		System.out.println(r.getStatusCode());
		
	}
}
