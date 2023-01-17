@tag
Feature: Validate PUT Request
  @tag1
  Scenario Outline: To Update data By Program Id
    Given User with URL (Update By Program Id)
    When  PUT request made with Request body "<programId>","<programName>","<programDescription>","<programStatus>"
    Then User should receive 200 OK status code
    Examples:
   |programId|programName                     |programDescription|programStatus|
   |966      |Jan23-API Testers-Salesforce-035|SDET              |Active       |