package appiumServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public abstract class AppiumServerInitialization {

	 private AppiumDriverLocalService service;
	 private DesiredCapabilities cap;
	 private AppiumServiceBuilder builder;
	 protected static AppiumDriver<MobileElement> driver;
	 static Properties properties;
	 String node_js_Path="C:\\Program Files\\nodejs\\node.exe";
	 String appium_js_path="C:\\Program Files\\Appium\\node_modules\\appium\\build\\lib\\main.js";

@BeforeMethod
public void appiumInitialization() throws IOException
{
	
	properties = new Properties();
	
	File f = new File(System.getProperty("user.dir")+"\\src\\properties_file\\config.properties");
	
	FileReader obj = new FileReader(f);
	
	properties.load(obj);
	
	  builder = new AppiumServiceBuilder();
	  builder.usingDriverExecutable(new File(node_js_Path));
	  builder.withAppiumJS(new File(appium_js_path));
	  builder.withIPAddress("0.0.0.0");
	  builder.usingPort(4723);
	  //builder.usingAnyFreePort();
	  builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
	  
	  service = AppiumDriverLocalService.buildService(builder);	
	  
	  service.start();
	  
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("PLATFORM_NAME"));						
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("DEVICE_NAME"));
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
		
		cap.setCapability("chromedriverExecutable", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		//cap.setCapability(MobileCapabilityType.APP, properties.getProperty("APP"));
		
		cap.setCapability("appWaitPackage", "com.android.chrome");
		
		cap.setCapability("appWaitActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Appium Server started");
		
		//driver.get("http://www.google.com");
		
		//driver.navigate().to("http://www.google.com");
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		  
}

@AfterMethod
public void stopAppiumService()
{
	driver.quit();
	
	System.out.println("Close the Browser");
	
	service.stop();	
}

/*@Test
public void startAppiumService()
{
	//service.start();
	System.out.println("Appium service is Started");	
}*/
















}
