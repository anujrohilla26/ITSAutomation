package utility;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;	
import utility.constants.Constants;

public class DriverSetup extends Instance{

	public void openApplication() {
		String browser = FileManager.readProperty(Constants.configFilePath, "browser");
		String url = FileManager.readProperty(Constants.configFilePath, "url");
		if(browser.equalsIgnoreCase("chrome")) { 
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();  		
		}
		else if(browser.equalsIgnoreCase("firefox")) { 
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();  

		}
		else if(browser.equalsIgnoreCase("edge")) { 
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();  
		}
		else if(browser.equalsIgnoreCase("safari")) { 
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();  
		}
		else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("--headless");
			//chromeOptions.addArguments("disable-dev-shm-usage");
			driver=new ChromeDriver(chromeOptions);
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.manage().window().maximize();

	}


}
