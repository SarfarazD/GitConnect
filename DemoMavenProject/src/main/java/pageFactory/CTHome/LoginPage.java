package pageFactory.CTHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class LoginPage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public LoginPage(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
	}
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
	@FindBy(css = "#edit-name")
	WebElement username;
	
	@FindBy(css = "#edit-pass")
	WebElement password;
	
	@FindBy(css = "#edit-submit")
	WebElement login;
	
	//Enter Username
	public void EnterUsername(String Username)
	{
		username.clear();
		username.sendKeys(Username);
	}
	
//Enter Password
	public void EnterPassword(String Password)
	{
		password.clear();
		password.sendKeys(Password);
	}
	
//Click on Login button
	public void ClickOnLogInButton()
	{
		login.click();
	}
	
	
	
}
