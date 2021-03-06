package base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllIncidentHomePage;
import utils.ReadFromExcel;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests {

	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();
//	public ChromeDriver driver;
	public static String incidentNo;
	public static String browser = "chrome";
	public String excelFilename;
	public static ReadFromExcel excelData;
	public String testName, testDescription, testAuthor, testCategory;
	public static ArrayList<String> listOfIncident = new ArrayList<String>();
	public static ArrayList<String> readIncidentNumber;

	public void setDriver() {
		remoteWebDriver.set(new ChromeDriver());
	}

	public RemoteWebDriver getDriver() {
		return remoteWebDriver.get();
	}

	@BeforeSuite
	public void getIncidentNoFromExcel() throws IOException {
		ReadFromExcel readIncident = new ReadFromExcel();

		readIncidentNumber = readIncident.readIncidentNumber();

	}

//	@Parameters({"browser","URL"})
	@BeforeMethod
	public void launchApp() throws IOException {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			setDriver();
//			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			setDriver();
//			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			setDriver();
//			driver = new InternetExplorerDriver();
		}

		getDriver().get("https://dev100062.service-now.com/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {

		excelData = new ReadFromExcel();
		String[][] readExcelObj = excelData.readExcel(excelFilename);

		return readExcelObj;

	}

	@AfterMethod
	public void closeApp() {

		getDriver().close();

	}

//	@AfterClass
	public void writeToexcel() throws IOException {

		excelData = new ReadFromExcel();
		excelData.writeToExcel(listOfIncident);

	}

}
