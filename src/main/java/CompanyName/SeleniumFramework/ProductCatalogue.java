package CompanyName.SeleniumFramework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import CompanyName.AbstractComponents.abstractcomponents;

public class ProductCatalogue extends abstractcomponents
{
	public ProductCatalogue(WebDriver driver) 
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement Spinner;
	By productsBy = By.cssSelector(".mb-3");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	List<WebElement> products()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
		public WebElement getproductsBy(String productName)
	{
		WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null); 
		return prod;
		
	}
		public void addproductTocart(String productName)
		{
		WebElement prod = getproductsBy(productName);
		prod.findElement(addTocart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(Spinner);
		}
}
