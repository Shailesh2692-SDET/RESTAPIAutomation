package api.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListenerclass implements ITestListener {

	ExtentSparkReporter htmlReporter; // For user interface i.e. look and feel of the report
	ExtentReports reports; // For common information
	ExtentTest test; // For entries to be done for tests

	public void configureReport() {

		// ReadConfig readConfig = new ReadConfig();
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "PetStoreAutomationTestReport-" + timeStamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		// reports.setSystemInfo("browser: ", readConfig.getBrowser());
		reports.setSystemInfo("User Name: ", "Shailesh");

		// Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Report Listner Demo");
		htmlReporter.config().setReportName("This Is My First Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	// OnStart method is called when any test starts
	public void onStart(ITestContext Result) {

		configureReport();
		System.out.println("On Start Method Invoked....");

	}

	// OnFinish method is called after all tests are executed
	public void onFinish(ITestContext Result) {

		System.out.println("On Finish Method Invoked....");
		reports.flush();

	}

	// When test case gets failed, this method is called
	public void onTestFailure(ITestResult Result) {

		System.out.println("Name Of Test Method Failed: " + Result.getName());
		test = reports.createTest(Result.getName()); // Create entry in HTML report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name Of The Failed Test Case", ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result;

		File screenshotFile = new File(screenshotPath);

		if (screenshotFile.exists()) {

			test.fail("Captured Screenshot Is Below: " + test.addScreenCaptureFromPath(screenshotPath));

		}

	}

	// When test case gets skipped, this method is called
	public void onTestSkip(ITestResult Result) {

		System.out.println("Name Of Test Method Skipped: " + Result.getName());
		test = reports.createTest(Result.getName()); // Create entry in HTML report
		test.log(Status.SKIP, MarkupHelper.createLabel("Name Of The Skipped Test Case", ExtentColor.YELLOW));

	}

	// When test case gets started, this method is called
	public void onTestStart(ITestResult Result) {

		System.out.println("Name Of The Test Method Started: " + Result.getName());

	}

	// When test case gets passed, this method is called
	public void onTestSuccess(ITestResult Result) {

		System.out.println("Name Of The Test Method Successfully Executed: " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name Of The Failed Test Case", ExtentColor.GREEN));

	}
	
	public void onTestFailButWithinSuccessPercentage(ITestResult Result) {
		
		
		
	}

}
