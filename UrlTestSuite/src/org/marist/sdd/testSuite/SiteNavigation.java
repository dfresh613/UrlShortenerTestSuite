package org.marist.sdd.testSuite;

import org.openqa.selenium.By.ByXPath;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteNavigation extends UrlShortenerTestCase {

	private final String popularLinksPanelId = "//h3[contains(.,'Most popular links')]";
	private final String urlMapsLinkId = "//a[contains(.,'URL Maps')]";
	private final String urlMapsPanelId  = "//div[contains(.,'URL Maps')]";
	
	public SiteNavigation(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public void performTestCase() throws InterruptedException {
		//Make sure popular links panel is on the homepage
		assertTrue(waitAndGetElement(new ByXPath(popularLinksPanelId)).isDisplayed());
		
		//click to UrlMaps page
		waitAndGetElement(new ByXPath(urlMapsLinkId)).click();
		
		//validate urlMaps page contains data
		assertTrue(waitAndGetElement(new ByXPath(urlMapsPanelId)).isDisplayed());
	}

}
