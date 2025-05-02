package com.dsalgo.automation.tests;


import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.utils.NavigationUtil;

/**
 * This class contains TestNG test cases for validating the functionality of the Home Page
 * of the DSAlgo application. It includes tests for logo navigation, dropdown validation,
 * get started button checks, and navigation to Register/SignIn pages.
 */
public class HomePageTest extends BaseClass {
	private HomePage homePage; // Global declaration for reuse
	private LoginPage loginPage; // Global declaration for reuse

	 // Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    
   

	@BeforeMethod
	public void navigateBeforeEachTest() {
		//homepage object is initialized using baseclass webdriver
		homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
	    NavigationUtil.navigateToHomePage(homePage);
	}
	

	
	@Test
	public void checkLogoHomeRedirection() {
		homePage.clickNumpyNinjaLogo();
		Assert.assertEquals(homePage.getTextLogo().toLowerCase(), "numpyninja", "Not redirected to home page");
		logger.info("Redirected to home page successfully");
	}
	
	
	@Test
	public void verifyCustomDropdownOptions() {
	    List<String> expectedOptions = Arrays.asList(
	    		"Data Structures-Introduction" , "Array", "Linked List", "Stack", "Queue", "Tree", "Graph"
	    );

	    // Make sure dropdown is visible before accessing items
	    homePage.clickDataStructuresDropdown(); // method to open dropdown if needed

	    List<String> actualOptions = homePage.getDropdownOptionTexts();

	    Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options mismatch. Data Structure Introduction is not available");
	}

    @DataProvider(name = "dropdownOptions")
    public Object[][] options() {
        return new Object[][] {
            {"Array"},
            {"Linked List"},
            {"Stack"},
            {"Queue"},
            {"Tree"},
            {"Graph"}
        };
    }

    @Test(dataProvider = "dropdownOptions")
    public void testEachDropdownOptionWithoutLogin(String option) {
        homePage.selectDropdown(option);

        if (homePage.isWarningMessageVisible()) {
            String warning = homePage.getWarningMessage();
            logger.warn("Warning for '" + option + "': " + warning);
            Assert.assertEquals(warning, "You are not logged in", "Unexpected warning for: " + option);
        } else {
            logger.info("No warning for '" + option + "'");
        }

        driver.navigate().back();
    }
    

    @Test(dataProvider = "dropdownOptions")
    public void testEachDropdownOptionWithLogin(String option) {
    	NavigationUtil.performLogin(homePage, loginPage);
        homePage.selectDropdown(option);

        Assert.assertTrue(homePage.isPageDisplayed(option), 
                "Failed to navigate to page for: " + option);
        driver.navigate().back();
        NavigationUtil.clickSignout(homePage);
    }

    @DataProvider(name = "getstartedOptions")
    public Object[][] getstartedOptions() {
        return new Object[][] {
        	{"Data Structures-Introduction"},
            {"Arrays"},
            {"Linked List"},
            {"Stack"},
            {"Queue"},
            {"Tree"},
            {"Graph"}
        };
    }
	@Test(dataProvider = "getstartedOptions")
	public void testGetStartedButtonsWithoutLogin(String option) {
	        homePage.getStartedhome(option);
	        // Check if warning is displayed
	        if (homePage.isWarningMessageVisible()) {
	            String warning = homePage.getWarningMessage();
	            logger.warn("Warning message displayed for '" + option + "': " + warning);
	            Assert.assertEquals(warning, "You are not logged in", "Unexpected warning message.");
	        } else {
	            logger.info("No warning message for '" + option + "'");
	        }

	        driver.navigate().back(); // Go back to home page for next iteration
	    
	}
	
	@Test
	public void checkRegister() {
		homePage.clickRegister();
		Assert.assertTrue(homePage.isRegisterPageDisplayed(), "Failed to navigate to Register page.");
	}
	
	@Test
	public void checkSignin() {
		homePage.clickSignin();
		Assert.assertTrue(homePage.isSignInPageDisplayed(), "Failed to navigate to Sign in page.");
	}

	
}
