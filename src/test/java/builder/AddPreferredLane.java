package builder;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import pages.AddPreferredLanePage;
import pages.BasePage;
import pages.CommonPage;
import pages.DedicatedLaneDetailsPage;
import pages.BasePage;
import utility.Utils;

public class AddPreferredLane extends BasePage {

	Utils utils = new Utils();
	Map<String, String> data = new HashMap <String, String>();
	CommonPage commonPage = new CommonPage();
	AddPreferredLanePage addPreferredLane = new AddPreferredLanePage();

	
	public void clickOnLeftNavigationPeferredLane(String module) throws InterruptedException {
		commonPage.navigateToModuleFromLeftNavigationPanel(driver, module);		
	}	
	
	public void addPreferredLane() throws InterruptedException {
		addPreferredLane.clickOnAddPreferredLane();		
	}
	
	
	public void selectTypesField(String types) throws InterruptedException {
		addPreferredLane.clickOnSelectTypesField(types);		
	}
	
	public void selectEquipmentType(String value) throws InterruptedException {
		addPreferredLane.enterEquipmentType(value);	
	}
	
	public void selectTransitType(String value) throws InterruptedException {
		addPreferredLane.enterTransitTypes(value);	
	}
	
	public void selectServiceType(String value) throws InterruptedException {
		addPreferredLane.enterServiceTypes(value);	
	}
	
	
	public void clickOnCross() throws InterruptedException {
		addPreferredLane.clickOnCancel();		
	}
	public boolean isChipStyleDisplayed(String optionName) throws InterruptedException {
		return addPreferredLane.isChipStyleOptionsDisplayed(optionName);
	}
	
	public boolean verifyIfOptionsDisplayedInDropDown(String optionName) throws InterruptedException {
		return addPreferredLane.isOptionsDisplayedInDropDown(optionName);
	}
}


