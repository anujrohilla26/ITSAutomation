package tests;

import org.testng.annotations.Test;


public class Login_Tests extends BaseTest{

	@Test(description="Verify if the valid user able to login successfully")
	public void Verify_User_AbleTo_Login_Successfully(){

		login.loginIntoApplication();
		availableLoads.verifyIfHomeDisplayed("Welcome back !");
	}

	@Test(description="Verify error if the username/Password is not entered")
	public void Verify_InvalidUser_NotAbleTo_Login(){
		login.loginIntoApplication("","");
		login.verifyLoginError("Please enter your Email Address","Please enter your password");
	}
}


