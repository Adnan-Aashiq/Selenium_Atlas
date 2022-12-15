package TestSuite;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class FillFormLocators 
{
	ExtentTest test = null;
	WebDriver driver= null;
	JavascriptExecutor jse= null;
	
	public FillFormLocators (WebDriver driver,ExtentTest test) {
		this.test = test;
		this.driver= driver;
		jse = (JavascriptExecutor) driver;
	}

	public void ClickElementsButton()
	{
		jse.executeScript("scroll(0, 250)");
		WebElement element = driver.findElement(By.xpath("//h5[normalize-space()='Elements']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();	
		test.log(Status.PASS, "Verify User can click on Element Button");
	}
	
	public void ClickTextBox()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).click();	
		test.log(Status.PASS, "Verify User can click on TextBox");
	}
	
	public void EnterContactInformation(String fullName,String email,String currentAddress,String permamnentAddress)
	{
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(fullName);
		test.log(Status.PASS, "Verify User has written his/her FullName");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
		test.log(Status.PASS, "Verify User has written his/her Email");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(currentAddress);
		test.log(Status.PASS, "Verify User has written his/her Current Address");
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(permamnentAddress);
		test.log(Status.PASS, "Verify User has written his/her Permanent Address");
	}
	
	public void ClickSubmitButton()
	{
		jse.executeScript("scroll(0, 250)");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		test.log(Status.PASS, "Verify User has clicked on Submit Button");
	}
	public void VerifyInputdata(String fullName,String email,String currentAddress,String permamnentAddress)
	{
		try{
			String nametext= driver.findElement(By.xpath("//p[@id='name']")).getText();
			String[] text = nametext.split(":");
			String text1 = text[1];
			assertEquals(text1, fullName);
			test.log(Status.PASS, "Verify Names are equal");
			
		}catch(AssertionError e){
			test.log(Status.FAIL, "Verify Names are not equal");
		}
		
		try{
			String nametext= driver.findElement(By.xpath("//p[@id='email']")).getText();
			String[] text = nametext.split(":");
			String text1 = text[1];
			assertEquals(text1, email);
			test.log(Status.PASS, "Verify Emails are equal");
			
		}catch(AssertionError e){
			test.log(Status.FAIL, "Verify Emails are not equal");
		}
		
		try{
			String nametext= driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
			String[] text = nametext.split(":");
			String text1 = text[1];
			assertEquals(text1, currentAddress);
			test.log(Status.PASS, "Verify Current Addresses are equal");
			
		}catch(AssertionError e){
			test.log(Status.FAIL, "Verify Current Addresses are not equal");
		}
		
		try{
			String nametext= driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
			String[] text = nametext.split(":");
			String text1 = text[1];
			assertEquals(text1, permamnentAddress);
			test.log(Status.PASS, "Verify Permamnent Addresses are equal");
			
		}catch(AssertionError e){
			test.log(Status.FAIL, "Verify Permamnent Addresses are not equal");
		}
		
	}
}
