package utility;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	
	public static ArrayList<String> bResult = new ArrayList<String>();
	
	
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		//BaseClass.bResult = true;
		
	}

}
