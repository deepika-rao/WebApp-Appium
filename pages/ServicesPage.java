package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import appiumServer.AppiumServerInitialization;
import appiumServer.CommonMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class ServicesPage extends AppiumServerInitialization{
	
	private AppiumDriver appiumDriver;
	
	CommonMethods commonmethods;
	
	public ServicesPage(AppiumDriver appiumDriver)
	{
	//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.appiumDriver=appiumDriver;
	}
	
	public void ClickServices_MicrosoftNet() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "(//*[@class='menu-toggle'])[2]");	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-200']")).click();
		
		/*driver.findElement(By.xpath("//*[@class='icon-menu-fine']")).click();
		
		Thread.sleep(2000);
		
		// ---- use below when there are 2 matching nodes
		driver.findElement(By.xpath("(//*[@class='menu-toggle'])[2]")).click();*/
		
		// ---- Method 1
		/*List menu = driver.findElements(By.xpath("//*[@class='sub-menu']"));
		System.out.println(menu.size());
		
		((WebElement) menu.get(0)).click();*/
		
		
		// ---- Method 2
		/*int menu=driver.findElements(By.xpath("//*[@class='sub-menu']")).size();
		 
		driver.findElements(By.xpath("//*[@class='sub-menu']")).get(menu-1).click();*/
		
		// ---- Method 3		
		/*WebElement submenu = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-item-772']")));
		
		submenu.click();*/		
	}
	
	public void ClickServices_SharePointAdmin_Development() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "(//*[@class='menu-toggle'])[2]");	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-208']")).click();
		
	}
	
	public void ClickServices_MobileApplication_Development() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "(//*[@class='menu-toggle'])[2]");	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-205']")).click();
		
	}
	
	public void ClickServices_QAAutomation_Testing() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "(//*[@class='menu-toggle'])[2]");	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-211']")).click();
		
	}
	
	public void ClickOpenSource_PHPDevelopment() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "(//*[@class='menu-toggle'])[2]");	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@class='menu-toggle'])[1]")).click();	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-202']")).click();
		
	}
	
	public void ClickOpenSource_CMSECommerce() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "(//*[@class='menu-toggle'])[2]");	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@class='menu-toggle'])[1]")).click();	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-203']")).click();
		
	}
	
	public void ClickServices_DataAnalytics() throws InterruptedException
	{
		commonmethods = new CommonMethods(driver);
		
		commonmethods.getWebViewText("icon-menu-fine", "(//*[@class='menu-toggle'])[2]");	
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-423']")).click();
		
	}
		

}
