package stepDefinitions_Batch_Module;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.runner.Request;

public class batch_GetRequest 
{

		Response response;
		private final String baseURL = "https://lms-backend-service.herokuapp.com/lms";
		Request req;
		RequestSpecification reqSpec;
		RequestSpecification res;
		int validatetableResponse;
		String getid;
		private Scenario scenario;

		JsonPath json;
		RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
//
//		@Given("User with URL  {string} \\(Batches by Id)")
//		public void user_with_url_batches_by_id(String id) {
//			reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
//			reqSpec = reqSpecBuilder.build();
//			res = given().spec(reqSpec);
//			getid = id;
//
//		}
	@Given("User with URL  {string} \\(Batches by Id)")
	public void user_with_url_batches_by_id(String id) {
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();
		res = given().spec(reqSpec);
		getid = id;  
	}
	
	@When("Get Request is made for Batch module")
	public void get_request_is_made_for_Batch_module() {
		response = res.when().get(getid);

	}

	@Then("Status Code should be {string} and validate Content type, Headers,Program Name.")
	public void status_code_should_be_and_validate_content_type_headers_program_name(String string) {
		response.then().log().body();
	}


//
//		@Then("Status Code should be {string} and validate Content type, Headers,Program Name.")
//		public void status_code_should_be_and_validate_content_type_headers_program_name(String string) {
//
//			response.then().log().body();
//
//		}
}



