package com.dsalgo.automation.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	 private WebDriverWait wait;

	    public WaitHelper(WebDriver driver, int timeoutInSeconds) {
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    }

	    public void waitForElementVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public void waitForTextToBePresent(WebElement element, String text) {
	        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	    }
	    
	    public Alert waitForAlertIsPresent() {
	    	return wait.until(ExpectedConditions.alertIsPresent());
	    }
}
