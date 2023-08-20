package Company.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;

import CompanyName.SeleniumFramework.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
	public WebDriver driver;
	public Landingpage landingpage;
	public WebDriver initializeDriver() throws IOException 
	{
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//seleniumMainJava//resources//GlobalData.properties" );
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public Landingpage launchApplication() throws IOException
	{
		driver = initializeDriver();
		landingpage = new Landingpage(driver);
		landingpage.goTo();
		return landingpage;
	}
	/*@AfterMethod
	public void tearDown()
	{
		driver.close();
	}*/
}
