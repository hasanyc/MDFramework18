package base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import utils.WebDriverApi;
import utils.Xls_Reader;

public class Config extends WebDriverApi {

	// protected Xls_Reader LOAD_EXCEL_FILE = new Xls_Reader (excelPath());

	protected Xls_Reader LOAD_EXCEL_FILE;
	public static String winPath = System.getProperty("user.dir")+"//data.xlsx";
	public static String macPath = System.getProperty("user.dir")+"/data.xlsx";

	@BeforeSuite
	public void suiteStart () {
		APPLICATION_LOGS.debug("Test Suite S-T-A-R-T");
		startTime();
		System.out.println("");

	}

	@Parameters ({"browser", "platform"})
	@BeforeMethod
	public void setUp(String browser, String platform, Method method){
		
		if (browser.equalsIgnoreCase("ch")){
			if(platform.equalsIgnoreCase("Windows")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
				driver = new ChromeDriver();
				APPLICATION_LOGS.debug("Chrome Browser started on WINDOWS");
				LOAD_EXCEL_FILE = new Xls_Reader(winPath);
				
			}
			else if(platform.equalsIgnoreCase("Mac")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
				driver = new ChromeDriver();
				APPLICATION_LOGS.debug("Chrome Browser started on MAC");
				LOAD_EXCEL_FILE = new Xls_Reader(macPath);
			}
		}
		else if (browser.equalsIgnoreCase("ff")){
			if (platform.equalsIgnoreCase("Windows")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
				driver = new FirefoxDriver();
				APPLICATION_LOGS.debug("Firefox Browser started on WINDOWS");
				LOAD_EXCEL_FILE = new Xls_Reader(winPath);
			}
			else if (platform.equalsIgnoreCase("Mac")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver");
				driver = new FirefoxDriver();
				APPLICATION_LOGS.debug("Firefox Browser started on MAC");
				LOAD_EXCEL_FILE = new Xls_Reader(macPath);
			}
		}

		//driver.navigate().to("http://www.facebook.com");
		driver.get("https://www.facebook.com");
		APPLICATION_LOGS.debug("Facebook opend");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String testName = method.getName();
		APPLICATION_LOGS.debug("==========================================================================================================");
		APPLICATION_LOGS.debug("Test Method is: ==> " +testName+ " Just S-T-A-R-T-E-D");
		APPLICATION_LOGS.debug("==========================================================================================================");
	}

	@AfterMethod
	public void closeBrowser(Method method) {
		String testName = method.getName();
		APPLICATION_LOGS.debug("==========================================================================================================");
		APPLICATION_LOGS.debug("Test Method is: ==> " +testName+ " Just E-N-D-E-D");
		APPLICATION_LOGS.debug("==========================================================================================================");
		driver.close();

	}

	@AfterSuite
	public void tearDown (){
		endTime();
		APPLICATION_LOGS.debug("Test Suite E-N-D");
		driver.quit();

	}
}
