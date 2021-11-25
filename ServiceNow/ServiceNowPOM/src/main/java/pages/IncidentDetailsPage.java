package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.Then;

public class IncidentDetailsPage extends ProjectSpecificMethods {

	@Then("Update the urgency")
	public IncidentDetailsPage updateUrgency() {
		Select urgencyDropdown = new Select(getDriver().findElementByName("incident.urgency"));

		urgencyDropdown.selectByVisibleText("1 - High");

		return this;

	}

	@Then("Update the the state as {string}")
	public IncidentDetailsPage updateState(String state) {
		Select stateDropdown = new Select(getDriver().findElementByName("incident.state"));

		stateDropdown.selectByVisibleText(state);

		return this;

	}

	@Then("Check the priority")
	public IncidentDetailsPage checkPriority() throws InterruptedException {

//		Thread.sleep(1000);

		Select priorityDropdown = new Select(getDriver().findElementByName("incident.priority"));

		String priority = priorityDropdown.getFirstSelectedOption().getText();
		System.out.println(priority);
		if (priority.contentEquals("3 - Moderate")) {
			System.out.println("Priority has changed");
		}

		return this;
	}

	@Then("Click on update")
	public AllIncidentHomePage clickOnUpdate() {
		getDriver().findElementById("sysverb_update").click();

		return new AllIncidentHomePage();

	}

	@Then("Check the updated state and urgency")
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

	@Then("Select the assignment group")
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

	@Then("Update the work notes for {string}")
	public IncidentDetailsPage updateWorkNotes(String testcase) {

		/*
		 * WebElement workNotes =
		 * getDriver().findElementById("activity-stream-textarea");
		 * 
		 * WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
		 * wait.until(ExpectedConditions.elementToBeClickable(workNotes));
		 */
		/*
		 * JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
		 * Js1.executeScript("window.scrollBy(10,1000)");
		 */
		
		switch (testcase) {
		case "Update Incident":
			getDriver().findElementById("activity-stream-textarea").sendKeys("State and Urgency updated");
			break;

		case "Assign Incident":
			getDriver().findElementById("activity-stream-textarea").sendKeys("Incident assigned to Software group");
			break;
		}

		return this;
	}

	@Then("Update the resolution info")
	public IncidentDetailsPage updateResolutionInfo() {

		getDriver().findElementByXPath("//span[text()='Resolution Information']").click();

		Select resolutionCode = new Select(getDriver().findElementById("incident.close_code"));

		resolutionCode.selectByVisibleText("Solved (Work Around)");

		getDriver().findElementById("incident.close_notes").sendKeys("Ticket resolved");

		return this;
	}

	@Then("Verify the resolution code")
	public IncidentDetailsPage verifyResolutionCode() {
		Select updResolutionCode = new Select(getDriver().findElementByName("incident.state"));

		System.out.println(updResolutionCode.getFirstSelectedOption().getText());

		return this;

	}

	@Then("Click on delete")
	public AllIncidentHomePage deleteIncident() throws IOException {

		getDriver().findElementById("sysverb_delete").click();
		
		File source = getDriver().getScreenshotAs(OutputType.FILE);
		
		File target = new File("./snapshots/deletepopup.jpeg");
		
		FileUtils.copyFile(source, target);
		

		getDriver().findElementById("ok_button").click();

		return new AllIncidentHomePage();

	}

}
