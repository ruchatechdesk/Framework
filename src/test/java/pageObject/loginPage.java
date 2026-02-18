package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.basePage;

public class loginPage extends basePage 
{

	public loginPage(WebDriver driver)
	{
		super(driver);
	}
	
	// page locators 
	@FindBy(id="email")
	WebElement txtuname;
	
	@FindBy(id="password")
	WebElement txt;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement buttonLogin;
	
	@FindBy()
	WebElement linkForgotPassword;
	
	
	// action methods
	public void addUname(String uname) 
	{
		txtuname.sendKeys(uname);
	}
	
	public void addcredentials(String credential) 
	{
		txt.sendKeys(credential);
	}
	
	public void clickLogin() 
	{
		buttonLogin.click();
	}
}
