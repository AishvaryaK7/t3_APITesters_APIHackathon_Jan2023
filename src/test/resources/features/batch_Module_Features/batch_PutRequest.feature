
@tag
Feature: Validate PUT Request

  @tag1
  Scenario Outline: To Update data with Batch Id
    Given User with URL (Update Batch by Batch Id)
    When Put request is made with <batchId> and Request body is updated with <batchName>,<batchDescription>,<batchStatus>,<batchNoOfClasses>,<programName>,<programId>
    Then User should receive 200 ok status code
     
  Examples:
  |batchId|batchName|batchDescription|batchStatus|batchNoOfClasses|programName|programId|
   |1255|"Jan23-API Testers"|"Testing"|"ACTIVE"|205|"SDET"|1255|
   
   