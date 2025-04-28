package com.dsalgo.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.automation.utils.WaitHelper;

public class LoginPage {
	WebDriver driver;
	WaitHelper waitHelper;
	 // Initialize logger for this class
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	
	@FindBy(xpath = "//input[@id='id_username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='id_password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")
	WebElement alertMsg;
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	WebElement successLogin;
	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement registerlink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	WebElement signout;
	@FindBy(xpath = "//div[contains(text(),'Logged out successfully')]")
	WebElement successLogout;
	
	@FindBy(xpath = "//*[text()='NumpyNinja']")
	WebElement numpyninjaLogo;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;                     //stores the driver passed from baseclass
		PageFactory.initElements(driver, this);   
		waitHelper = new WaitHelper(driver,10);
		logger.info("LoginPage initialized with WebDriver and waitHelper");
	}
	
	public void enterUsername(String userName) {
		try {
			username.clear();
			username.sendKeys(userName);
		} catch (Exception e) {
			logger.error("Unexpected error while entering username.");
		}

	}
	
	public void enterPassword(String passWord) {
		try {
			password.clear();
			password.sendKeys(passWord);
		} catch (Exception e) {
			logger.error("Unexpected error while entering password.");
		}
	}
	
	public void clickLogin() {
		try {
			waitHelper.waitForElementVisible(loginbtn);
			loginbtn.click();
		} catch (Exception e) {
				logger.error("Unexpected error while clicking login button.");
		}
	}

	public String getInvalidAlert() {
		try {
			String alertMessage = alertMsg.getText();
			return alertMessage;
			} catch (Exception e) {
				logger.error("Failed to get invalid alert message");
				return null;
		}
	}
	
	public boolean isLoginErrorMessageDisplayed() {
        try {
        	//wait for Alert message
			waitHelper.waitForElementVisible(alertMsg);
        	return alertMsg.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getUsernameValidationMessage() {
    	try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        return (String) js.executeScript("return arguments[0].validationMessage;", username);
	    } catch (Exception e) {
			logger.error("Failed to get username validation message");
			return null;
	    }
    }

    public String getPasswordValidationMessage() {
    	try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        return (String) js.executeScript("return arguments[0].validationMessage;", password);
    	} catch (Exception e) {
    		logger.error("Failed to get password validation message");
    		return null;
    	}
    }
    
	public void clickRegister() {
		registerlink.click();
	}

	public String register_page() {
		String title = driver.getTitle();
		return title;
	}

	public void logout() {
		signout.click();
	}
	
	
	public String getSuccessLogout() {
		String alert = successLogout.getText();
		return alert;
	}
	
	public void clickNumpyninjaLogo() {
		numpyninjaLogo.click();
	}
	
	public String getSuccessLogin() {
		waitHelper.waitForElementVisible(successLogin);
		String alert = successLogin.getText();
		System.out.println(alert);
		return alert;
	}
}
