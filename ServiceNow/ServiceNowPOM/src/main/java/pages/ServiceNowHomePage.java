package pages;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.Then;

public class ServiceNowHomePage extends ProjectSpecificMethods {
	@Then("Enter the Search text")
	public ServiceNowHomePage enterSearchText() throws InterruptedException {
		getDriver().findElementById("filter").sendKeys("incident");

		Thread.sleep(5000);

		return this;

	}
	
	@Then("Click On All Incidents")
	public AllIncidentHomePage clickOnAllIncident() {
		getDriver().findElementByXPath("(//div[text()='All'])[2]").click();

		return new AllIncidentHomePage();

	}
}
