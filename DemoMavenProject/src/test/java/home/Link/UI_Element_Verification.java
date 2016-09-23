package home.Link;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.CTHome.LoginPage;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

public class UI_Element_Verification {
	
	private WebDriver driver;
	 
	private Browser b = new Browser();
	JavaHelpers JH = new JavaHelpers();
	
	
	@Parameters({ "browser", "environment", "os" })
	@BeforeMethod
	public void setUp(String browser, String environment , String OS) throws Exception 
	{		
		driver= b.setUp(browser, environment, OS);
		
	}

	@AfterMethod
	public void teardown() throws Exception
	{
		
		b.tearDown();
	}
	
	
	
	
	/* Test 1: 
	 * Verify UI of Login page
	*/ 

	@Test
	private void Login_UIElementVerification() throws Exception
	{
		
	
		System.out.println("====" + "\n" +
					"Test 1 : Verify UI of Login page"  + "\n" +
		 			"====");
		Reporter.log("====" + "\n" +
		 			  "Test 1 : Verify UI of Login page"  + "\n" +
				 	  "====");	
		
		int AssertFailedCount=0 ;
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
	
		System.out.println("Step 1 : Navigate to Login page : " + Constants.ApplicationURL + "/user/login");
		Reporter.log("Step 1 : Navigate to Login page : " + Constants.ApplicationURL+ "user//login"); 
			
			SeleniumFunc.ToGoToUrl(Constants.ApplicationURL+ "user/login");
		
	
		System.out.println("Step 2 : Verifying presence of UI elements : Email Textbox,Password Textbox,Forgot Password Link,Login Button ");
		Reporter.log("Step 2 : Verifying presence of UI elements : Email Textbox,Password Textbox,Forgot Password Link,Login Button "); 	
			
			if(SeleniumFunc.IsElementPresent("css", "#edit-name"))
			{
				
				System.out.println("Success !! Username Textbox is present");
				Reporter.log("Success !! Username Textbox is present"); 
			}
			else
			{
				System.out.println("Failure !! Username Textbox is NOT present ");
				Reporter.log("Failure !! Username Textbox is NOT present "); 
				AssertFailedCount++;
			}
			
			
			if(SeleniumFunc.IsElementPresent("css", "#edit-pass"))
			{
				
				System.out.println("Success !! Password Textbox is present");
				Reporter.log("Success !! Password Textbox is present"); 
			}
			else
			{
				System.out.println("Failure !! Password Textbox is NOT present ");
				Reporter.log("Failure !! Password Textbox is NOT present "); 
				AssertFailedCount++;
			}
			
			
			if(SeleniumFunc.IsElementPresent("css", "#edit-submit"))
			{
				
				System.out.println("Success !! Login button is present");
				Reporter.log("Success !! Login button is present"); 
			}
			else
			{
				System.out.println("Failure !! Login button is NOT present ");
				Reporter.log("Failure !! Login button is NOT present "); 
				
				AssertFailedCount++;
				
			}
			
			
			
			/*
			if(SeleniumFunc.IsElementPresent("css", "a[href='https://kps.staging.kalkomey.com/password/recover']"))
			{
				
				System.out.println("Success !! Forgot Password link is present");
				Reporter.log("Success !! Forgot Password link is present"); 
			}
			else
			{
				System.out.println("Failure !! Forgot Password link is NOT present");
				Reporter.log("Failure !! Forgot Password link is NOT present"); 
				AssertFailedCount++;
			}
		*/
			
		/*
		 * Marking Test Pass or Fail as per the value of AssertFailedCount variable
		 */
	
	
	 	if(AssertFailedCount>0)	
		{
			
			//Marking this test as Failed
			
			System.out.println("---- Test Failed. Please check the console or TestNg report for details");
			Reporter.log("---- Test Failed. Please check the console or TestNg report for details");
			
			Assert.fail();
		}
		
	}
	
	
	
	
}
