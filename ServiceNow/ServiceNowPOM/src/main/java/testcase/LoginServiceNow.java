package testcase;

import org.testng.annotations.BeforeTest;

import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features", glue = "pages", monochrome = true, dryRun = true)
public class LoginServiceNow extends ProjectSpecificMethods {

}
