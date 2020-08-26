package district;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Shyena.FacilitatorWebApplication.UtilityClass;

public class District {
	public  WebDriver driver;
	 public static ExtentHtmlReporter htmlReporter;
	static ExtentTest test;
	static ExtentReports extent;
	UtilityClass ScreenCap = new UtilityClass();
	public District(WebDriver driver)
	{
		this.driver=driver;
		
	}
	UtilityClass ref = new UtilityClass();
	String sheetName="Sheet3";
	Map<String, Object> customer = ref.exceldata(sheetName);
	
	public void districtName()
	{
		
		
		
	}
	

}
