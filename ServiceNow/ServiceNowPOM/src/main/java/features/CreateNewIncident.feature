Feature: ServiceNow
@CreateIncident
Scenario Outline: To Create a new incident in serviceNow 
	Given Enter the username as 'admin' 
	Then Enter the password as 'qjX0QPUtYvb6' 
	Then Click on Login Button 
	Then Enter the Search text 
	Then Click On All Incidents 
	Then Switch to frame 
	Then Click on New Button 
	Then Get the new incident number 
	Then Select the caller name as '<callerName>' 
	Then Enter the short description '<description>' 
	Then Click on Submit button 
	Then Select the search field 
	Then Enter the search value after create 
	Then Click on Incident 
	
	Examples: 
		|callerName		|description	|
		|Justina Dragaj	|Ticket Number 1|
		|Mari Hwang		|Ticket Number 2|
