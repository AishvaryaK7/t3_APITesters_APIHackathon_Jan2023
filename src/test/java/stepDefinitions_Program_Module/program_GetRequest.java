package stepDefinitions_Program_Module;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class program_GetRequest
{

	@Given("User with URL  {string} \\(AllPrograms)")
	public void user_with_url_all_programs(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("{string} Request is made")
	public void request_is_made(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Status Code should be {int} and validate Content type, Headers,Program Name.")
	public void status_code_should_be_and_validate_content_type_headers_program_name(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User with URL {string} \\(Get Program By Id)")
	public void user_with_url_get_program_by_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("{string} Request is made with  Program Id")
	public void request_is_made_with_program_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Status Code should be {int} and validate Program Id field, Program Name, Centent type.")
	public void status_code_should_be_and_validate_program_id_field_program_name_centent_type(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("User with URL {string} \\(Get Program By Invalid Id)")
	public void user_with_url_get_program_by_invalid_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("{string} Request is made with Invalid Program Id")
	public void request_is_made_with_invalid_program_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Status code should be {int} AND user receives an error message as {string}")
	public void status_code_should_be_and_user_receives_an_error_message_as(Integer int1, String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
