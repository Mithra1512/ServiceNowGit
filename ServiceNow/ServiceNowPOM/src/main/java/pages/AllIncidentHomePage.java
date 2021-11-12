package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class AllIncidentHomePage extends ProjectSpecificMethods {

	public AllIncidentHomePage switchToframe() {
		driver.switchTo().frame("gsft_main");

		return this;

	}

	public CreateIncident clickOnNewButton() {

		driver.findElementById("sysverb_new").click();

		return new CreateIncident();

	}

	public AllIncidentHomePage selectSearchField() {
		try {
			WebElement dropdown = driver.findElementByXPath("//select[@class='form-control default-focus-outline']");

			Select searchDropdown = new Select(dropdown);

			searchDropdown.selectByVisibleText("Number");

		} catch (Exception e) {
			WebElement dropdown = driver.findElementByXPath("//select[@class='form-control default-focus-outline']");

			Select searchDropdown = new Select(dropdown);

			searchDropdown.selectByVisibleText("Number");

		}

		return this;

	}

	public AllIncidentHomePage enterSearchValueAfterCreate() {
		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentNo);

		System.out.println(incidentNo);

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);

		return this;

	}

	public IncidentDetailsPage searchIncident(String incidentNumber) {

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentNumber);

		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);
		try {
			driver.findElementByXPath("//a[text() = '" + incidentNumber + "']").click();
		} catch (Exception e) {
			if (driver.findElementByXPath("//td[text()='No records to display']").isDisplayed()) {
				System.out.println("Incident is not available");
			}
		}

		return new IncidentDetailsPage();

	}

	public IncidentDetailsPage clickOnIncident() {
		driver.findElementByXPath("//a[text() = '" + incidentNo + "']").click();

		return new IncidentDetailsPage();

	}

}
