package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class WebDriverApi {

	protected static WebDriver driver;
	public static Logger APPLICATION_LOGS = Logger.getLogger("myLogs");

	/// -------------------- to deal with editBox (TYPE)---------------------

	public void typeByXpath (String locators, String values){
		try {
			driver.findElement(By.xpath(locators)).clear();
			driver.findElement (By.xpath(locators)).sendKeys (values);
		} 
		catch (Exception e){
			System.err.println("issue with :"  + e.getMessage());
			APPLICATION_LOGS.debug("issue with : " + e.getMessage());
			APPLICATION_LOGS.debug("    ");
		}
	};


	public void typeByCss (String locator, String value){
		driver.findElement (By.cssSelector(locator)).sendKeys(value);

	}
	public void typeById (String locator, String value){
		driver.findElement (By.id(locator)).sendKeys(value);

	}
	public void typeByName (String locator, String value){
		driver.findElement (By.name(locator)).sendKeys(value);

	}

	/// -------------------- to deal with CLICK---------------------
	public void clickByXpath (String locator){
		driver.findElement (By.xpath(locator)).click();

	}
	public void clickByCss (String locator){
		driver.findElement (By.cssSelector(locator)).click();

	}
	public void clickById (String locator){
		driver.findElement (By.id(locator)).click();

	}
	public void clickByName (String locator){
		driver.findElement (By.name(locator)).click();

	}


	// dropdown
	public  void dropDownByXpath (String locator, String text){
		WebElement dropDownListBox = driver.findElement(By.xpath(locator));
		Select clickThis = new Select(dropDownListBox);
		clickThis.selectByVisibleText(text);
	}

	// +++++++++++++++++++++++++++++ Current Date -----------===============

	public void startTime (){
		String t;
		Date date;
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		date = currentDate.getTime();
		SimpleDateFormat formatter= new SimpleDateFormat("EEEE - MM/dd/YYYY & hh:mm:ss a"); //format it as per your requirement
		t = formatter.format(date);
		System.out.println("Test start at: ==>>  " + t);
		APPLICATION_LOGS.debug("Test Suite started at: ==>>  " + t);
		APPLICATION_LOGS.debug("");
	}

	public static void endTime (){
		String t;
		Date date;
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		date = currentDate.getTime();
		SimpleDateFormat formatter= new SimpleDateFormat("EEEE - MM/dd/YYYY & hh:mm:ss a"); //format it as per your requirement
		t = formatter.format(date);
		System.out.println("Test end at: ==>>  " + t);
		APPLICATION_LOGS.debug("Test Suite Ended at: ==>>  " + t);
	}


	// ++++++++++++++++++++++++ Screenshots
	public static String captureScreenshot (String screenshotName ){
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String dest  = (System.getProperty ("user.dir")+"//screenShots//"+screenshotName+".jpg");
			File destination = new File (dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Test Case Failed and Sceenshot was taken and named it as "  +screenshotName+".jpg");
			APPLICATION_LOGS.debug("Test Case Failed and Screenshot was taken and named it as " + screenshotName+".jpg");;
			return screenshotName;

		} catch (Exception e) {
			System.err.println ("Exception while taking screenshot " + e.getMessage());
			APPLICATION_LOGS.debug("Exception while taking screenshot " + e);
			return e.getMessage();
		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenShots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}


	// ++++++++++++++++++++++++++++++ EXCEL PATH +++++++++++++++++++++++++++++++++++
	public String path;
	public String excelPath() {
		if(System.getProperty("os.name").startsWith("Win")) {
			path = System.getProperty("user.dir")+"//data.xlsx";
			//APPLICATION_LOGS.debug("Excel File was loading from WINDOWS");
		}
		else if(System.getProperty("os.name").startsWith("Mac")) {
			path = System.getProperty("user.dir")+"/data.xlsx";
			//APPLICATION_LOGS.debug("Excel File was loading from MAC");
		}
		return path;
	};

}
