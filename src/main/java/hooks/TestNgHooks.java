package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import services.WebDriverServiceImpl;
import utils.DataInputProvider;
import utils.HTMLReporter;

public class TestNgHooks extends WebDriverServiceImpl{

	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		startReport();
	}

	@BeforeClass(alwaysRun=true)
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);		
	}

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws FileNotFoundException, IOException {

		startTestcase(nodes);		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		
		if(properties.getProperty("Headless").equalsIgnoreCase("true"))
			options.setHeadless(true);
		
		webdriver = new ChromeDriver(options);
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		tlDriver.set(driver);		
		getDriver().manage().window().maximize();
		//properties.load(new FileInputStream(new File("./environment.properties")));

		getDriver().get(properties.getProperty("URL"));
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

	}
	
	@BeforeMethod(alwaysRun=true)
	public void startLogin() {

		type(getDriver().findElement(By.id("username")), properties.getProperty("UserName"));
		type(getDriver().findElement(By.id("password")), properties.getProperty("Password"));
		click(getDriver().findElement(By.xpath("//button[text()='Sign In']")));
	}
	

	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		closeActiveBrowser();
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		endResult();
	}

	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	

	

}
