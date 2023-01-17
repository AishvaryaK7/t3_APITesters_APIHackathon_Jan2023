package stepDefinitions_Batch_Module;

import static io.restassured.RestAssured.given;

import org.asynchttpclient.Request;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class batch_DeleteRequest
{
	String baseURL = "https://lms-backend-service.herokuapp.com/lms/";
	Request req;
	Response response;
	RequestSpecification reqSpec;
	RequestSpecification res;
	RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();

	@Given("User with URL \\(Delete Batch by Batch Id)")
	public void user_with_url_delete_batch_by_batch_id() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("DELETE request is sent with valid Batch Id <batchId>")
	public void delete_request_is_sent_with_valid_batch_id_batch_id() 
	{
		response= res.when().get("/batches/"+851);
	}

	@Then("User should receive {int} OK status code for Batch deletion")
	public void user_should_receive_ok_status_code_for_Batch_deletion(Integer int1) 
	{
		response.then().assertThat().statusCode(int1).log().all();
	}

	@Given("User with URL \\(Delete Batch by Invalid Batch Id)")
	public void user_with_url_delete_batch_by_invalid_batch_id()
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("DELETE request is sent with Invalid Batch Id {string}")
	public void delete_request_is_sent_with_invalid_batch_id(String invbatchId) 
	{
		response= res.when().get("/batches/"+invbatchId);
	}

	@Then("User should receive Status Code {int} Bad Request with errorMessage")
	public void user_should_receive_status_code_bad_request_with_error_message(Integer int1)
	{
		response.then().assertThat().statusCode(int1).log().all();
	}

}
