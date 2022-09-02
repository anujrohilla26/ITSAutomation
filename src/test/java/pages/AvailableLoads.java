package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AvailableLoads extends BasePage{

	String welcomeText="welcome-message";
	String AvilableLoads = "//*[@class='nav nav-tabs']//li[1]";
	String AvilableLoadsCount = "//*[@class='nav nav-tabs']//li[1]//span";
	String FirstRow = "//*[@class='viewed ng-star-inserted'][1]";
	String BidButton = "//Button[@class='mat-focus-indicator its-bid-default-button mat-raised-button mat-button-base its-bid-button']";
	String InterestButton = "//Button[@class='mat-focus-indicator ml-a mat-raised-button mat-button-base its-interested-button']";
	String FlatRate = "//input[@id='mat-input-2']";
	String Submit = "//button[@class='mat-focus-indicator its-submit-button mat-raised-button mat-button-base']";
	String BidNow = "//*[@class='viewed ng-star-inserted'][1]//a";
	String searchField = "//input[@placeholder='Enter ITS Load Number']";
	String searchButton="//div[contains(@class,'search-input')]//mat-icon";
	String VerificationBid = "//*[contains(text(),'Thank you for submitting a bid!')]";
	String VerificationInterest = "//*[contains(text(),'Thank you for submitting a Interest!')]";
	String LoadingImage = "";
	String reloadTab="//li[contains(text(),'Reloads')]";
	String viewTrips = "//a[contains(text(),'View Trips')]";
	String reloadTripView = "//span[@class='its-modal-title']";
	String bookNowButton = "(//span[contains(text(),'Book Now')])[last()]";
	String submit = "//span[contains(text(),'Submit')]";
	String confirmationModal = "//img[contains(@src,'/modal')]";
	String thankyouText="//div[contains(@class,'modal-response-title')]";
	String carrierCommitmentMessage ="//div[contains(text(),'An ITS')]";
	String confirmationMessageText = "//div[contains(text(),'A con')]";
	String closeModal = "//div[contains(@class,'close')]";
	String blankHeart = "(//mat-icon[contains(text(),'favorite_border')])[last()]";
	String filledHeart = "(//mat-icon[contains(text(),'favorite')])[last()]";
	String refresh = "(//mat-icon[contains(text(),'refresh')])[last()]";
	String analyticsTab = "//li[contains(text(),'Analytics')]";
	String additionalOutboundText = "//span[contains(text(),'Additional')]";
	String link = "(//div[contains(@class,'underline-color')])[last()]";
	String availableLoadsFromPanel = "//a[contains(text(),'Available Loads')]";
	

	public String getWelcomeText(WebDriver driver) {
		return getText(welcomeText,Types.CLASSNAME);
	}

	public String getAvailableLoads(WebDriver driver) {
		return getText(AvilableLoadsCount,Types.XPATH);
	}

	public String getReloadTripsViewTitle(WebDriver driver) {
		waitForElementVisiblity(reloadTripView,Types.XPATH);
		return getText(reloadTripView,Types.XPATH);
	}

	public void clickLoad(WebDriver driver) {
		click(FirstRow, Types.XPATH);
	}
	
	public void clickAvailableLoadsFromPanel(WebDriver driver) {
		waitForElementVisiblity(availableLoadsFromPanel, Types.XPATH);
		click(availableLoadsFromPanel, Types.XPATH);
	}
	
	public void clickHyperlink(WebDriver driver) {
		click(link, Types.XPATH);
	}
	public void clickAnalyticsTab(WebDriver driver) {
		waitForElementVisiblity(analyticsTab, Types.XPATH);
		click(analyticsTab, Types.XPATH);
	}
	
	
	public void clickClose(WebDriver driver) {
		waitForElementVisiblity(closeModal, Types.XPATH);
		click(closeModal, Types.XPATH);
	}

	public void clickOnBookNow(WebDriver driver) {
		//scrollToElement(bookNowButton, Types.XPATH);
		click(bookNowButton, Types.XPATH);
		clickOnSubmitButton(driver);
	}

	public void clickReload(WebDriver driver) {
		waitForElementVisiblity(reloadTab,Types.XPATH);
		click(reloadTab, Types.XPATH);
	}

	public void clickOnAvailableLoads(WebDriver driver) {
		waitForElementVisiblity(AvilableLoads, Types.XPATH);
		click(AvilableLoads, Types.XPATH);
	}

	public void clickOnViewTrips(WebDriver driver) {
		waitForElementVisiblity(viewTrips, Types.XPATH);
		click(viewTrips, Types.XPATH);
	}
	public void clickOnSubmitButton(WebDriver driver) {
		waitForElementVisiblity(submit, Types.XPATH);
		click(submit, Types.XPATH);
	}


	

	public void clickOnBlankHeartIcon(WebDriver driver) {
		hardWait(6000);
		if (getWebElements(blankHeart, Types.XPATH).size()>0)
			click(blankHeart, Types.XPATH);
		else {
			click(filledHeart, Types.XPATH);
			click(blankHeart, Types.XPATH);

		}
	}


	public void clickOnFilledHeartIcon(WebDriver driver) {
		hardWait(5000);
		waitForElementVisiblity(filledHeart, Types.XPATH);
		click(filledHeart, Types.XPATH);
	}

	public void enterLoadNumber(WebDriver driver,String loadNumber) {
		waitForElementVisiblity(searchField,Types.XPATH );
		sendKeys(searchField, Types.XPATH,loadNumber);
		waitForElementVisiblity(searchButton,Types.XPATH );
		click(searchButton, Types.XPATH);


	}
	
	

	public void raiseBid(WebDriver driver) throws InterruptedException {
		click(FirstRow, Types.XPATH);
		Thread.sleep(30000);
		for(int i =1;i<10;i++) {

			click("//*[@class='viewed ng-star-inserted'][1]",Types.XPATH);
			if(isEnabled(BidButton, Types.XPATH)) {
				break;
			}
		}

		click(BidButton,Types.XPATH);
		sendKeys(FlatRate, Types.XPATH, "100");
		click(Submit,Types.XPATH);

	}

	public void raiseInterest(WebDriver driver) throws InterruptedException {
		click(FirstRow, Types.XPATH);
		Thread.sleep(30000);
		for(int i =1;i<10;i++) {
			//click("//*[@class='viewed ng-star-inserted'and position()=i]",Types.XPATH);

			click("//*[@class='viewed ng-star-inserted'][1]",Types.XPATH);
			if(isEnabled(InterestButton, Types.XPATH)) {
				break;
			}
		}

		click(InterestButton,Types.XPATH);
		//sendKeys(FlatRate, Types.XPATH, "100");
		click(Submit,Types.XPATH);

	}

	public boolean verifyBidThankYouMsg() {

		return isElementDisplayed(VerificationBid, Types.XPATH);

	}
	public boolean verifyInterestThankYouMsg() {	
		waitForElementVisiblity(VerificationInterest, Types.XPATH);
		return isElementDisplayed(VerificationInterest, Types.XPATH);

	}

	public boolean getFilledHeart() {	
		waitForElementVisiblity(filledHeart, Types.XPATH);
		return isElementDisplayed(filledHeart, Types.XPATH);

	}

	public boolean getBlankHeart() {
		hardWait(5000);
		waitForElementVisiblity(blankHeart, Types.XPATH);
		return isElementDisplayed(blankHeart, Types.XPATH);

	}
	public boolean verifyConfirmationModalForITS() {
		return isElementDisplayed(confirmationModal, Types.XPATH);

	}
	public String getThankyouText(WebDriver driver) {
		waitForElementVisiblity(thankyouText, Types.XPATH);
		return getText(thankyouText, Types.XPATH);

	}

	public String getCarrierCommitmentMessage(WebDriver driver) {
		waitForElementVisiblity(carrierCommitmentMessage, Types.XPATH);
		return getText(carrierCommitmentMessage, Types.XPATH);

	}
	
	public String getAdditionalOutboundsText(WebDriver driver) {
		waitForElementVisiblity(additionalOutboundText, Types.XPATH);
		return getText(additionalOutboundText, Types.XPATH);

	}

	public String getConfirmationMessageText(WebDriver driver) {
		waitForElementVisiblity(confirmationMessageText, Types.XPATH);
		return getText(confirmationMessageText, Types.XPATH);

	}
}
