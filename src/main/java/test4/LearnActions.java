package test4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActions {
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
				
				//instead of using the click function to enter the site we used the below 
				//function as an alternative to.click();
				Actions act = new Actions(driver);
				act.sendKeys(Keys.RETURN).build().perform();
			// below is the formula of scrolling down a page	
			JavascriptExecutor js =	(JavascriptExecutor) driver;
			js.executeScript("scroll(0,500)");
			
		}
}
