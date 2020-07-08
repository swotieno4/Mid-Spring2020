package test4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {
	

	WebDriver driver;

	//ALERT/POPUP: small message box displayed on the screen to give some kind of information
    //or ask for permission to perform certain kind of operation. 
	//To click on the 'Cancel' button:     driver.switchTo().alert().dismiss();
	//To click on the 'OK' button:     driver.switchTo().alert().accept();
	//To capture the alert message:     driver.switchTo().alert().getText();
	//To send some data to alert box:     driver.switchTo().alert().sendKeys("Text");
	
	@Before //always runs before every test case
	public void launchBrowser() {
		//Setting the property
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Launchbrowser1\\drivers\\chromedriver.exe");
		// Creating web driver instance
		 driver = new ChromeDriver();
		// maximizing browser
		driver.manage().window().maximize();
		//get to the site
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(3000);
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
	}
	
	/*@After //always runs after every test case
	public void closebrowser() {
		driver.quit();*/
	}
 /*   Anything in the middle is commented out     */

