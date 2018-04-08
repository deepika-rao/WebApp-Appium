package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import appiumServer.AppiumServerInitialization;
import appiumServer.CommonMethods;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pages.MenuList;

public class TestCase1 extends AppiumServerInitialization{
	
	private AppiumDriverLocalService service;
	
	CommonMethods commonmethods;
	
	MenuList homepage;
	
	@Test(priority=1)
	public void launchURL()
	{
		driver.navigate().to("http://www.naarsoft.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		commonmethods = new CommonMethods(driver);
		
		commonmethods.log("Launch URL");		 
	}
	
	@Test(priority=2)
	public void NavigateToAboutUSPage() throws InterruptedException 
	{
		commonmethods = new CommonMethods(driver);
		
		homepage = new MenuList(driver);
		
		homepage.ClickAboutUs();
		
		Thread.sleep(2000);
		
		commonmethods.log("Click on AboutUS");	
	}
	
	@Test(priority=3)
	public void NavigateToHome() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		homepage = new MenuList(driver);
		
		homepage.ClickHome();
		
		Thread.sleep(2000);
		
		commonmethods.log("Click on Home");
	}
}
