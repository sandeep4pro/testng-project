package web.automation.utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

import com.aventstack.extentreports.reporter.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners /*extends Hooks*/ implements ITestListener, IAnnotationTransformer {
    public static String testName;
    private ExtentReports extent;
    public static ExtentTest test;

    public void onStart(ITestContext context) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./target/test-execution-report.html");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Automation test report");
        htmlReporter.config().setEncoding("utf-10");
        htmlReporter.config().setReportName("Automation Report");
        extent = new ExtentReports();
        extent.setSystemInfo("Author", "Sandeep Kumar");
        extent.setSystemInfo("Environment", ConfigReader.getEnv().toUpperCase());
        extent.setSystemInfo("Running on os ", System.getProperty("os.name").toUpperCase());
        extent.attachReporter(htmlReporter);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName(), result.getMethod().getDescription());
        testName = result.getName();
        test.log(Status.INFO, testName + " Test has Started");
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName() + " Test Passed Successfully");
        try {
            test.addScreenCaptureFromPath(ScreenshotGenerator.captureScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getName() + " Test is failed due to " + result.getThrowable());
        try {
            test.addScreenCaptureFromPath(ScreenshotGenerator.captureScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " Test is skipped due to " + result.getThrowable());
        try {
            test.addScreenCaptureFromPath(ScreenshotGenerator.captureScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    // IAnnotationTransformer
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}