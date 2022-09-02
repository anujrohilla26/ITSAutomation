package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.Instance;


public class BasePage extends Instance{
	




	 enum Types{
		XPATH,
		CSS,
		ID,
		NAME,
		CLASSNAME
	}


	public static WebElement element(String locator, Types type) {
		return driver.findElement(bylocator(type,locator));
	}
	public static List<WebElement> getWebElements(String locator, Types type) {
		return driver.findElements(bylocator(type,locator));
	}

	public static By bylocator(Types type,String locator) {
		switch(type) {
		case XPATH:
			return By.xpath(locator);
		case CSS:
			return By.cssSelector(locator);
		case NAME:
			return By.name(locator);
		case CLASSNAME:
			return By.className(locator);
		default:
			return null;	

		}

	}

	public void waitForElementVisiblity(String locator,Types type) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(element(locator,type)));
	}
	public void waitForElementClickability(String locator,Types type) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
		wait.until(ExpectedConditions.elementToBeClickable(element(locator,type)));
	}
	public void waitForElementInVisiblity(String locator,Types type) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
		wait.until(ExpectedConditions.invisibilityOf(element(locator,type)));
	}
	

	public void click(String locator, Types type) {
			pause(4000);
		if (!(getWebElements(locator, type).size()>0)) {
			waitForElementVisiblity(locator, type);
			waitForElementClickability(locator, type);
		}
		
		element(locator, type).click();
	}

	public void sendKeys(String locator, Types type,String data) {
		waitForElementVisiblity(locator, type);
		element(locator,type).sendKeys(data);
	}
	
	public void sendKeysAfterDeleteExistingValue(String locator, Types type,String data) {
		waitForElementVisiblity(locator, type);
		element(locator,type).click();
		element(locator,type).clear();
		element(locator,type).sendKeys(data);
	}
	
	
	public void sendKeys(String locator, Types type,Keys key) {
		element(locator,type).sendKeys(key);
	}
	public String getText(String locator, Types type) {
		return element(locator,type).getText();
	}

	public boolean isElementDisplayed(String locator, Types type) {
		return element(locator,type).isDisplayed();	
	}
	
	public boolean isElementNotDisplayed(String locator, Types type) {
	    try{
	       return(!element(locator,type).isDisplayed());
	    }
	    catch(Exception e){
	       return false;
	    }
	    }
	public void selectCheckBox(String locator,Types type) {
		if (!element(locator,type).isSelected()) {
			element(locator,type).click();
		}
	}
	
	public void unselectCheckBox(String locator,Types type) {
		if (element(locator,type).isSelected()) {
			element(locator,type).click();
		}
	}
	
	public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException i) {
			i.printStackTrace();
		}
	}
	
	public void hardWait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException i) {
			i.printStackTrace();
		}
	}
	
	public void scrollToElement(String locator,Types type){
		waitForElementVisiblity(locator, type);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", locator);
		pause(200);
		
	}
	public void rightScrollToElement(String locator,Types type){
		waitForElementVisiblity(locator, type);	
		((JavascriptExecutor)driver).executeScript("window.scrollBy(2000,0)",locator);
	   }
		
	public void scrollDown(String locator,Types type){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator);;	
		
	
	}
	
	public boolean isEnabled(String locator,Types type) {
		boolean enable= false;
		if (element(locator,type).isEnabled()) {
			enable = true;
		}
		return enable;
	}
	
	public boolean isBtnEnabled(String locators,Types type) {
		boolean status = false;
		try {
			waitForElementClickability(locators,type);
			element(locators,type).isEnabled();
			status = true;
		} catch (NoSuchElementException e) {
			status = false;
		}
		return status;
	}
	
	public void scrolToRightUsingAction(WebDriver driver) {
		List<WebElement> ele = driver.findElements(By.cssSelector("div.ag-body-horizontal-scroll-viewport"));
		if(ele.size()>0) {
			ele.get(0).click();
			Actions move = new Actions(driver);
			move.moveToElement(ele.get(0)).clickAndHold();
			move.moveByOffset(300,0);
			move.release();
			move.perform();
			hardWait(3000);
		}
		
		
	}
	
	/**
	 * @param driver
	 * @param locator
	 * @param attributeName
	 * @return
	 */
	public String getValueFromAttribute(String locators,Types types, String attributeName) {
		waitForElementVisiblity(locators, types);
		return element(locators, types).getAttribute(attributeName);
}
	
}
	
