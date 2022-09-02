package builder;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import pages.BasePage;
import pages.BidPage;
import pages.CommonPage;
import pages.InterestedPage;
import pages.ProfilePage;
import pages.AvailableLoads;
import utility.Utils;

public class Home extends BasePage {

	Utils utils = new Utils();
	Map<String, String> data = new HashMap <String, String>();
	CommonPage commonPage = new CommonPage();
	AvailableLoads homePage = new AvailableLoads();
	ProfilePage profilePage = new ProfilePage();
	BidPage bidPage = new BidPage();
	InterestedPage interestedPage = new InterestedPage();

	public void verifyIfHomeDisplayed(String text,SoftAssert softAssert) {
		String welcome= homePage.getWelcomeText(driver);
		softAssert.assertEquals(welcome, text);
	}
	public void verifyIfSuccessfullySavedTextDisplayed(String expectedToast,SoftAssert softAssert) {
		String actualToastMsg= commonPage.getSuccessfullySavedText(driver);
		softAssert.assertEquals(actualToastMsg, expectedToast);
	}

	public void verifyAvailbleLoads() {
		String LoadCount= homePage.getAvailableLoads(driver);
		if(Integer.parseInt(LoadCount) > 0) {
			System.out.println(LoadCount);
		}	
	}

	public void verifyModalTitle(String expectedTitle,SoftAssert softAssert) {
		String actualTitle= homePage.getReloadTripsViewTitle(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}



	public void selectViewTrips(String loadNumber) throws InterruptedException {
		homePage.clickOnAvailableLoads(driver);
		homePage.enterLoadNumber(driver,loadNumber);
		homePage.clickLoad(driver);
		homePage.clickReload(driver);
		homePage.clickOnViewTrips(driver);
	}

	public void navigateToReloadTab(String loadNumber) throws InterruptedException {
		homePage.clickOnAvailableLoads(driver);
		homePage.enterLoadNumber(driver,loadNumber);
		homePage.clickLoad(driver);
		homePage.clickReload(driver);
	}
	
	public void navigateToModuleFromLeftPanel(String moduleName) throws InterruptedException {
		commonPage.navigateToModuleFromLeftNavigationPanel(driver,moduleName);
	}

	public void enterFlatRateValue(String value) throws InterruptedException {
		bidPage.enterFlatRate(driver,value);
	}

	public void addSecondaryNumber(String secondNumber) throws InterruptedException {
		profilePage.clickOnThreeDots(driver);
		profilePage.clickOnProfile(driver);
		profilePage.enterSecondaryPhoneNumber(driver,secondNumber);
	}
	
	public void clickOnInterestedButton() throws InterruptedException {
		interestedPage.clickOnInterestedButton(driver);
	}
	
	
	public void clickDeleteContainer() throws InterruptedException {
		profilePage.clickOnDeleteContainerForSecondaryNumber(driver);
	}

	public void clickBeginVaultDemo() throws InterruptedException {
		profilePage.clickOnBeginWithVaultDemo(driver);
	}


	public void clickSubmit() throws InterruptedException {
		commonPage.clickOnSubmit();


	}
	public void navigateToBidNow() throws InterruptedException {
		homePage.clickOnAvailableLoads(driver);
		bidPage.clickOnAvailableBid();
	}
	
	public void navigateToInterested() throws InterruptedException {
		homePage.clickOnAvailableLoads(driver);
		bidPage.clickOnAvailableBid();


	}
	public void clickAddNewPhoneNumber(String number) throws InterruptedException {
		bidPage.clickOnPhoneDropdown(driver);
		bidPage.clickOnAddNewPhoneNumber(driver);
		bidPage.enterPhoneNumber(driver,number);
	}



	public void clickOnAnalyticsTab() throws InterruptedException {
		homePage.clickAnalyticsTab(driver);

	}
	
	public void selectCheckboxForAddingSecondNumber() throws InterruptedException {
		bidPage.selectTheCheckbox(driver);
	}
	public void deselectTheCheckbox() throws InterruptedException {
		bidPage.deselectTheCheckbox(driver);

	}

	public void clickOnBlankHeart() throws InterruptedException {
		//homePage.scrollToParticularElement(driver);
		homePage.clickOnBlankHeartIcon(driver);

	}



	public void clickOnClose() throws InterruptedException {
		homePage.clickClose(driver);

	}
	public void clickOnFilledHeart() throws InterruptedException {
		homePage.clickOnFilledHeartIcon(driver);

	}

	public void clickOnBookNowButton() throws InterruptedException {
		homePage.clickOnBookNow(driver);		
	}


	public void clickOnHyperlinkCorrespondingToStateCity() throws InterruptedException {
		homePage.clickHyperlink(driver);		
	}


	public boolean VerifyBidSubmitted() throws InterruptedException {
		homePage.raiseBid(driver);
		return homePage.verifyBidThankYouMsg();
	}
	public boolean VerifyInterestSubmitted() throws InterruptedException {
		homePage.raiseInterest(driver);
		return homePage.verifyInterestThankYouMsg();
	}

	public boolean verifyITSModal() throws InterruptedException {
		return homePage.verifyConfirmationModalForITS();
	}
	

	public void verifySecondaryPhoneNumberOnProfile(String expectedTitle,SoftAssert softAssert) {
		String actualTitle= profilePage.getPhoneNumber(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}

	public void verifyThankyouMessage(String expectedTitle,SoftAssert softAssert) {
		String actualTitle= homePage.getThankyouText(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}

	public void verifyAdditionalOutboundText(String expectedTitle,SoftAssert softAssert) {
		String actualTitle= homePage.getAdditionalOutboundsText(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}


	public void verifyCarrierCommitmentMessage(String expectedTitle,SoftAssert softAssert) {
		String actualTitle= homePage.getCarrierCommitmentMessage(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}
	public void verifyConfirmationMessageText(String expectedTitle ,SoftAssert softAssert) {
		String actualTitle= homePage.getConfirmationMessageText(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}

	public void verifyPhoneNumber(String expectedTitle ,SoftAssert softAssert) {
		String actualTitle= profilePage.getPhoneNumber(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}

	public void verifyYouAlreadyHaveTwoPhoneNumbersOnProfileText(String expectedTitle ,SoftAssert softAssert) {
		String actualTitle= commonPage.getYouAlreadyHaveTwoPhoneNumbersOnProfileText(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}
	public void verifyErrorText(String expectedTitle ,SoftAssert softAssert) {
		String actualTitle= bidPage.getValidationText(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void verifyDefaultNumber(String expectedTitle ,SoftAssert softAssert) {
		String actualTitle= bidPage.getDefaultNumber(driver);
		softAssert.assertEquals(actualTitle, expectedTitle);
	}


	public boolean verifyFilledHeart() throws InterruptedException {
		return homePage.getFilledHeart();
	}

	public boolean verifyBlankHeart() throws InterruptedException {
		return homePage.getBlankHeart();
	}
	
	public boolean verifyAddButton() throws InterruptedException {
		return profilePage.getAddNumberButton();
	}
}

