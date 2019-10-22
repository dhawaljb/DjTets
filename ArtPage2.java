package pageObjects_DMP;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.utils;
import utility.webdriverWait;

public class ArtPage2 extends utils{
	
public static WebElement element;

/////////////////////////////////////////////////////////////////////////////////////////////	
	@FindBy(xpath="//img[contains(@alt,'Brown bear - Vector graphics')]")
	static

    WebElement art_BrownBearImageButton;
	
	public static WebElement art_BrownBearImageButton(){
	      element = webdriverWait.waitForVisibilityOf(art_BrownBearImageButton);
	      return element;	
	}	
	//////////////////////////////////////////////////////////////////////////////////////////////	
	
	@FindBy(xpath="//button[contains(@class,'btn btn-primary add-to-cart')]")
	static

    WebElement art_BrownBearAddToCartButton;
	
	public static WebElement art_BrownBearAddToCartButton(){
	      element = webdriverWait.waitForVisibilityOf(art_BrownBearAddToCartButton);
	      return element;	
	}	
	//////////////////////////////////////////////////////////////////////////////////////////////	
	
	@FindBy(xpath="//*[@id=\\\"blockcart-modal\\\"]/div/div/div[2]/div/div[2]/div/div/a")
	static

    WebElement art_proceedToCheckoutButton;
	
	public static WebElement art_proceedToCheckoutButton(){
	      element = webdriverWait.waitForVisibilityOf(art_proceedToCheckoutButton);
	      return element;	
	}	
	//////////////////////////////////////////////////////////////////////////////////////////////	
	
	@FindBy(xpath="//a[contains(@class,'btn btn-primary')]")
	static

    WebElement art_proceedToCheckoutFinalButton;
	
	public static WebElement art_proceedToCheckoutFinalButton(){
	      element = webdriverWait.waitForVisibilityOf(art_proceedToCheckoutFinalButton);
	      return element;	
	}	
	//////////////////////////////////////////////////////////////////////////////////////////////

	 public ArtPage2(){

	        this.driver = utils.driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	        
	    }   
	
}
