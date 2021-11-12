package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;

import base.ProjectSpecificMethods;

public class CreateIncident extends ProjectSpecificMethods {

	public CreateIncident selectCaller(String caller) throws InterruptedException {
		driver.findElementById("lookup.incident.caller_id").click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windowHandlesList.get(1));
		
		Thread.sleep(2000);

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(caller);

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);

		driver.findElementByXPath("//a[text()='" + caller + "']").click();

		driver.switchTo().window(windowHandlesList.get(0));

		return this;

	}

	public CreateIncident enterShotDesc(String desc) {
		driver.switchTo().frame("gsft_main");

		driver.findElementById("incident.short_description").sendKeys(desc);

		return this;

	}

	public CreateIncident getNewIncidentNumber() throws IOException {

		incidentNo = driver.findElementById("incident.number").getAttribute("value");

		listOfIncident.add(incidentNo);

		return this;
	}

	public AllIncidentHomePage clickOnSubmitButton() {
		driver.findElementById("sysverb_insert_bottom").click();

		return new AllIncidentHomePage();

	}
}
