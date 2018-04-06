package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import config.AppiumServerInitialization;
import config.CommonMethods;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pages.Homepage;

public class TestCase1 extends AppiumServerInitialization{
	
	private AppiumDriverLocalService service;
	
	CommonMethods commonmethods;
	
	Homepage homepage;
	
	@Test(priority=1)
	public void launchURL()
	{
		driver.navigate().to("http://www.naarsoft.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		commonmethods = new CommonMethods(driver);
		
		commonmethods.log("Launch URL");		 
	}
	
	@Test(priority=2)
	public void NavigateToMenuPage() throws InterruptedException 
	{
		commonmethods = new CommonMethods(driver);
		
		homepage = new Homepage(driver);
		
		//driver.findElementByXPath("//*[contains(@class, 'icon-menu-fine')]").click();
		
		commonmethods.log("Click on Menu");	
		
		Thread.sleep(2000);
			
		
	}
}
