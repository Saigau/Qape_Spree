package Authorization;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;




public class Getlistofallapplicationskeys {



	@Test
	public void Get_appkey() throws IOException {
		
		
		{
			
			RestAssured.baseURI=Propper.promp("Url");
			  
			Response r = given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+Propper.promp("access_token"))
					.body("{\r\n"
							+ "    \"store_id\":23   \r\n"
							+ "}")
					.when()
					.get("/api/v2/apps")
					.then()
					.log().all().extract().response();
	System.out.println(	r.getClass());
		System.err.println(r.getStatusCode());
		}
	}
}
