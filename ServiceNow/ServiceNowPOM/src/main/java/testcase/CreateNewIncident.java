package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;
import pages.LoginPage;

@CucumberOptions(features = "src/main/java/features", glue = "pages", monochrome = true, publish=true)
public class CreateNewIncident extends ProjectSpecificMethods {

	@BeforeTest
	public void setFilename() {
		excelFilename = "CreateNewIncident";

	}

	/*
	 * @Test(dataProvider = "fetchData", priority = 0) public void
	 * createNewIncident(String caller, String desc) throws InterruptedException,
	 * IOException { new
	 * LoginPage().enterUsername("admin").enterPassword("qjX0QPUtYvb6").
	 * clickOnLoginButton().enterSearchText()
	 * .clickOnAllIncident().switchToframe().clickOnNewButton().getNewIncidentNumber
	 * ().selectCaller(caller)
	 * .enterShotDesc(desc).clickOnSubmitButton().selectSearchField().
	 * enterSearchValueAfterCreate() .clickOnIncident(); }
	 */
}
