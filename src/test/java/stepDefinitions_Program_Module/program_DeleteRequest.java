package stepDefinitions_Program_Module;

import static io.restassured.RestAssured.given;

import org.asynchttpclient.Request;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class program_DeleteRequest 
{
	String baseURL = "https://lms-backend-service.herokuapp.com/lms/";
	Request req;
	Response response;
	RequestSpecification reqSpec;
	RequestSpecification res;
	RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
	
	
	@Given("User with URL \\(Delete By ProgramID)")
	public void user_with_url_delete_by_program_id()
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("Delete Request is made with {string}")
	public void delete_request_is_made_with(String programId) 
	{
		response= res.when().get("/deletebyprogid/"+programId);
	}

	@Then("Status code should be {int} AND user receives a success message")
	public void status_code_should_be_and_user_receives_a_success_message(Integer int1) 
	{
		response.then().assertThat().statusCode(int1).log().all();
	}

	@Given("User with URL \\(Delete By Invalid ProgramID)")
	public void user_with_url_delete_by_invalid_program_id() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("Delete Request is made with {string} which is already deleted")
	public void delete_request_is_made_with_which_is_already_deleted(String programId)
	{
		response= res.when().get("/deletebyprogid/"+programId);
	}

	@Then("Status code should be {int} AND user receives an error message")
	public void status_code_should_be_and_user_receives_an_error_message_as(Integer int1)
	{
		response.then().assertThat().statusCode(int1).log().all();
	}

	@Given("User with URL \\(Delete By ProgramName)")
	public void user_with_url_delete_by_program_name() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("Delete Request is made with Program Name")
	public void request_is_made_with_program_name() 
	{
		response= res.when().get("/deletebyprogname/Jan23-Ninja Survivors-SDET-001");
	}
	
	@Then("Status code should be {int} AND user receives a success message ProgramName deleted Successfully!")
	public void status_code_should_be_and_user_receives_a_success_message_program_name_deleted_successfully(Integer int1)
	{
		response.then().assertThat().statusCode(int1).log().all();
	}

	@Given("User with URL \\(Delete By Invalid ProgramName)")
	public void user_with_url_delete_by_invalid_program_name() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("Delete Request is made with Invalid {string}")
	public void delete_request_is_made_with_invalid_program_name(String programName) 
	{
		response= res.when().get("/deletebyprogname/"+programName);
	}

	@Then("Status code should be {int} AND user receives a error message for Program Name")
	public void status_code_should_be_and_user_receives_a_error_message_for_program_name(Integer int1) 
	{
		response.then().assertThat().statusCode(int1).log().all();
	}


}
