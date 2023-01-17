Feature: I am testing post request for LMS
Scenario: Post request to create a record in the LMS DB
    Given LMS website is up and running
    And Set header and body to create new user
   When  Hit the api with post request and end point as "/allprograms"
    Then API returned the error code as 201 and API created a new USER in the system
Scenario: Post request to validate error message when no body is sent
    Given LMS website is up and running
    And  set header and but without any body
    When Hit the api with post request and end point as "/allprograms"
    Then API returned the status code as 415
#  And  message displayed as "Unsupported Media Type