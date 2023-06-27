package cms_page;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;
import plat_utility.RandomStringGenerator_plat;

public class CreateCMSPage {
	@Test
	public void CmsPage() throws IOException {
		
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\": \"23\",\r\n"
						+ "    \"cms_page\": {\r\n"
						+ "        \"title\": \"title\",\r\n"
						+ "        \"locale\": \"locale\",\r\n"
						+ "        \"type\": \"Spree::Cms::Pages::StandardPage\",\r\n"
						+ "        \"meta_title\": \"title\",\r\n"
						+ "        \"content\": \"content\",\r\n"
						+ "        \"meta_description\": \"description\",\r\n"
						+ "        \"visible\": false,\r\n"
						+ "        \"slug\": \"European"+RandomStringGenerator_plat.generateRandomString(3)+"\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post("api/v2/platform/cms_pages")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}

}
