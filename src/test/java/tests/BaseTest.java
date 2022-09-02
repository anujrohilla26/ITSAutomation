package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import builder.AddPreferredLane;
import builder.DedicatedLane;
import builder.Home;
import builder.Login;
import builder.Profile;
import builder.WeeklyPlanning;
import utility.DriverSetup;
import utility.Instance;

public class BaseTest extends Instance{

	public static Login login ;

	public static Home home ;
	public static DedicatedLane dedicatedLane ;
	public static WeeklyPlanning weeklyPlanning ;
	public static Profile profile ;
	public static AddPreferredLane addPreferredLane ;

	
	private DriverSetup driversetup= new DriverSetup();
	static ExtentTest test;
	static ExtentReports report;



	@BeforeMethod
	public void setup(){
		driversetup.openApplication();
	    login= new Login();
	    home = new Home();
	    dedicatedLane=new DedicatedLane();
	    weeklyPlanning=new WeeklyPlanning();
	    profile=new Profile();
	    addPreferredLane=new AddPreferredLane();

	   // shipments = new Shipments();
	}

//	@AfterMethod
//	public void testteardown(){
//
//		driver.quit();
//	}


}
