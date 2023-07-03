import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class Rest_Get_Reference {

	public static void main(String[] args) {
		// Declare the base URL
		RestAssured.baseURI = "https://reqres.in/";
	
		//Declare given, when then method (Response Body fetching)
		//String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).log().all().
				//when().post("api/users").then().log().all().extract().response().asString();
		String ResponseBody = given().header("Content-Type","application/json").body("RequestBody").
				when().get("api/users/2").then().extract().response().asString();
		System.out.println(ResponseBody);
		
	}

}
