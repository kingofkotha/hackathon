package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener {
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test
							// methods

	public void onStart(ITestContext context) {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");// specify
																											// location
																											// of the
																											// report

		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "HP EliteBook 845");
		extent.setSystemInfo("Environment", "QEA");
		extent.setSystemInfo("Tester Name", "Moosa Shaik");
		extent.setSystemInfo("os", "Windows11");
		extent.setSystemInfo("Browser name", "Chrome");

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		try {
			
			String imgPath=new Screenshots(driver).screenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);

			
		} catch (Exception e) {
			
		}
	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
		try {
			
			String imgPath=new Screenshots(driver).screenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);

			
		} catch (Exception e) {
			
		}

	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		try {
			
			String imgPath=new Screenshots(driver).screenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);

			
		} catch (Exception e) {
			
		}

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
