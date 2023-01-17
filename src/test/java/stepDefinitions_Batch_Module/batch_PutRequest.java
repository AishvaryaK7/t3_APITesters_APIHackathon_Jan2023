package stepDefinitions_Batch_Module;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.asynchttpclient.Request;
import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class batch_PutRequest 
{
	String baseURL = "https://lms-backend-service.herokuapp.com/lms/";
	Request req;
	Response response;
	RequestSpecification reqSpec;
	RequestSpecification res;
	
	RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
	
	
	@Given("User with URL \\(Update Batch by Batch Id)")
	public void user_with_url_update_batch_by_batch_id() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("Put request is made with {int} and Request body is updated with {string},{string},{string},{double},{string},{int}")
	public void put_request_is_made_with_and_request_body_is_updated_with(Integer batchId, String batchName, String batchDescription, String batchStatus, Double batchNoOfClasses, String programName,Integer programId) 
	{
	    
		HashMap<String, Object> update_body = new HashMap<String, Object>();
		
		update_body.put("batchId",batchId);
		update_body.put("batchName", batchName);
		update_body.put("batchDescription",batchDescription);
		update_body.put("batchStatus", batchStatus);
		update_body.put("batchNoOfClasses", batchNoOfClasses);
		update_body.put("programId", programId);
		update_body.put("programName", programName);
			
		response= res.when().body(JSONObject.toJSONString(update_body)).put("batches/"+batchId);
	}

	@Then("User should receive {int} ok status code")
	public void user_should_receive_ok_status_code(Integer int1) 
	{
		
		response.then().assertThat().statusCode(int1).log().all();
	}

}
