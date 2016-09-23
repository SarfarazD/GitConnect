package home.Link;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Report.ReportMain;

public class TestCase2 extends ReportMain

{
	

private ExtentTest test;
    
    @Test
    public void Test2() {
    	System.out.println("Test");
    	//test.log(LogStatus.INFO, " Print Started");
        test = extent.startTest("Verify Report Generates for Test Case2");
        test.log(LogStatus.PASS, "Test cases2 report generated successfully" );
        test.log(LogStatus.INFO, " Started");
        
        Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
    }
    
    @AfterMethod
    public void afterEachTest2(ITestResult result) {
        if (!result.isSuccess()) {
            test.log(LogStatus.FAIL, result.getThrowable());
        }
        
        extent.endTest(test);
        extent.flush();
    }
}