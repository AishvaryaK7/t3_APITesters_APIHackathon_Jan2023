package stepDefinitions_Program_Module;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Excelutils;
public class program_PostRequest {
	protected static RequestSpecification req_spec = null;
	protected static Response resp;
	@Given("LMS website is up and running")
	public void lms_website_is_up_and_running() {
		req_spec = given().baseUri("https://lms-backend-service.herokuapp.com/lms/");
	}
	@Given("Set header and body to create new user")
	public void set_header_and_body_to_create_new_user() {
		HashMap<String, String> hm_header = new HashMap<String, String>();
		hm_header.put("Content-Type", "application/json");
		HashMap<String, Object> post_body = new HashMap<String, Object>();
		String Excelpath = "./ExcelData/TestData.xlsx";
		String Sheetname = "Sheet2";
		Excelutils excel = new Excelutils(Excelpath, Sheetname);
		excel.getCellData(0, 2);
		excel.getrowcount();
		
		post_body.put("programName", excel.getCellData(1, 0));
		post_body.put("programDescription", excel.getCellData(1, 1));
		post_body.put("programStatus", excel.getCellData(1, 2));

	}
	@When("Hit the api with post request and end point as {string}")
	public void hit_the_api_with_post_request_and_end_point_as(String endpoint) {
		resp = req_spec.when().post(endpoint);
	}
	@Then("API returned the error code as {int} and API created a new USER in the system")
	public void api_returned_the_error_code_as_and_api_created_a_new_user_in_the_system(Integer int1) {
		req_spec.then().body("Status code", equalTo(201));
	}
	@Given("set header and but without any body")
	public void set_header_and_but_without_any_body() {
		HashMap<String, String> hm_header = new HashMap<String, String>();
		hm_header.put("Content-Type", "application/json");
		req_spec.headers(hm_header);
	}
	@Then("API returned the status code as {int}")
	public void api_returned_the_status_code_as(Integer int1) {
		req_spec.then().body("Status code", equalTo(415));
	}
	@Then("message displayed as {string}")
	public void message_displayed_as(String string) {
		String body_as_string = resp.asString();
		System.out.println(body_as_string);
	}
}
