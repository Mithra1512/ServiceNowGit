package testcase;

import org.testng.annotations.DataProvider;

import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features", glue = "pages", monochrome = true, publish = true, tags = "@DeleteIncident")

public class CucumberRunner extends ProjectSpecificMethods {

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
