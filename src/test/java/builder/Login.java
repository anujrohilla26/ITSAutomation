package builder;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import pages.CommonPage;
import pages.Dialog;
import pages.LoginPage;
import utility.Constants;
import utility.FileManager;
import utility.Instance;
import utility.Utils;

public class Login extends Instance{

	Utils utils = new Utils();
	Map<String, String> data = new HashMap <String, String>();

	public Login() {
		data.put(EMAIL,FileManager.readProperty(Constants.configFilePath, "email"));
		data.put(PASSWORD,FileManager.readProperty(Constants.configFilePath, "password"));
	}

	LoginPage loginPage = new LoginPage(); 
	Dialog dialog = new Dialog();
	CommonPage common = new CommonPage();

	public final  String EMAIL ="EMAIL";
	public final  String  PASSWORD="PASSWORD";


	public Map<String, String> getData() {
		return data;
	}

	public String getData(String key) {
		return data.get(key);
	}

	public void setData(String key, String data) {
		this.data.put(key, data);
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public void loginIntoApplication() throws InterruptedException {
		loginPage.setEmailAddressEmailField(getData(EMAIL));
		loginPage.setPasswordPasswordField(getData(PASSWORD));
		loginPage.clickSignInButton();
		common.waitUntilWelcomeMsgDisplayed();
		
		
	}

	public void loginIntoApplication(String email,String password) {
		loginPage.setEmailAddressEmailField(email);
		loginPage.setPasswordPasswordField(password);
		loginPage.clickSignInButton();
	}
	
	
	public void verifyLoginError(String text1, String text2) {
		String error1= loginPage.getEmailText(driver);
		Assert.assertEquals(error1, text1);
		String error2= loginPage.getPasswordText(driver);
		Assert.assertEquals(error2, text2);
	}
	
	
}
