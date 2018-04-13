package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import appiumServer.AppiumServerInitialization;
import appiumServer.CommonMethods;
import io.appium.java_client.AppiumDriver;

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
		
		//commonmethods.getWebViewText("icon-menu-fine", "//*[@class='sub-menu']");	
		
		driver.findElement(By.xpath("//*[@class='icon-menu-fine']")).click();
		
		Thread.sleep(2000);
		
		WebElement submenu = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-item-772']")));
		
		submenu.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id='menu-item-200']")).click();
		
		//WebElement services = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='menu-toggle']")));
		
		//Select services = new Select(driver.findElement(By.xpath("//*[@class='menu-toggle']")));
		
		//services.selectByVisibleText("Microsoft .Net");
		
		//driver.findElement(By.xpath("//*[@class='icon-menu-fine']")).click();
		
		//Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//*[@id='menu-item-200']")).click();
		
		//WebElement microsoft = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-item-200']")));
		
		//microsoft.click();		
		
	}
	
	

}
