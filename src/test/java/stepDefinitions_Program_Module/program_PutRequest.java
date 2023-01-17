package stepDefinitions_Program_Module;

import static io.restassured.RestAssured.given;
	import java.time.Instant;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import org.json.simple.JSONObject;
	//import org.json.JSONObject;
	import org.junit.runner.Request;
	import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
	import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.restassured.builder.RequestSpecBuilder;
	import io.restassured.response.Response;
	import io.restassured.response.ValidatableResponse;
	import io.restassured.specification.RequestSpecification;
	public class program_PutRequest {
		String baseURL = "https://lms-backend-service.herokuapp.com/lms/";
		Request req;
		Response response;
		RequestSpecification reqSpec;
		RequestSpecification res;
		RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
		@Given("User with URL \\(Update By Program Id)")
		public void user_with_url_update_by_program_id() {
			reqSpecBuilder.setBaseUri(baseURL).setAccept("application/json").setContentType("application/json");
			reqSpec = reqSpecBuilder.build();
			res = given().spec(reqSpec);
		}
		@When("PUT request made with Request body {string},{string},{string},{string}")
		public void put_request_made_with_request_body(String programId, String programName, String programDescription,
				String programStatus) {
			HashMap<String, Object> update_body = new HashMap<String, Object>();
			Instant instant = Instant.now();
			update_body.put("programId", programId);
			update_body.put("programName", programName);
			update_body.put("programDescription", programDescription);
			update_body.put("programStatus", programStatus);
			update_body.put("creationTime", "2023-01-16T18:48:55.933+00:00");
			update_body.put("lastModTime", instant.toString());
			response = res.when().body(JSONObject.toJSONString(update_body)).put("putprogram/" + programId);
		}
		@Then("User should receive {int} OK status code")
		public void user_should_receive_ok_status_code(Integer int1) {
			response.then().assertThat().statusCode(int1).log().all();
		}

}
