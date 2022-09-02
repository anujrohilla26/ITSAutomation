package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import pages.BasePage.Types;

public class WeeklyPlanningPage extends BasePage{

	String weeklyPlanning = "//a[contains(text(),'Weekly Planning')]";
	String startDate= "//mat-label[contains(text(),'Start')]";
	String endDate= "//mat-label[contains(text(),'End')]";
	String origin= "//mat-label[contains(text(),'Origin ')]";
	String oRadius = "//mat-label[contains(text(),'Radius ')]";
	String destination = "//mat-label[contains(text(),'Destination Location')]";
	String equipment ="//mat-label[contains(text(),'Equipment Type')]";
	String transitType = "//mat-label[contains(text(),'Transit ')]";
	String planButton = "//span[contains(text(),'Plan ')]";
	String startDateRequiredValidation ="//mat-error[contains(text(),'Start Date is required')]";
	String endDateRequiredValidation ="//mat-error[contains(text(),'End Date is required')]";
	String originLocationRequiredValidation ="//mat-error[contains(text(),'Origin Location is required')]";
	String destinationRequiredValidation = "//mat-error[contains(text(),'Destination Location is required')]";
	String equipmentRequiredValidation = "//mat-error[contains(text(),'Equipment is required')]";
	String transitRequiredValidation = "//mat-error[contains(text(),'Equipment is required')]";
	String startDateIcon = "//mat-label[contains(text(),'Start Date')]/..//mat-icon[contains(text(),'today')]";
	String endDateIcon = "//mat-label[contains(text(),'End Date')]/..//mat-icon[contains(text(),'today')]";
	String nextButton = "//button[contains(@class,'next-button')]";
	String originLocation = "//mat-label[contains(text(),'Origin ')]/..//div[contains(text(),'Enter City, ST or Zip')]";
	String oRadious = "//mat-select[contains(@placeholder,'O-Radius (mi)')]";
	String destinationLocation = "//mat-label[contains(text(),'Destination Location')]/..//div[contains(text(),'Enter City, ST or Zip')]";
	String equipmentTypeDropdown="//mat-label[contains(text(),'Equipment Type')]/..//mat-select[contains(@class,'mat-select')]";
	String transitTypeDropdown="//mat-label[contains(text(),'Transit Type')]/..//mat-select[contains(@class,'mat-select')]";

	public void clickOnEquipmentTypeDropdown(WebDriver driver) {
		waitForElementVisiblity(equipmentTypeDropdown, Types.XPATH);
		click(equipmentTypeDropdown, Types.XPATH);
	}
	
	public void clickOnTransitTypeDropdown(WebDriver driver) {
		waitForElementVisiblity(transitTypeDropdown, Types.XPATH);
		click(transitTypeDropdown, Types.XPATH);
	}
	
	
	public void clickOnDestination(WebDriver driver) {
		waitForElementVisiblity(destinationLocation, Types.XPATH);
		click(destinationLocation, Types.XPATH);
	}
	public void clickOnRadius(WebDriver driver) {
		waitForElementVisiblity(oRadious, Types.XPATH);
		click(oRadious, Types.XPATH);
	}
	
	
	public void clickOnOrigin(WebDriver driver) {
		waitForElementVisiblity(originLocation, Types.XPATH);
		click(originLocation, Types.XPATH);
	}

	public void clickOnStartDateIcon(WebDriver driver,String value) {
		waitForElementVisiblity(startDateIcon, Types.XPATH);
		click(startDateIcon, Types.XPATH);
		waitForElementVisiblity(nextButton, Types.XPATH);
		click(nextButton, Types.XPATH);
		String date = "//div[text()=' "+value+" ']";
		waitForElementVisiblity(date, Types.XPATH);
		click(date, Types.XPATH);
	}
	public void clickOnEndDateIcon(WebDriver driver,String value) {
		waitForElementVisiblity(endDateIcon, Types.XPATH);
		click(endDateIcon, Types.XPATH);
		String date = "//div[text()=' "+value+" ']";
		waitForElementVisiblity(date, Types.XPATH);
		click(date, Types.XPATH);
	}


	public void clickOnWeeklyPlanning(WebDriver driver) {
		waitForElementVisiblity(weeklyPlanning, Types.XPATH);
		click(weeklyPlanning, Types.XPATH);
	}

	public void clickOnBidNow(WebDriver driver) {
		waitForElementVisiblity(weeklyPlanning, Types.XPATH);
		click(weeklyPlanning, Types.XPATH);
	}


	public void selectOptionsFromDropDown(WebDriver driver,String value) {
		String options = "(//span[text()='"+value+"'])[last()]";
		waitForElementVisiblity(options, Types.XPATH);
		click(options, Types.XPATH);
	}


	public void chooseStartDate(WebDriver driver ,String value) {
		String date = "//div[text()=' "+value+" ']";
		waitForElementVisiblity(date, Types.XPATH);
		click(date, Types.XPATH);
	}

