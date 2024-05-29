Feature: Validating Restfull Booker

Scenario Outline: Verify if Booking is being Succesfully created using CreateBookingAPI
	Given Creates a new auth token to use for access "<username>"  "<password>"
	When user calls the "AddAuthAPI" with "POST" http request
	Then the API call got succeded with status code 200
	#And "status" in the response body is "OK"
	


	

	
Examples:
	|username|password |
	|admin |password123 |
	
	
Scenario: Verify if Get Booker ID functionality is working
Given Creates a new auth token to uses for access "<username>"  "<password>"
When user call "getBookerAPI" with "GET" http request
Then the API call got succes with status code 200



Scenario Outline: Verify if Booking is being Succesfully created using CreateBooking
	Given Creates a new booking ID of user with details "<firstname>"  "<lastname>" "<additionalneeds>"  "<depositpaid>"
	When user exclaim the "AddBookerAPI" with "POST" http request
#		Then the API call got succe with status code 200

	
		
Examples:
	|firstname|lastname |additionalneeds | depositpaid|
	|Jim |Brown |Breakfast| true|

	
