package com.dsalgo.automation.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.dsalgo.automation.driver.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentRptListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/target/screenshots/" + result.getName() + ".png";

            try {
                Files.createDirectories(Paths.get("target/screenshots"));
                Files.copy(src.toPath(), Paths.get(path));
                test.fail("Test failed: " + result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            } catch (IOException e) {
                test.fail("Test failed and screenshot could not be saved.");
            }
        } else {
            test.fail("Test failed: " + result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}