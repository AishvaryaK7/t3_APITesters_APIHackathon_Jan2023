Feature: I am testing post request for LMS
Scenario: Post request to create a record in the LMS DB
    Given LMS is up and running
    And I set header and body to create new record
    When I hit the api with post request and end point as "/batches"
    Then API returned the error code as 201 and API created a new record in the system
Scenario: Post request to validate error message when no body is sent
    Given LMS is up and running
    And I set header and but with out any body
    When I hit the api with post request and end point as "/batches"
    Then API returned the error code as 415
  And error message displayed as "Unsupported Media Type"