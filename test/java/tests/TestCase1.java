package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import appiumServer.AppiumServerInitialization;
import appiumServer.CommonMethods;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestCase1 extends AppiumServerInitialization{
	
	private AppiumDriverLocalService service;
	
	CommonMethods commonmethods;
	
	@Test
	public void launchURL()
	{
		driver.navigate().to("http://www.naarsoft.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		commonmethods = new CommonMethods(driver);
		
		commonmethods.log("Launch URL");		 
	}
	
	@Test
	public void NavigateToAboutPage()
	{
		
		
	}
}
