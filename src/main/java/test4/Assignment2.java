package test4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.org.apache.bcel.internal.generic.Select;

public class Assignment2 {
	
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
				Thread.sleep(2000);
				driver.findElement(By.xpath("//i[@class='icon-users']")).click();
				//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
				driver.findElement(By.linkText("Add Customer")).click();
				Thread.sleep(2000);
				
	
				driver.findElement(By.id("account")).sendKeys("Simon Otieno");
				driver.findElement(By.xpath("//*[@id=\"cid\"]/option[2]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("email")).sendKeys("swotienoabc2@yahoo.com");
				driver.findElement(By.id("address")).sendKeys("224 New York");
				
				Thread.sleep(2000);
				driver.findElement(By.id("phone")).sendKeys("2222444");
				driver.findElement(By.id("city")).sendKeys("New York");
				driver.findElement(By.id("select2-country-container"));
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"group\"]/option[3]")).click();
				
				
				driver.findElement(By.id("submit")).click();
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				driver.findElement(By.linkText("List Customers")).click();
				driver.findElement(By.linkText("Simon Otieno")).click();
				
				//need to use assert and use webElement
				
		}
	

}
