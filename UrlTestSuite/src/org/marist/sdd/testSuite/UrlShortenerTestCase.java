package org.marist.sdd.testSuite;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UrlShortenerTestCase {

	public WebDriverWait wait;
	public WebDriver driver; 
	
	public UrlShortenerTestCase(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		initializeSite();
		
	}

	
	public abstract void performTestCase() throws InterruptedException;
	
	protected WebElement waitAndGetElement(By byType){
		//Method locateMethod = By.class.getMethod(byType, String);
		//locateMethod.invoke(arg0, arg1)
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byType));
		return driver.findElement(byType);
	}
	protected void focusIframe(){
		this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mainLayoutFrame")));
		this.driver.switchTo().frame(driver.findElement(By.id("mainLayoutFrame")));
	}
	
	protected void initializeSite(){
		this.driver.get("localhost:8080/URLShortener/");
		focusIframe();
		
	}
}
