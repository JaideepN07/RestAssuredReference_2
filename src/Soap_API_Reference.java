import io.restassured.RestAssured;
import io.restassured.path.xml.*;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
public class Soap_API_Reference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declare Base URL
		RestAssured.baseURI="https://www.dataaccess.com/";
		
		//Declare the request body
		String RequestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>100</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>\r\n"
				+ "";
		System.out.println(RequestBody);

		//Extract the response body
		String ResponseBody=given().header("Content-Type","text/xml; charset=utf-8").body(RequestBody).when().
				post("webservicesserver/NumberConversion.wso").then().extract().response().asString();
		System.out.println(ResponseBody);
		
		//Parse the response body
		XmlPath XmlResponse=new XmlPath(ResponseBody);
		String ResponseParameter=XmlResponse.getString("NumberToWordsResult");
		System.out.println(ResponseParameter);
		
       Assert.assertEquals(ResponseParameter,"one hundred ");
		
	}

}
