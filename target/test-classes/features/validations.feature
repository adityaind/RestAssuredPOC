#Author: aditya.automationqa@gmail.com
Feature: validating req-res api
@AddUser
Scenario: Verify if user is successfully added
	Given Add User Payload with "<name>" "<job>"
	When  "AddUserEndPoint" is called with "POST" http request
	Then  The API call is successful with status code "201" 
	And   "name" in response body is "<name>"
	And   "job" in response body is "<job>" 
	
Examples:
	|name  |job      |
	|aditya|tester   |
	|nupur |developer|
	
@GetAddedUser
Scenario: Verify if the added user is successfully retrieved
	Given user id of user
	When "GetSingleUserEndpoint" is called with "GET" http request
 #using 404 response since the mock api does not persist the values
	Then The API call is successful with status code "404"
