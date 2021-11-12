package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class UpdateIncident extends ProjectSpecificMethods {

	@BeforeTest
	public void setFilename() {
		excelFilename = "IncidentManagement";

	}

	@Test(dataProvider = "fetchData", priority = 1)
	public void updateIncident(String incidentNumber) throws InterruptedException, IOException {
		new LoginPage().enterUsername("admin").enterPassword("qjX0QPUtYvb6").clickOnLoginButton().enterSearchText()
				.clickOnAllIncident().switchToframe().selectSearchField().searchIncident(incidentNumber).updateUrgency().updateState("In Progress").checkPriority().clickOnUpdate().searchIncident(incidentNumber).checkStateAndUregency();
	}

}
