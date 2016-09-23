package tripPlanner;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.TripPlanner.Trip;

public class TripPlanner_Device 
{
	

	@Test(dataProvider="Trip",dataProviderClass=utility.TestNG.class)
	private void verifyTripPlannervalidCheck(String From, String to, String date, String time) throws Exception,MalformedURLException
	{
		
	 
	// Create object of  DesiredCapabilities class and specify android platform
	DesiredCapabilities capabilities=DesiredCapabilities.android();
	 
	 
	// set the capability to execute test in chrome browser
	 capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
	 
	// set the capability to execute our test in Android Platform
	   capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
	 
	// we need to define platform name
	  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	 
	// Set the device name as well (you can give any name)
	 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"my phone");
	 
	 // set the android version as well 
	   capabilities.setCapability(MobileCapabilityType.VERSION,"5.1.1");
	 
	 // Create object of URL class and specify the appium server address
	 URL url= new URL("http://127.0.0.1:4723/wd/hub");
	 
	// Create object of  AndroidDriver class and pass the url and capability that we created
	 WebDriver driver = new AndroidDriver(url, capabilities);
	 
	// Open url
	  driver.get("http://dev.cttransit.webship.com/");
	  
	  Trip trip = new Trip(driver);
	  trip.EnterFrom(From);
	  trip.EnterTo(to);
		trip.EnterDate(date);
		trip.EnterTime(time);
		trip.Go();
		 String Expected = "Local agency information:";
	        Assert.assertEquals(driver.findElement(By.cssSelector(".adp-agencies>div>b")).getText(), Expected);		
	        
	       // Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	        System.out.println("--------Test Passed : User is able to search Trip successfully!!!! ");
	        driver.quit();
	        
}
}