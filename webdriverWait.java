package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverWait {
	

	
	public static WebElement waitForVisibilityOf(WebElement element){
		  //element = null;
		 
  	try{
  		System.out.println("waitForVisibilityOf called");
  		  WebDriverWait wait = new WebDriverWait(utils.driver, 20);
          wait.until(ExpectedConditions.visibilityOf(element));
  	}catch (Exception e){
  		//Reporter.log(element.getText()+" Element Not Found!!!!", true );
  		throw(e);
  		}
  	return element;
   }	
	

}
