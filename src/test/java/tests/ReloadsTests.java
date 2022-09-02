package tests;

import org.testng.annotations.Test;

import utility.masterdata.ModuleData;
import utility.masterdata.ReloadsData;

public class ReloadsTests extends BaseTest{
	

	@Test(description="43368 Verify Dedicated Lane Opportunities Logic")
	public void VerifyDedicatedLaneOpportunitiesLogic()  {

		availableLoadsPage.clickLoad(driver);
		commonPage.navigateToModule(driver, ModuleData.ReloadsModule);
		reloadsPage.searchForReloadsTrip();
		softAssert.assertEquals(reloadsPage.getReloadsModalTitle(), ReloadsData.ReloadsModalTitle,"Reloads Trip Title is not same as expected");
		commonPage.clickOnBookNowButton();
		reloadsPage.clickOnSubmitButton();
	    softAssert.assertTrue(dedicatedOpportunitiesPage.verifyConfirmationModalIsDisplayed(),"Book Now Modal is not displayed");
		
		softAssert.assertAll();
}
	
	@Test(description="43413 Verify in Available Loads ,Reloads Table No Result Found Message")
	public void VerifyReloadsNoResultFoundMessage() throws InterruptedException{

		availableLoadsPage.clickLoad(driver);
		commonPage.navigateToModule(driver, ModuleData.ReloadsModule);
	    softAssert.assertTrue(reloadsPage.getReloadsTableMessage(),"Reloads Table Message is not same as expected");
		softAssert.assertAll();

		
	}

		

	
}
