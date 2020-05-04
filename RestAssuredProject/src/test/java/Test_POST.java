import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Test_POST {

    //@Test
	public void Test_1_post() {
		
    	JSONObject request =new JSONObject();
    	
    	request.put("name", "Gauri");
    	request.put("job", "Teacher");
    	
//    	System.out.println(request);
    	
    	given().
    	    header("Content-Type", "application/json").
    	    contentType(ContentType.JSON).
    	    accept(ContentType.JSON).
    	    body(request.toJSONString()).
    	when().
    		post("https://reqres.in/api/users").
    	then().
    		statusCode(201).
    		log().all();
    	    
    	
	}
    
    
	public void Test_2_put() {
		
    	JSONObject request =new JSONObject();
    		request.put("name", "Gauri");
    		request.put("job", "Teacher");
    	

    	given().
    	    header("Content-Type", "application/json").
    	    contentType(ContentType.JSON).
    	    accept(ContentType.JSON).
    	    body(request.toJSONString()).
    	when().
    		put("https://reqres.in/api/users/2").
    	then().
    		statusCode(200).
    		log().all();
    	    
    	
	}
    
    @Test
	public void Test_3_delete() {
		
    	given().
    		delete("https://reqres.in/api/users/2").
    	then().
    		statusCode(204).
    		log().all();
    	    
    	
	}
}
