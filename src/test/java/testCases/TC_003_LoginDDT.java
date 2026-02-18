package testCases;

import org.testng.annotations.Test;

import pageObject.loginPage;
import testBase.baseClass;
import utilities.loginDataProvider;

public class TC_003_LoginDDT extends baseClass 
{

	@Test(dataProvider = "loginProvider", dataProviderClass = loginDataProvider.class)
	public void loginDDT(String uname, String pwd, String resp) throws InterruptedException 
	{
		logger.info("Starting of TC_003_LoginDDT");
		loginPage lp =new loginPage(driver);
		lp.addUname(uname);
		Thread.sleep(2000);
		logger.info("Entered uname");
		lp.addcredentials(pwd);
		logger.info("Entered credential");
		Thread.sleep(2000);
		logger.info("Clicked on login button");
		lp.clickLogin();
		
		
		logger.info("Ending of TC_003_LoginDDT");
	}
}
