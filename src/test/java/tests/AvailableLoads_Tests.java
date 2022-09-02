package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AvailableLoads_Tests extends BaseTest{
	private SoftAssert softAssert;

	String loadNumber = "939952";
	String reloadTripsViewText = "Reload Trips View";
	String thankyouMessage = "Thank you for booking Loads ,!";
	String carrierCommitmentMessage = "An ITS team member will send you a rate confirmation shortly at INC-Test-Carrier-1@its4logistics.com";
	String ConfirmationMessageText = "A confirmation email has been sent to your account email.";
	String snackBar="Successfully Saved!";
	String additionalOutBoundText = "Additional Outbound Loads";
	String secondaryNumber = "1234567890";
	String YouAlreadyHaveTwoPhoneNumbersOnProfileText = "You already have two phone numbers on your profile.";
	String errorMsg = "Contact number is required";
	String flatRate = "45";
	String moduleName = "Available Loads";

	@Test(description="Verify Submitting a BID from Available Loads")
	public void Verify_BidSubmittedFromAvailableLoad() throws InterruptedException{

		login.loginIntoApplication();
		home.verifyAvailbleLoads();
		home.VerifyBidSubmitted();

	}

	@Test(description="Verify Submitting a Interest from Available Loads")
	public void Verify_InterestSubmittedFromAvailableLoad() throws InterruptedException{

		login.loginIntoApplication();
		home.verifyAvailbleLoads();
		home.VerifyInterestSubmitted();

	}
	/*
	 * Testcase ID = 43411
	 */
	@Test(description="Verify Confirmation Message Modal from book now modal from view trips link")
	public void verifyConfirmationMessageModalFromBookNowModaFromViewTripsLink() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		home.selectViewTrips(loadNumber);
		home.verifyModalTitle(reloadTripsViewText,softAssert);
		home.clickOnBookNowButton();
		home.verifyITSModal();
		home.verifyThankyouMessage(thankyouMessage,softAssert);
		home.verifyCarrierCommitmentMessage(carrierCommitmentMessage,softAssert);
		home.verifyConfirmationMessageText(ConfirmationMessageText,softAssert);
		home.clickOnClose();
		softAssert.assertAll();


	}

	/*
	 * Testcase ID = 43293
	 */
	@Test(description="Verify Confirmation Message Modal from book now modal from view trips link")
	public void verifyHeartWatchingColumnInReloadsTable() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		home.navigateToReloadTab(loadNumber);
		home.clickOnBlankHeart();
		home.verifyFilledHeart();
		home.verifyIfSuccessfullySavedTextDisplayed(snackBar,softAssert);
		home.clickOnFilledHeart();
		home.verifyBlankHeart();
		home.verifyIfSuccessfullySavedTextDisplayed(snackBar,softAssert);
		softAssert.assertAll();
	}


	/*
	 * Testcase ID = 43398
	 */
	@Test(description=" Verify'Additional Outbound'loads Hyperlinks")
	public void verifAdditionalOutboundLoadsHyperlinks() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		home.navigateToReloadTab(loadNumber);
		home.clickOnAnalyticsTab();
		home.verifyAdditionalOutboundText(additionalOutBoundText, softAssert);
		home.clickOnHyperlinkCorrespondingToStateCity();
		//verification of hyperlink is still remaining can't figure it out because On qa env link is not clickable
		softAssert.assertAll();

	}
	/*
	 * Testcase ID = 43398
	 */
	@Test(description="Verify Validation Text If user Already Having Two numbers In Profile")
	public void verifyValidationTextIfuserAlreadyHavingTwonumbersInProfile() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		home.clickBeginVaultDemo();
		home.addSecondaryNumber(secondaryNumber);
		home.navigateToBidNow();
		home.verifyYouAlreadyHaveTwoPhoneNumbersOnProfileText(YouAlreadyHaveTwoPhoneNumbersOnProfileText, softAssert);
		profile.navigateToProfile();
		home.clickDeleteContainer();
		profile.clickSaveChanges();
		softAssert.assertAll();
	}
	/*
	 * Testcase ID = 44507
	 */
	@Test(description="Verify If User Adds Number From Bid Modal Same Number Is Displayed In Profile Page")
	public void verifyIfUserAddsNumberFromBidModalSameNumberIDisplayedInProfilPage() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		profile.deleteSecondaryNumberIfExists();
		home.navigateToBidNow();
		home.enterFlatRateValue(flatRate);
		home.clickAddNewPhoneNumber(secondaryNumber);
		home.selectCheckboxForAddingSecondNumber();
		home.clickSubmit();
		profile.navigateToProfile();
		home.verifySecondaryPhoneNumberOnProfile(secondaryNumber, softAssert);
		softAssert.assertAll();
	}
	/*
	 * Testcase ID = 43398
	 */
	@Test(description="Verify Secondary Number Is Not Added In Profile If User Uncheck The Checkbox")
	public void verifySecondaryNumberIsNotAddedInProfileIfUserUncheckTheCheckbox() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		profile.deleteSecondaryNumberIfExists();
		home.navigateToBidNow();
		home.enterFlatRateValue(flatRate);
		home.clickAddNewPhoneNumber(secondaryNumber);
		home.deselectTheCheckbox();
		home.clickSubmit();
		profile.navigateToProfile();
		home.verifyAddButton();	
		softAssert.assertAll();
	}
	/*
	 * Testcase ID = 43398
	 */
	@Test(description="Verify Validation Text If user Already Having Two Numbers On Interested Modal")
	public void verifyValidationTextIfuserAlreadyHavingTwoNumbersOnInterestedModal() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		home.clickBeginVaultDemo();
		home.addSecondaryNumber(secondaryNumber);
		home.navigateToModuleFromLeftPanel(moduleName);
		home.clickOnInterestedButton();
		home.verifyYouAlreadyHaveTwoPhoneNumbersOnProfileText(YouAlreadyHaveTwoPhoneNumbersOnProfileText, softAssert);
		profile.navigateToProfile();
		home.clickDeleteContainer();
		profile.clickSaveChanges();
		softAssert.assertAll();
	}
}

