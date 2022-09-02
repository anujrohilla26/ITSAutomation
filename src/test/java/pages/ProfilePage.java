package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.BasePage.Types;

public class ProfilePage extends BasePage{

	String threeDots="//button[contains(@aria-label,'icon-button with a menu')]";
	String profile = "//span[text()='Profile']";
	String add = "//div//mat-label[text()='Add']";
	String secondaryPhoneNumber = "//input[@formcontrolname='phoneNumberTwo']";
	String saveChangesButton = "//span[contains(text(),'Save Changes')]";
	String deleteContainer = "//mat-label[contains(text(),'Secondary Phone Number:')]/../../../..//mat-icon[contains(text(),'delete')]";
	String addThisNumberToYourProfileChkbox = "//span[contains(text(),'Add this number to your profile?')]/..//span[contains(@class,'mat-checkbox-inner')]";
	String beginVaultDemo = "//span[contains(text(),' Begin Vault Demo ')]";
	String primaryPhoneNumber = "//input[@formcontrolname='phoneNumberOne']";
	String defaultCheckBoxForPrimaryNumber ="//mat-checkbox[@formcontrolname='phoneNumberOneDefault']";
	String defaultCheckBoxForSecondaryNumber ="//mat-checkbox[@formcontrolname='phoneNumberTwoDefault']";
	
	public void clickOnThreeDots(WebDriver driver) {
		waitForElementClickability(threeDots, Types.XPATH);
		click(threeDots, Types.XPATH);
	}

	public void clickOnBeginWithVaultDemo(WebDriver driver) {
		waitForElementClickability(beginVaultDemo, Types.XPATH);
		click(beginVaultDemo, Types.XPATH);
	}
	//span[contains(text(),' Begin Vault Demo ')]

	public void clickOnProfile(WebDriver driver) {
		waitForElementClickability(profile, Types.XPATH);
		click(profile, Types.XPATH);
	}

	public void clickOnSaveChanges(WebDriver driver) {
		waitForElementClickability(saveChangesButton, Types.XPATH);
		click(saveChangesButton, Types.XPATH);
	}

	public void enterSecondaryPhoneNumber(WebDriver driver ,String number) {
		hardWait(6000);
		if(getWebElements(add, Types.XPATH).size()>0) {
			click(add, Types.XPATH);
			waitForElementVisiblity(secondaryPhoneNumber, Types.XPATH);
			sendKeys(secondaryPhoneNumber, Types.XPATH , number);
			waitForElementVisiblity(saveChangesButton, Types.XPATH);
			click(saveChangesButton, Types.XPATH);
		}
		else {
			System.out.println("hjmno");
		}
	}

	public void clickOnAddButton(WebDriver driver) {
		hardWait(6000);
		if(getWebElements(add, Types.XPATH).size()>0) {
			click(add, Types.XPATH);
		}
		if(getWebElements(deleteContainer, Types.XPATH).size()>0) {
			click(deleteContainer, Types.XPATH);
			click(add, Types.XPATH);

		}

	}
	public void addSecondaryNumber(WebDriver driver ,String number) {
		hardWait(6000);
		waitForElementVisiblity(secondaryPhoneNumber, Types.XPATH);
		sendKeys(secondaryPhoneNumber, Types.XPATH , number);

	}

	public void clickOnDeleteContainerForSecondaryNumber(WebDriver driver) {
		hardWait(6000);
		if(getWebElements(deleteContainer, Types.XPATH).size()>0) {
			click(deleteContainer, Types.XPATH);
		}
	}



	public void clickOnaddThisNumberToYourProfileChkbox(WebDriver driver) {
		waitForElementClickability(addThisNumberToYourProfileChkbox, Types.XPATH);
		click(addThisNumberToYourProfileChkbox, Types.XPATH);
	}

	public void enterPrimaryPhoneNumber(WebDriver driver,String value) {
		waitForElementVisiblity(primaryPhoneNumber, Types.XPATH);
		sendKeysAfterDeleteExistingValue(primaryPhoneNumber, Types.XPATH,value);
	}


	public String getPhoneNumber(WebDriver driver) {
		waitForElementVisiblity(secondaryPhoneNumber, Types.XPATH);
		String secondaryValue = getValueFromAttribute(secondaryPhoneNumber, Types.XPATH,"value");
		System.out.println(secondaryValue);
		return secondaryValue;
	}

	public boolean getAddNumberButton() {
		waitForElementVisiblity(add, Types.XPATH);
		return isElementDisplayed(add, Types.XPATH);

	}

	public boolean isDefaultCheckboxChecked(String status) {
		if(element(defaultCheckBoxForPrimaryNumber,Types.XPATH).findElement(By.xpath("..//input")).getAttribute("aria-checked").equals(status))
			return true;
		return false;
	}

	public boolean isDefaultCheckboxDisplayedUnchecked(String status) {
		if(element(defaultCheckBoxForPrimaryNumber,Types.XPATH).findElement(By.xpath("..//input")).getAttribute("aria-checked").equals("false"))
			return true;
		return false;
	}

	public void clickOnSecondaryCheckbox(WebDriver driver) {
		waitForElementClickability(defaultCheckBoxForSecondaryNumber, Types.XPATH);
		selectCheckBox(defaultCheckBoxForSecondaryNumber, Types.XPATH);
	}

	public void clickOnPrimaryCheckbox(WebDriver driver) {
		waitForElementClickability(defaultCheckBoxForPrimaryNumber, Types.XPATH);
		selectCheckBox(defaultCheckBoxForPrimaryNumber, Types.XPATH);
	}


}


