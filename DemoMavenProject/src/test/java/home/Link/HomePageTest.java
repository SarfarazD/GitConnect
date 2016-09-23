package home.Link;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
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
import factory.Schedules.FactorySchedule;
import pageFactory.CM.LoginPage;
import pageFactory.CTHome.HomePage;
import utility.Browser;
import utility.Constants;
import utility.JavaHelpers;
import utility.SeleniumFunctions;

public class HomePageTest extends ReportMain{
	
	
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
	 
	driver.get("D:\\Report\\HomePage_Report.html");
	}
	
/*
	@Test
	public void verifyHomePageUIElements() throws Exception 
	{
		test = extent.startTest("Verify UI Elements of Home Page!!");	
		
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		//FactorySchedule fact = new FactorySchedule(driver);	
		HomePage page = new HomePage(driver);
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL);
		
		driver.manage().window().maximize();
		
		test.log(LogStatus.INFO, "1)Browser and Application is up and runing!!");
	
		if(SeleniumFunc.IsElementPresent("css", "#alerts-tab"))
		{
			test.log(LogStatus.INFO, "2) AletTab is available to User!!");
			
		}
		else
		{
			test.log(LogStatus.INFO,"Failure !! Alet Tab is not available to User!! "); 
			Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
		}
		
		if(SeleniumFunc.IsElementPresent("css", "#schedules-tab"))
		{
			test.log(LogStatus.INFO, "3) Schedule Tab is available to User!!");
		}
		else
		{
			test.log(LogStatus.INFO,"Failure !! Alet Tab is not available to User!! "); 
			Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
		}
		if(SeleniumFunc.IsElementPresent("css", "#trip-planner-tab"))
		{
			test.log(LogStatus.INFO, "4) Trip Planner Tab is available to User!!");
			
		}
		else
		{
			test.log(LogStatus.INFO,"Failure !! Trip Planner tab is not available to User!! "); 
			Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
		}
		
	}
	*/
	@Test
	public void TabBannerColor() throws Exception
	{
		test = extent.startTest("Verify After mouse click Tab banner color changes for Trip Planner, Aletrs and Schedules!!");	
		
		SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		//FactorySchedule fact = new FactorySchedule(driver);	
		HomePage page = new HomePage(driver);
		SeleniumFunc.ToGoToUrl(Constants.ApplicationURL);
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "1)Browser and Application is up and runing!!");
		//page.scheduleTab.click();
		
		
		System.out.println("Color of Schedule tab banner before mouse Click: "	+ page.TripColor.getCssValue("color"));
		test.log(LogStatus.INFO," Color of Schedule tab banner before mouse Click: "+ page.TripColor.getCssValue("color"));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(page.scheduleTab).click();
		page.scheduleTab.getCssValue("color");
		System.out.println("Color of Schedule tab banner after mouse ClicK : "	+ page.scheduleTab.getCssValue("color"));
		test.log(LogStatus.INFO," Color of Schedule tab banner after mouse ClicK : "+ page.scheduleTab.getCssValue("color"));
		
		
		test.log(LogStatus.INFO," Color of Alerts tab banner before mouse ClicK : "+ page.altTab.getCssValue("color"));
		page.altTab.click();
		test.log(LogStatus.INFO," Color of Alerts tab banner after mouse ClicK : "+ page.altTab.getCssValue("color"));
		
		
	}
}