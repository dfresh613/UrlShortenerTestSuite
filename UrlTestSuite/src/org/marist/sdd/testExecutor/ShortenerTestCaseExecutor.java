package org.marist.sdd.testExecutor;

import org.junit.BeforeClass;
import org.junit.Test;
import org.marist.sdd.testSuite.CreateUrl;
import org.marist.sdd.testSuite.InvalidInput;
import org.marist.sdd.testSuite.SiteNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShortenerTestCaseExecutor {
	public static WebDriverWait wait;
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
	}
	
	@Test
	public void executeInvalidInputTest() throws InterruptedException{
		InvalidInput invalidInputTest = new InvalidInput(driver,wait);
		invalidInputTest.performTestCase();
	}
	@Test
	public void  executeSiteNavigationTest() throws InterruptedException{
		SiteNavigation siteNavigate = new SiteNavigation(driver,wait);
		siteNavigate.performTestCase();		
	}
	
	@Test
	public void executeUrlCreationTest() throws InterruptedException{
		CreateUrl urlCreationTest = new CreateUrl(driver, wait);
		urlCreationTest.performTestCase();
	}
}
