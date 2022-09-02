package builder;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import pages.BasePage;
import pages.BidPage;
import pages.CommonPage;
import pages.ProfilePage;
import pages.WeeklyPlanningPage;
import pages.AvailableLoads;
import utility.Utils;

public class WeeklyPlanning extends BasePage {

	Utils utils = new Utils();
	Map<String, String> data = new HashMap <String, String>();
	CommonPage commonPage = new CommonPage();
	AvailableLoads homePage = new AvailableLoads();
	ProfilePage profilePage = new ProfilePage();
    BidPage bidPage = new BidPage();
    WeeklyPlanningPage weeklyPlanningPage = new WeeklyPlanningPage();


    
	public void selectOriginLocation(String value) throws InterruptedException {
		weeklyPlanningPage.clickOnOrigin(driver);
		weeklyPlanningPage.selectOptionsFromDropDown(driver,value);


	}
	
	public void selectOradius(String value) throws InterruptedException {
		weeklyPlanningPage.clickOnRadius(driver);
		weeklyPlanningPage.selectOptionsFromDropDown(driver,value);


	}
	

	public void selectDestination(String value) throws InterruptedException {
		weeklyPlanningPage.clickOnDestination(driver);
		weeklyPlanningPage.selectOptionsFromDropDown(driver,value);


	}
	
	public void selectEquipmentTypeDropdown(String value) throws InterruptedException {
		weeklyPlanningPage.clickOnEquipmentTypeDropdown(driver);
		weeklyPlanningPage.selectOptionsFromDropDown(driver,value);


	}
	public void selectTransitType(String value) throws InterruptedException {
		weeklyPlanningPage.clickOnTransitTypeDropdown(driver);
		weeklyPlanningPage.selectOptionsFromDropDown(driver,value);


	}
	public void clickWeeklyPlanning() throws InterruptedException {
//		profilePage.clickOnBeginWithVaultDemo(driver);
		weeklyPlanningPage.clickOnWeeklyPlanning(driver);
	}
	
	public void selectStartDate(String value) throws InterruptedException {
		weeklyPlanningPage.clickOnStartDateIcon(driver,value);

	}
	
	public void selectEndDate(String value) throws InterruptedException {
		weeklyPlanningPage.clickOnEndDateIcon(driver,value);

	}
	

	public void clickPlan(){
		weeklyPlanningPage.clickOnPlanButton(driver);
	}
	
	
	public void verifyStartDateFieldText( String expectedText ,SoftAssert softAssert) {
		String actualText= weeklyPlanningPage.getStartDate(driver).trim();
		softAssert.assertEquals(actualText, expectedText);
	
	}
	public void verifyEndDateFieldText( String expectedText ,SoftAssert softAssert) {
		String actualText= weeklyPlanningPage.getEndDate(driver).trim();
		softAssert.assertEquals(actualText, expectedText);
	
	}
	
	public void verifyOrigin( String expectedText ,SoftAssert softAssert) {
		String actualText= weeklyPlanningPage.getOrigin(driver).trim();
		softAssert.assertEquals(actualText, expectedText);
	
	}
	

	public void verifyRadius( String expectedText ,SoftAssert softAssert) {
		String actualText= weeklyPlanningPage.getORadius(driver).trim();
		softAssert.assertEquals(actualText, expectedText);
	
	}
	public void verifyDestination( String expectedText ,SoftAssert softAssert) {
		String actualText= weeklyPlanningPage.getDestination(driver).trim();
		softAssert.assertEquals(actualText, expectedText);
	
	}
	public void verifyEquipment( String expectedText ,SoftAssert softAssert) {
		String actualText= weeklyPlanningPage.getEquipment(driver).trim();
		softAssert.assertEquals(actualText, expectedText);
	
	}
	
	public void verifyTransitType( String expectedText ,SoftAssert softAssert) {
		String actualText= weeklyPlanningPage.getTransitType(driver).trim();
		softAssert.assertEquals(actualText, expectedText);
	
	}
	
	public boolean verifyStartDateRequiredValidation() throws InterruptedException {
		return weeklyPlanningPage.getStartDateRequiredValidation();
	}
	
	public boolean verifyEndDateRequiredValidation() throws InterruptedException {
		return weeklyPlanningPage.getEndDateRequiredValidation();
	}
	
	public boolean verifyOriginRequiredValidation() throws InterruptedException {
		return weeklyPlanningPage.getOriginLocationRequiredValidation();
	
	}
	
	public boolean verifyDestinationRequiredValidation() throws InterruptedException {
		return weeklyPlanningPage.getdestinationRequiredValidation();
	}
	
	public boolean verifyEquipmentRequiredValidation() throws InterruptedException {
		return weeklyPlanningPage.getEquipmentRequiredValidation();
	}
	
	public boolean verifyTransitRequiredValidation() throws InterruptedException {
		return weeklyPlanningPage.getTransitRequiredValidation();
	}
	
	public boolean verifyStartDateRequiredValidationNotDisplayed() throws InterruptedException {
		return weeklyPlanningPage.getStartDateRequiredValidationNotDisplayed();
	}
	
	public boolean verifyEndDateRequiredValidationNotDisplayed() throws InterruptedException {
		return weeklyPlanningPage.getEndDateRequiredValidationNotDisplayed();
	}
	
	public boolean verifyOriginRequiredValidationNotDisplayed() throws InterruptedException {
		return weeklyPlanningPage.getOriginLocationRequiredValidationNotDisplayed();
	
	}
	
	public boolean verifyDestinationRequiredValidationNotDisplayed() throws InterruptedException {
		return weeklyPlanningPage.getdestinationRequiredValidationNotDisplayed();
	}
	
	public boolean verifyEquipmentRequiredValidationNotDisplayed() throws InterruptedException {
		return weeklyPlanningPage.getEquipmentRequiredValidationNotDisplayed();
	}
	
	public boolean verifyTransitRequiredValidationNotDisplayed() throws InterruptedException {
		return weeklyPlanningPage.getTransitRequiredValidationNotDisplayed();
	}
}


