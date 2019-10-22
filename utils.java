package utility;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import enums.DriverType;

public class utils {
	
	
	public static WebDriver driver = null;
	public static long startTime;
	public static long endTime;

	
	
	public static WebDriver OpenBrowser(DriverType driverType, String appURL, HashMap<String, Object> chromePrefs) throws Exception {
		try {
		
		
		if (driverType.toString().equalsIgnoreCase("edge")) {
			
			driver = initEdgeDriver(appURL);			
		}
		else if (driverType.toString().equalsIgnoreCase("ie")) {
			
			driver = initIEDriver(appURL);			
		}
		else if (driverType.toString().equalsIgnoreCase("chrome")) {
		
			driver = initChromeDriver(appURL, chromePrefs);			
		}
		else if (driverType.toString().equalsIgnoreCase("firefox")){
			driver = initFirefoxDriver(appURL);			
		}
		
		else {
			System.out.println("browser : " + driverType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}
		catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
			}
			return driver;
		}
	//////////////////////////////////////////////////
	private static WebDriver initChromeDriver(String appURL, HashMap<String, Object> chromePrefs) {
		System.out.println("Launching google chrome!!!");
		System.setProperty("webdriver.chrome.driver", Constant.Path_Drivers + "chromedriver.exe");
		/////////For handling SSL error in Chrome////////// 
		DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();       
		handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);    
		ChromeOptions options = new ChromeOptions();
		options.merge(handlSSLErr);
		options.setExperimentalOption("prefs", chromePrefs);
		//////////////////////////////////////////////////		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
/////////////////////////////////////////////////////////
	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser!!!");
		System.setProperty("webdriver.gecko.driver",Constant.Path_Drivers +"geckodriver.exe");
		///////For handling SSL error in Firefox//////////
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setAcceptInsecureCerts(true);
		/////////////////////////////////////////////////
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		//driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	//////////////////////////////////////////////////////////Z
	private static WebDriver initEdgeDriver(String appURL) {
		System.out.println("Launching Edge browser!!!");
		System.setProperty("webdriver.edge.driver",Constant.Path_Drivers +"MicrosoftWebDriver.exe");
		//DesiredCapabilities capabilities = new DesiredCapabilities("MicrosoftEdge", "", Platform.WINDOWS);
		
		/////////For handling SSL error in Chrome////////// 
		EdgeOptions options1 = new EdgeOptions();
		options1.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		//////////////////////////////////////////////////	
		EdgeDriver driver = new EdgeDriver(options1);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	//////////////////////////////////////////////////////////Z
	private static WebDriver initIEDriver(String appURL) {
	System.out.println("Launching IE browser!!!");
	System.setProperty("webdriver.ie.driver",Constant.Path_Drivers +"IEDriverServer.exe");
	//DesiredCapabilities capabilities = new DesiredCapabilities("MicrosoftIE", "", Platform.WINDOWS);
	/////////For handling SSL error in Chrome////////// 
	InternetExplorerOptions options = new InternetExplorerOptions();
	options.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
	//////////////////////////////////////////////////	
	InternetExplorerDriver driver = new InternetExplorerDriver(options);
	driver.manage().window().maximize();
	driver.navigate().to(appURL);
	return driver;
	}
	
	/*public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		try{

			long startTime = System.currentTimeMillis();
			System.out.println("Start Time: " + startTime);
			
		String homePage = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_URL);
		System.setProperty("webdriver.gecko.driver","C:\\Users\\dbharkhada\\eclipse-workspace\\TruConnectProductPOC\\Resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(homePage); 
		}
		
	catch (Exception e){
		Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}*/
	
	
	
	///////////////////////////////////Normal Screenshot////////////////////////////////////////////////////////
	public static void takeScreenshot(WebDriver ldriver, String TcName) throws Exception{
		File scrFile = ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		try{
			DateFormat dateFormat = new SimpleDateFormat("_MM-dd-yyyy_HH.mm.ss");
			Date date = new Date();
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + TcName + dateFormat.format(date) +".jpg"));	
		} catch (Exception e){
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	

	//This method is to capture the screenshot and return the path of the screenshot.
		public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
	
	
	//////////////////////////////////ReportNG Screenshot///////////////
	public static void screenCaptureForReportNG() throws IOException{
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String Path = System.getProperty("user.dir")+"\\Screenshots\\";
        File screenshotName = new File(Path +driver.getTitle()+".png");
        //Now add screenshot to results by copying the file
        FileUtils.copyFile(scrFile, screenshotName);
        Reporter.log("<br><a href='"+screenshotName+"'><img src='"+screenshotName+"' height='200' width='200' /></a><br>");
	}
	
	//////////////////Video Recording Of Test Cases///////////////
	public static ScreenRecorder configScreeenRecorder() throws Exception, AWTException {
		
		//String pathToFile = System.getProperty("user.dir")+"\\test-output\\Recordings\\";
	    //Create a instance of GraphicsConfiguration to get the Graphics configuration
	    //of the Screen. This is needed for ScreenRecorder class.
	    GraphicsConfiguration gc = GraphicsEnvironment//
	    .getLocalGraphicsEnvironment()//
	    .getDefaultScreenDevice()//
	    .getDefaultConfiguration();

	    //Create a instance of ScreenRecorder with the required configurations
	    ScreenRecorder screenRecorder = new ScreenRecorder(gc,
	    null, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
	    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	    DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
	    QualityKey, 1.0f,
	    KeyFrameIntervalKey, (int) (15 * 60)),
	    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,"black",
	    FrameRateKey, Rational.valueOf(30)),
	    null,new File(Constant.Path_VideoRecordings));
	    return screenRecorder;
	    
	    /*Syntex to start and stop recordings
	    
	    screenRecorder.start();
	    screenRecorder.stop();*/
	    
	}
	
