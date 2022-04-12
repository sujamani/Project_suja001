package parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExample {

	WebDriver driver=null;
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test(dataProvider="users")
	public void loginTest(String uname,String pwd)
	{
		driver.get("https://login.salesforce.com/");
		 driver.findElement(By.id("username")).sendKeys(uname);

	        driver.findElement(By.id("password")).sendKeys(pwd);

	        driver.findElement(By.xpath("//input[@id='Login']")).click();
	        Assert.assertEquals(driver.getTitle(), "Home Page ~ Salesforce - Developer Edition");

		
		
	}
	@DataProvider(name="users")
	String [][] loginData()
	{
		String [][]data= { {"akshay0412@tekarch.com","Krithik1112"},{"sana1","sana"}};
		return data;	
		
	}
	@AfterClass
	void closeBrowser()
	{
		
	}
}
