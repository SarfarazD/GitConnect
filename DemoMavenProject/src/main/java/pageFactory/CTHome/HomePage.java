package pageFactory.CTHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class HomePage 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public HomePage(WebDriver driver)
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
	
		@FindBy(css="#alerts-tab")
		public
	    WebElement altTab;
		
		@FindBy(css="#schedules-tab")
		public WebElement scheduleTab;
		
		@FindBy(css="#trip-planner-tab")
	    WebElement tripTab;
		
		@FindBy(css ="#span.icon.glyphicon.glyphicon-search ")
		WebElement searchField;
		
		@FindBy( css = ".nav.nav-tabs")
		public WebElement TripColor;
		
		public void ClickOnAlert()
		{
			altTab.click();
		}
		
		public void ClickOnScheduleTab()
		{
			scheduleTab.click();
		}
		
		public void ClickOnTripTab()
		{
			tripTab.click();
		}
		
		public void SearchFieldBgColor()
		{
			searchField.getCssValue("background-color");
			Actions action = new Actions(driver);
			action.moveToElement(searchField).perform();
			
		}
		
		
		
		
}

