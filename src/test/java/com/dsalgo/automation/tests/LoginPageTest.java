package com.dsalgo.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.utils.ConfigReader;

public class LoginPageTest extends BaseClass {
	private LoginPage loginPage; // Global declaration for reuse
	private HomePage homePage;
	// Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
    
    @BeforeClass
    public void setUpPage() {
		//Loginpage object is initialized using baseclass webdriver
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    
    @BeforeMethod
	public void navigateBeforeEachTest() {
	    homePage.navigateToHomePage();
	    homePage.clickSignin();
	}
    
    @Test
    public void testValidLogin() {
    	String username = ConfigReader.getProperty("username");
    	String password = ConfigReader.getProperty("password");
    	loginPage.enterUsername(username);
    	loginPage.enterPassword(password);
    	loginPage.clickLogin();
    	Assert.assertEquals(loginPage.getSuccessLogin(),"You are logged in","Login success message does not match.");
    }

}
