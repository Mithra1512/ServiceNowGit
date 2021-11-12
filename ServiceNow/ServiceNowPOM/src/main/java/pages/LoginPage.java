package pages;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage enterUsername(String username) {
		driver.switchTo().frame("gsft_main");

		driver.findElementById("user_name").sendKeys(username);

		return this;

	}

	public LoginPage enterPassword(String password) {
		driver.findElementById("user_password").sendKeys(password);

		return this;

	}

	public ServiceNowHomePage clickOnLoginButton() throws InterruptedException {
		driver.findElementById("sysverb_login").click();

		Thread.sleep(5000);
		
		return new ServiceNowHomePage();

	}
}
