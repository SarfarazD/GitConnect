package factory.Report;

import java.io.File;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class Utility 
{
public static String captureScreenshot(WebDriver driver,String screenshotName)
{
 
try 
{
TakesScreenshot ts=(TakesScreenshot)driver;
 
File source=ts.getScreenshotAs(OutputType.FILE);
 
FileUtil.copyFile(source, new File("./Screenshots/"+screenshotName+".jpg"));
 
System.out.println("Screenshot taken");
} 
catch (Exception e)
{
 
System.out.println("Exception while taking screenshot "+e.getMessage());
}
return screenshotName; 
}
}