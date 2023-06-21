package Authorization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utility.RandomStringGenerator;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class one_token {

	static String email_login;
	static String access_token;
	static String uid;
	static String secret;
	
	 public  String final_token;
	@Test(priority = 1)
	public void loginApi() {

		
		// For Generate email id
		
		 RestAssured.baseURI = "https://devspree.uncode.io";


	
	
		Response r = given().contentType(ContentType.JSON) .body("{\r\n" +
				"    \"user\":\r\n" + "     {\r\n" +
				"        \"email\": \"User20057"+RandomStringGenerator.generateRandomString(8)+"@gmail.com\",\r\n" +
				"        \"password\": \"123456\",\r\n" +
				"        \"password_confirmation\": \"123456\",\r\n" +
				"        \"name\": \"User20057"+RandomStringGenerator.generateRandomString(8)+"\",\r\n" +
				"        \"industry_type\": \"Small industry\"\r\n" + "    }\r\n" + "}")
				.when() .post("/api/v2/registrations") .then()
				.log().all().extract().response();

		JsonPath jsonpath = r.jsonPath();  email_login = jsonpath.get("email");
		System.out.println("Email is "+email_login);
System.out.println("**********************************************************************************************************************************************************");

	}

	@Test(priority = 2)
	public static void oath()
	{
		
		//For Generate temporary access token

		RestAssured.baseURI = "https://devspree.uncode.io";




		Response rs = given().contentType(ContentType.JSON)

				.body("{\r\n"
						+ "  \"grant_type\": \"password\",\r\n"
						+ "  \"username\": \"mani@gmail.com\",\r\n"
						+ "  \"password\": \"123456\"\r\n"
						+ "}")
				.when()
				.post("/spree_oauth/token")
				.then()
				.log().all().extract().response();

		access_token =  rs.jsonPath().getString("access_token");
		System.out.println("toekn is "+access_token);
		System.out.println("**********************************************************************************************************************************************************");
	}
	@Test(priority = 3)
	public void oauth()
	{
		
		//User Email and access token for generate uid and Secret id 
		
		RestAssured.baseURI = "https://devspree.uncode.io";


		Response r = given().contentType(ContentType.JSON)
				.header("Authorization","Bearer "+access_token)
				.body("{\r\n"
						+ "    \"oauth_application\": {\r\n"
						+ "        \"name\": \""+email_login+"\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post("/api/v2/apps/")
				.then()
				.log().all().extract().response();

		JsonPath jsonpath = r.jsonPath();
		uid= jsonpath.getString("uid");
		secret= jsonpath.getString("secret");
		System.out.println("uid is "+uid);
		System.out.println("secret is "+secret);
		System.out.println("**********************************************************************************************************************************************************");
	}





	@Test(priority = 4)
	public void Final_token()
	{

		// user uid and secret id for generate final token


		RestAssured.baseURI = "https://devspree.uncode.io";


		Response r = given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"grant_type\": \"client_credentials\",\r\n"
						+ "    \"client_id\": \""+uid+"\",\r\n"
						+ "    \"client_secret\": \""+secret+"\",\r\n"
						+ "    \"scope\": \"admin\"\r\n"
						+ "}")
				.when()
				.post("/spree_oauth/token")
				.then()
				.log().all().extract().response();

		JsonPath jsonpath = r.jsonPath();
		final_token= jsonpath.getString("access_token");
		System.out.println("the final token is-  "+final_token);
















	}

}
