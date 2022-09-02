package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Testcode {

	//@Test
	public void LoginIntoApplication(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		// Navigate to the site website
		//driver.get("https://tmslitedev.swanleap.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@routerlink='/accounts/login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("testUser-fW1sESL9H69tSgSwZafFPH");
		//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("fW1sESL9H69tSgSwZafFPH");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean isvisible= driver.findElement(By.xpath("//a[@ng-reflect-router-link='/shipments/create']")).isDisplayed();
		Assert.assertEquals(true, isvisible);

		driver.quit();
	}

	@Test
	public void test() {
		
		String abc = "test";
		for(int i =1;i<10;i++) {
			System.out.println("newabc}");
			}
	}
}
