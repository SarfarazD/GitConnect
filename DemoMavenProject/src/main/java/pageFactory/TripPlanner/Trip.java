package pageFactory.TripPlanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class Trip 
{

	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public Trip(WebDriver driver)
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
	
		@FindBy(css="#edit-origin")
	    WebElement from;
		
		@FindBy(css="#edit-destination")
	    WebElement to;
		
		
		@FindBy(css="#edit-trip-planner-date")
		WebElement date;
		
		@FindBy(css="#edit-trip-planner-time")
		WebElement time;
		
		@FindBy(css="#edit-getdirection")
		WebElement go;
		
		@FindBy(css="#trip-planner-tab")
		WebElement tab;
		
		public void EnterFrom(String From)
		{
			from.clear();
			from.sendKeys(From);
		}
		
		public void EnterTo(String TO)
		{
			to.clear();
			to.sendKeys(TO);
		}
		
		
		public void EnterDate(String DATE)
		{
			date.clear();
			date.sendKeys(DATE);
		}
		
		public void EnterTime(String TIME)
		{
			time.clear();
			time.sendKeys(TIME);
		}
		
		public void Go()
		{
			go.click();
		}
		
		public void ClickOnTrip()
		{
			tab.click();
		}
		
	
}