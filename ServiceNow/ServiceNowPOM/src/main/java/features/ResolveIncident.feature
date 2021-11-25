Feature: ServiceNow 
@ResolveIncident
Scenario Outline: To resolve a incident in serviceNow 
	Given Enter the username as 'admin' 
	Then Enter the password as 'qjX0QPUtYvb6' 
	Then Click on Login Button 
	Then Enter the Search text 
	Then Click On All Incidents 
	Then Switch to frame 
	Then Select the search field 
	Then Select the Incident number <incidentNumIndex> 
	Then Update the the state as 'Resolved' 
	Then Update the resolution info
	Then Click on update
	Then Select the search field
	Then Select the Incident number <incidentNumIndex>
	Then Verify the resolution code
	
	Examples: 
		|incidentNumIndex	|
		|0					|
		|1					|
