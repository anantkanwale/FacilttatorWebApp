package Shyena.FacilitatorWebApplication;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static  WebDriver driver;
	
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	
	@BeforeTest
  public void beforeTest() {
		extendReport();
	 System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		 driver = new ChromeDriver();
		
		 driver.get("http://facilitator.dev.mcc.kpnappfactory.nl/");
			
			driver.manage().window().maximize();
			//return driver;
	  
      
  
  }
  public static void extendReport()
	{
		
		//report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		//test = report.startTest("ExtentDemo");
		 htmlReporter = new ExtentHtmlReporter("facilitatorWebApplication.html");
	//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"facilitatorWebApplication.html");
		htmlReporter.setAppendExisting(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		
		
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		test = extent.createTest("Selenium Test");

		test.info("Autmation started");
		//return test;
	}

 @AfterTest
  public void afterTest() {
	 // driver.quit();
	 
	 extent.flush();
  }

}