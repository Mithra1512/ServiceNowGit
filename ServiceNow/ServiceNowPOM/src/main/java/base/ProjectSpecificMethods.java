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
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadFromExcel;

public class ProjectSpecificMethods {

	public static RemoteWebDriver driver;
	public static String incidentNo;
	public static String browser = "chrome";
	public String excelFilename;
	public static ReadFromExcel excelData;

	public static ArrayList<String> listOfIncident = new ArrayList<String>();

//	@Parameters({"browser","URL"})
	@BeforeMethod
	public void launchApp() {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.get("https://dev100062.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {

		excelData = new ReadFromExcel();
		String[][] readExcelObj = excelData.readExcel(excelFilename);

		return readExcelObj;

	}

	@AfterMethod
	public void closeApp() {

		driver.close();

	}

	@AfterClass
	public void writeToexcel() throws IOException {

		excelData = new ReadFromExcel();
		excelData.writeToExcel(listOfIncident);

	}

}
