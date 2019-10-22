package pageObjects_DMP;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.utils;
import utility.webdriverWait;

public class DMPSonarHomePage extends utils{
	
	private static WebElement element = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////
		
	public static WebElement Finance_Link(WebDriver driver){
	    WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#'][contains(.,'Finance')]")));
        element = driver.findElement(By.xpath("//a[@href='#'][contains(.,'Finance')]"));
	    return element;	 
	  }
	
//////////////////////////////////////////////////////////////////////////////////////////////	
	
public static WebElement RevenueForecast_Link(WebDriver driver){
	 
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='RevenueForecast']")));
    element = driver.findElement(By.xpath("//a[@id='RevenueForecast']"));
    return element;
    
    }
//////////////////////////////////////////////////////////////////////////////////////////////

public static WebElement WaitForTableLoad(WebDriver driver){

	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jqgh_gvConfirmedGrid_ProjectName")));
	element = driver.findElement(By.id("jqgh_gvConfirmedGrid_ProjectName"));
	return element;

	}

//////////////////////////////////////////////////////////////////////////////////////////////

public static WebElement ExcelExport(WebDriver driver){

	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("ExportToExcel")));
	element = driver.findElement(By.id("ExportToExcel"));
	return element;

	}

//////////////////////////////////////////////////////////////////////////////////////////////

public static WebElement ConfirmPopup(WebDriver driver){

	WebDriverWait wait = new WebDriverWait(driver,90);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ExportToExcel")));
	element = driver.findElement(By.id("ExportToExcel"));
	return element;

	}
}
