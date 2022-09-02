package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import builder.AvailableLoads;
import builder.Login;
import pages.AddPreferredLanePage;
import pages.AvailableLoadsPage;
import pages.CommonPage;
import pages.DedicatedOpportunitiesPage;
import pages.FilterPage;
import pages.ReloadsPage;
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
	public static AvailableLoadsPage  availableLoadsPage ;
	public static CommonPage  commonPage ;
	public static AvailableLoads availableLoads ;
	public static SoftAssert softAssert ;
	public static DedicatedOpportunitiesPage  dedicatedOpportunitiesPage ;
	public static AddPreferredLanePage  addPreferredLanePage ;
	public static FilterPage  filterPage ;
	public static ReloadsPage reloadsPage;
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
	    availableLoads = new AvailableLoads();
	    softAssert =new SoftAssert(); 
	    availableLoadsPage = new AvailableLoadsPage();
	    commonPage = new CommonPage();
	    dedicatedOpportunitiesPage = new DedicatedOpportunitiesPage();
	    addPreferredLanePage = new AddPreferredLanePage();
	    filterPage = new FilterPage();	   
	    reloadsPage = new ReloadsPage();
		login.loginIntoApplication();
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
