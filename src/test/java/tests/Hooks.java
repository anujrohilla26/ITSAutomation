package tests;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.DialogPage;

import pages.LoginPage;
import utility.DriverSetup;
import utility.Instance;

public class Hooks extends Instance {

	public static LoginPage loginPage;
	public static DialogPage dialogPage;
	

	private DriverSetup driversetup= new DriverSetup();
	static ExtentTest test;
	static ExtentReports report;



	@BeforeMethod
	public void setup(){
		driversetup.openApplication();
		loginPage = PageFactory.initElements(driver,LoginPage.class); 
		dialogPage = PageFactory.initElements(driver,DialogPage.class); 

	}

	@AfterMethod
	public void testteardown(){

		//driver.quit();
	}


}
