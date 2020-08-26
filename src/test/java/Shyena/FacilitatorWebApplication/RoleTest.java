package Shyena.FacilitatorWebApplication;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import Pages.LoginClass;
import role.RoleClass;

public class RoleTest extends BaseClass {
	//private WebDriver driver;
	/*private BaseClass baseClass;
	private LoginClass loginClass;*/
	
	UtilityClass ScreenCap = new UtilityClass();
	/*@BeforeClass
	public void setUp() {
	//driver=getDriver();
	driver=beforeTest();
	}*/
	
@Test(priority=1)
  public void RoleTest() throws InterruptedException, IOException {
	  LoginClass loginObject=new LoginClass(driver);
	  loginObject.login();
	  
	  
	  RoleClass roleobject= new RoleClass(driver);
	  roleobject.role();
	  MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Role add Successfully")).build();
	  test.pass("I Have added Role successfully!!",mediaModel);
	  
	  
	  
	 /* Boolean b=driver.findElement(By.xpath("//*[@id='formdata']/form/div[5]/input")).isDisplayed();
		if(b==true)
		{
			Assert.assertTrue(true);
			
			System.out.println("Enter role and Description");
			
			  MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Enter Role")).build();
			  test.fail("Please Enter Role and Descripton",mediaModel);
		}
		else
		{
			System.out.println("Not Enter");
		}*/
	  
	 
	 
	  
	  
	
	  
  }
@Test(priority=2)
public void editRole() throws IOException
{
	RoleClass roleobject1= new RoleClass(driver);
	roleobject1.editrole();
	MediaEntityModelProvider mediaModel= MediaEntityBuilder.createScreenCaptureFromPath(ScreenCap.captureScreenShot(driver, "Role edit Successfully")).build();
	  test.pass("I Have Updated Role successfully!!",mediaModel);
}
}
