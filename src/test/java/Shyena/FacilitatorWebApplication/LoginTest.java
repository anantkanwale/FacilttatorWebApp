package Shyena.FacilitatorWebApplication;

import java.io.File;
import java.io.IOException;

import javax.rmi.CORBA.UtilDelegate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pages.LoginClass;

public class LoginTest extends BaseClass{
	//public WebDriver driver;
	 
	
	UtilityClass ScreenCap = new UtilityClass();
	
	/*@BeforeClass
	public void setUp() {
	//driver=getDriver();
	driver=beforeTest();
	}*/
	
@Test()
  public void LoginTest() throws IOException {
	  
	LoginClass loginObject=new LoginClass(driver);
	  loginObject.login();
	  
	  String actualUrl="http://facilitator.dev.mcc.kpnappfactory.nl/index.php/functions/home"; 
	  String expectedUrl= driver.getCurrentUrl(); 
	  if(actualUrl.equalsIgnoreCase(expectedUrl)) 
	  { 
	  System.out.println("Test passed");
	  MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Login Successfully")).build();
	  test.pass("I Have login successfully!!",mediaModel);
	  } 
	  else 
	  { 
		  System.out.println("Test failed");
		  MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Login Not Successfully")).build();
		  test.fail("I Have Not login successfully ",mediaModel);
	  } 
	 
	  
	 /* MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Login Successfully")).build();
	  test.pass("I Have login successfully!!");*/
	  
  }
}

