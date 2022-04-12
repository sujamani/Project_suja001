package TestNgListeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	void setup() 
	{
		Assert.assertTrue(false);
	}
	@Test
	void loginbyemail()
	{
		Assert.assertTrue(true);
	}
	@Test(dependsOnMethods= {"setup"})
	void loginbyfacebook()
	{
		Assert.assertTrue(true);
	}
}
