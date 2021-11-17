package pages;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends ProjectSpecificMethods {
	
	@Given("Enter the username as {string}")
	public LoginPage enterUsername(String username) {
		getDriver().switchTo().frame("gsft_main");

		getDriver().findElementById("user_name").sendKeys(username);

		return this;

	}
	
	@When("Enter the password as {string}")
	public LoginPage enterPassword(String password) {
		getDriver().findElementById("user_password").sendKeys(password);

		return this;

	}

	@Then("Click on Login Button")
	public ServiceNowHomePage clickOnLoginButton() throws InterruptedException {
		getDriver().findElementById("sysverb_login").click();

		Thread.sleep(5000);
		
		return new ServiceNowHomePage();

	}
}
