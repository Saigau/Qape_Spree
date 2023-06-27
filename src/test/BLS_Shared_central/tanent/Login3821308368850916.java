package tanent;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import BLS_utility.Propper_bls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Login3821308368850916 {


	@Test
	public void login () throws IOException {

		RestAssured.baseURI = Propper_bls.promp("BLS_url");

		Response r = given()
				.header("Content-Type","application/json")
				.header("Access_key",Propper_bls.promp("access_key") )
				.header("Application_id", Propper_bls.promp("application_id"))
				.header("Account_id",Propper_bls.promp("account_id"))
				.body("{\r\n"
						+ "    \"grant_type\": \"password\",\r\n"
						+ "    \"username\": \"mani@Gmail.com\",\r\n"
						+ "    \"password\": \"123456\"\r\n"
						+ "}")
				.when()
				.post("/api/v1/service_contract/3821308368850916")
				.then()
				.log().all().extract().response();
		System.out.println("Code "+r.getStatusCode());
		System.out.println(r.timeIn(TimeUnit.SECONDS)+" sec");
	}

}
