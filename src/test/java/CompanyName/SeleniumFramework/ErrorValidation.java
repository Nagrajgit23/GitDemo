package CompanyName.SeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import Company.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	@Test
	public void submiOreder() 
		{
		String productName = "ZARA COAT 3";
		landingpage.LoginApplication("nagara@gmail.com","Sure01234");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		//div[@aria-label='Incorrect email or password.']
	}

}
