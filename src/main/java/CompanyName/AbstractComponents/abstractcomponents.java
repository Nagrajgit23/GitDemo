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
		@FindBy(css="[routerlink*='cart']")
		WebElement cartHeader;
	protected WebDriver driver;
	public abstractcomponents(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
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
		return null;
		
		
	}
}
