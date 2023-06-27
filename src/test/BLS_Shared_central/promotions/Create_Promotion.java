package promotions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import BLS_utility.Propper_bls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class Create_Promotion {
	
	@Test
	public void promotion () throws IOException {
		RestAssured.baseURI=Proppery.promp("BLS_url");

		
		
		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Propper_bls.promp("access_token"))
				.header("Access_key",Propper_bls.promp("access_key") )
				.header("Application_id", Propper_bls.promp("application_id"))
				.header("Account_id",Propper_bls.promp("account_id"))
				
				.body("{\\\"store_id\\\": 23,\\r\\n\"\r\n"
						+ "						+ \"  \\\"promotion\\\": {\\r\\n\"\r\n"
						+ "						+ \"    \\\"name\\\": \\\"Mani new\\\",\\r\\n\"\r\n"
						+ "						+ \"    \\\"code\\\": \\\"1234\\\",\\r\\n\"\r\n"
						+ "						+ \"    \\\"description\\\": \\\"Hello new\\\",\\r\\n\"\r\n"
						+ "						+ \"    \\\"usage_limit\\\": \\\"1000\\\",\\r\\n\"\r\n"
						+ "						+ \"    \\\"advertise\\\": true,\\r\\n\"\r\n"
						+ "						+ \"    \\\"starts_at\\\": \\\"today\\\",\\r\\n\"\r\n"
						+ "						+ \"    \\\"ends_at\\\": \\\"tomorrow\\\",\\r\\n\"\r\n"
						+ "						+ \"    \\\"store_ids\\\": [\\r\\n\"\r\n"
						+ "						+ \"      \\\"1\\\",\\r\\n\"\r\n"
						+ "						+ \"      \\\"2\\\"\\r\\n\"\r\n"
						+ "						+ \"    ]\\r\\n\"\r\n"
						+ "						+ \"  }\\r\\n\"\r\n"
						+ "						+ \"}")
				.when()
				.delete("/api/v1/service_contract/3821545537717838")
				.then()
				.log().all().extract().response();
		System.out.println("Code "+r.getStatusCode());
		System.out.println(r.timeIn(TimeUnit.SECONDS)+" sec");
	}

}
