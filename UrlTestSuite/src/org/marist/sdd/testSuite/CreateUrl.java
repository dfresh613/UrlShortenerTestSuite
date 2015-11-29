package org.marist.sdd.testSuite;

import static org.junit.Assert.assertTrue;

import org.marist.sdd.testSuite.constants.ShortenerConstants;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUrl extends UrlShortenerTestCase{
	private final String urlSuccessLocator = "//h3[contains(.,'Shortened URL ready!')]";
	private final String backHomeId = "//button[@id='backHome']";
	private final String desiredIdString = "testId";
	private final String longUrlString = "https://www.youtube.com/watch?v=RSS1zh45Fts";
	private final String shortLinkId = "//a[@href='http://www.mini.com/?id="+desiredIdString+"']";

	public CreateUrl(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public void performTestCase() throws InterruptedException {
		waitAndGetElement(new ByXPath(ShortenerConstants.LONG_URL_INPUT_ID)).sendKeys(longUrlString);
		waitAndGetElement(new ByXPath(ShortenerConstants.DESIRED_INPUT_ID)).sendKeys(desiredIdString);
		Thread.sleep(1000);
		waitAndGetElement(new ByXPath(ShortenerConstants.PANEL_SUBMIT_ID)).click();
		assertTrue(waitAndGetElement(new ByXPath(urlSuccessLocator)).isDisplayed());
		
		waitAndGetElement(new ByXPath(backHomeId)).click();
		
		assertTrue(waitAndGetElement(new ByXPath(shortLinkId)).isDisplayed());
				
	}

}
