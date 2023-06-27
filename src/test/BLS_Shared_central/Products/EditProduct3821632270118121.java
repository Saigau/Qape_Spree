package Products;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import BLS_utility.Propper_bls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EditProduct3821632270118121 {
@Test
public void editproduct() throws IOException {
	RestAssured.baseURI =Propper_bls.promp("BLS_url");
	
	Response r = given()
			.contentType(ContentType.JSON)
			
			.header("token",Propper_bls.promp("access_token"))
			.header("Access_key",Propper_bls.promp("access_key") )
			.header("Application_id", Propper_bls.promp("application_id"))
			.header("Account_id",Propper_bls.promp("account_id"))
			
			.body("{\r\n"
					+ "    \"product_id\": \"22\",\r\n"
					+ "    \"data\": {\r\n"
					+ "        \"store_id\": \"23\",\r\n"
					+ "        \"product\": {\r\n"
					+ "            \"name\": \"jockey3\",\r\n"
					+ "            \"price\": \"8000\",\r\n"
					+ "            \"shipping_category_id\": \"10\",\r\n"
					+ "            \"description\": \"These is the once of the best product with best price u will get it.\",\r\n"
					+ "            \"available_on\": \"09/06/2023\",\r\n"
					+ "            \"discontinue_on\": \"qwq\",\r\n"
					+ "            \"permalink\": \"<string>\",\r\n"
					+ "            \"meta_description\": \"<string>\",\r\n"
					+ "            \"meta_keywords\": \"<string>\",\r\n"
					+ "            \"sku\": \"<string>\",\r\n"
					+ "            \"deleted_at\": \"<string>\",\r\n"
					+ "            \"prototype_id\": \"<string>\",\r\n"
					+ "            \"option_values_hash\": \"<string>\",\r\n"
					+ "            \"weight\": \"850gms\",\r\n"
					+ "            \"height\": \"4mtr\",\r\n"
					+ "            \"width\": \"2mtr\",\r\n"
					+ "            \"depth\": \"<string>\",\r\n"
					+ "            \"tax_category_id\": \"<string>\",\r\n"
					+ "            \"cost_currency\": \"Rupee\",\r\n"
					+ "            \"cost_price\": \"2500\",\r\n"
					+ "            \"compare_at_price\": \"2800\",\r\n"
					+ "            \"option_type_ids\": \"<string>\",\r\n"
					+ "            \"taxon_ids\": \"<string>\",\r\n"
					+ "            \"public_metadata\": {},\r\n"
					+ "            \"private_metadata\": {}\r\n"
					+ "        }\r\n"
					+ "    }\r\n"
					+ "}")
			.when()
			.post("/api/v1/service_contract/3821632270118121")
			.then()
			.log().all().extract().response();
	System.out.println("Code "+r.getStatusCode());
	System.out.println(r.timeIn(TimeUnit.SECONDS)+" sec");
	
}
}
