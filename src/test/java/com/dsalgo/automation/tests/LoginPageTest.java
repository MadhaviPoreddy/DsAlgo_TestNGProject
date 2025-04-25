package com.dsalgo.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;

import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.utils.NavigationUtil;


public class LoginPageTest extends BaseClass {
	private LoginPage loginPage; // Global declaration for reuse
	
	// Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
    
    
    @BeforeClass
    public void setUpPage() {
		//Loginpage object is initialized using baseclass webdriver
        loginPage = new LoginPage(driver);
       
    }
    
    @BeforeMethod
	public void navigateBeforeEachTest() {
	    NavigationUtil.navigateToHomePage(driver);
	    
	}
    
    @Test
    public void testValidLogin() {
    	NavigationUtil.performLogin(driver);
    	Assert.assertEquals(loginPage.getSuccessLogin(),"You are logged in","Login success message does not match.");
    }

}
