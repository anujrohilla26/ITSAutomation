package builder;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import pages.BasePage;
import pages.BidPage;
import pages.CommonPage;
import pages.ProfilePage;
import pages.AvailableLoads;
import utility.Utils;

public class Profile extends BasePage {

	Utils utils = new Utils();
	Map<String, String> data = new HashMap <String, String>();
	CommonPage commonPage = new CommonPage();
	AvailableLoads homePage = new AvailableLoads();
	ProfilePage profilePage = new ProfilePage();
	BidPage bidPage = new BidPage();

	
	public void navigateToProfile() throws InterruptedException {
		profilePage.clickOnThreeDots(driver);
		profilePage.clickOnProfile(driver);
	}
	
	public void clickSaveChanges() throws InterruptedException {
		profilePage.clickOnSaveChanges(driver);
	}

	public void addPrimaryNumber(String primaryNumber) throws InterruptedException {
		profilePage.enterPrimaryPhoneNumber(driver, primaryNumber);
	}
	public void clickOnSecondaryCheckbox() throws InterruptedException {
		profilePage.clickOnSecondaryCheckbox(driver);
	}
	
	public void clickOnPrimaryCheckbox() throws InterruptedException {
		profilePage.clickOnPrimaryCheckbox(driver);
	}
	
	public void isDefaultCheckboxCheckedForPrimaryNumber(SoftAssert softAssert ,String status) throws InterruptedException {
		softAssert.assertTrue(profilePage.isDefaultCheckboxChecked(status),"checkbox is not checked");
	}
	public void deleteSecondaryNumberIfExists() throws InterruptedException {
		profilePage.clickOnDeleteContainerForSecondaryNumber(driver);
	}
	
	public void addButtonAndEnterSecondaryNumber(String secondNumber) throws InterruptedException {
		profilePage.clickOnAddButton(driver);
		profilePage.addSecondaryNumber(driver,secondNumber);
	}

}

