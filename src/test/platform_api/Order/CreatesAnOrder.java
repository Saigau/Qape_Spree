package Order;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import plat_utility.Proppery;

public class CreatesAnOrder {

	@Test
	public void order() throws IOException {
		
		RestAssured.baseURI=Proppery.promp("Url");

		Response r = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+Proppery.promp("access_token"))
				.body("{\r\n"
						+ "    \"store_id\": 23,\r\n"
						+ "    \"order\": {\r\n"
						+ "        \"item_total\": \"65\",\r\n"
						+ "        \"total\": \"68\",\r\n"
						+ "        \"state\": \"payment\",\r\n"
						+ "        \"adjustment_total\": \"25\",\r\n"
						+ "        \"user_id\": \"spreerose\",\r\n"
						+ "        \"completed_at\": \"thursday\",\r\n"
						+ "        \"bill_address_id\": \"okohoma hiroshaki\",\r\n"
						+ "        \"ship_address_id\": \"<string>\",\r\n"
						+ "        \"payment_total\": \"<number>\",\r\n"
						+ "        \"shipment_state\": \"canceled\",\r\n"
						+ "        \"payment_state\": \"paid\",\r\n"
						+ "        \"email\": \"shipmentid@mail.com\",\r\n"
						+ "        \"special_instructions\": \"<string>\",\r\n"
						+ "        \"currency\": \"USD\",\r\n"
						+ "        \"last_ip_address\": \"orio\",\r\n"
						+ "        \"created_by_id\": \"<string>\",\r\n"
						+ "        \"shipment_total\": \"<number>\",\r\n"
						+ "        \"additional_tax_total\": \"<number>\",\r\n"
						+ "        \"promo_total\": \"<number>\",\r\n"
						+ "        \"channel\": \"BBC news\",\r\n"
						+ "        \"included_tax_total\": \"<number>\",\r\n"
						+ "        \"item_count\": \"10\",\r\n"
						+ "        \"approver_id\": \"apr12\",\r\n"
						+ "        \"approved_at\": \"<string>\",\r\n"
						+ "        \"confirmation_delivered\": false,\r\n"
						+ "        \"considered_risky\": false,\r\n"
						+ "        \"canceled_at\": \"<string>\",\r\n"
						+ "        \"canceler_id\": \"<string>\",\r\n"
						+ "        \"taxable_adjustment_total\": \"<number>\",\r\n"
						+ "        \"non_taxable_adjustment_total\": \"<number>\",\r\n"
						+ "        \"store_owner_notification_delivered\": false,\r\n"
						+ "        \"bill_address_attributes\": {\r\n"
						+ "            \"address\": {\r\n"
						+ "                \"country_id\": \"1\",\r\n"
						+ "                \"state_id\": \"US-AL\",\r\n"
						+ "                \"state_name\": \"Albama\",\r\n"
						+ "                \"address1\": \"alabama1\",\r\n"
						+ "                \"address2\": \"arizona\",\r\n"
						+ "                \"city\": \"california\",\r\n"
						+ "                \"zipcode\": \"84851\",\r\n"
						+ "                \"phone\": \"090878654\",\r\n"
						+ "                \"alternative_phone\": \"090878654\",\r\n"
						+ "                \"firstname\": \"albama\",\r\n"
						+ "                \"lastname\": \"bama\",\r\n"
						+ "                \"label\": \"AL\",\r\n"
						+ "                \"company\": \"RJC solutions ltd\",\r\n"
						+ "                \"user_id\": \"12US\",\r\n"
						+ "                \"public_metadata\": {},\r\n"
						+ "                \"private_metadata\": {}\r\n"
						+ "            }\r\n"
						+ "        },\r\n"
						+ "        \"ship_address_attributes\": {\r\n"
						+ "            \"address\": {\r\n"
						+ "                \"country_id\": \"FLorida\",\r\n"
						+ "                \"state_id\": \"FL129\",\r\n"
						+ "                \"state_name\": \"Florida\",\r\n"
						+ "                \"address1\": \"<string>\",\r\n"
						+ "                \"address2\": \"<string>\",\r\n"
						+ "                \"city\": \"Georgia\",\r\n"
						+ "                \"zipcode\": \"75758484\",\r\n"
						+ "                \"phone\": \"84736294887\",\r\n"
						+ "                \"alternative_phone\": \"<string>\",\r\n"
						+ "                \"firstname\": \"SProo\",\r\n"
						+ "                \"lastname\": \"commerce\",\r\n"
						+ "                \"label\": \"SPD\",\r\n"
						+ "                \"company\": \"REC limited\",\r\n"
						+ "                \"user_id\": \"1665\",\r\n"
						+ "                \"public_metadata\": {},\r\n"
						+ "                \"private_metadata\": {}\r\n"
						+ "            }\r\n"
						+ "        },\r\n"
						+ "        \"line_items_attributes\": [\r\n"
						+ "            {\r\n"
						+ "                \"line_item\": {\r\n"
						+ "                    \"variant_id\": \"12\",\r\n"
						+ "                    \"quantity\": \"10\"\r\n"
						+ "                }\r\n"
						+ "            },\r\n"
						+ "            {\r\n"
						+ "                \"line_item\": {\r\n"
						+ "                    \"variant_id\": \"12\",\r\n"
						+ "                    \"quantity\": \"5\"\r\n"
						+ "                }\r\n"
						+ "            }\r\n"
						+ "        ],\r\n"
						+ "        \"public_metadata\": {},\r\n"
						+ "        \"private_metadata\": {}\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post("/api/v2/platform/orders")
				.then()
				.log().all().extract().response();
		System.out.println(r.getStatusCode());

	}
}
