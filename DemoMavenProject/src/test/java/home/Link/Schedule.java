package home.Link;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageFactory.TripPlanner.Trip;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Report.ReportMain;
import factory.Report.Utility;
import factory.Schedules.FactorySchedule;

public class Schedule extends ReportMain {
	
	private WebDriver driver;
	private Browser b = new Browser();
	JavaHelpers JH = new JavaHelpers();
	private ExtentTest test;
	
	
	@Parameters({ "browser", "environment", "os" })
	
	@BeforeTest
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
	 
	driver.get("D:\\Report\\Schdeule_Report.html");
	}
	
	@Test
	private void verifySchedule() throws Exception
	{
		test = extent.startTest("Verify User is able to search the Schedules!!");	
		
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		FactorySchedule fact = new FactorySchedule(driver);	
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL+ "/schedules");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "1)Browser and application is up and runing");
		
		fact.Enter_RouteTex();
		test.log(LogStatus.INFO, " 2) Entered the route name!!");
		fact.RouteName.click();
		fact.go.click();
		test.log(LogStatus.INFO, " 3) Clicked on Go button");
		
		String expected  = "Testing Route Alerts";
		Assert.assertEquals(driver.findElement(By.cssSelector(".route-title")).getText(), expected);		
        
        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
		
	}
	
	@Test
	private void VerifyUI() throws Exception
	{
		test = extent.startTest("Verifying presence of UI elements : Enter Route Number or name Auto-Complete Field, and Go button");	
		
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		FactorySchedule fact = new FactorySchedule(driver);	
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL+ "/schedules");
		
		driver.manage().window().maximize();
		
		test.log(LogStatus.INFO, "1)Browser and Application is up and runing!!");
		
		if(SeleniumFunc.IsElementPresent("css", "#edit-combine-route-name-no"))
		{
			
			System.out.println("Success !! Route Name or number autocomplete field is present!!");
			test.log(LogStatus.INFO, "Success !! Route Name or number autocomplete field is present!!"); 
			Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
		}
		else
		{
			System.out.println("Failure !! Route Name or number autocomplete field is NOT present ");
			test.log(LogStatus.INFO,"Failure !! Route Name or number autocomplete field is NOT present "); 
			Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
		}
		
		
		if(SeleniumFunc.IsElementPresent("css", "#edit-submit-schedules"))
		{
			
			System.out.println("Success !! Go Button is present!!");
			test.log(LogStatus.INFO, "Success !! Go button is present!!"); 
			Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
		}
		else
		{
			System.out.println("Failure !! Go Button is NOT present ");
			test.log(LogStatus.INFO,"Failure !! Go button is NOT present "); 
			Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
		}
		
	}

}
