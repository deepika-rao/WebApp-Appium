package pages;

import appiumServer.AppiumServerInitialization;
import appiumServer.CommonMethods;
import io.appium.java_client.AppiumDriver;

public class MenuList extends AppiumServerInitialization{
	
	private AppiumDriver appiumDriver;
	
	CommonMethods commonmethods;
	
	public MenuList(AppiumDriver appiumDriver)
	{
	//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.appiumDriver=appiumDriver;
	}	
	
	public void ClickAboutUs()
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "//a[contains(@href,'http://naarsoft.com/about-us/')]");
		
	}
	
	public void ClickHome()
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "//span[text()='Home']");
	}
	
	public void ClickCaseStudies()
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "//*[@id='menu-item-773']");
	}
	
	public void ClickPortfolio()
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "//*[@id='menu-item-241']");
	}
	
	public void ClickBlog()
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "//*[@id='menu-item-196']");
	}
	
	public void ClickContactUs()
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "//*[@id='menu-item-199']");
	}
	

}
