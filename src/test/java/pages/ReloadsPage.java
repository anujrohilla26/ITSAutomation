package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ReloadsPage extends BasePage{
	
	CommonPage commonPage = new CommonPage();
	
	String NoResult = "//table[@class='its-table']/..//h2[contains(text(),'No results found.')]";
	String Reloads = "//li[contains(text(),'Reloads')]";
	String ReloadsRadius = "select.custom-select.ng-untouched.ng-pristine.ng-valid";
	String ReloadsTable = "//div[@class='reloads-second-section']/..//table/tbody";
	String ViewTrip = "//a[text()='View Trips']";
	String ReloadsModalTitle = "span.its-modal-title";
	String SubmitButton = "button.mat-focus-indicator.its-search-button";	
	
	
	public void searchForReloadsTrip()
	{
		if(getWebElements(NoResult, Types.XPATH).size()>0);
		{
			selectValueUsingSelectClass(ReloadsRadius, Types.CSS, "250");
			commonPage.waitForLoaderInvisibility();
			if(getWebElements(NoResult, Types.XPATH).size()>0);
			{
				iterateLoads();
				
			}
			
		}
	}
	
	public void iterateLoads(){
		String loadList="//tr[contains(@class,'viewed')]";
		List<WebElement> listItem=getWebElements(loadList,Types.XPATH);
		for(int i=2;i<listItem.size();i++)
		{
			String nextLoads="(//tr[contains(@class,'viewed')])["+i+"]";
			click(nextLoads, Types.XPATH);
			commonPage.waitForLoaderInvisibility();
			click(Reloads, Types.XPATH);
			if(getWebElements(ReloadsTable, Types.XPATH).size()>0)
			{
				click(ViewTrip, Types.XPATH);
			}
			else {
				searchForReloadsTrip();
			}
			
	     }
	}
	
	public boolean getReloadsTableMessage()
	{
		return getWebElements(NoResult, Types.XPATH).size()>0;
	}
	
	public String getReloadsModalTitle()
	{
		return getText(ReloadsModalTitle, Types.CSS);
	   	
	}
	
	public void clickOnSubmitButton()
	{
		click(SubmitButton, Types.XPATH);
	}
	

}


