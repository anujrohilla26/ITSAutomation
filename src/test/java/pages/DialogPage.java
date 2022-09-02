package pages;



import org.openqa.selenium.WebDriver;


public class DialogPage extends BasePage {


	String invalidUserPasswordError = "#swal2-content";


	String okButton = "//button[text()='OK']";

	/**
	 * Get Text from dialog
	 *
	 * @return the text in string.
	 */
	public String getTextFromDialog(WebDriver driver) {
		return getText(invalidUserPasswordError,Types.CSS);
	}

	/**
	 * click on Ok Button from dialog
	 */
	public void clickOkFromDialog(WebDriver driver) {
		click(okButton,Types.XPATH);
	}
}
