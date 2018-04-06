package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import config.AppiumServerInitialization;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage extends AppiumServerInitialization{
	
	public Homepage(AppiumDriver<AndroidElement> driver)
	{
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//@AndroidFindBy(xpath="//android.view.View[@index='1']")
	@AndroidFindBy(xpath="//*[contains(@class, 'icon-menu-fine')]")
	public WebElement Menu;
	
	@AndroidFindBy(xpath="//android.view.View[@accessibilityid='ABOUT US']")
	public WebElement AboutUs;	
	
	public void ClickMenu()
	{
		Menu.click();
	}
	
	public void ClickAboutUs()
	{
		AboutUs.click();
	}
	
	

}
