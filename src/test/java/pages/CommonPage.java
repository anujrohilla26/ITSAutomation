package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.BasePage.Types;

public class CommonPage extends BasePage{

	String WelcomeText="welcome-message";
	String SnackbarMsg ="//div[@aria-label='Successfully Saved!']";
	String Loader ="//div[contains(@class,'ngx-spinner-overlay ng-tns')]";
	String BookNowButton = "//div[contains(@class,'its-tab-button-content')]//span[text()='Book Now ']";
	String ModuleName = "//li[contains(@class,'mat-tooltip-trigger')]" ;
	String NoteTextArea = "//textarea[contains(@placeholder,'Enter any notes')]";
	String SubmitButton = "button.mat-focus-indicator.its-submit-button.mat-raised-button";
	String FlatRate = "//input[@placeholder='Enter Flat Rate']";
	String successfullySaved="//div[contains(@class,'toast-message')]";
	String alreadyPhoneNumbersSnackbar = "//span[contains(@class,'simple-snack-bar')]";
	String submitButton = "//span[text()='Submit ']";
	String sideBarModule = "//div[contains(@class,'nav-text-item')]" ;
	
	public void waitUntilWelcomeMsgDisplayed() {
		 		waitForElementVisiblity(WelcomeText,Types.CLASSNAME);
		 	}
	
	public boolean verifySnackbarMsgDisplayed() {
		waitForElementVisiblity(SnackbarMsg,Types.XPATH);
		return isElementDisplayed(SnackbarMsg,Types.XPATH);
	}
		
	public void clickOnSubmit() {
		waitForElementVisiblity(submitButton,Types.XPATH);
		click(submitButton, Types.XPATH);
	}
	public String getSuccessfullySavedText(WebDriver driver) {
		waitForElementVisiblity(successfullySaved,Types.XPATH);
		return getText(successfullySaved,Types.XPATH);
	}
	
	public String getYouAlreadyHaveTwoPhoneNumbersOnProfileText(WebDriver driver) {
		waitForElementVisiblity(alreadyPhoneNumbersSnackbar,Types.XPATH);
		return getText(alreadyPhoneNumbersSnackbar,Types.XPATH);
	}

	 public void waitForLoaderInvisibility() {
			
	    if(isElementDisplayed(Loader, Types.XPATH))
		{
			 waitForElementInVisiblity(Loader,Types.XPATH);
		}
	 }
	 
	 public void clickOnBookNowButton() {
		 waitForLoaderInvisibility();
		 click(BookNowButton, Types.XPATH);
	 }
	 
	 public void navigateToModule(WebDriver driver, String value)
		{
			List<WebElement> menuListElements = getWebElements(ModuleName, Types.XPATH);
			for (WebElement menuElement : menuListElements) {
				if (menuElement.getText().trim().contains(value)) {
					menuElement.click();;
					break;
				}
			}
			waitForLoaderInvisibility();
		}
	 
	 public void enterNoteTextinInterestModal(String value) {
		 sendKeys(NoteTextArea, Types.XPATH, value);
	 }
	 
	 public void clickOnSubmitButton() {
		 waitForElementVisiblity(SubmitButton, Types.CSS);
		 click(SubmitButton, Types.CSS);
		 
	 }
	 
	 public void enterFlatRate(String value ) {
		 waitForElementVisiblity(FlatRate, Types.XPATH);
		 sendKeys(FlatRate, Types.XPATH, value);
	 }
	 
	  
	  public void navigateToModuleFromLeftNavigationPanel(WebDriver driver, String value)
		{
			waitForElementVisiblity(sideBarModule,Types.XPATH);
			List<WebElement> menuListElements = getWebElements(sideBarModule, Types.XPATH);
			for (WebElement menuElement : menuListElements) {
				System.out.println(menuElement.getText());
				if (menuElement.getText().trim().contains(value)) {
					menuElement.click();;
					break;
				}
			}
			waitForLoaderInvisibility();
		}


}
