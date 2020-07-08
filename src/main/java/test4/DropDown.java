package test4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	WebDriver driver;
	@Before
	public void launchBrowser() {
		//Setting the property
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Launchbrowser1\\drivers\\chromedriver.exe");
		// Creating web driver instance
		 driver = new ChromeDriver();
		// maximizing browser
		driver.manage().window().maximize();
		//get to the site
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
	
	@Test
	public void loginTest() throws InterruptedException {
		// Identify the user name field
				driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
				// Identify the password field
				driver.findElement(By.id("password")).sendKeys("abc123");
				// Identify the signing button and click
				driver.findElement(By.name("login")).click();
				//Stopping the browser for 2 sec
			//Two ways of storing web elements:	
				//WebElement NAME_ELEMENT = driver.findElement(By.xpath(" "));
				//By NAME_LOCATOR = By.xpath(" ");
				//Explicit wait:
				//WebDriverWait wait = new WebDriverWait(driver, 60);
				//wait.until(ExpectedConditions.visibilityof(driver.findElement(By.name(" "))));
				//how to deal with dropdown:
				//use select class by using the object variable and using.by()visibletext
	driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
	WebElement COUNTRY_DROPDOWN_LOCATOR = driver.findElement(By.xpath("//select[@id='country']"));
	Select sel = new Select(COUNTRY_DROPDOWN_LOCATOR);
	sel.selectByVisibleText("Armenia");
		}
	

}
