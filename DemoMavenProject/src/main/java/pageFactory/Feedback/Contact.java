package pageFactory.Feedback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constants;
import utility.JavaHelpers;

public class Contact 
{
	WebDriver driver;
	JavaHelpers JH = new JavaHelpers();
	
	public Contact(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WebDriverWaitDuration), this);
	}
	
	@FindBy(css = "#edit-field-ff-salutation-mr")
	public WebElement Mr;
	
	@FindBy(css = "#edit-field-ff-salutation-mrs")
	public WebElement Mrs;
	
	@FindBy(css = "#edit-field-ff-salutation-ms")
	public WebElement Ms;
	
	@FindBy(css="#edit-field-ff-first-name-0-value")
	WebElement fname;
	
	@FindBy(css="#edit-field-ff-last-name-0-value")
	WebElement lname;
	
	@FindBy(css="#edit-field-ff-address-actions-ief-add")
	WebElement NewAddress;
	
	@FindBy(css = "#edit-field-ff-address-form-inline-entity-form-field-ff-street-0-value--1rRijbk-7O4")
	public WebElement street;
	
	@FindBy(css = "#edit-field-ff-address-form-inline-entity-form-field-ff-city-0-value--tRhh9EuOtAI")
	public WebElement  city;
	

	@FindBy(css = "#edit-field-ff-address-form-inline-entity-form-field-ff-state-0-value--m81qkmUdnHE")
	public WebElement state;
	

	@FindBy(css = "#edit-field-ff-address-form-inline-entity-form-field-ff-zip-0-value--mgjQ6HbzmUs")
	public WebElement zip ;
	
	@FindBy(css = "#edit-field-ff-daytime-phone-0-value")
	public WebElement phone ;
	
	@FindBy(css = "#edit-mail")
	public WebElement email ;
	
	@FindBy(css = ".select2-selection__arrow")
	public WebElement natureOfFeedback ;
	
	@FindBy(css = "#select2-edit-field-ff-nature-of-feedback-result-876j-Information Request" )
	public WebElement infoReq ;
	
	@FindBy(css = ".select2-selection__arrow")
	public WebElement ServiceType ;
	
	@FindBy(css = "#select2-edit-field-ff-service-area-type-result-5r47-Express Bus")
	public WebElement Service ;
	
	@FindBy(css = "#edit-field-ff-date-of-incident-0-value")
	public WebElement date;
	
	@FindBy(css = "#edit-field-ff-time-of-incident-0-value")
	public WebElement time;
	
	@FindBy(css = "#edit-field-ff-bus-route-number-0-value")
	public WebElement BusRoute;
	
	@FindBy(css = "#edit-field-ff-bus-vehicle-number-0-value")
	public WebElement BusNum;
	
	@FindBy(css = "#edit-field-ff-location-of-incident-0-value")
	public WebElement location;
	
	@FindBy(css = "#edit-field-ff-employee-name-or-number-0-value")
	public WebElement emp;
	
	@FindBy(css ="#edit-field-ff-employee-was-m-f-male")
	public WebElement male;
	
	
	@FindBy(css ="#edit-field-ff-employee-was-m-f-female")
	public WebElement female;
	
	@FindBy(css ="#edit-field-ff-detailed-description-0-value")
	public WebElement description;
	
	@FindBy(css ="#edit-copy")
	public WebElement SelfCopy;
	
	@FindBy(css ="div.recaptcha-checkbox-checkmark")
	public WebElement captcha;
	
	
	@FindBy(css ="#edit-submit")
	public WebElement submit;
	
	public void EnterFname(String First)
	{
		fname.clear();
		fname.sendKeys(First);
	}
	
	public void EnterLname(String Last)
	{
		lname.clear();
		lname.sendKeys(Last);
	}
	
	public void EnterEmail(String mail)
	{
		email.clear();
		email.sendKeys(mail);
	}
	
	public void EnterConcern(String Desc)
	{
		description.clear();
		description.sendKeys(Desc);
	}
	
	
	
}



