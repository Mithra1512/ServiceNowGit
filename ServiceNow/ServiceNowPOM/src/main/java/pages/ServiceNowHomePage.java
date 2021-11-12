package pages;

import base.ProjectSpecificMethods;

public class ServiceNowHomePage extends ProjectSpecificMethods {
	public ServiceNowHomePage enterSearchText() throws InterruptedException {
		driver.findElementById("filter").sendKeys("incident");

		Thread.sleep(5000);

		return this;

	}

	public AllIncidentHomePage clickOnAllIncident() {
		driver.findElementByXPath("(//div[text()='All'])[2]").click();

		return new AllIncidentHomePage();

	}
}
