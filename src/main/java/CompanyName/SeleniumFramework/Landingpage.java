 package CompanyName.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CompanyName.AbstractComponents.abstractcomponents;

public class Landingpage extends abstractcomponents
	{

	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement PasswordEle;
	@FindBy(id="login")
	WebElement Submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue LoginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		PasswordEle.sendKeys(password);
		Submit.click();
		ProductCatalogue productcatalogue=new ProductCatalogue(driver);
		return productcatalogue;
	}
	public String getErrorMessage() 
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText(); 
		 
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
