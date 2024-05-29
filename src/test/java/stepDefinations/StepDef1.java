package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ResouresOfAPI;
import resources.TestData1;
import resources.TestData2;
import resources.Util1;


public class StepDef1 extends Util1 {
	RequestSpecification res1;
	ResponseSpecification resspec;
	Response response;
	TestData1 dat =new TestData1();
	TestData2 dat1 =new TestData2();
//	static String place_id;
	@Given("Creates a new auth token to use for access {string}  {string}")
	public void creates_a_new_auth_token_to_use_for_access(String username, String password)throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 res1=given().spec(request())
					.body(dat.addAuthentication(username,password));
	}
	@When("user calls the {string} with {string} http request")
	public void user_calls_the_with_http_request(String resource, String method) {
		    // Write code here that turns the phrase above into concrete actions
	//constructor will be called with value of resource which you pass
		ResouresOfAPI resourceofAPI=ResouresOfAPI.valueOf(resource);
			System.out.println(resourceofAPI.getResource());
			
			
			resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			if(method.equalsIgnoreCase("POST"))
			 response =res1.when().post(resourceofAPI.getResource());
//			else if(method.equalsIgnoreCase("GET"))
//				 response =res.when().get(resourceAPI.getResource());
		
			
	}
	@Then("the API call got succeded with status code {int}")
	public void the_API_call_got_succeded_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
		
	
	}

	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	  
	 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Given ("Creates a new booking ID of user with details {string}  {string} {string}  {string}")
	//@Given("Creates a new auth token to use for access {string}  {string}")
	public void Creates_a_new_booking_ID_of_user_with_details(String firstname, String lastname,String additionalneeds, String depositpaid)throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 res1=given().spec(request())
					.body(dat1.addBookerLoad(firstname, lastname, additionalneeds, depositpaid));
	}
	@When("user exclaim the {string} with {string} http request")
	public void user_exclaim_the_with_http_request(String resource, String method) {
		    // Write code here that turns the phrase above into concrete actions
	//constructor will be called with value of resource which you pass
		ResouresOfAPI resourceofAPI=ResouresOfAPI.valueOf(resource);
			System.out.println(resourceofAPI.getResource());
			
			
			resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			if(method.equalsIgnoreCase("POST"))
			 response =res1.when().post(resourceofAPI.getResource());
//			else if(method.equalsIgnoreCase("GET"))
//				 response =res.when().get(resourceAPI.getResource());
		
			
	}
	@Then("the API call got succe with status code {int}")
	public void the_API_call_got_succe_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
		
	
	}

	




}
