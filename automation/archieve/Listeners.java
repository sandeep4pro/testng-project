package web.automation.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Listeners implements IReporter, ITestListener, IAnnotationTransformer {
    private ExtentReports extent;
    private static ExtentTest test;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports("./target/test-execution-report.html", true);
        Map<String, String> map = new TreeMap<>();
        map.put("OS", "Windows 8.1");
        extent.addSystemInfo(map);
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                try {
                    buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                    buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                    buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        extent.flush();
        extent.close();
    }

    public void buildTestNodes(IResultMap tests, LogStatus status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));
                for (String group : result.getMethod().getGroups()) {
                    test.assignCategory(group);
                }
                if (result.getThrowable() != null) {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                    test.log(status, result.getThrowable());
                    test.log(status, test.addScreenCapture(ScreenshotGenerator.screenshotPath));
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                    test.log(status, test.addScreenCapture(ScreenshotGenerator.screenshotPath));
                }
                extent.endTest(test);
            }
        }

    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    // IAnnotationTransformer
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}

