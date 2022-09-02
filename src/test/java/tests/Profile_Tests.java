package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Profile_Tests extends BaseTest{
	private SoftAssert softAssert;
	String secondaryNumber = "1234567890";
	String primaryNumber = "0987654321";



	@Test(description=" Verify Phone number verbiage on 'Profile Page' ")
	public void  VerifyPhoneNumberverbiageonProfilePage() throws InterruptedException{
		softAssert = new SoftAssert();	
		login.loginIntoApplication();
		home.clickBeginVaultDemo();
		profile.navigateToProfile();
		profile.deleteSecondaryNumberIfExists();
		profile.isDefaultCheckboxCheckedForPrimaryNumber(softAssert,"true");
		profile.addButtonAndEnterSecondaryNumber(secondaryNumber);
		profile.clickOnSecondaryCheckbox();
		profile.isDefaultCheckboxCheckedForPrimaryNumber(softAssert,"false");
		profile.addPrimaryNumber(primaryNumber);
        profile.clickOnPrimaryCheckbox();
        profile.clickSaveChanges();
		home.navigateToBidNow();
		home.verifyDefaultNumber(primaryNumber,softAssert);
		softAssert.assertAll();

	}
}