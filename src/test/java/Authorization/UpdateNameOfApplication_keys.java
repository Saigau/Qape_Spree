package Authorization;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;

public class UpdateNameOfApplication_keys {
	
	
	@Test
	public void update_name_appkey() throws IOException 
	{
		RestAssured.baseURI = Propper.promp("Url");
		
		Response r = given()
		.contentType(ContentType.JSON)
		.header("Authorization","Bearer"+Propper.promp("access_token"))
		.body("{\"oauth_application\":{\r\n"
				+ "    \"name\":\"user20057imkq03hv@gmail.com\" \r\n"
				+ "}\r\n"
				+ "}")
		.when()
		.put("/api/v2/apps/151")
		.then()
		.log().all().extract().response();
		System.out.println(r.getContentType());
	}
	

}
