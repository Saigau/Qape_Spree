package tanent;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import BLS_utility.Propper_bls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteApiKeys3821311277997961 {
@Test

public void deletekey() throws IOException {
	
	RestAssured.baseURI =Propper_bls.promp("BLS_url");
	
	Response r = given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer "+Propper_bls.promp("access_token"))
			.header("Access_key",Propper_bls.promp("access_key") )
			.header("Application_id", Propper_bls.promp("application_id"))
			.header("Account_id",Propper_bls.promp("account_id"))
			
			.body("{\r\n"
					+ "    \"data\": {\r\n"
					+ "        \"oauth_application\": {\r\n"
					+ "            \"name\": \"User18@gmail.com\"\r\n"
					+ "        }\r\n"
					+ "    }\r\n"
					+ "}")
			.when()
			.delete("/api/v1/service_contract/3821311277997961")
			.then()
			.log().all().extract().response();
	System.out.println("Code "+r.getStatusCode());
	System.out.println(r.timeIn(TimeUnit.SECONDS)+" sec");
}
}
