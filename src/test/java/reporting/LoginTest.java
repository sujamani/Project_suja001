package reporting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	static WebDriver driver;
	@BeforeClass
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test
	public void Login()
	{
		driver.get("https://login.salesforce.com/");
		 driver.findElement(By.id("username")).sendKeys("akshay0412@tekarch.com");

	        driver.findElement(By.id("password")).sendKeys("Krithik1112");

	        driver.findElement(By.xpath("//input[@id='Login']")).click();
	        Assert.assertEquals(driver.getTitle(),"Home Page ~ Salesforce - Developer Edition");

	}
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
	@AfterMethod
	public void captureScreen(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
			FileUtils.copyFile(source,target);
			System.out.println("screenshot captured");
		}
	}
	}

