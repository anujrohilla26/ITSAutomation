package tests;

import org.testng.annotations.Test;

import utility.masterdata.ModuleData;
import utility.masterdata.PreferredLaneData;

public class AddPreferredLaneTests extends BaseTest {
	
	
	@Test(description="Verify Power Only Equipment Type in Add Preferred Lane")
	public void VerifyPowerOnlyTypeInPreferredLane() {
		
		addPreferredLanePage.clickOnAddPreferredLane();
		addPreferredLanePage.enterOrigin(PreferredLaneData.Origin);
		addPreferredLanePage.enterDestination(PreferredLaneData.Destination);
		addPreferredLanePage.enterEquipmentType(PreferredLaneData.EquipmentType);
		addPreferredLanePage.enterTransitTypes(PreferredLaneData.TransitTypes);
		addPreferredLanePage.enterModeType(PreferredLaneData.ModeType);
		addPreferredLanePage.enterMultiStop();
		addPreferredLanePage.enterSelectDay(PreferredLaneData.SelectDay);
		addPreferredLanePage.enterServiceTypes(PreferredLaneData.ServiceTypes);
		addPreferredLanePage.enterTransactionTypes(PreferredLaneData.TransactionTypes);
		addPreferredLanePage.clickOnSaveButton();
		softAssert.assertTrue(dedicatedOpportunitiesPage.verifyConfirmationModalIsDisplayed(),"Preferred Lane is not Added");
		commonPage.navigateToModule(driver, ModuleData.PreferredLaneSubscriptionsModule);
		addPreferredLanePage.navigateToLastPageCount();
		softAssert.assertEquals(addPreferredLanePage.getEquipmentTypeValue(), PreferredLaneData.EQUIP, "Equipment Type Is not same as expected");
		addPreferredLanePage.clickOnEditIcon();
		softAssert.assertTrue(addPreferredLanePage.isPowerOnlyDisplayed(), "Power Only Type Is not displayed in add a preferred lane");		
		softAssert.assertAll();
		
	}
	
	@Test(description="Verify Power Only Equipment Type in Add Preferred Lane")
	public void VerifyPowerOnlyTypeInAvailableLoads() {
		filterPage.applyFilter("EQUIP", "Power Only");
		availableLoadsPage.clickLoad(driver);
		softAssert.assertTrue(filterPage.isPowerOnlyDisplayedInLoadDetail(),"Power Only Type Is not displayed in Loads Details");
		softAssert.assertTrue(filterPage.isReloadTabDisabled(),"Reloads Tab is not disbled for power only");
		softAssert.assertAll();		
		
	}
		
	
	

}
