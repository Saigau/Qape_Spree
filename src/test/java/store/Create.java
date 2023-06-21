package store;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Propper;
import utility.RandomStringGenerator;

public class Create {
	
	@Test
	public void cr_zone() throws IOException
	{
RestAssured.baseURI= Propper.promp("Url");
		
		Response r  = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Propper.promp("access_token"))
				.body("{\r\n"
						+ "    \"store\": {\r\n"
						+ "        \"name\": \"merchant store\",\r\n"
						+ "        \"code\": \""+RandomStringGenerator.generateRandomString(7)+"\",\r\n"
						+ "        \"mail_from_address\": \"birbittemahesh@gmail.com\",\r\n"
						+ "        \"customer_support_email\": \"support1@example.com\",\r\n"
						+ "        \"new_order_notifications_email\": \"\",\r\n"
						+ "        \"default_currency\": \"USD\",\r\n"
						+ "        \"supported_currencies\": [\r\n"
						+ "            \"\",\r\n"
						+ "            \"CAD\",\r\n"
						+ "            \"CDF\"\r\n"
						+ "        ],\r\n"
						+ "        \"checkout_zone_id\": \"\",\r\n"
						+ "        \"default_country_id\": \"793\",\r\n"
						+ "        \"default_locale\": \"EN\",\r\n"
						+ "        \"supported_locales\": [\r\n"
						+ "            \"\",\r\n"
						+ "            \"fr\",\r\n"
						+ "            \"en\"\r\n"
						+ "        ],\r\n"
						+ "        \"digital_asset_authorized_clicks\": \"5\",\r\n"
						+ "        \"limit_digital_download_count\": \"1\",\r\n"
						+ "        \"digital_asset_authorized_days\": \"7\",\r\n"
						+ "        \"limit_digital_download_days\": \"1\",\r\n"
						+ "        \"digital_asset_link_expire_time\": \"300\",\r\n"
						+ "        \"seo_title\": \"Spree Commerce Demo Shop\",\r\n"
						+ "        \"meta_description\": \"This is the new Spree UX DEMO | OVERVIEW: http://bit.ly/new-spree-ux | DOCS: http://bit.ly/spree-ux-customization-docs | CONTACT: https://spreecommerce.org/contact/\",\r\n"
						+ "        \"meta_keywords\": \"[FILTERED]\",\r\n"
						+ "        \"seo_robots\": \"\",\r\n"
						+ "        \"facebook\": \"spreecommerce\",\r\n"
						+ "        \"twitter\": \"spreecommerce\",\r\n"
						+ "        \"instagram\": \"spreecommerce\",\r\n"
						+ "        \"description\": \"new merchant\",\r\n"
						+ "        \"address\": \"address\",\r\n"
						+ "        \"contact_phone\": \"98745612320\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when().post("/api/v2/platform/stores")
				.then().log().all().extract().response();
	}
	}


