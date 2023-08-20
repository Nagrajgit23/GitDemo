package CompanyName.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CompanyName.SeleniumFramework.Cartpage;

	public class abstractcomponents 
	{
	protected WebDriver driver;
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	@FindBy(xpath="//div[aria-label='Incorrect email or password.']")
	protected WebElement errorMessage;
	public abstractcomponents(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	//.presenceOfElementLocated(By.xpath("//div[@id='results']")));
	}
	public void waitForWebElementToAppear(WebElement findBy)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf (findBy));
	}
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public Cartpage goToCartPage() 
	{
		cartHeader.click();
		Cartpage cartpage= new Cartpage(driver);
		return cartpage;
	}
		public OrderPage goToOrdersPage()
		{
			orderHeader.click();
			OrderPage orderPage = new OrderPage(driver);
			return orderPage;
		}
}
