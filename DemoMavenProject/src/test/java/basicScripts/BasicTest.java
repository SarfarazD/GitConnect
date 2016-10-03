package basicScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import factory.Report.ReportMain;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;	


public class BasicTest extends ReportMain {
	
	
	@Test
	private void Test() throws Exception
	{
		
		 WebDriver driver = new HtmlUnitDriver();
		 driver.get("https://qa1.boat-ed.com/");
		
		 driver.findElement(By.cssSelector(".dropdown-toggle")).click();
		 
		 List<WebElement> list=driver.findElements(By.cssSelector("#state-listing"));
		 
		 
		 
		    System.out.println("No of links present="+ list.size());
		    
		  
		   for(WebElement wb: list){
		        System.out.println(wb.getText());
		        
		   // for(int i=0;i<list.size();i++){
		        //System.out.println(list.get(i).getAttribute("href"));
		    }
		    System.out.println("end of test");
		    
		    driver.quit();
		 
		
		/*
		driver.manage().window().maximize();
		driver.get("http://clarionwebsiteqa.com/");

		System.out.println("-----Automatic Buid Execution is Done when user commit and push the code in GitHub  Server-----");
		driver.close();*/
	}
}