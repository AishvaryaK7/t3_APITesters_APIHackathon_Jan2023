
@tag
Feature: Validate Get Request

  @tag1
  Scenario: To Get All Programs
    Given User with URL  " {{baseurl}}/allPrograms" (AllPrograms)
    When "Get" Request is made
    Then Status Code should be 200 and validate Content type, Headers,Program Name.

  @tag2
  Scenario Outline: To Get Program By ID
    Given User with URL " {{baseurl}}/programs/programId" (Get Program By Id)
    When "Get" Request is made with  Program Id
    Then Status Code should be 200 and validate Program Id field, Program Name, Centent type.

@tag2
  Scenario Outline: To Get Program By ID
    Given User with URL " {{baseurl}}/programs/programId" (Get Program By Invalid Id)
    When "Get" Request is made with Invalid Program Id
    Then Status code should be 400 AND user receives an error message as "no record found with programId"

   