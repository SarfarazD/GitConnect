package factory.Report;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;

public abstract class ReportMain {
    protected ExtentReports extent;
    protected final String filePath = "D:\\Report\\CTtransit_Test_Execution_Report.html";
    
    @BeforeClass
    public void beforeClass() {
        extent = ExtentManager.getReporter(filePath);
    }
    
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}