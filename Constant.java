package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {
   
  //Test Data
	
  	//Test Data Sheet
	public static final String Path_TestData = System.getProperty("user.dir")+"\\Lib\\ExcelSheets\\";
	public static final String File_TestData = "TestData.xlsx";
	//Result Sheet
	public static final String Path_Result = System.getProperty("user.dir")+"\\Lib\\ExcelSheets\\";
	public static final String File_Result = "Result.xlsx";
	//Browser Drivers
	public static final String Path_Drivers = System.getProperty("user.dir")+"\\Lib\\Drivers\\";
    //Log File
	public static final String DOMConfiguratorFile = System.getProperty("user.dir")+"\\log4j.xml";
	
	//Test Image File
	public static final String TestImageFile = System.getProperty("user.dir")+"\\Lib\\ResourceFiles\\TestImage.png";
	
	//Screenshot path
	public static final String Path_ScreenShot = System.getProperty("user.dir")+"\\Lib\\Screenshots\\";
		
	//Video Recordings Path
	public static final String Path_VideoRecordings = System.getProperty("user.dir")+"\\Lib\\Recordings\\";
	
	
	//****************************//PrestaShop Test Data Sheet Columns//****************************//
	public static final int PrestaShop_Col_TestCaseName = 0;	
	public static final int PrestaShop_Col_UserName =1 ;
	public static final int PrestaShop_Col_Password = 2;
	public static final int PrestaShop_Col_Browser = 3;
	public static final int PrestaShop_Col_PhoneModel = 4;
	public static final int PrestaShop_Col_Plan = 5;
	public static final int PrestaShop_Col_FirstName = 6;
	public static final int PrestaShop_Col_LastName = 7;
	public static final int PrestaShop_Col_Address = 8;
	public static final int PrestaShop_Col_City = 9;
	public static final int PrestaShop_Col_ZipCode = 10;
	public static final int PrestaShop_Col_InvalidZipCode = 11;
	public static final int PrestaShop_Col_Email = 12;
	public static final int PrestaShop_Col_InvalidEmail = 13;
	public static final int PrestaShop_Col_State = 14;
	public static final int PrestaShop_Col_InvalidPIN = 15;
	public static final int PrestaShop_Col_SecurityQuestion = 16;
	public static final int PrestaShop_Col_Answer = 17;
	public static final int PrestaShop_Col_CreditCardNumber = 18;
	public static final int PrestaShop_Col_InvalidCreditCard = 19;
	public static final int PrestaShop_Col_ExpirationMonth = 20;
	public static final int PrestaShop_Col_ExpirationYear = 21;
	public static final int PrestaShop_Col_CreditCardCVC = 22;
	public static final int PrestaShop_Col_InvalidCreditCardCVC = 23;
	public static final int PrestaShop_Col_BillingZip = 24;
	public static final int PrestaShop_Col_InvalidBillingZip = 25;
	public static final int Col_URL = 26;
	public static final int PrestaShop_Col_ExecuteTC = 27;
	
	
		
	 //////////////////////////////
	
	static DateFormat dateFormat = new SimpleDateFormat(" MM-dd-yyyy_HH.mm.ss");
	static Date date = new Date();
	
	
	//Report Path
	public static final String Path_Report = System.getProperty("user.dir")+"\\target\\surefire-reports\\html";
	public static final String Path_EmailableReport = System.getProperty("user.dir")+"\\test-output\\EmailableZipReport\\SeleniumAutomationReport.Zip";
	
	//Email List
	
	public static final String EmailList = "dhawal.bharkhada@slkgroup.com";
	public static final String EmailListForSuccess = "dhawal.bharkhada@slkgroup.com";
}

