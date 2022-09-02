package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import pages.BasePage.Types;

public class DedicatedLaneDetailsPage extends BasePage{

	String dedicatedOpportunitiesTab = "//a[contains(text(),'Dedicated Opportunities')]";
	String thirdRow = "//*[@class='viewed ng-star-inserted'][3]";
	String searchField = "//input[@placeholder='Enter ITS Load Number']";
	String currentLoad ="//li[contains(text(),'Current Loads')]";
	String checkboxOfLoad="(//li[contains(text(),'Current Loads')]/../..//span[contains(@class,'mat-checkbox-i')])[last()]";
	String InterestedButtonIlluminated="//button[contains(@class,'mat-button-base interested-btn')]";
	String searchButton="//div[contains(@class,'search-input')]//mat-icon";
	String inactiveInterested ="//button[contains(@class,'interest-its-inactive-button')]";
	
	public void clickOnDedicatedOpportunitiesTab(WebDriver driver) throws InterruptedException {
		waitForElementVisiblity(dedicatedOpportunitiesTab, Types.XPATH);
		click(dedicatedOpportunitiesTab, Types.XPATH);
		Thread.sleep(50000);
	}

	public void clickOnLoad(WebDriver driver) throws InterruptedException {
		try {
			waitForElementVisiblity(thirdRow, Types.XPATH);
			waitForElementClickability(thirdRow, Types.XPATH);
			click(thirdRow, Types.XPATH);
		} catch (ElementClickInterceptedException e) {
			click(thirdRow, Types.XPATH);
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			click(thirdRow, Types.XPATH);
			e.printStackTrace();
			Thread.sleep(30000);

	}}
		
	public void clickOnCurrentLoadsTab(WebDriver driver) throws InterruptedException {
		waitForElementVisiblity(currentLoad, Types.XPATH);
		click(currentLoad, Types.XPATH);
		Thread.sleep(3000);

	}

	public void clickOnCheckbox(WebDriver driver) throws InterruptedException {
		waitForElementVisiblity(checkboxOfLoad, Types.XPATH);
		selectCheckBox(checkboxOfLoad, Types.XPATH);

	}
	public void enterDataInSearchField(WebDriver driver,String value) throws InterruptedException {
		waitForElementVisiblity(searchField, Types.XPATH);
		sendKeys(searchField, Types.XPATH,value);
		waitForElementVisiblity(searchField, Types.XPATH);
		click(searchButton,Types.XPATH);
	}

	public boolean VerifyInterestedButtonIsIlluminated() throws InterruptedException {
		Thread.sleep(4000);
		return isBtnEnabled(InterestedButtonIlluminated, Types.XPATH);
	}
	public boolean VerifyInterestedButtonIsDisabled() throws InterruptedException {
		Thread.sleep(4000);
		return isBtnEnabled(inactiveInterested, Types.XPATH);
	}

}

