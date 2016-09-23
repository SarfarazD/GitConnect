package home.Link;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageFactory.CTHome.LoginPage;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Report.ReportMain;
import factory.Report.Utility;

public class TestCase1 extends ReportMain

{
	private WebDriver driver;
	private ExtentTest test;
	private Browser b = new Browser();
	JavaHelpers JH = new JavaHelpers();
	
	
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
	 
	driver.get("D:\\Report\\CTtransit_Test_Execution.html");
	}

    
    @Test
    public void Verify_Login_Success() throws Exception
    
    {
    	
        test = extent.startTest("Verify that user can login with valid credentials");
      
        SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		LoginPage login = new LoginPage(driver);
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL + "/user/login");
		  test.log(LogStatus.INFO, " Step 1 : Navigate to Login page ");
		 
		  
		  	login.EnterUsername(Constants.CT_Username);
			login.EnterPassword(Constants.CT_Password);
			login.ClickOnLogInButton();
			test.log(LogStatus.INFO, " Step 2 : Login with valid credentials");
			 
			 
			 String ActualUserName=SeleniumFunc.GetElementText("css", ".js-quickedit-page-title.page-header").trim();
			 String Expected = "sarfaraz";
			 Assert.assertEquals(ActualUserName, Expected);
			 test.log(LogStatus.INFO, " Step 3 : Verifying whether user is logged successfully or not");
			 test.log(LogStatus.PASS, " Step 3 : Verifying whether user is logged successfully or not");
			 
			 
        test.log(LogStatus.PASS, "Test cases 1 repor generated successfully" );
        
        
        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
    }
    
}