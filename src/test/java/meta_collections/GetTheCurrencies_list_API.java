package meta_collections;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class GetTheCurrencies_list_API {
@Test


public void Currency() throws IOException
{
	
	RestAssured.baseURI= Propper.promp("Url");
	
	Response r = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer "+Propper.promp("access_token"))
			.when()
			.get("/api/v2/platform/currencies")
			.then()
			.log().all()
			.extract().response();
	
	System.out.println(r.getStatusCode());
	
}
}