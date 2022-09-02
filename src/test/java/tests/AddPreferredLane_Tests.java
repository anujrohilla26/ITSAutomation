package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddPreferredLane_Tests extends BaseTest{
	private SoftAssert softAssert;

	String preferredLane = "Preferred Lane Subscriptions";
	String dryVan = "Dry Van";
	String equipmentOption = "Equipment";
	String transitType = "Transit Type";
	String serviceType="Service Type";
	String transactionType="Transaction Type";
	String adhoc = "Adhoc";
	String dedicated = "Dedicated";
	String reefer = "Reefer";
	String dryVanReefer = "Dry Van or Reefer";
	String flatbed = "Flatbed";
	String otherSpecializations = "Other Specialized";
	String powerOnly = "Power Only";
	String standard = "Standard";
	String expedited = "Expedited";
	String drop = "Drop";
	String live = "Live";


	@Test(description="Verify equipment Options Is Displayed As Chip Style")
	public void verifyequipmentOptionsIsDisplayedAsChipStyle () throws InterruptedException{
		login.loginIntoApplication();
		addPreferredLane.clickOnLeftNavigationPeferredLane(preferredLane);
		addPreferredLane.addPreferredLane();
		addPreferredLane.selectEquipmentType(dryVan);
		softAssert.assertTrue(addPreferredLane.isChipStyleDisplayed(equipmentOption),"Preferred Lane is not Displayed");
		addPreferredLane.clickOnCross();
		addPreferredLane.selectTypesField(equipmentOption);
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(dryVan),"Dry Van is not Displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(reefer),"Reefer is not Displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(dryVanReefer),"Dry Van and Reefer is not Displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(flatbed),"Flatbed is not Displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(otherSpecializations),"Other specializations Lane is not Displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(powerOnly),"Power only is not Displayed");
		softAssert.assertAll();
	}

	@Test(description="Verify Transit Options Is Displayed As Chip Style")
	public void verifyTransitOptionsIsDisplayedAsChipStyle () throws InterruptedException{
		login.loginIntoApplication();
		addPreferredLane.clickOnLeftNavigationPeferredLane(preferredLane);
		addPreferredLane.addPreferredLane();
		addPreferredLane.selectTransitType(standard);
		softAssert.assertTrue(addPreferredLane.isChipStyleDisplayed(transitType),"Option is not displayed in chip style manner");
		addPreferredLane.clickOnCross();
		addPreferredLane.selectTypesField(transitType);
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(standard),"Standard option is not displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(expedited),"Expedited option is not displayed");
		softAssert.assertAll();
	}

	@Test(description="Verify equipment Options Is Displayed As Chip Style")
	public void verifyServiceTypeOptionsIsDisplayedAsChipStyle() throws InterruptedException{
		login.loginIntoApplication();
		addPreferredLane.clickOnLeftNavigationPeferredLane(preferredLane);
		addPreferredLane.addPreferredLane();
		addPreferredLane.selectServiceType(drop);
		softAssert.assertTrue(addPreferredLane.isChipStyleDisplayed(serviceType),"Option is not displayed in chip style manner");
		addPreferredLane.clickOnCross();
		addPreferredLane.selectTypesField(serviceType);
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(drop),"Standard option is not displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(live),"Expedited option is not displayed");
		softAssert.assertAll();
	}
	@Test(description="Verify transaction Options Is Displayed As Chip Style")
	public void verifyTransactionTypeOptionsIsDisplayedAsChipStyle() throws InterruptedException{
		login.loginIntoApplication();
		addPreferredLane.clickOnLeftNavigationPeferredLane(preferredLane);
		addPreferredLane.addPreferredLane();
		addPreferredLane.selectServiceType(drop);
		softAssert.assertTrue(addPreferredLane.isChipStyleDisplayed(transactionType),"Option is not displayed in chip style manner");
		addPreferredLane.clickOnCross();
		addPreferredLane.selectTypesField(transactionType);
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(adhoc),"Adhoc option is not displayed");
		softAssert.assertTrue(addPreferredLane.verifyIfOptionsDisplayedInDropDown(dedicated),"Dedicated option is not displayed");
		softAssert.assertAll();
	}	

}
