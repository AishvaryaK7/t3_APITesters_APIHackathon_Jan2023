
@tag
Feature: Validate Get Request

  @tag1
  Scenario: To Get All Programs
    Given User with URL (AllPrograms)
    When Get Request is made
    Then Status Code should be 200 and validate Content type, Headers,Program Name.

  @tag2
  Scenario Outline: To Get Program By ID
    Given User with URL (Get Program By Id)
    When Get Request is made with Program Id <programId>
    Then Status Code should be 200
		
@tag3
  Scenario Outline: To Get Program By ID
  	Given User with URL (Get Program By Invalid Id)
    When Get Request is made with Invalid Program Id "<ivprogramId>"
    Then Status code should be 400 user receives an error message

  Examples:
  |programId|ivprogramId|
  |966|1|
  
   