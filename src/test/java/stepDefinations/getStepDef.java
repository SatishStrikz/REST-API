package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
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
import resources.Util1;


public class getStepDef extends Util1  {
	RequestSpecification res2;
	ResponseSpecification resspec;
	Response response;
	TestData1 dat =new TestData1();
//	static String place_id;
	
	@Given("Creates a new auth token to uses for access {string}  {string}")
	public void creates_a_new_auth_token_to_uses_for_access(String username, String password)throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 res2=given().spec(request())
					.body(dat.addAuthentication(username,password));}
	@When("user call {string} with {string} http request")
	public void user_call_with_http_request(String resource, String method) {
		    // Write code here that turns the phrase above into concrete actions
	//constructor will be called with value of resource which you pass
		ResouresOfAPI resourceofAPI=ResouresOfAPI.valueOf(resource);
			System.out.println(resourceofAPI.getResource());
			
			
			resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			if(method.equalsIgnoreCase("POST"))
			 response =res2.when().post(resourceofAPI.getResource());
			else if(method.equalsIgnoreCase("GET"))
			 response =res2.when().get(resourceofAPI.getResource());
		
			
	}
	@Then("the API call got succes with status code {int}")
	public void the_API_call_got_succes_with_status_code(Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
		
	
	}





}
