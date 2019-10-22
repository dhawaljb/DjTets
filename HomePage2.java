package pageObjects_DMP;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.utils;
import utility.webdriverWait;

public class HomePage2 extends utils{
	
public static  WebElement element;
	
//////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath="//a[@class='dropdown-item'][contains(.,'Art')]")
	static 

    WebElement HomePage_ArtMenuLink;
	
	public static WebElement HomePage_ArtMenuLink(){
      webdriverWait.waitForVisibilityOf(HomePage_ArtMenuLink);
      element = HomePage_ArtMenuLink;
      return element;	
}	
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	 public HomePage2(){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }   

}
