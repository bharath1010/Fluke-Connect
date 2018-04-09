package com.fluke.connect.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.fluke.connect.listner.Listner;
import com.fluke.connect.prepoststeps.LoginApplication;
import com.fluke.connect.utility.Configration;
import com.fluke.connect.utility.ExcelReader;
import com.fluke.connect.utility.ExtentManager;
import com.fluke.connect.utility.GetDataProperties;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




@SuppressWarnings("unused")
public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public static WebDriver driver;
	ExcelReader excel;
	Listner lis;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	public static String newFileName;
	public ExtentReports reo =ExtentManager.getInstance();
	public static ExtentTest tst;
	public WebDriverWait wait;
	
	/* static method to store the extent reports (Location of extent report). 
	configuration of extent are set in ReportsCongig.xml file are loading hear */
	
	@BeforeSuite
	public void initilization() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
		//extent.loadConfig(new File( System.getProperty("user.dir") +"\\src\\test\\java\\com\\fluke\\connect\\utility\\ReportsConfig.xml"));
	System.out.println("Before suite");
	}
	
	
	public void init(){
		
		selectBrowser(GetDataProperties.getConfData("browser"));
		getUrl(GetDataProperties.getConfData("url"));
		String log4jConfPath ="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	
	@SuppressWarnings("deprecation")
	public  void selectBrowser(String browser){
		
if (browser.equalsIgnoreCase("chrome")){
			
			
	System.setProperty("webdriver.chrom.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\" +"chromedriver.exe");		
	//	System.setProperty("webdriver.chrome.driver", GetDataProperties .getData("browserdriver_path") +  "\\chromedriver.exe");
		driver= new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait= new WebDriverWait(driver, 60);
	
	     }
		else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\"+"geckodriver.exe");
		//	System.setProperty("webdriver.gecko.driver", GetDataProperties.getData("browserdriver_path") + "\\geckodriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("acceptInsecureCerts",true);
			driver = new FirefoxDriver(capabilities);
			 
			 //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				wait= new WebDriverWait(driver, 20);
		 }

else if (browser.equalsIgnoreCase("ie")) {
			
			
	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\"+"IEDriverServer.exe");
	//System.setProperty("webdriver.ie.driver", GetDataProperties.getData("browserdriver_path") + "\\IEDriverServer.exe");
			
			//DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability("acceptInsecureCerts",true);
			driver = new InternetExplorerDriver();
			 
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		 }
			
			
	}

		 
		 
		 
		

	public void getUrl(String url){
	driver.get(url);
	log.info("Open ");

	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "\\src\\resources\\testData\\"+excelName;
		excel = new ExcelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);  
		return data;
	}
 
	public String captureScreen(String fileName) {
		if (fileName == "") {
		fileName = "blank";
	}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		String reportDirectory = new File(System.getProperty("user.dir"))+ "\\target\\surefire-reports\\html\\";

		destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
		newFileName = fileName + "_" + formater.format(calendar.getTime()) + ".png";
		FileUtils.copyFile(scrFile, destFile);
		Reporter.log("<a href='" + destFile + "'> <img src='" +  "_" + fileName +formater.format(calendar.getTime()) + ".png" + "' height='100' width='100'/> </a>");

	} 
	
	catch (IOException e) {
		e.printStackTrace();
	}
	
	return destFile.toString();
}
	public Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public void getresult(ITestResult result ) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass" );
			String screen = captureScreen("");
			test.log(LogStatus.PASS, test.addScreenCapture(newFileName));

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
			String screen = captureScreen("");
			test.log(LogStatus.SKIP, test.addScreenCapture(newFileName));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(newFileName));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getInstanceName() +  "   test is started" + result.getThrowable());
			
		}
		
		extent.endTest(test);
		extent.flush();
		
	}
	
	
	@BeforeMethod
	public void setUp(){
		WindowsUtils.killByName("chromedriver.exe");
		init();
		log("Open https://connect.fluke.com/en/login\r\n");
		LoginApplication.login(GetDataProperties.getConfData("username"),GetDataProperties.getConfData("password") );
	}
	
	@AfterMethod()
	public void afterMethod(ITestResult result) {
		getresult(result);
	}


	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser() {
		driver.quit();
		log.info("browser closed");		
		
	}
	public WebElement waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
}

