package store;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;
public class GetStoreByIdAPI {
	
	@Test
	public void StoreById() throws IOException
	{
		
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.when()
					.get("/api/v2/platform/stores/23")
					.then()
					.log().all().extract().response();
		}
	}

}
