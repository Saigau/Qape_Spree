package store;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class DeleteStorebyId {

	@Test
	public void Deletestore() throws IOException {
		
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.when()
					.get("/api/v2/platform/stores/73")
					.then()
					.log().all().extract().response();
		}
	}
}
