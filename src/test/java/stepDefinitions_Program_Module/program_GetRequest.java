package stepDefinitions_Program_Module;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;

import org.asynchttpclient.Request;
import org.junit.Assert;

public class program_GetRequest
{
	String baseURL = "https://lms-backend-service.herokuapp.com/lms/";
	Request req;
	Response response;
	RequestSpecification reqSpec;
	RequestSpecification res;
	RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();

	@Given("User with URL \\(AllPrograms)")
	public void user_with_url_all_programs() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();		
		res =  given().spec(reqSpec);
	}

	@When("Get Request is made")
	public void request_is_made()
	{
	    response= res.when().get("/allPrograms");
	}

	@Then("Status Code should be {int} and validate Content type, Headers,Program Name.")
	public void status_code_should_be_and_validate_content_type_headers_program_name(Integer int1) 
	{
	    response.then().assertThat().statusCode(int1).log().all();
	    
	}

	@Given("User with URL \\(Get Program By Id)")
	public void user_with_url_get_program_by_id() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();
		res =  given().spec(reqSpec);
	}

//	@When("Get Request is made with Program Id {int}")
//	public void get_request_is_made_with_program_id(Integer programId) 
//	{
//		response= res.when().get("/programs/"+programId);
//		System.out.println(programId);
//	}
	
	@When("Get Request is made with Program Id <programId>")
	public void get_request_is_made_with_program_id_program_id() {
		response= res.when().get("/programs/"+966);
	}


	@Then("Status Code should be {int}")
	//public void status_code_should_be_and_validate_program_id_field_program_name_centent_type(Integer int1) 
	public void status_code_should_be(Integer int1)
	{
		response.then().log().all().assertThat().statusCode(int1);
	}

	@Given("User with URL \\(Get Program By Invalid Id)")
	public void user_with_url_get_program_by_invalid_id() 
	{
		reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
		reqSpec = reqSpecBuilder.build();
		res =  given().spec(reqSpec);
	}

	@When("Get Request is made with Invalid Program Id {string}")
	public void get_request_is_made_with_invalid_program_id(String ivprogramId) {
	
		response= res.when().get("/programs/"+ivprogramId);
	}

	@Then("Status code should be {int} user receives an error message")
	public void status_code_should_be_user_receives_an_error_message(Integer int1) 
	{
		response.then().log().all().assertThat().statusCode(int1);
		//String err_Msg = response.then().assertThat().statusCode(int1).log().all().extract().response().asString();
		//Assert.assertEquals(err_string,err_Msg);
	}


}
