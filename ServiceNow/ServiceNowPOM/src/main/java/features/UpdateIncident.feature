Feature: ServiceNow 

#Background: 
#	Given Get incident number from excel 
	
@UpdateIncident 
Scenario Outline: To update a incident in serviceNow 
	Given Enter the username as 'admin' 
	Then Enter the password as 'qjX0QPUtYvb6' 
	Then Click on Login Button 
	Then Enter the Search text 
	Then Click On All Incidents 
	Then Switch to frame 
	Then Select the search field 
	Then Select the Incident number <incidentNumIndex> 
	Then Update the urgency 
	Then Update the the state as 'In Progress' 
	Then Check the priority 
	Then Update the work notes for 'Update Incident'
	Then Click on update 
	Then Select the search field 
	Then Select the Incident number <incidentNumIndex> 
	Then Check the updated state and urgency 
	
	Examples: 
		|incidentNumIndex	|
		|0					|
		|1					|
