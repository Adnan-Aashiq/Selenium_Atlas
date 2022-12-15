package TestSuite;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import Resources.ExtentReporterNG;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends ExtentReporterNG{
	WebDriver driver = null;
	public static ExtentTest test;
	@BeforeMethod
	public void SetCapabilities() throws MalformedURLException 
	{
		// This command will download suitable chrome driver
		WebDriverManager.chromedriver().setup();  
		
		// Initialize driver
		driver = new ChromeDriver();		
	}
}
