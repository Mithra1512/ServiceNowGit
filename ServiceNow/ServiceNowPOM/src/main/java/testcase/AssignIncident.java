package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class AssignIncident extends ProjectSpecificMethods {

	@BeforeTest
	public void setFilename() {
		excelFilename = "IncidentManagement";

	}

	@Test(dataProvider = "fetchData", priority = 2)
	public void updateIncident(String incidentNumber) throws InterruptedException, IOException {
		new LoginPage().enterUsername("admin").enterPassword("qjX0QPUtYvb6").clickOnLoginButton().enterSearchText()
				.clickOnAllIncident().switchToframe().selectSearchField().searchIncident(incidentNumber).selectAssignmentGroup().updateWorkNotes().clickOnUpdate();
		
		//Comment 17
	}

}
