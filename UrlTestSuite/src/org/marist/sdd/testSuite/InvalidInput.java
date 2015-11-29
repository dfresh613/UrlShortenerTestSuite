package org.marist.sdd.testSuite;

import static org.junit.Assert.assertTrue;

import org.marist.sdd.testSuite.constants.ShortenerConstants;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidInput extends UrlShortenerTestCase {

	private final String bothInfoMissingErrorId = "//div[contains(.,'Missing information: Long URL Desired Id')]";
	private final String longUrlMissingErrorId = "//div[contains(.,'Missing information: Long URL')]";
	private final String desiredIdMissingErrorId = "//div[contains(.,'Missing information:  Desired Id')]";
	
	
	public InvalidInput(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public void performTestCase() throws InterruptedException {
		Thread.sleep(1000);
		//attempt to click the submit with no data entered. Validate that there is an error message
		WebElement panelSubmitEle = waitAndGetElement(new ByXPath(ShortenerConstants.PANEL_SUBMIT_ID));
		panelSubmitEle.click();
		assertTrue(waitAndGetElement(new ByXPath(bothInfoMissingErrorId)).isDisplayed());
		
		//attempt to enter with desiredId missing
		WebElement longUrlInputEle = waitAndGetElement(new ByXPath(ShortenerConstants.LONG_URL_INPUT_ID));
		longUrlInputEle.sendKeys("testEntry");
		panelSubmitEle.click();
		assertTrue(waitAndGetElement(new ByXPath(desiredIdMissingErrorId)).isDisplayed());
		longUrlInputEle.clear();
		
		//attempt to enter with long url missing
		WebElement desiredIdInputEle = waitAndGetElement(new ByXPath(ShortenerConstants.DESIRED_INPUT_ID));
		desiredIdInputEle.sendKeys("testEntry");;
		panelSubmitEle.click();
		assertTrue(waitAndGetElement(new ByXPath(longUrlMissingErrorId)).isDisplayed());
		
		//reload the page to do invalid checks on the modal
		initializeSite();
		
		//make sure both errors are shown
		waitAndGetElement(new ByXPath(ShortenerConstants.NAV_SUBMIT_ID)).click();;
		assertTrue(waitAndGetElement(new ByXPath(bothInfoMissingErrorId)).isDisplayed());
		waitAndGetElement(new ByXPath(ShortenerConstants.MODAL_CLOSE_BUTTON_ID)).click();
		initializeSite();
		
		//check desiredId missing
		WebElement navUrlInputEle = waitAndGetElement(new ByXPath(ShortenerConstants.NAV_URL_INPUT_ID));
		navUrlInputEle.sendKeys("testEntry");
		waitAndGetElement(new ByXPath(ShortenerConstants.NAV_SUBMIT_ID)).click();;
		assertTrue(waitAndGetElement(new ByXPath(desiredIdMissingErrorId)).isDisplayed());
		waitAndGetElement(new ByXPath(ShortenerConstants.MODAL_CLOSE_BUTTON_ID)).click();
		initializeSite();

		
		
		//check longUrl missing
		WebElement navDesiredIdEle = waitAndGetElement(new ByXPath(ShortenerConstants.NAV_ID_INPUT_ID));
		navDesiredIdEle.sendKeys("testEntry");
		waitAndGetElement(new ByXPath(ShortenerConstants.NAV_SUBMIT_ID)).click();;
		assertTrue(waitAndGetElement(new ByXPath(longUrlMissingErrorId)).isDisplayed());
		waitAndGetElement(new ByXPath(ShortenerConstants.MODAL_CLOSE_BUTTON_ID)).click();
	}

}
