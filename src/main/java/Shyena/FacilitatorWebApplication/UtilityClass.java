package Shyena.FacilitatorWebApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class UtilityClass {
	
	public  WebDriver driver;
	

	public Map<String, Object> exceldata(String sheetName) {
		String nameOfsheet=sheetName;

		File file = new File("Resource/ShyenaData.xlsx");
		FileInputStream fis = null;
		XSSFWorkbook xcel = null;
		Map<String, Object> customer = null;
		try {
			fis = new FileInputStream(file);

			xcel = new XSSFWorkbook(fis);

			XSSFSheet sht = xcel.getSheet(nameOfsheet);

			int noOfColumns = sht.getRow(0).getLastCellNum();

			customer = new HashMap<String, Object>();
			System.out.println(sht.getPhysicalNumberOfRows());

			for (int i = 0; i < sht.getPhysicalNumberOfRows() - 1; i++) {

				for (int j = 0; j < noOfColumns; j++) {

					try {

						String header = sht.getRow(i).getCell(j).getStringCellValue();

						customer.put(header, new DataFormatter().formatCellValue(sht.getRow(i + 1).getCell(j)));

					} catch (Exception e) {
						System.out.println("NUll Data");

					}

				}
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				xcel.close();
				fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println(customer);
		return customer;

		// return customer;
	}

	
	
	//public static String captureScreenShot(String number)
	//public  String captureScreenShot(WebDriver driver, String name)
	public static String  captureScreenShot(WebDriver driver, String name)
	 {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		String filepath=System.getProperty("user.dir")+"\\Resource\\screenshots\\screenshot"+name+".png";
		//String filepath=System.getProperty("user.dir")+"\\Resource\\screenshots\\screenshot"++".png";
		File destination = new File(filepath);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filepath;
	}
	     
	 
	
	
	

}
