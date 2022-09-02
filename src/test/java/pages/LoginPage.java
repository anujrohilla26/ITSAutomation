package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    String emailAddress = "//input[@id='email']";
    String password = "//input[@id='password']";
    String signIn = "//button[contains(text(),'Sign in')]";
    String EmailError = "(//*[@class='error itemLevel'])[1]";
    String PasswordError = "(//*[@class='error itemLevel'])[2]";
	String beginVaultDemo = "//span[contains(text(),' Begin Vault Demo ')]";
	String tableData ="//tbody[@class='ng-star-inserted']/tr[contains(@class,'viewed ng-star-inserted')]";


	/**
	 * Click on Sign In Button.
	 */
	public void clickSignInButton() {
		waitForElementVisiblity(signIn, Types.XPATH);
		click(signIn,Types.XPATH);
	}


	/**
	 * Set value to Email Address Email field.
	 */
	public void setEmailAddressEmailField(String emailAddressValue) {
		waitForElementVisiblity(emailAddress, Types.XPATH);
		sendKeys(emailAddress,Types.XPATH,emailAddressValue);
	}


	/**
	 * Set value to Password Password field.
	 */
	public void setPasswordPasswordField(String passwordValue) {
		waitForElementVisiblity(password,Types.XPATH);
		sendKeys(password,Types.XPATH,passwordValue);
	}

	/**
	 * Get Text from dialog
	 *
	 * @return the text in string.
	 */
	public String getEmailText(WebDriver driver) {
		return getText(EmailError,Types.XPATH);
	}

	public String getPasswordText(WebDriver driver) {
		return getText(PasswordError,Types.XPATH);
	}
	
	public void clickOnBeginWithVaultDemo(WebDriver driver) {
		waitForElementVisiblity(beginVaultDemo, Types.XPATH);
		click(beginVaultDemo, Types.XPATH);
	}
	
	public void tableDataVisible()
	{
		waitForElementVisiblity(tableData, Types.XPATH);
	}
	
}