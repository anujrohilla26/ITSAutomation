package tests;

import org.testng.annotations.Test;

import utility.masterdata.ModuleData;

public class DedicatedOpportunitiesTests extends BaseTest {
			
	
	@Test(description="43401 Verify Dedicated Lane Opportunities Logic")
	public void VerifyDedicatedLaneOpportunitiesLogic() throws InterruptedException{

		commonPage.navigateToModule(driver, ModuleData.DedicatedOpportunitiesModule);
		availableLoadsPage.clickLoad(driver);
		commonPage.navigateToModule(driver, ModuleData.CurrentLoadsModule);
		softAssert.assertEquals(dedicatedOpportunitiesPage.getCurrentLoadsTabCount(driver),dedicatedOpportunitiesPage.getCurrentLoadsTableCount(driver)
				,"Current Loads tab & table count is not same as expected"  );
		softAssert.assertAll();		
	}
	
	@Test(description="43400 Verify In Current Loads Book Now Close modal Are you sure you want to exit modal")
	public void VerifyCurrentLoadBookNowCloseModal() throws InterruptedException{

		commonPage.navigateToModule(driver, ModuleData.DedicatedOpportunitiesModule);
		availableLoadsPage.clickLoad(driver);
		commonPage.navigateToModule(driver, ModuleData.CurrentLoadsModule);
		dedicatedOpportunitiesPage.selectLoadFromCurrentLoadTable("1");
		commonPage.clickOnBookNowButton();
		dedicatedOpportunitiesPage.clickOnCloseButton();
		softAssert.assertEquals(dedicatedOpportunitiesPage.getBookNowCloseModalText(), "Are you sure you want exit ? Not all loads in the queue have been booked."
				,"Close Modal Text is not same as expected");
		dedicatedOpportunitiesPage.clickNoButton();
	    softAssert.assertTrue(dedicatedOpportunitiesPage.verifyConfirmationModalIsDisplayed(),"Book Now Modal is not displayed");
		softAssert.assertAll();
		
}
	
	@Test(description="43379 Verify Submit Interest Confirmation Message in Current Loads")
	public void VerifySubmitInterestInCurrentLoads() throws InterruptedException{

		commonPage.navigateToModule(driver, ModuleData.DedicatedOpportunitiesModule);
		availableLoadsPage.clickLoad(driver);
		commonPage.navigateToModule(driver, ModuleData.CurrentLoadsModule);
		dedicatedOpportunitiesPage.selectLoadFromCurrentLoadTable("1");
		dedicatedOpportunitiesPage.clickOnInterestButton();
		commonPage.enterNoteTextinInterestModal("Enter any notes for the ITS team here");
	    commonPage.clickOnSubmitButton();
	    softAssert.assertTrue(dedicatedOpportunitiesPage.verifyConfirmationModalIsDisplayed(),"Confirmation Modal is not displayed");
		softAssert.assertAll();	    
	}
	
	
	@Test(description="43384 Verify Submit Bid Confirmation Message in Current Loads")
	public void VerifySubmitBidInCurrentLoads() {

		commonPage.navigateToModule(driver, ModuleData.DedicatedOpportunitiesModule);
		availableLoadsPage.clickLoad(driver);
		commonPage.navigateToModule(driver, ModuleData.CurrentLoadsModule);
		dedicatedOpportunitiesPage.selectLoadFromCurrentLoadTable("1");
		dedicatedOpportunitiesPage.clickOnBidButton();
		commonPage.enterFlatRate("500");
	    commonPage.clickOnSubmitButton();
	    softAssert.assertTrue(dedicatedOpportunitiesPage.verifyConfirmationModalIsDisplayed(),"Confirmation Modal is not displayed");
		softAssert.assertAll();	    	
	
	}	
	
}
