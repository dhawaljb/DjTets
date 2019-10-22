package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenBrowser {
	private static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(String browserType, String appURL, int iTestCaseRow) throws Exception {
		String appURL1 = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_URL);
		switch (browserType) {
		case "chrome":
			
			driver = initChromeDriver(appURL1);
			break;
		case "firefox":
			
			driver = initFirefoxDriver(appURL1);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL1);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", Constant.Path_Drivers + "chromedriver.exe");
		/////////For handling SSL error in Chrome////////// 
		DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();       
		handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions options = new ChromeOptions();
		options.merge(handlSSLErr);
		//////////////////////////////////////////////////		
		WebDriver driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver",Constant.Path_Drivers +"geckodriver.exe");
		
		///////For handling SSL error in Firefox//////////
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setAcceptInsecureCerts(true);
		/////////////////////////////////////////////////
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		//driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
}
	


