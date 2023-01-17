
@tag
Feature: Validate DELETE Request

  @tag1
  Scenario Outline: To Delete By Batch Id
    Given User with URL (Delete Batch by Batch Id)
    When DELETE request is sent with valid Batch Id <batchId>
    Then User should receive 200 OK status code for Batch deletion

  @tag2
  Scenario Outline: To Delete By Batch Id
    Given User with URL (Delete Batch by Invalid Batch Id)
    When DELETE request is sent with Invalid Batch Id "<invbatchId>"
    Then User should receive Status Code 405 Bad Request with errorMessage

    Examples: 
      |batchId|invbatchId|
      |"851"|     5 |
