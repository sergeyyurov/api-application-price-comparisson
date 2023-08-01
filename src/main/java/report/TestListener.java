package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static report.ExtentReportManager.createSparkInstance;

/**
 *  The class is used to listen for test events to generate corresponding HTML report after test execution.
 */
public class TestListener implements ITestListener {
    ExtentReports extentReports;
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) { test = extentReports.createTest(result.getMethod().getMethodName()); }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.info("Test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.info(result.getThrowable());
        test.fail("Test failure");
    }

    @Override
    public void onStart(ITestContext context) {
        extentReports = createSparkInstance("src/test/report/report.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
