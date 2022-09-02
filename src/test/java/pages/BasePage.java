package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(element(locator,type)));
	}
	
	public void waitForElementInVisiblity(String locator,Types type) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(1));
		wait.until(ExpectedConditions.invisibilityOf(element(locator,type)));
	}

	public void click(String locator, Types type) {
		waitForElementVisiblity(locator, type);
		element(locator,type).click();
	}

	public void sendKeys(String locator, Types type,String data) {
		element(locator,type).sendKeys(data);
	}
	public void sendKeys(String locator, Types type,Keys key) {
		element(locator,type).sendKeys(key);
	}
	public String getText(String locator, Types type) {
		return element(locator,type).getText();
	}

	public boolean isElementDisplayed(String locator, Types type) {
		boolean status = false;
		try {
			element(locator,type).isDisplayed();	
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
		
	}
	public boolean isElementEnabled(String locator, Types type) {
		boolean status = false;
		try {
			element(locator,type).isEnabled();	
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
		
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
	
	public boolean isEnabled(String locator,Types type) {
		boolean enable= false;
		if (element(locator,type).isEnabled()) {
			enable = true;
		}
		return enable;
	}
	
	public  List<WebElement> getWebElements(String locator, Types type) {
		return driver.findElements(bylocator(type,locator));
	}
	
	public void enterData( String locator, Types type, String value) {
		waitForElementVisiblity(locator, type);
		hardWait(1000);
		click(locator, type);
		hardWait(1000);
		element(locator, type).clear();
		hardWait(2000);
		element(locator, type).sendKeys(value);
	}
	public void hardWait(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public void selectValueUsingSelectClass(String locator, Types type,  String value) {
		try {
			waitForElementVisiblity(locator, type);
			Select dropdown = new Select(element(locator,type));
			dropdown.selectByValue(value);
			//log.info("SelectByValue action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			//log.error("Timeout occurs while selecting dropdrown option for element " + locator);
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			//log.error("NoSuchElementException occurs while selecting dropdrown option " + locator);
		}
	}
	
}