	//////////////////////////////////////////
	public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	    
	 	}
	
	////////////////////////////////////////////
	public static String dateAndTime(){
		 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	 	}
	
	//////////////////////////////////////////////
	
	 public static void highlightElement(WebElement element) throws Exception {
	        for (int i = 0; i <2; i++) {
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 3px solid red;");
	            Thread.sleep(1000);
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	            }
	        }
	 
	//////////////////////////////////////////////
			
	public boolean compareStrings(String str1,String str2,String str3){
		
		List<String> strings = Arrays.asList(str1, str2, str3);
		
		if(strings.stream().distinct().count() == 1) {
		    // all strings are equal
			return true;
		}
		else {
			return false;	
		}	
	}
	 
	
//////////////////////////////////////////////
	
public  String getTableCellDataById(String tableId, int row, int column){

	
	WebElement cellIneed = utils.driver.findElement(By.xpath("//*[@id='"+tableId+"']/table/tbody/tr["+row+"]/td["+column+"]"));

	String valueIneed = cellIneed.getText();
	
	return valueIneed;
		
	}

//////////////////////////////////////////////

public  String getTableCellDataByClass(String tableClass, int row, int column){


		WebElement cellIneed = utils.driver.findElement(By.xpath("//*[@class='"+tableClass+"']/table/tbody/tr["+row+"]/td["+column+"]"));
		
		String valueIneed = cellIneed.getText();
		
		return valueIneed;

}
	///////////////////////////////Wait For Page Load///////////////////
	 
	 public boolean waitForJStoLoad() {
		 	JavascriptExecutor js1 = (JavascriptExecutor)driver;
		    WebDriverWait wait = new WebDriverWait(driver, 30);

		    // wait for jQuery to load
		    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		      @Override
		      public Boolean apply(WebDriver driver) {
		        try {
		          return ((Long)js1.executeScript("return jQuery.active") == 0);
		        }
		        catch (Exception e) {
		          return true;
		        }
		      }
		    };

		    // wait for Javascript to load
		    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		      @Override
		      public Boolean apply(WebDriver driver) {
		        return js1.executeScript("return document.readyState").toString().equals("complete");
		      }
		    };

		  return wait.until(jQueryLoad) && wait.until(jsLoad);
		}
	 
	///////////////////////////////////////////////
	public static void closeDriver() throws Exception{
		 try {
		  //driver.close();	 
			 driver.quit();
			 /*if(BaseClass.bResult==false)
			 {
				 System.out.println(BaseClass.bResult);
				 utility.EmailReport.EmailReportTo();
			 }*/
			endTime = System.currentTimeMillis();
			System.out.println("End Time: " + endTime);

			long executionTime = TimeUnit.MILLISECONDS.toMinutes(endTime - startTime); 
			System.out.println("Total Execution Time: " + executionTime);
	 	}
	catch (Exception e){
		Log.error("Class Utils | Method closeDriver | Exception desc : "+e.getMessage());
		}
	}
}
