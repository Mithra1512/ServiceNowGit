package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.Then;

public class AllIncidentHomePage extends ProjectSpecificMethods {
	
	@Then("Switch to frame")
	public AllIncidentHomePage switchToframe() {
		getDriver().switchTo().frame("gsft_main");

		return this;

	}

	@Then("Click on New Button")
	public CreateIncident clickOnNewButton() {

		getDriver().findElementById("sysverb_new").click();

		return new CreateIncident();

	}

	@Then("Select the search field")
	public AllIncidentHomePage selectSearchField() {
		try {
			WebElement dropdown = getDriver().findElementByXPath("//select[@class='form-control default-focus-outline']");

			Select searchDropdown = new Select(dropdown);

			searchDropdown.selectByVisibleText("Number");

		} catch (Exception e) {
			WebElement dropdown = getDriver().findElementByXPath("//select[@class='form-control default-focus-outline']");

			Select searchDropdown = new Select(dropdown);

			searchDropdown.selectByVisibleText("Number");

		}

		return this;

	}

	@Then("Enter the search value after create")
	public AllIncidentHomePage enterSearchValueAfterCreate() {
		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentNo);

		System.out.println(incidentNo);

		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);

		return this;

	}

	public IncidentDetailsPage searchIncident(String incidentNumber) {

		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentNumber);

		getDriver().findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);
		try {
			getDriver().findElementByXPath("//a[text() = '" + incidentNumber + "']").click();
		} catch (Exception e) {
			if (getDriver().findElementByXPath("//td[text()='No records to display']").isDisplayed()) {
				System.out.println("Incident is not available");
			}
		}

		return new IncidentDetailsPage();

	}
	
	@Then("Click on Incident")
	public IncidentDetailsPage clickOnIncident() {
		getDriver().findElementByXPath("//a[text() = '" + incidentNo + "']").click();

		return new IncidentDetailsPage();

	}

}
