package appiumServer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public abstract class AppiumServerInitialization {

	 private AppiumDriverLocalService service;
	 private DesiredCapabilities cap;
	 private AppiumServiceBuilder builder;
	 protected static AppiumDriver<AndroidElement> driver;
	 static Properties properties;
	 String node_js_Path="C:\\Program Files\\nodejs\\node.exe"; // Replace the  path
	 String appium_js_path="C:\\Program Files\\Appium\\node_modules\\appium\\build\\lib\\main.js"; // Replace the path

@BeforeClass
public void appiumInitialization() throws IOException
{
	
	properties = new Properties();
	
	File f = new File(System.getProperty("user.dir")+"\\src\\properties_file\\config.properties");
	
	FileReader obj = new FileReader(f);
	
	properties.load(obj);
	
	  builder = new AppiumServiceBuilder();
	  builder.usingDriverExecutable(new File(node_js_Path));
	  builder.withAppiumJS(new File(appium_js_path));
	  builder.withIPAddress("127.0.0.1");
	  builder.usingPort(4723);
	  //builder.usingAnyFreePort();
	  builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
	  
	  service = AppiumDriverLocalService.buildService(builder);	
	  
	  service.start();
	  
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("PLATFORM_NAME"));						
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("DEVICE_NAME"));
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
		
		cap.setCapability("chromedriverExecutable", "C:\\Program Files\\ChromeDriver\\chromedriver.exe"); // Use when Mobile chrome browser is less < 60.0 version
		
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		//cap.setCapability(MobileCapabilityType.APP, properties.getProperty("APP"));
		
		//cap.setCapability("appWaitPackage", "com.android.chrome");
		
		//cap.setCapability("appWaitActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
		
		try {
			
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		}catch (MalformedURLException e){
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Appium Server started");
		
		//driver.get("http://www.google.com");
		
		//driver.navigate().to("http://www.google.com");
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		  
}

@AfterMethod(enabled=true)
public void stopAppiumService()
{
	//driver.quit();
	
	//System.out.println("Close the Browser");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	service.stop();	
	
	System.out.println("Close the Browser");
}

}
