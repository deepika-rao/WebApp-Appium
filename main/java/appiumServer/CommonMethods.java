package appiumServer;

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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonMethods extends AppiumServerInitialization{
	
	public CommonMethods(AppiumDriver<AndroidElement> driver)
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
	
	// use this method when elements are in WebView
	public void getWebViewText(String classname, String xpath)
	{
		System.out.println("First Current Context : "+driver.getContext());
		driver.findElementByClassName(classname).click();
		for(int i=0;i<=20;i++)
		{
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementByXPath(xpath).click();
				break;
			} catch (Exception e) {
				//verticalSwipe();
			}
		}
		// Using this method we switch to web view/native_app
		switchContext("WEBVIEW");
		String webViewText = driver.findElementByXPath(xpath).getText();
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
	
	private void verticalScroll() {
        TouchAction action = new TouchAction(driver);
        action.press(535, 1486).waitAction().moveTo(250,200).release().perform();
    }
	
	private WebElement scrollViewArea() {
        return driver.findElementByAccessibilityId("listview");
    }
	
	public void swipeScrollView() {
        Dimension size = scrollViewArea().getSize();
        new TouchAction(driver).press(scrollViewArea(), size.width / 2, (size.height * 3) / 4).waitAction().moveTo(size.width / 2, size.height / 4).release().perform();
    }
	
}
	

