package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	//TestNG stands for Test Unit frame work. 
		//good for html reports,diff annotations etc.
		//purpose is to design test cases in a systematic way. its open source available in jar files
		//http://dl.bintray.com/testng-team/testng-eclipse-release/
		//https://www.guru99.com/install-testng-in-eclipse.html

		//how to use different browsers
		String browser = "null";
		WebDriver driver;
		
		public void readconfig() {
			//Inputstream
			//BufferedReader
			//FileReader
			//Scanners
			Properties prop = new Properties();
			try {
				InputStream input = new FileInputStream("C:\\eclipse\\Class4Selenium\\src\\main\\java");
				prop.load(input);
				browser = prop.getProperty("browser");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		@BeforeTest
		public void init() {
			
		
			if(browser.equalsIgnoreCase("chrome")) {
			//setting up the property
				System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
				//creating webDriver instance
				
			}else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",".\\driver\\geckodriver2.exe");
			driver = new FirefoxDriver();
			//Setting the property
			System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
			// Creating web driver instance
			 driver = new ChromeDriver();
			}
			// maximizing browser
			//driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			//get to the site
			//driver.get("http://www.techfios.com/ibilling/?ng=admin/");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
				
			}
		
		@Test
		public void loginTest() throws InterruptedException {
			//element library
			By USER_FILED_Locator =By.id("username");
			By PASS_WORD_FIELD_LOCATOR = By.id("password");
			By SIGNIN_BOTTON_LOCATOR = By.name("login");
			
			//data
			String loginID = "demo@techfios";
			String password = "abc123";
			
			driver.findElement(USER_FILED_Locator).sendKeys(loginID);
			driver.findElement(PASS_WORD_FIELD_LOCATOR).sendKeys(password);
			driver.findElement(SIGNIN_BOTTON_LOCATOR).click();
			
			Thread.sleep(2000);
			}
		@AfterTest
		public void tearDown() {
			driver.close();
			driver.quit();

	}
  
  public void f() {
  }
}
