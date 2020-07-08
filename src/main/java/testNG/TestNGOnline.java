package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGOnline {
	//unit testing new generation frame work, designing test cases in a systematic way. it
	//is open source and available in JAR files. Generates good HTMl reports and gives good 
	//annotations. 
    //also called TDD-test driven development. allows you to build your test
	//cases in a systematic way. You can drive your cases using testnG frame work
	//TestNG uses annotations i.e@Beforeclass
	
	//pre-conditions annotation---starting with @Before
	@BeforeSuite
	public void setUp() {
		System.out.println("set up system property for chrome");
	}
	
	@BeforeTest
	public void lauchBrowser() {
		System.out.println("launch chrome Browser");
	}
	@BeforeClass
	public void login() {
		System.out.println("login to app");
	}
	/*
	 * when using different test in one test the sequence is:
	 * @beforeMethod
	 * @test-1
	 * @Aftermethod
	 * second test will follow:
	 * @before Method
	 * @test-2
	 * @AfterMethod
	 * @BeforeMethod
	 * @Test-3
	 * @AfterMethod
	 */
	@BeforeMethod
	public void enterURL() {
		System.out.println("enter URL");
	}
	//test cases---starting with @Test
	@Test
	public void googleTitleTest() {
	System.out.println("Google Title Test");	
	}
	@Test
	public void searchTest() {
		System.out.println("search test");
	}
	@Test
	public void googleLogoTest() {
		System.out.println("google logo test");
	}
	//post conditions --starting with @After
	@AfterMethod
	public void  logout() {
	System.out.println("log out from app");	
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("close browser");
	}
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
}	
	
