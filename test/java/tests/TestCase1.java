package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import appiumServer.AppiumServerInitialization;
import appiumServer.CommonMethods;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pages.ContactUsPage;
import pages.MenuList;
import pages.ServicesPage;

public class TestCase1 extends AppiumServerInitialization{
	
	private AppiumDriverLocalService service;
	
	CommonMethods commonmethods;
	
	MenuList menulist;
	
	ServicesPage servicespage;
	
	ContactUsPage contactuspage;
	
	@Test(priority=1)
	public void launchURL() throws IOException
	{
		driver.navigate().to("http://www.naarsoft.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		commonmethods = new CommonMethods(driver);
		
		commonmethods.log("Launch URL");
		
		commonmethods.captureScreenShot("LaunchURL");
	}
	
	@Test(priority=2)
	public void NavigateToAboutUSPage() throws InterruptedException, IOException 
	{
		commonmethods = new CommonMethods(driver);
		
		menulist = new MenuList(driver);
		
		menulist.ClickAboutUs();
		
		Thread.sleep(2000);
		
		commonmethods.log("Click on AboutUS");	
		
		commonmethods.captureScreenShot("AboutUSpage");
	}
	
	@Test(priority=4)
	public void NavigateToHome() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		menulist = new MenuList(driver);
		
		menulist.ClickHome();
		
		Thread.sleep(2000);
		
		commonmethods.log("Click on Home");
		
		commonmethods.captureScreenShot("HomePage");
	}
	
	@Test(enabled=false)
	public void NavigateToContactUS() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		menulist = new MenuList(driver);
		
		menulist.ClickContactUs();
		
		Thread.sleep(2000);
		
		commonmethods.log("Click on ContactUS");
		
	}
	
	@Test(priority=5)
	public void NavigateToMicrosoft_Net() throws Exception
	{
		commonmethods = new CommonMethods(driver);
		
		servicespage = new ServicesPage(driver);
		
		servicespage.ClickServices_MicrosoftNet();
		
		Thread.sleep(2000);
		
		commonmethods.log("Click on Microsoft .Net");
		
		commonmethods.captureScreenShot("Microsoft_NetPage");
	}
	
	@Test(priority=6)
	public void NavigateToPHP_Development() throws Exception
	{
		commonmethods = new CommonMethods(driver);
		
		servicespage = new ServicesPage(driver);
		
		servicespage.ClickOpenSource_PHPDevelopment();
		
		Thread.sleep(2000);
		
		commonmethods.log("Click on PHP Development");
		
		commonmethods.captureScreenShot("PHP_DevelopPage");
	}
	
	@Test(priority=7)
	public void Scroll_Down() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.ScrollPage();
		
		Thread.sleep(2000);
		
		commonmethods.log("Scroll down");
	}
	
	@Test(priority=8)
	public void NavigateToContactUs() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		contactuspage = new ContactUsPage(driver);
		
		contactuspage.ClickContactUs();
		
		Thread.sleep(2000);
		
		contactuspage.YourName();
		
		Thread.sleep(2000);
		
		commonmethods.log("Enter Your Name");
		
		Thread.sleep(2000);
		
		commonmethods.captureScreenShot("Name_field");
		
	}
	
	
	
}
