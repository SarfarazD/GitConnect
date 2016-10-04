package basicScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import factory.Report.ReportMain;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;	


public class BasicTest extends ReportMain {
	
	
	@Test
	private void Test() throws Exception
	{
		/*
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDrivers/chromedriver.exe");
		   driver = new ChromeDriver();*/
		
		WebDriver driver = new HtmlUnitDriver();
		 driver.get("http://clarionwebsiteqa.com/");

		System.out.println("-----Automation Jenkins CI-----");
		driver.close();
	}
}