package com.slkgroup.testCasesDMP;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import enums.DriverType;
import fileReaderManager.FileReaderManager;
import pageObjects_DMP.DMPSonarHomePage;
import testDataTypes.TestData;
import utility.BaseClass;
import utility.Constant;
import utility.Log;
import utility.utils;

public class TC01DMPSonarRevenueForecastExport2_Demo<jsonData> {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public ExtentKlovReporter KlovReporter;
	
	
	private String sTestCaseName;
	
	private static DriverType driverType;
	private String appURL;
	
		
@BeforeMethod
	public void beforeMethod() throws Exception {
	
	//////////Create Json object and use it throughout testcase ////////////////////////
	TestData testdata = FileReaderManager.getInstance().getJsonReader().getTestDataByName(getClassName());
	
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
    //////$$$$$ Klov Reporter Code $$$$$$////////
	//ExtentKlovReporter klov = new ExtentKlovReporter("DMPSonar", "DMPSonar_"+dateName);
	// address, host/port of MongoDB
	//klov.initMongoDbConnection("http://10.42.150.27", 27017);
	// Klov server address
	//klov.initKlovServerConnection("http://10.42.150.27:8282");
	  
	//Extent Report Code
	// Create an object of Extent Reports
	extent = new ExtentReports();  
	//extent.attachReporter(klov);
	extent.setSystemInfo("Host Name", "SLK Software");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("User Name", "Dhawal");
	
	//////$$$$$ Html Reporter Code $$$$$$////////
	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/DMPAutomationReport_"+dateName+".html");
	extent.attachReporter(htmlReporter);
	htmlReporter.config().setDocumentTitle("DMPSonar "); 
	        // Name of the report
	htmlReporter.config().setReportName("DMPSonar "); 
	        // Dark Theme
	htmlReporter.config().setTheme(Theme.STANDARD);	
	
	/////////////////////////Check IsRunnable///////////////
	String IsTCRunnable = testdata.IsTCRunnable;
	if(!IsTCRunnable.equalsIgnoreCase("Yes")){
	
	Log.info("Run mode of testcase is . Skipping execution.....");
	throw new SkipException("Run mode of testcase is No. Skipping execution.....");
	
	}else
	Log.info("Run mode of testcase is Yes. Starting testcase execution.");
	
	}
	 
public String getClassName() {
    String sTestCaseName = this.getClass().getSimpleName(); 
    System.out.println("Name:" + sTestCaseName);
	return sTestCaseName;
}


@Test//(enabled=false)(groups = {"Functional","all"})
	public void RevenueForecastExport() throws Exception {
	
	try {
			
		//TC01DMPSonarRevenueForecastExport2_Demo<jsonData> TC = new TC01DMPSonarRevenueForecastExport2_Demo<jsonData>();
		//String sTestCaseName = TC.getClassName();
		//String TC_Name = this.getClass().getSimpleName();
		
		/////////////////Get class name///////////////////
		String sTestCaseName = this.getClass().getSimpleName();
		
		//////////Create Json object and use it throughout testcase ////////////////////////
	    TestData testdata = FileReaderManager.getInstance().getJsonReader().getTestDataByName(sTestCaseName);
		
	    /////////////////Get Driver Type from config file ////////////////////
	    
	    driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	    
		/////////////////Get Driver Type from config file ////////////////////
			    
	    appURL = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
	    
		DOMConfigurator.configure(Constant.DOMConfiguratorFile);
		  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		//Code to set browser download path
		String downloadFilePath = "D:\\File";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);
        //chromePrefs.put("--disable-blink-features", "BlockCredentialedSubresources");
        
      
        
		utils.OpenBrowser(driverType, appURL, chromePrefs);
		//utility.OpenBrowser.setDriver(ExcelUtils.getCellData(iTestCaseRow, Constant.PrestaShop_Col_Browser), ExcelUtils.getCellData(iTestCaseRow, Constant.PrestaShop_Col_Browser), iTestCaseRow);

		logger = extent.createTest("Export Revenue Excel");
		
		DMPSonarHomePage.Finance_Link(utils.driver).click();
		logger.createNode("Click on Finance Link Passed");
		
		DMPSonarHomePage.RevenueForecast_Link(utils.driver).click();
		logger.createNode("Click on RevenueForecast Link Passed");
		
		DMPSonarHomePage.WaitForTableLoad(utils.driver);
		logger.createNode("Wait for table load Passed");
		
		//scroll down 
		JavascriptExecutor jse = (JavascriptExecutor)utils.driver;
        jse.executeScript("window.scrollBy(0,1550)", "");

        DMPSonarHomePage.ExcelExport(utils.driver).click();
        logger.createNode("Click on Excel Export Button Passed");
          

	}
	
	catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		//ExcelUtils.setExcelFile(Constant.Path_Result + Constant.File_Result,"Sheet1");  
		//ExcelUtils.setCellData("Fail", Constant.Path_Result + Constant.File_Result, iTestCaseRow, Constant.Col_Result);
		  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
		  //utils.takeScreenshot(utils.driver,sTestCaseName);
		  // This will print the error log message
		  BaseClass.bResult.add("Fail");
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
}

@AfterMethod
public void getResult(ITestResult result) throws Exception{
	if(result.getStatus() == ITestResult.FAILURE){
		//MarkupHelper is used to display the output in different colors
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
		//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
		//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
		String screenshotPath = utils.getScreenShot(utils.driver, result.getName());
		//To add it in the extent report 
		logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	}
	else if(result.getStatus() == ITestResult.SKIP){
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
	} 
	else if(result.getStatus() == ITestResult.SUCCESS)
	{
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	}
	
}

@AfterTest
	public void afterMethod() throws Exception {
		// Printing logs -- end the test case
		extent.flush();
		Log.endTestCase(sTestCaseName);
		// Close driver
		utils.closeDriver();

}

}
