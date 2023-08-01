package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

/**
 * Class for creating and managing HTML report.
 */
public class ExtentReportManager {

    /**
     * Creates HTML reports.
     *
     * @param fileNamePath The path and name of the HTML report file to be generated.
     * @return Customized report.
     */
    public static ExtentReports createSparkInstance(String fileNamePath) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileNamePath);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}