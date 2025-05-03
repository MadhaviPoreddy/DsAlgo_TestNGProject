package com.dsalgo.automation.tests;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.utils.TestDataProvider;
import com.dsalgo.automation.utils.ExcelReader;
import com.dsalgo.automation.utils.NavigationUtil;

public class LoginPageTest extends BaseClass {
	private LoginPage loginPage; // Global declaration for reuse
	private HomePage homePage;
	// Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
    
    
    @BeforeMethod
	public void navigateBeforeEachTest() {
    	//Loginpage object is initialized using baseclass webdriver
        loginPage = new LoginPage(driver);
	    homePage = new HomePage(driver);
	    NavigationUtil.navigateToHomePage(homePage);

	}

	
   
    @Test
    public void testValidLogin() {
    	NavigationUtil.performLogin(homePage,loginPage);
    	Assert.assertEquals(loginPage.getSuccessLogin(),"You are logged in","Login success message does not match.");
    	NavigationUtil.clickSignout(homePage);
    }
    
    
   
    @Test(dataProvider = "allInvalidLoginData", dataProviderClass = TestDataProvider.class)
    public void testInvalidLogin(Map<String, String> data) {
    	homePage.clickSignin();
        String username = data.get("username");
        String password = data.get("password");
        if (username == null || username.trim().isEmpty()) {
            loginPage.enterUsername(""); // send empty string
        } else {
            loginPage.enterUsername(password);
        }
        
        if (password == null || password.trim().isEmpty()) {
            loginPage.enterPassword(""); // send empty string
        } else {
            loginPage.enterPassword(password);
        }
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        

        if (username.isEmpty() ) {
            // If username is empty, check message Please fill out this field
            Assert.assertEquals(loginPage.getUsernameValidationMessage(),"Please fill out this field.", "Username validation message not displayed");
        } else if ( password.isEmpty()){
        	// If password is empty, check message Please fill out this field
            Assert.assertEquals(loginPage.getPasswordValidationMessage(),"Please fill out this field.", "Password validation message not displayed");
        }else {
            // Otherwise, check for alert message
            String alertMessage = loginPage.getInvalidAlert();
            Assert.assertEquals(alertMessage, "Invalid Username and Password", "Unexpected alert message!");
        }  
        logger.info("Tested invalid login with: " + username + " | " + password);
       
    }
}
