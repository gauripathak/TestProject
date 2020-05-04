import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {

	@Test
	void test_01 () {
	 
	Response response =	RestAssured.get("https://jsonplaceholder.typicode.com/users");
		

	System.out.println("string is :--"+(response.asString() +"string ends here"));
	System.out.println("Body is "+response.getBody().asString());
	System.out.println("Ststus code is :--"+response.getStatusCode());
	System.out.println("Content Type is :--"+response.contentType());
	System.out.println("Status Line is  :-"+ response.getStatusLine());
	System.out.println("Header is: "+response.getHeader("content-type"));
	
	/*verification using asserts*/
	
	int statuscode = response.getStatusCode();
	Assert.assertEquals(statuscode, 200);
	
	}
	
	@Test
	void test_02 () {
		
		/* using static imports so that you can use given-when-then statements*/
		
    given()
    	.get("https://jsonplaceholder.typicode.com/users")
    .then()
    	.statusCode(200)
    	.body("id[0]",equalTo(1))
    	.body("address.street[0]", equalTo("Kulas Light"));
		
	}
}
