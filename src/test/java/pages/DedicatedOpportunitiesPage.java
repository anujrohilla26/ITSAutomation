package pages;

import org.openqa.selenium.WebDriver;

public class DedicatedOpportunitiesPage extends BasePage{
	
	CommonPage commonPage= new CommonPage();
	
	
	String CurrentLoadsTabCount = "//li[contains(text(),'Current Loads')]/span";
	String CurrentLoadsTableCount = "//div[@class='currentloads-second-section']//tbody/tr";
	String BookNowCloseButton = "div.side-content svg.cursor-pointer";
	String CloseModalText = "//div[@class='d-flex justify-content-center align-items-center modal-body-content']";
	String NoButton = "button.mat-focus-indicator.btn-apply";
	String Modal = "div.cdk-overlay-pane";
	String InterestButton = "//span[text()='Book Now ']/..//..//..//button[contains(@class,'mat-focus-indicator mat-raised-button mat-button-base interested-btn')]";
	String BidButton = "//span[text()='Book Now ']/..//..//..//button[contains(@class,'mat-focus-indicator mat-raised-button mat-button-base bid-btn')]";

	
	
	public int getCurrentLoadsTabCount(WebDriver driver) {
		commonPage.waitForLoaderInvisibility();
		String count = getText(CurrentLoadsTabCount, Types.XPATH);
		int intCount = Integer.parseInt(count);
		return intCount;
		
	}
	
	public int getCurrentLoadsTableCount(WebDriver driver) {
		commonPage.waitForLoaderInvisibility();
		String count = getText(CurrentLoadsTableCount, Types.XPATH);
		int intCount = Integer.parseInt(count);
		return intCount;
		
	}
	
	public void selectLoadFromCurrentLoadTable(String value)
	{
		String LoadRowNumber = "//div[@class='currentloads-second-section']//tbody/tr["+value+"]";
		click(LoadRowNumber, Types.XPATH);		
	}
	
	public void clickOnCloseButton() {
		click(BookNowCloseButton, Types.CSS);
	}
	
	public String getBookNowCloseModalText() {
		return getText(CloseModalText, Types.XPATH).trim();
	}
	
	public void clickNoButton()
	{
		click(NoButton, Types.CSS);
	}
	
	public boolean verifyConfirmationModalIsDisplayed()
	{
		return isElementDisplayed(Modal, Types.CSS);
	}
	public void clickOnInterestButton()
	{
		waitForElementVisiblity(InterestButton, Types.XPATH);
		click(InterestButton, Types.XPATH);
	}
	
	public void clickOnBidButton()
	{
		waitForElementVisiblity(BidButton, Types.XPATH);
		click(BidButton, Types.XPATH);
	}
	
	
	
	
}
