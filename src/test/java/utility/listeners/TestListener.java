package utility.listeners;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import tests.BaseTest;
import utility.FileManager;
import utility.constants.Constants;
import utility.extentreports.ExtentManager;

public class TestListener extends BaseTest implements ITestListener {
	//Extent Report Declarations
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Extent Reports Version 3 Test Suite started!");
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		FileManager filemanager = new FileManager();
		filemanager.cleanDir(s + File.separator + "test-output");
		//filemanager.cleanDir(s + File.separator + "Extent Reports/Failure Screenshots/");
		//filemanager.cleanDir(s + File.separator + "Extent Reports/Passed Screenshots/");
		//filemanager.cleanDir(s + File.separator + "Extent Reports/Skipped Screenshots/");
	}
	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
		ExtentManager.getInstance().setSystemInfo("Environment", FileManager.readProperty(Constants.configFilePath, "url")); 
		ExtentManager.getInstance().setSystemInfo("OS", ExtentManager.getCurrentPlatform().name());
		ExtentManager.getInstance().setSystemInfo("OS Version", FileManager.readProperty(Constants.configFilePath, "os"));
		ExtentManager.getInstance().setSystemInfo("Browser", FileManager.readProperty(Constants.configFilePath, "browser"));
		extent.flush();
	}
	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		test.set(extentTest);
	}
	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
	}
	@Override
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		//below line is just to append the date format with the screenshot name to avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+result.getMethod().getMethodName()+dateName+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Returns the captured file path
		

		test.get().fail(result.getThrowable());
		try {
			test.get().addScreenCaptureFromPath(destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().skip(result.getThrowable());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}
}