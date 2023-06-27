package store;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import BLS_utility.Propper_bls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteStore3821804037884625 {
@Test
public void deleteStore() throws IOException {
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
					+ "\r\n"
					+ "    \"id\": 3822755202885803,\r\n"
					+ "\r\n"
					+ "    \"bu_id\": 123,\r\n"
					+ "\r\n"
					+ "    \"name\": \"Store34\",\r\n"
					+ "\r\n"
					+ "    \"description\": \"hyd\",\r\n"
					+ "\r\n"
					+ "    \"address\": \"hyd\",\r\n"
					+ "\r\n"
					+ "    \"location\": \"hyd\",\r\n"
					+ "\r\n"
					+ "    \"is_enabled_business_hours\": \"\",\r\n"
					+ "\r\n"
					+ "    \"business_hours_id\": \"\",\r\n"
					+ "\r\n"
					+ "    \"stripe_account_id\": \"\",\r\n"
					+ "\r\n"
					+ "    \"approval_code\": \"\",\r\n"
					+ "\r\n"
					+ "    \"channel_setting_id\": \"\",\r\n"
					+ "\r\n"
					+ "    \"data\": {\r\n"
					+ "\r\n"
					+ "        \"store\": {\r\n"
					+ "\r\n"
					+ "            \"name\": \"Store3\",\r\n"
					+ "\r\n"
					+ "            \"code\": \"Tstore2iU4222253\",\r\n"
					+ "\r\n"
					+ "            \"mail_from_address\": \"no-reply1@example.com\",\r\n"
					+ "\r\n"
					+ "            \"customer_support_email\": \"support1@example.com\",\r\n"
					+ "\r\n"
					+ "            \"new_order_notifications_email\": \"\",\r\n"
					+ "\r\n"
					+ "            \"default_currency\": \"USD\",\r\n"
					+ "\r\n"
					+ "            \"supported_currencies\": [\r\n"
					+ "\r\n"
					+ "                \"\",\r\n"
					+ "\r\n"
					+ "                \"CAD\",\r\n"
					+ "\r\n"
					+ "                \"CDF\"\r\n"
					+ "\r\n"
					+ "            ],\r\n"
					+ "\r\n"
					+ "            \"checkout_zone_id\": \"\",\r\n"
					+ "\r\n"
					+ "            \"default_country_id\": \"793\",\r\n"
					+ "\r\n"
					+ "            \"default_locale\": \"EN\",\r\n"
					+ "\r\n"
					+ "            \"supported_locales\": [\r\n"
					+ "\r\n"
					+ "                \"\",\r\n"
					+ "\r\n"
					+ "                \"fr\",\r\n"
					+ "\r\n"
					+ "                \"en\"\r\n"
					+ "\r\n"
					+ "            ],\r\n"
					+ "\r\n"
					+ "            \"digital_asset_authorized_clicks\": \"5\",\r\n"
					+ "\r\n"
					+ "            \"limit_digital_download_count\": \"1\",\r\n"
					+ "\r\n"
					+ "            \"digital_asset_authorized_days\": \"7\",\r\n"
					+ "\r\n"
					+ "            \"limit_digital_download_days\": \"1\",\r\n"
					+ "\r\n"
					+ "            \"digital_asset_link_expire_time\": \"300\",\r\n"
					+ "\r\n"
					+ "            \"seo_title\": \"Spree Commerce Demo Shop\",\r\n"
					+ "\r\n"
					+ "            \"meta_description\": \"This is the new Spree UX DEMO | OVERVIEW: http://bit.ly/new-spree-ux | DOCS: http://bit.ly/spree-ux-customization-docs | CONTACT: https://spreecommerce.org/contact/\",\r\n"
					+ "\r\n"
					+ "            \"meta_keywords\": \"[FILTERED]\",\r\n"
					+ "\r\n"
					+ "            \"seo_robots\": \"\",\r\n"
					+ "\r\n"
					+ "            \"facebook\": \"spreecommerce\",\r\n"
					+ "\r\n"
					+ "            \"twitter\": \"spreecommerce\",\r\n"
					+ "\r\n"
					+ "            \"instagram\": \"spreecommerce\",\r\n"
					+ "\r\n"
					+ "            \"description\": \"hyd\",\r\n"
					+ "\r\n"
					+ "            \"address\": \"hyd\",\r\n"
					+ "\r\n"
					+ "            \"contact_phone\": \"\"\r\n"
					+ "\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "    }\r\n"
					+ "\r\n"
					+ "}")
			.when()
			.post("/api/v1/service_contract/3821631160277877")
			.then()
			.log().all().extract().response();
	System.out.println("Code "+r.getStatusCode());
	System.out.println(r.timeIn(TimeUnit.SECONDS)+" sec");
	
}
}
