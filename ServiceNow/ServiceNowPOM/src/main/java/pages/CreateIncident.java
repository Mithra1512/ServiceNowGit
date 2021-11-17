package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.Then;

public class CreateIncident extends ProjectSpecificMethods {
	
	@Then("Select the caller name as {string}")
	public CreateIncident selectCaller(String caller) throws InterruptedException {
		getDriver().findElementById("lookup.incident.caller_id").click();

		Set<String> windowHandles = getDriver().getWindowHandles();

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);

		getDriver().switchTo().window(windowHandlesList.get(1));
		
		Thread.sleep(2000);

		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys(caller);

		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);

		getDriver().findElementByXPath("//a[text()='" + caller + "']").click();

		getDriver().switchTo().window(windowHandlesList.get(0));

		return this;

	}

	@Then("Enter the short description {string}")
	public CreateIncident enterShotDesc(String desc) {
		getDriver().switchTo().frame("gsft_main");

		getDriver().findElementById("incident.short_description").sendKeys(desc);

		return this;

	}
	
	@Then("Get the new incident number")
	public CreateIncident getNewIncidentNumber() throws IOException {

		incidentNo = getDriver().findElementById("incident.number").getAttribute("value");

		listOfIncident.add(incidentNo);

		return this;
	}

	@Then("Click on Submit button")
	public AllIncidentHomePage clickOnSubmitButton() {
		getDriver().findElementById("sysverb_insert_bottom").click();

		return new AllIncidentHomePage();

	}
}
