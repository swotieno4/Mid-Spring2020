package test4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
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
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
	
	@Test
	public void loginTest() throws InterruptedException {
		WebElement PRODUCTS_MENU_LOCATOR = driver.findElement(By.xpath("//*[@id=\"l1\"]"));
		WebElement MONITOR_MENU_LOCATOR = driver.findElement(By.xpath("/html/body/main/header/div[3]/nav/ul/li[1]/ul/li[9]/a/span"));
		WebElement MONITOR_FOR_HOME = driver.findElement(By.xpath("/html/body/main/header/div[3]/nav/ul/li[1]/ul/li[9]/ul/li[1]/a/img"));
		Actions action = new Actions(driver);
		action.moveToElement(PRODUCTS_MENU_LOCATOR).build().perform();
		action.moveToElement(MONITOR_MENU_LOCATOR).build().perform();
		//action.moveToElement(MONITOR_FOR_HOME).build().perform();
		//When our driver can identify it we do not need to hover over but use click.
		MONITOR_FOR_HOME.click();
		/*action.clickAndHold() - Click (without releasing) at the current mouse location.
action.doubleClick() - Performs a double-click at the current mouse location.
action.dragAndDrop(source, target) - Performs click-and-hold at the location of the source element, moves to the location of the target element, then releases the mouse.
action.dragAndDropBy(source, x-offset, y-offset) - Performs click-and-hold at the location of the source element, moves by a given offset, then releases the mouse.
action.moveToElement(toElement) - Moves the mouse to the middle of the element. 
action.release() - Releases the depressed left mouse button at the current mouse location */

	}
}