package com.dsalgo.automation.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.dsalgo.automation.driver.DriverFactory;

import io.qameta.allure.Attachment;

public class AllureRptListener implements ITestListener {
	
	private static Logger LOGGER = LogManager.getLogger(AllureRptListener.class);

	    @Override
	    public void onTestFailure(ITestResult result) {
	        WebDriver driver = DriverFactory.getDriver();
	        if (driver != null) {
	            saveFailureScreenshot(driver);
	        } else {
	            LOGGER.info("Driver is null in listener!");
	        }
	    }

	    @Attachment(value = "FailureScreenshot", type = "image/png")
	    public byte[] saveFailureScreenshot(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
	}

    
   
