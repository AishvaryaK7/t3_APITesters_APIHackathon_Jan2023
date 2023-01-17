@tag
Feature: Validate Delete Request

  @tag1
  Scenario: To Delete by Program Id
    Given User with URL (Delete By ProgramID) 
    When Delete Request is made with "<Program Id>"
    Then Status code should be 200 AND user receives a success message

  @tag2
  Scenario Outline: To Delete by Program Id
    Given User with URL (Delete By Invalid ProgramID)
    When Delete Request is made with "<Program Id>" which is already deleted
    Then Status code should be 405 AND user receives an error message
  
  @tag3
  Scenario Outline: To Delete by Program Name
    Given User with URL (Delete By ProgramName) 
    When Delete Request is made with "<programName>"
    Then Status code should be 200 AND user receives a success message ProgramName deleted Successfully!
  
  @tag4
  Scenario Outline: To Delete by Program Name
    Given User with URL (Delete By Invalid ProgramName) 
    When Delete Request is made with Invalid "<programName>" 
    Then Status code should be 405 AND user receives a error message for Program Name
  
 Examples:
|programId|programName|
|305|Jan23-Ninja Survivors-SDET-001|