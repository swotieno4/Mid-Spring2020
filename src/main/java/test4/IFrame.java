package test4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {
//IFrame is a web page which is embedded in another web page or an HTML document 
	// embedded inside another HTML document.
	/*
	 * 3 ways to identify: It can be identified in the Firefox browser if the option
	 * named ‘This frame’ is displayed on the right-click options By inspecting the
	 * source code and searching for the tag <iframe> or <frameset> By using the
	 * following code: driver.findElements(By.tagName("iframe")).size();
	 */
	/*
	 * 3 ways to switch between frames: By Index: driver.switchTo().frame(0); By
	 * Name or Id: driver.switchTo().frame(“name of the element");
	 * driver.switchTo().frame("id of the element"); By Web Element: 
	 * driver.switchTo().frame(WebElement);
	 */

	WebDriver driver;

	@Before //always runs before every test case
	public void launchBrowser() {
		//Setting the property
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Launchbrowser1\\drivers\\chromedriver.exe");
		// Creating web driver instance
		 driver = new ChromeDriver();
		// maximizing browser
		driver.manage().window().maximize();
		//get to the site
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@Test
	public void loginTest() throws InterruptedException {
	driver.switchTo().frame("packageListFrame");
	driver.findElement(By.linkText("java.awt")).click();
	
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("packageFrame");
	driver.findElement(By.xpath("/html/body/div/ul[1]/li[2]/a/span")).click();
	
	
	}
}
