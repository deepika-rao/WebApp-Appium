package config;

import static org.testng.Assert.assertNotNull;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonMethods extends AppiumServerInitialization{
	
	//protected static AppiumDriver<MobileElement> driver;
	
	 //static AndroidDriver driver;
	
	public CommonMethods(AppiumDriver<AndroidElement> driver)
	{
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//protected static AppiumDriver<MobileElement> driver;
	
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
	
	public void testScroll()throws Exception
    {
        driver.findElementByAccessibilityId("Mobile Application Development").click();
        AndroidElement list = (AndroidElement) driver.findElement(By.id("android:id/mobile_list"));
        MobileElement listGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\" List item:25\"));"));
        assertNotNull(listGroup.getLocation());
        listGroup.click();
    }
	
	public void getWebViewText()
	{
		System.out.println("First Current Context : "+driver.getContext());
		driver.findElementByClassName("icon-menu-fine").click();
		//driver.findElementByAccessibilityId("Views").click();
		for(int i=0;i<=20;i++)
		{
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementById("menu").click();
				//driver.findElementByAccessibilityId("WebView").click();
				break;
			} catch (Exception e) {
				//verticalSwipe();
			}
		}
		// Using this method we switch to web view
		switchContext("WEBVIEW");
		String webViewText = driver.findElementByXPath("//*[contains(@class, 'icon-menu-fine')]").getText();
		System.out.println(webViewText);
		
	}
	
	public void switchContext(String context)
	{
		System.out.println("Before Switching : "+driver.getContext());
		Set<String> con = driver.getContextHandles();
		for(String c : con)
		{
			System.out.println("Available Context : "+c);
			if(c.contains(context))
			{
				driver.context(c);
				break;
			}
		}
		System.out.println("After Switching : "+driver.getContext());
	}
	
	
	/*public void verticalSwipe(MobileElement startElement, MobileElement endElement)
	{
		/*Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int starty = (int)(height*0.80);
		int endy = (int)(height*0.20);
		driver.swipe(x, starty, x, endy, 500);
		//driver.swipe(x, starty, x, endy, 500);	
		
			TouchAction actions = new TouchAction(driver);
			actions.press(startElement).waitAction(Duration.ofSeconds(2)).moveTo(endElement).release().perform();*/
				
	}
	
	

