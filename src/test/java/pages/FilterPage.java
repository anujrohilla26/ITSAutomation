package pages;

public class FilterPage extends BasePage{
	
	String FilterText = "//input[@placeholder='Type a value']";
	String ApplyButton = "button.mat-focus-indicator.btn-apply.mat-raised-button";
	String EquipmentType = "//div[@class='its-tab-content-wrapper']/..//span[text()='Equipment']/..//span[text()='Power Only']";
	String Reloads = "//li[text()=' Reloads ']";

	
	
	public void applyFilter(String filterName, String filterValue) {
		
		String FilterIcon = "//span[contains(text(),'"+filterName+"')]/..//..//mat-icon[contains(@class,'mat-icon notranslate filter-icon material-icons')]";
        click(FilterIcon, Types.XPATH);
        enterData(FilterText, Types.XPATH, filterValue);
        click(ApplyButton, Types.CSS);	
	}
	
	
	public boolean isPowerOnlyDisplayedInLoadDetail()
	{
		return isElementDisplayed(EquipmentType, Types.XPATH);
	}
	
	public boolean isReloadTabDisabled()
	{
		return isElementEnabled(Reloads, Types.XPATH);
	}
}
