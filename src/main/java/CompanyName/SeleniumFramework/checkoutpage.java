package CompanyName.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CompanyName.AbstractComponents.abstractcomponents;

public class checkoutpage extends abstractcomponents {

	static WebDriver driver;
	public checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".action_submit")
	WebElement submit;
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;
	By results=By.cssSelector(".ta-tesults");
	public void selectcountry(String countryName) 
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-tesults"));
		selectcountry.click();
	}
	public confirmationpage submitorder()
	{
		submit.click();
		return new confirmationpage(driver);
	}
}
