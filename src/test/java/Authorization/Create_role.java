package Authorization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Create_role {

	
	@Test
	public void get()
	{
		
		
		RestAssured.baseURI = "https://devspree.uncode.io";
	                 

		 String   bearerToken = "b5hy4Jzfy-V4rf_hUrjeqlmLuwlKGg-g3_7VxQiKHkA";
		
		 
	Response rr =
	        given()
	               .contentType(ContentType.JSON)
	               .header("Authorization", "Bearer " + bearerToken)
	             .body("{\"store_id\":23\r\n"
	             		+ ",\r\n"
	             		+ "  \"role\": {\r\n"
	             		+ "    \"name\": \"Saigdasdsaurkjkallv\"\r\n"
	             		+ "  }\r\n"
	             		+ "}")
	               .when()
	               .post("/api/v2/platform/roles").then()
	               
	               .log().all().extract().response();
	
		      
				
	}
}
