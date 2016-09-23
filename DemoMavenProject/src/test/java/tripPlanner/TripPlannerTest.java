package tripPlanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Report.ReportMain;
import factory.Report.Utility;
import pageFactory.Feedback.Contact;
import pageFactory.TripPlanner.Trip;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;



public class TripPlannerTest extends ReportMain {
	
	private WebDriver driver;
	private Browser b = new Browser();
	JavaHelpers JH = new JavaHelpers();
	private ExtentTest test;
	
	
	@Parameters({ "browser", "environment", "os" })
	@BeforeMethod
	public void setUp(String browser, String environment , String OS) throws Exception 
	{		
		driver= b.setUp(browser, environment, OS);
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) 
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
	 
	String screenshot_path=Utility.captureScreenshot(driver, result.getName());
	String image= test.addScreenCapture(screenshot_path);
	test.log(LogStatus.FAIL, "Title verification", image);
	 
	 
	}
	 
	extent.endTest(test);
	extent.flush();
	 
	driver.get("D:\\Report\\CTtransit_Test_Execution_Report.html");
	}

	/* Test 1: 
	 * Verify that user can login with valid credentials
	*/ 
	@Test(dataProvider="Trip",dataProviderClass=utility.TestNG.class)
	private void verifyTripPlannervalidCheck(String From, String to, String date, String time) throws Exception
	{
		test = extent.startTest("Verify User is able to search the trip!!");	
		
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		Trip trip = new Trip(driver);	
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL+ "/trip-planner");
		
		driver.manage().window().maximize();
		System.out.println("Test Scenario -2 : Verify User is able to to search the Trip!! ");
		test.log(LogStatus.INFO, "1)Browser and application is up and runing");
		//trip.ClickOnTrip();
		//test.log(LogStatus.INFO, " 2)On Home Page clicked on Trip Planner tab!!");
		trip.EnterFrom(From);
		test.log(LogStatus.INFO, " 2) Entered the FROM field, taken value from excel sheet.");
		trip.EnterTo(to);
		test.log(LogStatus.INFO, " 3) Entered TO field, taken value from excel sheet.");
		trip.EnterDate(date);
		test.log(LogStatus.INFO, " 4) Blank Date field as its not mandatory!!");
		trip.EnterTime(time);
		test.log(LogStatus.INFO, " 5) Entered the TIME field, taken value from excel sheet.");
		trip.Go();
		test.log(LogStatus.INFO, " 6) Clicked on Go Button!!");
		
		test.log(LogStatus.PASS, "User is able to search Trip successfully!!" );
        String Expected = "Local agency information:";
        Assert.assertEquals(driver.findElement(By.cssSelector(".adp-agencies>div>b")).getText(), Expected);		
        
        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
        System.out.println("--------Test Passed : User is able to search Trip successfully!!!! ");
		
}
	/*
	@Test(dataProvider="Feedback",dataProviderClass=utility.TestNG.class)
	private void FeedbackCheck(String fname, String lname, String email, String desc) throws Exception
	{
		 WebDriverWait wait= new WebDriverWait(driver,20 );
		test = extent.startTest("Verify User is able to sent feedback form with valid input");	
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		Contact con = new Contact(driver);
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL+ "/contact/feedback_form");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "1)Browser and application is up and runing");
		con.EnterFname(fname);
		con.EnterLname(lname);
		con.EnterEmail(email);
		
		SeleniumFunc.SelectValueFromDropdownList("ID", "edit-field-ff-nature-of-feedback", "Information Request");
		SeleniumFunc.SelectValueFromDropdownList("ID", "edit-field-ff-service-area-type", "Hartford");
	
		
		con.EnterConcern(desc);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".recaptcha-checkbox-checkmark")));
		con.captcha.click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO , "2)Verify all mandatory fields are Entered!!");
		con.submit.click();
		test.log(LogStatus.INFO , "3)Clicked on Send Message button!!");
		
		test.log(LogStatus.PASS, "Feedback Form Sent Successfully!!" );
		Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	
	
	}*/
}