package TestNgListeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test started");
	}

	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test skipped");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test success");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Failed");
		
	}
}

