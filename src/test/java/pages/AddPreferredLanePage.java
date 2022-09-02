package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.BasePage.Types;

public class AddPreferredLanePage extends BasePage {

	CommonPage commonPage = new CommonPage();

	String AddPreferredLane = "//a[text()='Add Preferred Lane']";
	String EquipmentType = "//input[@placeholder='Select Equipments']";
	String TransitTypes = "//input[@placeholder='Select Transit Types']";
	String ServiceTypes = "//input[@placeholder='Select Service Types']";
	String TransactionTypes = "//input[@placeholder='Select Transaction Types']";
	String ModeType = "//input[@placeholder='Select Mode']";
	String SelectDay = "//input[@placeholder='Select Day(s) of Available Capacity']";
	String Origin = "//label[contains(text(),'Origin')]/..//input";
	String Destination = "//label[contains(text(),'Destination')]/..//input";
	String MultiStop = "//label[contains(text(),'Multi Stop')]/..//..//div[contains(@class,'mat-select-arrow-wrapper')]";
	String selectType = "(//span[@class='mat-option-text'])[1]";
	String CitySt = "(//span[@class='ng-option-label ng-star-inserted'])[1]";
	String SaveButton = "//button[@type='submit']";
	String Pagecount = "//span[contains(text(),'Page 1 of ')]";
	String nextPaginationArrow = "//mat-icon[text()='arrow_right']";
	String EquipmentTypeValue = "(//tr[@class='viewed ng-star-inserted'])[last()]/td[6]";
	String editIcon = "(//tr[@class='viewed ng-star-inserted'])[last()]//mat-icon[text()='edit']";
	String PowerOnly = "//mat-chip[contains(text(),' Power Only ')]";	
	String crossIcon = "//mat-icon[text()='cancel']";

	public void clickOnAddPreferredLane() {
		click(AddPreferredLane, Types.XPATH);		  

	}

	public void enterEquipmentType(String value) {
		sendKeys(EquipmentType, Types.XPATH, value);
		click(selectType, Types.XPATH);

	}


	public void se(String value) {
		click(selectType, Types.XPATH);

	}


	public void clickOnCancel() {
		click(crossIcon, Types.XPATH);

	}
	public void enterServiceTypes(String value) {
		sendKeys(ServiceTypes, Types.XPATH, value);
		click(selectType, Types.XPATH);
	}

	public void enterTransitTypes(String value) {
		sendKeys(TransitTypes, Types.XPATH, value);
		click(selectType, Types.XPATH);
	}

	public void enterTransactionTypes(String value) {
		sendKeys(TransactionTypes, Types.XPATH, value);
		click(selectType, Types.XPATH);
	}

	public void enterModeType(String value) {
		sendKeys(ModeType, Types.XPATH, value);
		click(selectType, Types.XPATH);
	}

	public void enterSelectDay(String value) {
		sendKeys(SelectDay, Types.XPATH, value);
		click(selectType, Types.XPATH);
	}

	public void enterOrigin(String value) {
		sendKeys(Origin, Types.XPATH, value);
		click(CitySt, Types.XPATH);
	}

	public void enterDestination(String value) {
		sendKeys(Origin, Types.XPATH, value);
		click(CitySt, Types.XPATH);
	}


	public void enterMultiStop() {
		click(MultiStop, Types.XPATH);
		click(selectType, Types.XPATH);
	} 

	public void clickOnSaveButton()
	{
		click(SaveButton, Types.XPATH);
	}

	public void navigateToLastPageCount()
	{
		String[] array = getText(Pagecount, Types.XPATH).trim().split("of");
		int count =Integer.parseInt(array[1]);
		for(int i =1 ; i<count ; i++)
		{
			click(nextPaginationArrow, Types.XPATH);
			commonPage.waitForLoaderInvisibility();
		}
	}

	public String getEquipmentTypeValue() {
		String type = getText(EquipmentTypeValue, Types.XPATH);
		return type ;
	}

	public void clickOnEditIcon() {
		click(editIcon, Types.XPATH);

	}

	public boolean isPowerOnlyDisplayed()
	{
		return isElementDisplayed(PowerOnly, Types.XPATH);
	}



	public boolean isChipStyleOptionsDisplayed(String Option)
	{

		String chipStyle = "//label[contains(text(),'"+Option+"')]/../..//mat-chip[contains(@class,'mat-chip')]";
		return isElementDisplayed(chipStyle, Types.XPATH);
	}


	public void clickOnSelectTypesField(String types) {
		String field = "//input[contains(@placeholder,'"+types+"')]";
		click(field, Types.XPATH);
	}


	public boolean isOptionsDisplayedInDropDown(String value) {
		String dropdownOptions = "//mat-option[@role='option']" ;
		boolean status = false;
		hardWait(5000);
		List<WebElement> list = getWebElements(dropdownOptions,Types.XPATH);
		for(WebElement actualList : list) {
			if(actualList.getText().trim().equals(value)) {			
				status = true;
				break;
			}		
		}
		return status;
	}

}