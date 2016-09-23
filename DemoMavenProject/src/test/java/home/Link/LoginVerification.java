package home.Link;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageFactory.CTHome.LoginPage;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

public class LoginVerification {
	
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
	
	/* Test 2: 
	 * Verify that user can login with valid credentials
	*/ 
	

	@Test
	private void Valid_Login_Verification() throws Exception
	{
		System.out.println("====" + "\n" +
					"Test 2 : Verify that user can login with valid credentials"  + "\n" +
		 			"====");
		Reporter.log("====" + "\n" +
		 			  "Test 2 : Verify that user can login with valid credentials"  + "\n" +
				 	  "====");	
		
		int AssertFailedCount=0 ;
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		LoginPage login = new LoginPage(driver);
					
	
		System.out.println("Step 1 : Navigate to Login page : " + Constants.ApplicationURL + "/user/login");
		Reporter.log("Step 1 : Navigate to Login page : " + Constants.ApplicationURL + "/user/login"); 
			
			SeleniumFunc.ToGoToUrl(Constants.ApplicationURL + "/user/login");
	
		System.out.println("Step 2 : Login with valid credentials");
		Reporter.log("Step 2 : Login with valid credentials"); 
			
			login.EnterUsername(Constants.CT_Username);
			login.EnterPassword(Constants.CT_Password);
			login.ClickOnLogInButton();
			
		
		System.out.println("Step 3 : Verifying whether user is logged successfully or not");
		Reporter.log("Step 3 : Verifying whether user is logged successfully or not"); 
			
				
			
			String ActualUserName=SeleniumFunc.GetElementText("css", ".js-quickedit-page-title.page-header").trim();
			System.out.println(ActualUserName);
			
			if(ActualUserName.equals("sarfaraz"))
			{
				System.out.println("Success !! User logged in successfully");
				Reporter.log("Success !! User logged in successfully"); 
			}
			else
			{
				System.out.println("Failure !! User is not logged in successfully");
				Reporter.log("Failure !! User is not logged in successfully"); 
				AssertFailedCount++;
			}
			
			
		
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
