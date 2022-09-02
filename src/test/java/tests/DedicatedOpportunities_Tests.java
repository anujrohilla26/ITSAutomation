package tests;

import org.testng.annotations.Test;

import builder.DedicatedLane;

public class DedicatedOpportunities_Tests  extends BaseTest{

	String loadNumber = "938192";
	@Test(description="Verify Grey out Bid & Interested buttons for dedicated opportunities")
	public void verifyGreyOutBidAndInterested() throws InterruptedException{
		login.loginIntoApplication();
		dedicatedLane.selectLoadFromDedicatedLane();
		dedicatedLane.VerifyInterestedButtonIlluminated();
		dedicatedLane.deselectTheCheckbox();
		dedicatedLane.VerifyInterestedButtonDisabled();
	}
}