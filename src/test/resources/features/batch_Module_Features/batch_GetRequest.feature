@tag0
Feature: Validate Get Request

 @tag1 
  Scenario Outline: To Get all batches
  Given User with URL  "<url>" (Batches by Id)
  When Get Request is made for Batch module
  Then Status Code should be "<status>" and validate Content type, Headers,Program Name.
    
    Examples:
   | url                 | status          |
   | /batches            | 200 ok          |  
   | /batches/batchId/106| 200 ok          |
   |/batches/batchId/400| 400Bad Request   |
   |/batches/batchName/PY02| 200 ok        |
   |/batches/batchName/PY00| 400Bad Request|
   |/batches/program/221   | 200 ok        |
   |/batches/program/220   | 400Bad Request |
 