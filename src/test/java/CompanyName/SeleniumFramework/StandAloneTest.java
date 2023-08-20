package CompanyName.SeleniumFramework;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		String productName="ZARA COAT 3";
		String email="nagaraj6@gmail.com";
		/* //driver.findElement(By.xpath("//a[normalize-space()='Forgot password?']")).click();
		driver.findElement(By.xpath("//a[@class='btn1']")).click(); // register button
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Nagaraj");
		driver.findElement(By.id("lastName")).sendKeys("Madhu");
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userMobile")).sendKeys("9655379370");
		driver.findElement(By.xpath("//select[@formcontrolname='occupation']/option[@value='2: Student']")).click();
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.id("userPassword")).sendKeys("Sure1234");
		driver.findElement(By.id("confirmPassword")).sendKeys("Sure1234");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		*/
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys("Sure1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		//Thread.sleep(1000);
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null); 
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-trigger")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement>cartproducts=driver.findElements(By.cssSelector(".cart h3"));
		Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action_submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-priary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
		}
}