
package utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrockenLinks {
	private static WebDriver driver = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String homePage = "http://10.42.133.30/prestashop/";
        String url = "";
        String fieldName = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
        System.setProperty("webdriver.gecko.driver",Constant.Path_Drivers + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        
        
        driver.manage().window().maximize();
        
        driver.get(homePage);
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            //fieldName = it.next().getText();
           // fieldName = it.next().getText();
           // System.out.println(fieldName);
            
                    
            if(url == null || url.isEmpty()){
            	System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
           // if(!url.startsWith(homePage)||url.startsWith(homePage)){
           //     System.out.println("URL belongs to another domain, skipping it.");
           //     continue;
           // }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                    
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        driver.close();       
        driver.quit();
        
    }

}
