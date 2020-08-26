package Shyena.FacilitatorWebApplication;

	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.MediaEntityModelProvider;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtendedReport {
	 
		
		WebDriver driver;
		ExtentTest test;
		ExtentReports extent;

		@BeforeTest
		public void bt() throws IOException {

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("saurab.html");
			htmlReporter.setAppendExisting(true);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setChartVisibilityOnOpen(true);
			
			extent = new ExtentReports();

			extent.attachReporter(htmlReporter);

			test = extent.createTest("Selenium Test");

			test.info("Autmation started");

			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://facilitator.dev.mcc.kpnappfactory.nl/");
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("Browser")).build();
			test.pass("I have opened the chrome browser");
			//MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("userScreen1")).build();
			//.fail("user name text biox has some error ", mediaModel);
		}

		@Test
		public void m() throws IOException {
			try {
				WebElement username = driver.findElement(By.xpath("//body/div/form/div[1]/input"));
				username.sendKeys("prashant.shukla.in@gmail.com");
				//username.sendKeys("prashant.shukla.in");
				MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("userScreen23544")).build();
				test.pass("I have entered user name successfully!!");
			} catch (Exception e) {
				MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("userScreen2")).build();
				test.fail("user name text biox has some error ", mediaModel);	
				
				
			}
			
			try {
				WebElement xyz = driver.findElement(By.name("password"));
				xyz.sendKeys("123456");
				test.pass("I have entered password successfully!!");
			} catch (Exception e) {
				MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("passScreen33")).build();
				test.fail("password text box has some error ", mediaModel);	
				
				
			}
			try {
				WebElement login = driver.findElement(By.className("col-xs-4"));
				login.click();
				test.pass("Login button clicked successfully!!");
			} catch (Exception e) {
				MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotWhenNeeded("loginScreen123")).build();
				test.fail("Login button has some error ", mediaModel);	
				
				
			}

		}

		@AfterTest
		public void at() {
			driver.quit();

			test.info("my execution is done");

			extent.flush();
		}

		
		public String screenshotWhenNeeded(String number)
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
		
	}



