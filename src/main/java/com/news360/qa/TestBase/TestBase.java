package com.news360.qa.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.news360.qa.util.EventHandler;
import com.news360.qa.util.UtilClass;

public class TestBase {

public static WebDriver driver;	
public static Properties prop;
public static String browser;
public String url;
public static EventFiringWebDriver eventDriver;

public TestBase() throws IOException
{	
	System.out.println("TestBase: Property Initialization");
	prop = new Properties();
	FileInputStream ip=new FileInputStream("C:\\Users\\PurviPC\\Documents\\workspace\\News360TestAutomation\\src\\main\\java\\com\\news360\\qa\\config\\config.properties");
	prop.load(ip);
	browser = prop.getProperty("browser");
}

	
	public static void initialization ()throws IOException 
	{
		//new TestBase();
		System.out.println("TestBase: Initialization method");
		if (browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PurviPC\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		eventDriver= new EventFiringWebDriver(driver);
		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		driver=eventDriver;
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(UtilClass.pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.waitTime, TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("Dumb");
		}
		
	}
	
	public void closeBrowser()
	{
		System.out.println("TestBase: Close Browser Method");
		driver.quit();
	}
	
}
