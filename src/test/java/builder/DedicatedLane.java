package builder;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import pages.BasePage;
import pages.CommonPage;
import pages.DedicatedLaneDetailsPage;
import utility.Utils;

public class DedicatedLane extends BasePage {

	Utils utils = new Utils();
	Map<String, String> data = new HashMap <String, String>();
	CommonPage commonPage = new CommonPage();
	DedicatedLaneDetailsPage dedicatedLanePage = new DedicatedLaneDetailsPage();
	
	public void selectLoadFromDedicatedLane() throws InterruptedException {
		dedicatedLanePage.clickOnDedicatedOpportunitiesTab(driver);
		dedicatedLanePage.clickOnLoad(driver);
		dedicatedLanePage.clickOnCurrentLoadsTab(driver);
		dedicatedLanePage.clickOnCheckbox(driver);
		dedicatedLanePage.clickOnCheckbox(driver);

	}
	
	public void deselectTheCheckbox() throws InterruptedException {
		dedicatedLanePage.clickOnCheckbox(driver);

	}
	
	public void VerifyInterestedButtonIlluminated() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(dedicatedLanePage.VerifyInterestedButtonIsIlluminated(),"Button is not disabled");
	}
	public void VerifyInterestedButtonDisabled() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertFalse(dedicatedLanePage.VerifyInterestedButtonIsIlluminated(),"Button is not eanbled");
	}
}