package basicScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Report.ReportMain;
import factory.Report.Utility;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;



public class BasicTest extends ReportMain {
	
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
	@Test
	private void Test() throws Exception
	{
		test = extent.startTest("Verify User is able to search the trip!!");	
		
		//SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
	
		//SeleniumFunc.ToGoToUrl(Constants.ApplicationURL);
		
		
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.findElement(By.id("gs_htif0")).sendKeys("Software");
		System.out.println("Done 123");
		System.out.println("12111");
	}
}