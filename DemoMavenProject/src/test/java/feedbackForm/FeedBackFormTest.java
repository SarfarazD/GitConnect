package feedbackForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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

public class FeedBackFormTest extends ReportMain

{
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
/*
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
	 
	driver.get("D:\\Report\\FeedBack_Form_Report.html");
	}
	*/
	/* Test 1: 
	 * Verify that user can able to fill the feedback form
	*/ 
	
	@Test(dataProvider="Feedback",dataProviderClass=utility.TestNG.class)
	private void FeedbackCheck(String fname, String lname, String email, String desc) throws Exception
	{
		 WebDriverWait wait= new WebDriverWait(driver,20 );
		test = extent.startTest("Verify User is able to sent feedback form with valid input");	
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		Contact con = new Contact(driver);
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL+ "/contact/feedback_form");
		
		driver.manage().window().maximize();
		System.out.println("Test Scenario -1 : Verify User is able to send feedback form with valid input!! ");
		test.log(LogStatus.INFO, "1)Browser and application is up and runing");
		con.EnterFname(fname);
		test.log(LogStatus.INFO , "2) First Name value Entered!!");
		con.EnterLname(lname);
		test.log(LogStatus.INFO , "3) Last Name value Entered!!");
		con.EnterEmail(email);
		test.log(LogStatus.INFO , "4) Email Entered!!");
		SeleniumFunc.SelectValueFromDropdownList("ID", "edit-field-ff-nature-of-feedback", "Information Request");
		test.log(LogStatus.INFO , "5) Nature of feedback value is selected from Drop down list!!");
		SeleniumFunc.SelectValueFromDropdownList("ID", "edit-field-ff-service-area-type", "Hartford");
		test.log(LogStatus.INFO , "6) Service area type value is selected from Drop down list!!");
		
		con.EnterConcern(desc);
		test.log(LogStatus.INFO , "7) Detailed description of your concern field Entered!!");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".recaptcha-checkbox-checkmark")));
		con.captcha.click();
		test.log(LogStatus.INFO , "8) Captcha Clicked!!");
		Thread.sleep(2000);
		
		con.submit.click();
		test.log(LogStatus.INFO , "3)Clicked on Send Message button!!");
		
		test.log(LogStatus.PASS, "Feedback Form Sent Successfully!!" );
		Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
		
		
		
		
}
	@AfterMethod
    public void afterEachTest2(ITestResult result) {
        if (!result.isSuccess()) {
            test.log(LogStatus.FAIL, result.getThrowable());
            System.out.println("---- Test Failed. Please check Extent Report for more details");
        }
        
        extent.endTest(test);
        extent.flush();
    }
}
