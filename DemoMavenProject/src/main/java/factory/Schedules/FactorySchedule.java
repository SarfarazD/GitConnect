package factory.Schedules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class FactorySchedule {
	
	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public FactorySchedule(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
	}
	
	@FindBy(css = "#schedules-tab")
	public WebElement schedule;
	
	@FindBy(css = "#edit-combine-route-name-no")
	public WebElement route;
	
	@FindBy( css = "#edit-submit-schedules")
	public WebElement go;
	
	@FindBy( xpath = " //*[contains(@class,'ui-autocomplete-field-field_route_id') and contains(text(), '23')]")
	public WebElement RouteName;
	
	@FindBy( css = ".route-title")
	public WebElement title;
	
	public void Schedule_Click()
	{
		schedule.click();
	}
	
	public void Enter_RouteTex()
	{
		route.sendKeys("t");
	}
	
	
	public void go_Click()
	{
		go.click();
	}
	
	
	

}
