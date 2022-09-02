package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Login_Tests extends BaseTest{
	private SoftAssert softAssert;

	@Test(description="Verify if the valid user able to login successfully")
	public void Verify_User_AbleTo_Login_Successfully() throws InterruptedException{
		softAssert=new SoftAssert();
		login.loginIntoApplication();
		home.verifyIfHomeDisplayed("Welcome back !",softAssert);
	}

	@Test(description="Verify error if the username/Password is not entered")
	public void Verify_InvalidUser_NotAbleTo_Login(){
		login.loginIntoApplication("","");
		login.verifyLoginError("Please enter your Email Address","Please enter your password");
	}
}


