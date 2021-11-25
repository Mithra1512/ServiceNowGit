Feature: ServiceNow 
@AssignIncident
Scenario Outline: To Assign a incident in serviceNow 
	Given Enter the username as 'admin' 
	Then Enter the password as 'qjX0QPUtYvb6' 
	Then Click on Login Button 
	Then Enter the Search text 
	Then Click On All Incidents 
	Then Switch to frame
	Then Get incident number from excel
	Then Select the search field 
	Then Select the Incident number <incidentNumIndex> 
	Then Select the assignment group 
	Then Update the work notes 
	Then Click on update 
	
	Examples: 
		|incidentNumIndex	|
		|0					|
		|1					|
