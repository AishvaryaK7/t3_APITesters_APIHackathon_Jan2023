	package stepDefinitions_Batch_Module;
	import static io.restassured.RestAssured.given;
	import static org.hamcrest.Matchers.equalTo;
	import java.util.HashMap;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	import utils.Excelutils;
	public class batch_PostRequest {
		protected static RequestSpecification req_spec = null;
		protected static Response resp;
		int id;
		@Given("LMS is up and running")
		public void lms_is_up_and_running() {
			req_spec = given().baseUri("https://lms-backend-service.herokuapp.com/lms/");
		}
		@Given("I set header and body to create new record")
		public void i_set_header_and_body_to_create_new_record() {
			HashMap<String, String> hm_header = new HashMap<String, String>();
			hm_header.put("Content-Type", "application/json");
			HashMap<String, Object> post_body = new HashMap<String, Object>();
			String Excelpath = "./ExcelData/TestData.xlsx";
			String Sheetname = "Sheet1";
			Excelutils excel = new Excelutils(Excelpath, Sheetname);
			excel.getCellData(0, 2);
			excel.getrowcount();
			post_body.put("batchId", excel.getCellData(2, 0));
			post_body.put("batchName", excel.getCellData(2, 1));
			post_body.put("batchDescription", excel.getCellData(2, 2));
			post_body.put("batchStatus", excel.getCellData(2, 3));
			post_body.put("batchNoOfClasses", excel.getCellData(2, 4));
			post_body.put("programId", excel.getCellData(2, 5));
			post_body.put("programName", excel.getCellData(1, 6));
		}
		@When("I hit the api with post request and end point as {string}")
		public void i_hit_the_api_with_post_request_and_end_point_as(String endpoint) {
			resp = req_spec.when().post(endpoint);
		}
		@Then("API returned the error code as {int} and API created a new record in the system")
		public void api_returned_the_error_code_as_and_api_created_a_new_record_in_the_system(Integer int1) {
			req_spec.then().body("Status code", equalTo(201));
			// id = resp.extract().path("batchId"); // this is to save the id created by
			// post batch request
		}
		@Given("I set header and but with out any body")
		public void i_set_header_and_but_with_out_any_body() {
			HashMap<String, String> hm_header = new HashMap<String, String>();
			hm_header.put("Content-Type", "application/json");
			req_spec.headers(hm_header);
		}
		@Then("API returned the error code as {int}")
		public void api_returned_the_error_code_as(Integer int1) {
			req_spec.then().body("Status code", equalTo(415));
		}
		@Then("error message displayed as {string}")
		public void error_message_displayed_as(String msg) {
			String body_as_string = resp.asString();
			System.out.println(body_as_string);
			// Assert.assertEquals("no content", body_as_string);
		}
	

}
