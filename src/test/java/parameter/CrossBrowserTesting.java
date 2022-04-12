package parameter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CrossBrowserTesting {

	WebDriver driver=null;
	@Parameters("browser") 
	@Test(priority=1)
	public void launchUrl(String br)
	{if(br.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\k_man\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver=new ChromeDriver();
		
	}
	else if (br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\k_man\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new FirefoxDriver();
	}
	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver","C:\\Users\\k_man\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.get("https://google.com");
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
	}
	@Test(priority=2)
	public void verifyTitle()
	{
		Assert.assertEquals(driver.getTitle(),"https://google.com");
	}
	@Test(priority=3)
	public void login()
	{
		System.out.println("login method");
	}
	@Test(priority=4)
	public void logout()
	{
		
		System.out.println("logout method");
	}
}
