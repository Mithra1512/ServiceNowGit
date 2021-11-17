package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class IncidentDetailsPage extends ProjectSpecificMethods {

	public IncidentDetailsPage updateUrgency() {
		Select urgencyDropdown = new Select(getDriver().findElementByName("incident.urgency"));

		urgencyDropdown.selectByVisibleText("1 - High");

		return this;

	}

	public IncidentDetailsPage updateState(String state) {
		Select stateDropdown = new Select(getDriver().findElementByName("incident.state"));

		stateDropdown.selectByVisibleText(state);

		return this;

	}

	public IncidentDetailsPage checkPriority() {
		Select priorityDropdown = new Select(getDriver().findElementByName("incident.priority"));

		String priority = priorityDropdown.getFirstSelectedOption().getText();

		if (priority.contentEquals("3 - Moderate")) {
			System.out.println("Priority has changed");
		}

		return this;
	}

	public AllIncidentHomePage clickOnUpdate() {
		getDriver().findElementById("sysverb_update").click();

		return new AllIncidentHomePage();

	}

	public IncidentDetailsPage checkStateAndUregency() {
		Select urgencyDropdown1 = new Select(getDriver().findElementByName("incident.urgency"));

		String updatedUrgency = urgencyDropdown1.getFirstSelectedOption().getText();

		Select stateDropdown1 = new Select(getDriver().findElementByName("incident.state"));

		String updatedState = stateDropdown1.getFirstSelectedOption().getText();

		if (updatedUrgency.contains("High")) {
			System.out.println("Urgency is updated");
		}

		if (updatedState.contains("Progress"))

		{
			System.out.println("State is updated");
		}
		return this;

	}

	public IncidentDetailsPage selectAssignmentGroup() {
		getDriver().findElementById("lookup.incident.assignment_group").click();

		Set<String> windowHandles = getDriver().getWindowHandles();

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);

		getDriver().switchTo().window(windowHandlesList.get(1));

		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys("Software");

		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);

		getDriver().findElementByXPath("//a[text()='Software']").click();

		getDriver().switchTo().window(windowHandlesList.get(0));

		getDriver().switchTo().frame("gsft_main");

		return this;

	}

	public IncidentDetailsPage updateWorkNotes() {
		getDriver().findElementById("activity-stream-textarea").sendKeys("Assigned ticket to Software group");
		return this;
	}

	public IncidentDetailsPage updateResolutionInfo() {

		getDriver().findElementByXPath("//span[text()='Resolution Information']").click();

		Select resolutionCode = new Select(getDriver().findElementById("incident.close_code"));

		resolutionCode.selectByVisibleText("Solved (Work Around)");

		getDriver().findElementById("incident.close_notes").sendKeys("Ticket resolved");

		return this;
	}

	public IncidentDetailsPage verifyResolutionCode() {
		Select updResolutionCode = new Select(getDriver().findElementByName("incident.state"));

		System.out.println(updResolutionCode.getFirstSelectedOption().getText());

		return this;

	}

	public AllIncidentHomePage deleteIncident() {

		getDriver().findElementById("sysverb_delete").click();

		getDriver().findElementById("ok_button").click();

		return new AllIncidentHomePage();

	}

}
