package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.BasePage.Types;

public class CommonPage extends BasePage{
	
	private String welcomeText="welcome-message";
	String successfullySaved="//div[contains(@class,'toast-message')]";
	String  alreadyPhoneNumbersSnackbar = "//span[contains(@class,'simple-snack-bar')]";
	String submitButton = "//span[text()='Submit ']";
	String ModuleName = "//li[contains(@class,'mat-tooltip-trigger')]" ;
	String Loader ="//div[contains(@class,'ngx-spinner-overlay ng-tns')]";
	String sideBarModule = "//div[contains(@class,'nav-text-item')]" ;

	
	
	
	public void waitUntilWelcomeMsgDisplayed() {
		waitForElementVisiblity(welcomeText,Types.CLASSNAME);
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
	 public void navigateToModule(WebDriver driver, String value)
		{
			List<WebElement> menuListElements = getWebElements(ModuleName, Types.XPATH);
			for (WebElement menuElement : menuListElements) {
				System.out.println(menuElement.getText());
				if (menuElement.getText().trim().contains(value)) {
					menuElement.click();;
					break;
				}
			}
			waitForLoaderInvisibility();
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
