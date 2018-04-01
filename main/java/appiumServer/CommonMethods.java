package appiumServer;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonMethods extends AppiumServerInitialization{
	
	public CommonMethods(AppiumDriver<MobileElement> driver)
	{
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	public void waitcommand() throws InterruptedException
	{
		Thread.sleep(30);
	}
	
	public static void waitForSeconds(Integer seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
	
	public boolean VerifyPage(String xpath, String pagetitle)
	{
		Assert.assertTrue(xpath.contains(pagetitle));
	     
	     System.out.println("Testing Passed");
	     
		return false;
	} 
	
	public String log(String message) 
	{
		
		Logger logger = Logger.getLogger("NewSmokeTest");
		
		PropertyConfigurator.configure("log4j.properties");	
		
		logger.info(message);
		
		return null;
		
	}
	

}

