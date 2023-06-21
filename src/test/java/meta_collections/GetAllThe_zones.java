package meta_collections;

import java.io.IOException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class GetAllThe_zones {

	
@Test
public void zones() throws IOException
{
	
	RestAssured.baseURI=Propper.promp("Url");
	  
	Response r = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer "+Propper.promp("access_token"))
			.when()
			.get("/api/v2/platform/zones")
			.then()
			.log().all().extract().response();
}
}
