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

public class WindowHandle {

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
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}

	@Test
	public void loginTest() throws InterruptedException {
		// Identify the user name field pass username
		System.out.println(driver.getTitle());
		//System.out.println(driver.getWindowHandle());
				driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys("xpath");
				driver.findElement(By.xpath("//button[@id='header-desktop-search-button']")).click();
				
				Thread.sleep(2000);
		//		driver.findElement(By.linkText("XPATH tutorial -w3schools")).click();
				for (String i :driver.getWindowHandles())  {
					System.out.println(i);
					driver.switchTo().window(i);
				}
			//	System.out.println((driver.getTitle()));
				driver.findElement(By.linkText("CSS")).click();
				//we switch our drivers to next windows by using window handler, using for loop
	}
}