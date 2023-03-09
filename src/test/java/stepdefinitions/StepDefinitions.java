package stepdefinitions;
import classesforserializing.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.io.IOException;

import Utility.Resources;
import Utility.Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testdata.TestData;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
public class StepDefinitions extends Utility{
	RequestSpecification reqspec;	
	Response response;
	String responseString;
	JsonPath jpath;
	static String id;

	@Given("Add User Payload with {string} {string}")
	public void add_user_payload_with(String name, String job) throws IOException {
	TestData td = new TestData();
		
		reqspec=given()
				.spec(requestSpec())
				
				.body(td.AddUserpayload(name, job));
	    
	}



	
	@When("{string} is called with {string} http request")
	public void user_calls_with_post_http_request(String resourceName, String httpmethod) {
	Resources resource=Resources.valueOf(resourceName);
		if(httpmethod.equalsIgnoreCase("post")) {
			response  = reqspec.when().post(resource.getResource());
		}
		else if(httpmethod.equalsIgnoreCase("get")) {
			
				response  = reqspec.when().get(resource.getResource());
			}
		}
		

	@Then("The API call is successful with status code {string}")
	public void the_api_call_is_successful_with_status_code(String statusCode) {
		
	    assertEquals(String.valueOf(response.getStatusCode()), statusCode);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String val) {
		responseString = response.asString();
	
		jpath = new JsonPath(responseString);
		 
		id=jpath.get("id");
		assertEquals(val,jpath.get(key).toString());
	}

	

	@Given("user id of user")
	public void user_id_of_user() throws IOException {
		
	
				reqspec = given()
						.spec(requestSpec()).pathParam("usrid", id);
				
	}




}
