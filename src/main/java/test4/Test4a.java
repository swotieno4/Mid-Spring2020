package test4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert; 

public class Test4a {
	
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
		// Identify the user name field pass username
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
				// Identify the password field pass password
		By PASSWORD_BY_FIELD_LOCATOR = By.id("password");
				driver.findElement(PASSWORD_BY_FIELD_LOCATOR).clear();
				driver.findElement(PASSWORD_BY_FIELD_LOCATOR).sendKeys("abc123");
				// Identify the signing button and click
				driver.findElement(By.name("login")).click();
				//Stopping the browser for 2 sec
				Thread.sleep(2000);
		// to identify error once you import the error on the console, click on any empty space
		// on the console while the carser is blinking press control A and it will highlight
		//everything on the console copy it and paste on your note pad,go back to your code and copy 
		// the class name then press control F and look for your class name. Make sure you press Up or down based 
				// of the position.	or press control F on the console to make it simple. 	
												
		//	varType varName = varValue;
		//	String str = "abcd";
				//int num= 5;
			
		//store web element		
			// implicit wait declared at the beginning of the script and applies to all webElement
			//and explicit WAIT when implicit wait is not enough we use explicit wait
		//EXPECTED CONDITIONS: 
				//elementToBeClickable();
				//invisibilityOfTheElementLocated();
				//presenceOfElementLocated();
				//visibilityOfElementLocated();
		//WebElement DASHBOARD_PAGE_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), ' Dashboard ')]"));
		By DASHBOARD_ELEMENT_BY_LOCATOR = By.xpath("//h2[contains(text(), ' Dashboard ')]");
	
		boolean	pageTitleDisplayStatus;	
		try {
			WebElement DASHBOARD_PAGE_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), ' Dashboard ')]"));
			 pageTitleDisplayStatus = true;
		}catch(NoSuchElementException e) {
			 pageTitleDisplayStatus = false;
			// e.printStackTrace(); used to check for errors on the console
		}
	
		WebDriverWait Wait = new WebDriverWait(driver, 3);
		
		//Wait.until(ExpectedConditions.visibilityOf(DASHBOARD_PAGE_TITLE_ELEMENT));
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(DASHBOARD_ELEMENT_BY_LOCATOR));
		//ASSERTIONS is validation in Selenium. ARE BASED ON COMPARISON OF ACTUAL AND EXPECTED RESULTS.
		//COMMON USED ASSERTIONS: assert true, assert false,assert equals and assert not equal.
	
		Assert.assertTrue("Dashboard Page not Found! ",pageTitleDisplayStatus);
	
		driver.close();
		driver.quit();
		// Exceptions: NoSuchElementException, FileNotFoundExceptions, TimeoutException,
		//IOException
	}	
}