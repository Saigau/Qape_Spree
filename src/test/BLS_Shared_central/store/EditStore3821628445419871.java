package store;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import BLS_utility.Propper_bls;
import BLS_utility.RandomStringGenerator_BLS;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EditStore3821628445419871 {
	
	@Test
	public void edit_stire() throws IOException
	{
		
RestAssured.baseURI =Propper_bls.promp("BLS_url");
		
		Response r = given()
				.contentType(ContentType.JSON)
				
				.header("token",Propper_bls.promp("access_token"))
				.header("Access_key",Propper_bls.promp("access_key") )
				.header("Application_id", Propper_bls.promp("application_id"))
				.header("Account_id",Propper_bls.promp("account_id"))
				.header("controller_id",Propper_bls.promp("controller_id"))
				.header("prd_id",Propper_bls.promp("prd_id"))
				
				.body("{\r\n"
						+ "    \"id\": 69,\r\n"
						+ "    \"data\": {\r\n"
						+ "        \"store\": {\r\n"
						+ "            \"name\": \"Tenant first storing\",\r\n"
						+ "            \"code\": \""+RandomStringGenerator_BLS.generateRandomString(7)+"\",\r\n"
						+ "            \"mail_from_address\": \"no-reply1@example.com\",\r\n"
						+ "            \"customer_support_email\": \"support1@example.com\",\r\n"
						+ "            \"new_order_notifications_email\": \"\",\r\n"
						+ "            \"default_currency\": \"USD\",\r\n"
						+ "            \"supported_currencies\": [\r\n"
						+ "                \"\",\r\n"
						+ "                \"CAD\",\r\n"
						+ "                \"CDF\"\r\n"
						+ "            ],\r\n"
						+ "            \"checkout_zone_id\": \"\",\r\n"
						+ "            \"default_country_id\": \"793\",\r\n"
						+ "            \"default_locale\": \"EN\",\r\n"
						+ "            \"supported_locales\": [\r\n"
						+ "                \"\",\r\n"
						+ "                \"fr\",\r\n"
						+ "                \"en\"\r\n"
						+ "            ],\r\n"
						+ "            \"digital_asset_authorized_clicks\": \"5\",\r\n"
						+ "            \"limit_digital_download_count\": \"1\",\r\n"
						+ "            \"digital_asset_authorized_days\": \"7\",\r\n"
						+ "            \"limit_digital_download_days\": \"1\",\r\n"
						+ "            \"digital_asset_link_expire_time\": \"300\",\r\n"
						+ "            \"seo_title\": \"Spree Commerce Demo Shop\",\r\n"
						+ "            \"meta_description\": \"This is the new Spree UX DEMO | OVERVIEW: http://bit.ly/new-spree-ux | DOCS: http://bit.ly/spree-ux-customization-docs | CONTACT: https://spreecommerce.org/contact/\",\r\n"
						+ "            \"meta_keywords\": \"[FILTERED]\",\r\n"
						+ "            \"seo_robots\": \"\",\r\n"
						+ "            \"facebook\": \"spreecommerce\",\r\n"
						+ "            \"twitter\": \"spreecommerce\",\r\n"
						+ "            \"instagram\": \"spreecommerce\",\r\n"
						+ "            \"description\": \"\",\r\n"
						+ "            \"address\": \"\",\r\n"
						+ "            \"contact_phone\": \"\"\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post("/api/v1/service_contract/3821628445419871")
				.then()
				.log().all().extract().response();
		System.out.println("Code "+r.getStatusCode());
		System.out.println(r.timeIn(TimeUnit.SECONDS)+" sec");
	}

}
