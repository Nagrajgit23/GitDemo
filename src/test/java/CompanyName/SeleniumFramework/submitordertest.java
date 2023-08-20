package CompanyName.SeleniumFramework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Company.TestComponents.BaseTest;

public class submitordertest extends BaseTest {
	@Test
	public void submiOreder() 
		{
		String productName = "ZARA COAT 3";
		ProductCatalogue productcatalogue = landingpage.LoginApplication("nagaraj6@gmail.com","Sure1234");
		List<WebElement> getproductsBy= productcatalogue.products();
		productcatalogue.addproductTocart(productName);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		Cartpage cartpage = productcatalogue.goToCartPage();
		boolean match = cartpage.VerifyProductDisplay(productName);               
		Assert.assertTrue(match);
		checkoutpage checkoutpage= cartpage.goTocheckout();
		checkoutpage.selectcountry("india");
		confirmationpage confirmpage= checkoutpage.submitorder();
		String ConfirmMessage= confirmpage.getconfirmationMessage();
		Assert.assertTrue(true, ConfirmMessage);
	}

}
