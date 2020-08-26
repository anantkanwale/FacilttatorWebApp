package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Shyena.FacilitatorWebApplication.BaseClass;
import Shyena.FacilitatorWebApplication.UtilityClass;

public class LoginClass {
	public  WebDriver driver;
	 public static ExtentHtmlReporter htmlReporter;
	static ExtentTest test;
	static ExtentReports extent;
	
	public LoginClass(WebDriver driver) throws IOException {
		this.driver = driver;
		//extendReport();
   
	}
	
	
   
	public void login() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		UtilityClass ref = new UtilityClass();
		String sheetName="Sheet1";
		Map<String, Object> customer = ref.exceldata(sheetName);
		
		String userName=(String) customer.get("UserName");
		String password=(String) customer.get("Password");
		 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/input")).sendKeys(userName);
		//Thread.sleep(10000);
		
		driver.findElement(By.name("password")).sendKeys(password);

		//Thread.sleep(20000);
		
		
		WebElement buttonclick=driver.findElement(By.className("col-xs-4"));
		
		buttonclick.click();	
		
	}
	
	
	
	
}



//UtilityClass ScreenCap = new UtilityClass();
//ScreenCap.captureScreenShot(driver, null);
		
/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
UtilityClass ref = new UtilityClass();
String sheetName="Sheet1";
Map<String, Object> customer = ref.exceldata(sheetName);

String userName=(String) customer.get("UserName");
String password=(String) customer.get("Password");
UtilityClass ScreenCap = new UtilityClass();
		try {
			
			WebElement username = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/input"));
			username.sendKeys(userName);
			
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Username")).build();
			test.pass("I have entered user name successfully!!");
		} catch (Exception e) {
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "UsernameError")).build();
		   //MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("UsernameError")).build();
			test.fail("user name text box has some error ", mediaModel);	
			
			
		}
		
		try {
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys(password);
			test.pass("I have entered password successfully!!");
		} catch (Exception e) {
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "PasswordError")).build();
			// MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("PasswordError")).build();
			test.fail("password text box has some error ", mediaModel);	
			
			
		}
		try {
			WebElement login = driver.findElement(By.className("col-xs-4"));
			login.click();
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Password")).build();
			test.pass("Login button clicked successfully!!");
		} catch (Exception e) {
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "LoginButtonError")).build();
			// MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("LoginButtonError")).build();
			test.fail("Login button has some error ", mediaModel);	
			
			
		}
	}*/
	/*public String screenshotWhenNeeded(String number)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		String filepath=System.getProperty("user.dir")+"\\Resource\\screenshots\\screenshot"+number+".png";
		
		File destination = new File(filepath);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filepath;
	}
	
	public void extendReport() throws IOException {
		
		System.out.println("Extend report running");
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("facilitatorWebApplication.html");
	htmlReporter.setAppendExisting(true);
	htmlReporter.config().setTheme(Theme.DARK);
	htmlReporter.config().setChartVisibilityOnOpen(true);
	
	extent = new ExtentReports();

	extent.attachReporter(htmlReporter);

	test = extent.createTest("Selenium Test");

	test.info("Autmation started");
	
	}*/



	
	
	