	public void chooseEndDate(WebDriver driver ,String value) {
		String date = "//div[text()=' "+value+" ']";
		waitForElementVisiblity(date, Types.XPATH);
		click(date, Types.XPATH);
	}

	public void clickOnPlanButton(WebDriver driver) {
		waitForElementVisiblity(planButton, Types.XPATH);
		click(planButton, Types.XPATH);
	}
	public String getStartDate(WebDriver driver) {
		waitForElementVisiblity(startDate, Types.XPATH);
		return getText(startDate, Types.XPATH);

	}

	public String getEndDate(WebDriver driver) {
		waitForElementVisiblity(endDate, Types.XPATH);
		return getText(endDate, Types.XPATH);

	}

	public String getOrigin(WebDriver driver) {
		waitForElementVisiblity(origin, Types.XPATH);
		return getText(origin, Types.XPATH);

	}

	public String getORadius(WebDriver driver) {
		waitForElementVisiblity(oRadius, Types.XPATH);
		return getText(oRadius, Types.XPATH);

	}

	public String getDestination(WebDriver driver) {
		waitForElementVisiblity(destination, Types.XPATH);
		return getText(destination, Types.XPATH);

	}

	public String getEquipment(WebDriver driver) {
		waitForElementVisiblity(equipment, Types.XPATH);
		return getText(equipment, Types.XPATH);

	}

	public String getTransitType(WebDriver driver) {
		waitForElementVisiblity(transitType, Types.XPATH);
		return getText(transitType, Types.XPATH);

	}

	public boolean getStartDateRequiredValidation() {
		hardWait(5000);
		waitForElementVisiblity(startDateRequiredValidation, Types.XPATH);
		return isElementDisplayed(startDateRequiredValidation, Types.XPATH);

	}
	public boolean getEndDateRequiredValidation() {
		hardWait(5000);
		waitForElementVisiblity(endDateRequiredValidation, Types.XPATH);
		return isElementDisplayed(endDateRequiredValidation, Types.XPATH);

	}
	public boolean getOriginLocationRequiredValidation() {
		hardWait(5000);
		waitForElementVisiblity(originLocationRequiredValidation, Types.XPATH);
		return isElementDisplayed(originLocationRequiredValidation, Types.XPATH);

	}

	public boolean getORadiusRequiredValidation() {
		hardWait(5000);
		waitForElementVisiblity(originLocationRequiredValidation, Types.XPATH);
		return isElementDisplayed(originLocationRequiredValidation, Types.XPATH);

	}
	public boolean getdestinationRequiredValidation() {
		hardWait(5000);
		waitForElementVisiblity(startDateRequiredValidation, Types.XPATH);
		return isElementDisplayed(startDateRequiredValidation, Types.XPATH);

	}
	public boolean getEquipmentRequiredValidation() {
		hardWait(5000);
		waitForElementVisiblity(equipmentRequiredValidation, Types.XPATH);
		return isElementDisplayed(equipmentRequiredValidation, Types.XPATH);

	}
	public boolean getTransitRequiredValidation() {
		hardWait(5000);
		waitForElementVisiblity(transitRequiredValidation, Types.XPATH);
		return isElementDisplayed(transitRequiredValidation, Types.XPATH);

	}

	public boolean getStartDateRequiredValidationNotDisplayed() {
		hardWait(5000);
		waitForElementVisiblity(startDateRequiredValidation, Types.XPATH);
		return isElementNotDisplayed(startDateRequiredValidation, Types.XPATH);

	}
	public boolean getEndDateRequiredValidationNotDisplayed() {
		hardWait(5000);
		waitForElementVisiblity(endDateRequiredValidation, Types.XPATH);
		return isElementNotDisplayed(endDateRequiredValidation, Types.XPATH);

	}
	public boolean getOriginLocationRequiredValidationNotDisplayed() {
		hardWait(5000);
		waitForElementVisiblity(originLocationRequiredValidation, Types.XPATH);
		return isElementNotDisplayed(originLocationRequiredValidation, Types.XPATH);

	}


	public boolean getdestinationRequiredValidationNotDisplayed() {
		hardWait(5000);
		waitForElementVisiblity(startDateRequiredValidation, Types.XPATH);
		return isElementNotDisplayed(startDateRequiredValidation, Types.XPATH);

	}
	public boolean getEquipmentRequiredValidationNotDisplayed() {
		hardWait(5000);
		waitForElementVisiblity(equipmentRequiredValidation, Types.XPATH);
		return isElementNotDisplayed(equipmentRequiredValidation, Types.XPATH);

	}
	public boolean getTransitRequiredValidationNotDisplayed() {
		hardWait(5000);
		waitForElementVisiblity(transitRequiredValidation, Types.XPATH);
		return isElementNotDisplayed(transitRequiredValidation, Types.XPATH);

	}

}