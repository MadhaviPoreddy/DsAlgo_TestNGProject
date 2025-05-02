package com.dsalgo.automation.utils;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.chaintest.plugins.ChainTestListener;
import com.dsalgo.automation.base.BaseClass;

public class ScreenshotListener implements ITestListener{
	
	@Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseClass) testClass).getDriver(); // Cast to your base class that exposes WebDriver

        if (driver != null) {
            try {
            	ChainTestListener.embed(((TakesScreenshot) (driver)).getScreenshotAs(OutputType.BYTES), "image/png");

            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

}
