package CompanyName.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CompanyName.AbstractComponents.abstractcomponents;

public class Cartpage extends abstractcomponents 
{
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	public Cartpage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		public boolean VerifyProductDisplay(String productName)
	{
		boolean match= cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	 public checkoutpage goTocheckout()
	 {
		 checkoutEle.click();
		 return checkoutpage();
	 }
	private checkoutpage checkoutpage() {
		
		return null;
	}
	}
