package TestSuite;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FillFormTestCases extends Base
{
	
	@BeforeMethod
	public void VisitWebsite() throws InterruptedException
	{
		driver.manage().window().maximize();   // Maximize current window
		driver.get("https://demoqa.com/");     // Visit URL			
	}

	@Test(dataProvider = "FormData", dataProviderClass= Provider.class)
	public void FillForm(JSONObject d) throws InterruptedException, IOException, ParseException
	{
		test= extent.createTest("Form Testing");	
		FillFormLocators Form= new FillFormLocators(driver,test);
	
		Form.ClickElementsButton();
		Form.ClickTextBox();
		Form.EnterContactInformation((String) d.get("FullName"),(String) d.get("Email"),(String) d.get("CurrentAddress"),(String) d.get("PermamnentAddress"));
		Form.ClickSubmitButton();
		Form.VerifyInputdata((String) d.get("FullName"),(String) d.get("Email"),(String) d.get("CurrentAddress"),(String) d.get("PermamnentAddress"));
		driver.close();
	}
}
