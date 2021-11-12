package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class IncidentDetailsPage extends ProjectSpecificMethods {

	public IncidentDetailsPage updateUrgency() {
		Select urgencyDropdown = new Select(driver.findElementByName("incident.urgency"));

		urgencyDropdown.selectByVisibleText("1 - High");

		return this;

	}

	public IncidentDetailsPage updateState(String state) {
		Select stateDropdown = new Select(driver.findElementByName("incident.state"));

		stateDropdown.selectByVisibleText(state);

		return this;

	}

	public IncidentDetailsPage checkPriority() {
		Select priorityDropdown = new Select(driver.findElementByName("incident.priority"));

		String priority = priorityDropdown.getFirstSelectedOption().getText();

		if (priority.contentEquals("3 - Moderate")) {
			System.out.println("Priority has changed");
		}

		return this;
	}

	public AllIncidentHomePage clickOnUpdate() {
		driver.findElementById("sysverb_update").click();

		return new AllIncidentHomePage();

	}

	public IncidentDetailsPage checkStateAndUregency() {
		Select urgencyDropdown1 = new Select(driver.findElementByName("incident.urgency"));

		String updatedUrgency = urgencyDropdown1.getFirstSelectedOption().getText();

		Select stateDropdown1 = new Select(driver.findElementByName("incident.state"));

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
		driver.findElementById("lookup.incident.assignment_group").click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windowHandlesList.get(1));

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys("Software");

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);

		driver.findElementByXPath("//a[text()='Software']").click();

		driver.switchTo().window(windowHandlesList.get(0));

		driver.switchTo().frame("gsft_main");

		return this;

	}

	public IncidentDetailsPage updateWorkNotes() {
		driver.findElementById("activity-stream-textarea").sendKeys("Assigned ticket to Software group");
		return this;
	}

	public IncidentDetailsPage updateResolutionInfo() {

		driver.findElementByXPath("//span[text()='Resolution Information']").click();

		Select resolutionCode = new Select(driver.findElementById("incident.close_code"));

		resolutionCode.selectByVisibleText("Solved (Work Around)");

		driver.findElementById("incident.close_notes").sendKeys("Ticket resolved");

		return this;
	}

	public IncidentDetailsPage verifyResolutionCode() {
		Select updResolutionCode = new Select(driver.findElementByName("incident.state"));

		System.out.println(updResolutionCode.getFirstSelectedOption().getText());

		return this;

	}

	public AllIncidentHomePage deleteIncident() {

		driver.findElementById("sysverb_delete").click();

		driver.findElementById("ok_button").click();

		return new AllIncidentHomePage();

	}

}
