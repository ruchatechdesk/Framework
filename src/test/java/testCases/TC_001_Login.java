package testCases;

import org.testng.annotations.Test;

import pageObject.loginPage;
import testBase.baseClass;

public class TC_001_Login extends baseClass 
{

	@Test
	public void performLogin() throws InterruptedException 
	{
		logger.info("Starting of TC_001_Login");
		System.out.println("From login page");
		loginPage lp =new loginPage(driver);
		lp.addUname(prop.getProperty("email"));
		Thread.sleep(2000);
		logger.info("Entered uname");
		lp.addcredentials(prop.getProperty("password"));
		logger.info("Entered credential");
		Thread.sleep(2000);
		logger.info("Clicked on login button");
		lp.clickLogin();
		System.out.println("Clicked Logged in");
		logger.info("Clicked Logged in");
		logger.info("Ending of TC_001_Login");
	}
}
