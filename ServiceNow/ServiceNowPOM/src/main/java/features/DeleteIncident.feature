Feature: ServiceNow 
@DeleteIncident
Scenario Outline: To Delete a incident in serviceNow 
	Given Enter the username as 'admin' 
	Then Enter the password as 'qjX0QPUtYvb6' 
	Then Click on Login Button 
	Then Enter the Search text 
	Then Click On All Incidents 
	Then Switch to frame 
	Then Select the search field 
	Then Select the Incident number <incidentNumIndex> 
	Then Click on delete
	Then Select the search field
	Then Select the Incident number <incidentNumIndex>
	
	Examples: 
	|incidentNumIndex	|
	|0|
	|1|
