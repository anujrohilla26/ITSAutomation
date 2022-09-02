package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import builder.Login;
import pages.AvailableLoadsPage;
	
	
	public class AvailableLoadsTests extends BaseTest{		

		@Test(description="Verify Submitting a BID from Available Loads")
		public void Verify_BidSubmittedFromAvailableLoad() throws InterruptedException{

			//login.loginIntoApplication();
			availableLoads.verifyAvailbleLoads();
			availableLoads.VerifyBidSubmitted();
			
		}
		
		@Test(description="Verify Submitting a Interest from Available Loads")
		public void Verify_InterestSubmittedFromAvailableLoad() throws InterruptedException{

			//login.loginIntoApplication();
			availableLoads.verifyAvailbleLoads();
			availableLoads.VerifyInterestSubmitted();
			
		}
		
		
		@Test(description= "Verify Add to watchlist from Available Loads ")
			public void Verify_WatchlistFromAvailableLoads()
			{
			   
				//login.loginIntoApplication();
				availableLoadsPage.addToWatchlist();
				softAssert.assertTrue(commonPage.verifySnackbarMsgDisplayed(),"Snackbar is not displayed");
				availableLoadsPage.RemoveFromWatchlist();
				softAssert.assertTrue(commonPage.verifySnackbarMsgDisplayed(),"Snackbar is not displayed");
				availableLoadsPage.clickLoad(driver);
				availableLoadsPage.addToWatchlistFromLoadDetails();				
				availableLoadsPage.RemoveFromWatchlistFromLoadDetails();
				softAssert.assertAll();

				
			}
		


}
