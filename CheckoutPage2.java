package pageObjects_DMP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.utils;
import utility.webdriverWait;

public class CheckoutPage2  extends utils{
	public static WebElement element;
	public static WebElement dropdown;
	
/////////////////////////////////////////////////////////////////////////////////////////////	
	@FindBy(xpath="//*[@id=\\\"customer-form\\\"]/section/div[1]/div[1]/label[1]")
	static
	
	WebElement personalInfo_Gender;
	
	public static WebElement personalInfo_Gender(){
	      element = webdriverWait.waitForVisibilityOf(personalInfo_Gender);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//input[contains(@name,'firstname')]")
	static
	
	WebElement personalInfo_Firstname;
	
	public static WebElement personalInfo_Firstname(){
	      element = webdriverWait.waitForVisibilityOf(personalInfo_Firstname);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath="//input[@name='lastname']")
	static
	
	WebElement personalInfo_Lastname;
	
	public static WebElement personalInfo_Lastname(){
	      element = webdriverWait.waitForVisibilityOf(personalInfo_Lastname);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath="//input[@name='email']")
	static
	
	WebElement personalInfo_Email;
	
	public static WebElement personalInfo_Email(){
	      element = webdriverWait.waitForVisibilityOf(personalInfo_Email);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath="//button[contains(@data-link-action,'register-new-customer')]")
	static
	
	WebElement personalInfo_Continue;
	
	public static WebElement personalInfo_Continue(){
	      element = webdriverWait.waitForVisibilityOf(personalInfo_Continue);
	      return element;	
	}	
	
	//////////////////////////////////Address//////////////////////////
	
	@FindBy(xpath="//input[contains(@name,'address1')]")
	static
	
	WebElement AddressInfo_Address;
	
	public static WebElement AddressInfo_Address(){
	      element = webdriverWait.waitForVisibilityOf(AddressInfo_Address);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//input[contains(@name,'city')]")
	static
	
	WebElement AddressInfo_City;
	
	public static WebElement AddressInfo_City(){
	      element = webdriverWait.waitForVisibilityOf(AddressInfo_City);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//select[contains(@name,'id_state')]")
	static
	
	WebElement AddressInfo_State;
	
	public static WebElement AddressInfo_State(){
	      element = webdriverWait.waitForVisibilityOf(AddressInfo_State);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath="//input[contains(@name,'postcode')]")
	static
	
	WebElement AddressInfo_Zip;
	
	public static WebElement AddressInfo_Zip(){
	      element = webdriverWait.waitForVisibilityOf(AddressInfo_Zip);
	      return element;	
	}	
//////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath="//button[@name='confirm-addresses']")
	static
	
	WebElement AddressInfo_Continue;
	
	public static WebElement AddressInfo_Continue(){
	      element = webdriverWait.waitForVisibilityOf(AddressInfo_Continue);
	      return element;	
	}
//////////////////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////Payment//////////////////////

	@FindBy(xpath="//*[@id=\\\"payment-option-1-container\\\"]/label/span")
	static
	
	WebElement Payment_checkpayment;
	
	public static WebElement Payment_checkpayment(){
	      element = webdriverWait.waitForVisibilityOf(Payment_checkpayment);
	      return element;	
	}
//////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath="//*[@id=\\\"conditions-to-approve\\\"]/ul/li/div[2]/label")
	static
	
	WebElement Payment_AgreeTermsAndConditions;
	
	public static WebElement Payment_AgreeTermsAndConditions(){
	      element = webdriverWait.waitForVisibilityOf(Payment_AgreeTermsAndConditions);
	      return element;	
	}
//////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////Place Order /////////////////
  @FindBy(xpath="//button[@type='submit'][contains(.,'Order with an obligation to pay')]")
	static
	
	WebElement PlaceOrder;
	
	public static WebElement PlaceOrder(){
	      element = webdriverWait.waitForVisibilityOf(PlaceOrder);
	      return element;	
	}
//////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
