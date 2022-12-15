package Resources;
import org.testng.IReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG implements IReporter 
{
	 public static ExtentReports extent =new ExtentReports();    //initiating here is very important
     public static ExtentSparkReporter htmlReporter;

	@BeforeSuite
	public void beforeSuiteSetup() 
	{
	     String filepath = System.getProperty("user.dir");
	     htmlReporter = new ExtentSparkReporter(filepath+"/Report.html");     
	     extent.attachReporter(htmlReporter);
	 }
	
	@AfterMethod(alwaysRun = true)
	public void afterSuite() 
	{
	     extent.flush();
	}
}