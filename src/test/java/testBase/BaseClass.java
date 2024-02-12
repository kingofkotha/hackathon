package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public Properties properties;
	
	@BeforeTest
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
	
	logger = LogManager.getLogger(Test.class);
	
	FileInputStream propertiesFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	properties = new Properties();
	properties.load(propertiesFile);
		
	if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
 	{	
	DesiredCapabilities capabilities=new DesiredCapabilities();
	//os
	if(os.equalsIgnoreCase("windows"))
	{
		capabilities.setPlatform(Platform.WIN11);
	}
	else if(os.equalsIgnoreCase("mac"))
	{
		capabilities.setPlatform(Platform.MAC);
	}
	else
	{
		System.out.println("No matching os..");
		return;
	}
	//browser
	switch(br.toLowerCase())
	{
	case "chrome" : capabilities.setBrowserName("chrome"); break;
	case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
	default: System.out.println("No matching browser.."); return;
	}
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    }
 //If execution_env is local then run in local system
else if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
{
	//launching browser based on condition - locally
	switch(br.toLowerCase())
	{
	case "chrome": driver=new ChromeDriver(); break;
	case "edge": driver=new EdgeDriver(); break;
	default: System.out.println("No matching browser..");
				return;
	}
}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		//driver.get(p.getProperty("appURL"));
		driver.get("https://www.coursera.org/");
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void teardown() throws InterruptedException
	
	{	 
		Thread.sleep(3000);
		driver.quit();
	
	}


}
