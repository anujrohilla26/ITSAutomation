package builder;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import pages.BasePage;
import pages.CommonPage;
import pages.AvailableLoadsPage;
import utility.Utils;

public class AvailableLoads extends BasePage {

	Utils utils = new Utils();
	Map<String, String> data = new HashMap <String, String>();
	CommonPage commonPage = new CommonPage();
	AvailableLoadsPage homePage = new AvailableLoadsPage();
	
	public void verifyIfHomeDisplayed(String text) {
		String welcome= homePage.getWelcomeText(driver);
		Assert.assertEquals(welcome, text);
	}
	
	public void verifyAvailbleLoads() {
		String LoadCount= homePage.getAvailableLoads(driver);
		if(Integer.parseInt(LoadCount) > 0) {
			System.out.println(LoadCount);
		}		
	}
	
	public boolean VerifyBidSubmitted() throws InterruptedException {
		homePage.raiseBid(driver);
		return homePage.VerifyBidThankYouMsg();
	}
	public boolean VerifyInterestSubmitted() throws InterruptedException {
		homePage.raiseInterest(driver);
		return homePage.VerifyInterestThankYouMsg();
	}
}
