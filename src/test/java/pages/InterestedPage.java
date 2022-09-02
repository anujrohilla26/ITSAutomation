package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import pages.BasePage.Types;

public class InterestedPage extends BasePage{

	String interestedButton = "(//a[contains(text(),'Bid Now')])[last()]";

    
	public void clickOnInterestedButton(WebDriver driver){
		String loadList="//tr[contains(@class,'viewed')]";
	    String interestedButton = "(//span[contains(text(),'Interested')])[1]";
		waitForElementVisiblity(loadList,Types.XPATH);
		List<WebElement> listItem=getWebElements(loadList,Types.XPATH);
		for(int i=0;i<listItem.size();i++){
			click(loadList, Types.XPATH);
			if(getWebElements(interestedButton,Types.XPATH).size()>0){
				click(interestedButton,Types.XPATH);
				break;
			
	}}}
}

