package role;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Shyena.FacilitatorWebApplication.UtilityClass;

public class RoleClass {
	public  WebDriver driver;
	 public static ExtentHtmlReporter htmlReporter;
	static ExtentTest test;
	static ExtentReports extent;
	UtilityClass ScreenCap = new UtilityClass();
	public RoleClass(WebDriver driver)
	{
		this.driver=driver;
		
	}
	UtilityClass ref = new UtilityClass();
	String sheetName="Sheet2";
	Map<String, Object> customer = ref.exceldata(sheetName);
	
	public void role() throws InterruptedException, IOException
	{
		//driver.switchTo().alert().dismiss();
		//Thread.sleep(40000);
		driver.findElement(By.xpath("//a[contains(@href,'http://facilitator.dev.mcc.kpnappfactory.nl/index.php/functions/role')]")).click();
		
		driver.findElement(By.xpath("//a[@id='addrolebutton']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String role=(String) customer.get("Role");
		String roleDescription=(String) customer.get("RoleDescription");
		
		Thread.sleep(5000);
	WebElement RoleName=	driver.findElement(By.xpath("//input[@class='form-control']"));
	RoleName.sendKeys(role);
	

	
	WebElement RoleDesc	=driver.findElement(By.xpath("//*[@id='roleDescription']"));
	RoleDesc.sendKeys(roleDescription);
	
	
		driver.findElement(By.xpath("//*[@id='formdata']/form/div[5]/input")).click();
		Thread.sleep(5000);
		
		// Boolean b=driver.findElement(By.xpath("//*[@id='formdata']/form/div[5]/input")).isDisplayed();
		/*if( role.isEmpty() )
		{
			//Assert.assertTrue(true);
			
			System.out.println("Enter role and Description");
			
			  MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Enter Role")).build();
			  test.fail("Please Enter Role and Descripton",mediaModel);
		}
		else
		{
			System.out.println("Not Enter");
		}*/
		
	}
	
	private void assertEquals(String string, String text) {
		// TODO Auto-generated method stub
		
	}

	public void editrole()
	{
		driver.findElement(By.xpath("//a[contains(@href,'http://facilitator.dev.mcc.kpnappfactory.nl/index.php/functions/role')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bewerk')]")).click();
		String roleedit=(String) customer.get("UpdateRole");
		String roleDescriptionedit=(String) customer.get("UpdateDescription");
		
		WebElement roleClear =driver.findElement(By.xpath("//input[@class='form-control']"));
				roleClear.clear();
				roleClear.sendKeys(roleedit);
		
		WebElement roleDesc=driver.findElement(By.xpath("//*[@id='roleDescription']"));
		roleDesc.clear();
		roleDesc.sendKeys(roleDescriptionedit);
		
		driver.findElement(By.xpath("//*[@id='formdata']/form/div[5]/input")).click();
	}

	
}
