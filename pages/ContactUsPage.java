package pages;

import appiumServer.AppiumServerInitialization;
import appiumServer.CommonMethods;
import io.appium.java_client.AppiumDriver;

public class ContactUsPage extends AppiumServerInitialization{
	
private AppiumDriver appiumDriver;
	
	CommonMethods commonmethods;
	
	public ContactUsPage(AppiumDriver appiumDriver)
	{
	//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.appiumDriver=appiumDriver;
	}
	
	public void ClickContactUs()
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "//*[@id='menu-item-199']");
	}
	
	public void YourName()
	{
		commonmethods = new CommonMethods(driver);
		
		driver.findElementByXPath("//input[@name='your-name']").sendKeys("test");
	}
	
	public void YourEmail()
	{
		commonmethods = new CommonMethods(driver);
		
		driver.findElementByXPath("//input[@name='your-email']").sendKeys("test");
	}
	
	public void Subject()
	{
		commonmethods = new CommonMethods(driver);
		
		driver.findElementByXPath("//input[@name='your-subject']").sendKeys("test");
	}
	
	public void YourMessage()
	{
		commonmethods = new CommonMethods(driver);
		
		driver.findElementByXPath("//textarea[@name='your-message']").sendKeys("test");
	}
	
	

}
