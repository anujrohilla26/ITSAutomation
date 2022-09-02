package pages;

import org.openqa.selenium.WebDriver;

import pages.BasePage.Types;

public class AvailableLoadsPage extends BasePage{
	
	CommonPage commonPage = new CommonPage();
 
	String welcomeText="welcome-message";
	String AvilableLoads = "//*[@class='nav nav-tabs']//li[1]";
	String AvilableLoadsCount = "//*[@class='nav nav-tabs']//li[1]//span";
	String FirstRow = "//*[contains(@class,'viewed ng-star-inserted')][1]";
	String BidButton = "//Button[@class='mat-focus-indicator its-bid-default-button mat-raised-button mat-button-base its-bid-button']";
	String InterestButton = "//Button[@class='mat-focus-indicator ml-a mat-raised-button mat-button-base its-interested-button']";
	String FlatRate = "//input[@id='mat-input-2']";
	String Submit = "//button[@class='mat-focus-indicator its-submit-button mat-raised-button mat-button-base']";
	String BidNow = "//*[@class='viewed ng-star-inserted'][1]//a";
	String VerificationBid = "//*[contains(text(),'Thank you for submitting a bid!')]";
	String VerificationInterest = "//*[contains(text(),'Thank you for submitting a Interest!')]";
	String LoadingImage = "";
	String RemoveWatchlist =  "//a[text()='favorite']" ;
	String AddToWatchlist =  "//a[text()='favorite_border']" ;
	String RemoveWatchlistLoadsDetail =  "//span[contains(@class,'watching-text ng-star-inserted')]/..//mat-icon[contains(text(),'favorite')]" ;
	String AddToWatchlistLoadsDetail =  "//span[contains(@class,'watching-text ng-star-inserted')]/..//mat-icon[contains(text(),'favorite_border')]" ;
	
	
	public String getWelcomeText(WebDriver driver) {
		return getText(welcomeText,Types.CLASSNAME);
	}

	public String getAvailableLoads(WebDriver driver) {
		return getText(AvilableLoadsCount,Types.XPATH);
	}
	
	public void clickLoad(WebDriver driver) {
    	commonPage.waitForLoaderInvisibility();
		click(FirstRow, Types.XPATH);
	}
	
	public void raiseBid(WebDriver driver) throws InterruptedException {
		click(FirstRow, Types.XPATH);
		Thread.sleep(10000);
		for(int i =1;i<10;i++) {
			
			click("//*[@class='viewed ng-star-inserted'][1]",Types.XPATH);
			if(isEnabled(BidButton, Types.XPATH)) {
				break;
			}
		}
		
		click(BidButton,Types.XPATH);
		sendKeys(FlatRate, Types.XPATH, "100");
		click(Submit,Types.XPATH);
		
	}
	
	public void raiseInterest(WebDriver driver) throws InterruptedException {
		click(FirstRow, Types.XPATH);
		Thread.sleep(30000);
		for(int i =1;i<10;i++) {
			//click("//*[@class='viewed ng-star-inserted'and position()=i]",Types.XPATH);
			
			click("//*[@class='viewed ng-star-inserted'][1]",Types.XPATH);
			if(isEnabled(InterestButton, Types.XPATH)) {
				break;
			}
		}
		
		click(InterestButton,Types.XPATH);
		//sendKeys(FlatRate, Types.XPATH, "100");
		click(Submit,Types.XPATH);
		
	}
	
	public boolean VerifyBidThankYouMsg() {
		
		return isElementDisplayed(VerificationBid, Types.XPATH);
		
	}
    public boolean VerifyInterestThankYouMsg() {
		
		return isElementDisplayed(VerificationInterest, Types.XPATH);
		
	}
    
    public void addToWatchlist()
    {
    	commonPage.waitForLoaderInvisibility();
    	waitForElementVisiblity(AddToWatchlist, Types.XPATH);
    	 click(AddToWatchlist, Types.XPATH);
    }
    public void RemoveFromWatchlist()
    { 
    	 commonPage.waitForLoaderInvisibility();
    	 waitForElementVisiblity(RemoveWatchlist, Types.XPATH);
    	 click(RemoveWatchlist, Types.XPATH);
    }
    
    public void addToWatchlistFromLoadDetails()
    { 
    	commonPage.waitForLoaderInvisibility();
    	waitForElementVisiblity(AddToWatchlistLoadsDetail, Types.XPATH);
    	 click(AddToWatchlistLoadsDetail, Types.XPATH);
    }
    public void RemoveFromWatchlistFromLoadDetails()
    { 
    	commonPage.waitForLoaderInvisibility();
    	waitForElementVisiblity(RemoveWatchlistLoadsDetail, Types.XPATH);
    	 click(RemoveWatchlistLoadsDetail, Types.XPATH);
    } 
    
    


}
