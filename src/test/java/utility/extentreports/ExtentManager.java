package utility.extentreports;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.FileManager;
import utility.constants.Constants;

public class ExtentManager {

	private static ExtentReports extent;
	private static Platform platform;
	private static String os;
	private static String browser;


	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}
	//Create an extent report instance
	public static ExtentReports createInstance() {
		browser = FileManager.readProperty(Constants.configFilePath, "browser");
		os = FileManager.readProperty(Constants.configFilePath, "os");
		String fileName = Constants.extentReportPath+"\\"+os+"_"+browser+"_"+"ExtentReport.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("TMSLite Automation Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("TMSLite Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}
	
	//Get current platform
	public static Platform getCurrentPlatform () {
		if (platform == null) {
			String operSys = System.getProperty("os.name").toLowerCase();
			if (operSys.contains("win")) {
				platform = Platform.WINDOWS;
			} else if (operSys.contains("nix") || operSys.contains("nux")
					|| operSys.contains("aix")) {
				platform = Platform.LINUX;
			} else if (operSys.contains("mac")) {
				platform = Platform.MAC;
			}
		}
		return platform;
	}
}
