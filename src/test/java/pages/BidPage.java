package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import pages.BasePage.Types;

public class BidPage extends BasePage{

	String bidNow = "(//a[contains(text(),'Bid Now')])[last()]";
	String flatRate = "(//input[contains(@placeholder,'Flat Rate')])[last()]";
	String phoneDropdown = "//div//mat-select[@formcontrolname='number']";
	String addPhoneNumber = "//span[text()='Add New']";
	String errorMsg = "(//mat-error[contains(@class,'error error-message')])[last()]";
	String phoneNumberField= "//input[contains(@formcontrolname,'number')]";
	String checkboxForAddSecondNumber="//span[contains(@class,'modal-notice-text')]/..//mat-checkbox//span[contains(@class,'inner-container mat-checkbox')]";
  //  String interestedButton = "(//span[contains(text(),'Interested')])[1]";
    
	public void clickOnBidNow(WebDriver driver) {
		waitForElementVisiblity(bidNow, Types.XPATH);
		click(bidNow, Types.XPATH);
	}

	public void enterFlatRate(WebDriver driver,String flatValue) {
		waitForElementVisiblity(flatRate, Types.XPATH);
		sendKeys(flatRate, Types.XPATH , flatValue);
	}

	public void enterPhoneNumber(WebDriver driver,String flatValue) {
		waitForElementVisiblity(phoneNumberField, Types.XPATH);
		sendKeys(phoneNumberField, Types.XPATH , flatValue);
	}

	public void clickOn(WebDriver driver,String flatValue) {
		waitForElementVisiblity(phoneNumberField, Types.XPATH);
		sendKeys(phoneNumberField, Types.XPATH , flatValue);
	}

	
	public void clickOnPhoneDropdown(WebDriver driver) {
		waitForElementVisiblity(phoneDropdown, Types.XPATH);
		click(phoneDropdown, Types.XPATH);
	}
	
	public void selectTheCheckbox(WebDriver driver) {
		waitForElementVisiblity(checkboxForAddSecondNumber, Types.XPATH);
		selectCheckBox(checkboxForAddSecondNumber, Types.XPATH);
	}
	
	public void deselectTheCheckbox(WebDriver driver) {
		waitForElementVisiblity(checkboxForAddSecondNumber, Types.XPATH);
		unselectCheckBox(checkboxForAddSecondNumber, Types.XPATH);
	}

	public void clickOnAddNewPhoneNumber(WebDriver driver) {
		waitForElementVisiblity(addPhoneNumber, Types.XPATH);
		click(addPhoneNumber, Types.XPATH);
	}

	public String getValidationText(WebDriver driver) {
		waitForElementVisiblity(errorMsg, Types.XPATH);
		return getText(errorMsg, Types.XPATH);

	}


	public void clickOnAvailableBid() {	

		String bid="//a[contains(text(),'Bid Now')]";
		hardWait(8000);
		List<WebElement> bidElements= getWebElements(bid,Types.XPATH);
		for(WebElement bidElement : bidElements) {
			if(bidElement.getText().trim().equals("Bid Now")) {
				hardWait(8000);
				bidElement.click();
				break;
			}
		}

	}
	

	
	public void clickOnInterestedButton(WebDriver driver, String menuName){
		String loadList="//tr[contains(@class,'viewed')]";
	    String interestedButton = "(//span[contains(text(),'Interested')])[1]";
		waitForElementVisiblity(loadList,Types.XPATH);
		List<WebElement> listItem=getWebElements(loadList,Types.XPATH);
		for(int i=0;i<listItem.size();i++){
			click(loadList, Types.XPATH);
			if(getWebElements(interestedButton,Types.XPATH).size()>0){
				click(interestedButton,Types.XPATH);
				break;
			
	}}}
		
	public String getDefaultNumber(WebDriver driver) {
		waitForElementVisiblity(phoneDropdown, Types.XPATH);
		String secondaryValue = getValueFromAttribute(phoneDropdown, Types.XPATH,"value");		
		System.out.println(secondaryValue);
		return secondaryValue;
	}
}

