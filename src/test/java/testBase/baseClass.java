package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass 
{
	public WebDriver driver;
	public org.apache.logging.log4j.Logger logger;
	public Properties prop;
	
	
	@BeforeClass
	@Parameters({"browser","os"})
	public void testSetup(String browser, String os) throws IOException 
	{
		logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass());
		FileReader fr = new FileReader(".\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(fr);
		
		
		switch (browser.toLowerCase()) 
		{
		case "chrome":driver = new ChromeDriver();		break;
		case "firefox":driver = new FirefoxDriver();		break;
		case "edge":driver = new EdgeDriver();		break;
		default: logger.info("No default browser from testng xml");
			break;
		}
		
		System.out.println("From setup");
		logger.info("From setup file");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		driver.get(prop.getProperty("url"));
	}
	
	@AfterClass
	public void testTearDown() 
	{
		System.out.println("From tear down");
		logger.info("Clen up down");
		driver.quit();
	}
}
