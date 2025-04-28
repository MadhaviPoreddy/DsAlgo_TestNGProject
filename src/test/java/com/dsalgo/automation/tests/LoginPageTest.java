package com.dsalgo.automation.tests;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
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
	    NavigationUtil.navigateToHomePage(driver);
	    homePage = new HomePage(driver);
	}
    
    @Test
    public void testValidLogin() {
    	NavigationUtil.performLogin(driver);
    	Assert.assertEquals(loginPage.getSuccessLogin(),"You are logged in","Login success message does not match.");
    	NavigationUtil.clickSignout(driver);
    }
    
    
    @DataProvider(name = "allInvalidLoginData")
    public static Object[][] getAllLoginData() {
        List<Map<String, String>> allData = ExcelReader.getAllRows("SignIn"); // No filtering now!

        Object[][] result = new Object[allData.size()][1];
        for (int i = 0; i < allData.size(); i++) {
            result[i][0] = allData.get(i);
        }
        return result;
    }
    
    
    @Test(dataProvider = "allInvalidLoginData")
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
            // If username is empty, check that user stays on login page
            Assert.assertEquals(loginPage.getUsernameValidationMessage(),"Please fill out this field.", "Username validation message not displayed");
        } else if ( password.isEmpty()){
        	// If username is empty, check that user stays on login page
            Assert.assertEquals(loginPage.getPasswordValidationMessage(),"Please fill out this field.", "Password validation message not displayed");
        }else {
            // Otherwise, check for alert message
            String alertMessage = loginPage.getInvalidAlert();
            Assert.assertEquals(alertMessage, "Invalid Username and Password", "Unexpected alert message!");
        }  
        logger.info("Tested invalid login with: " + username + " | " + password);
       
    }
}
