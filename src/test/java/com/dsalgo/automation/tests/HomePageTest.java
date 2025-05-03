package com.dsalgo.automation.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.utils.NavigationUtil;

public class HomePageTest extends BaseClass {
	private HomePage homePage; // Global declaration for reuse
	 // Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);

	@BeforeClass
	public void navigateBeforeEachTest() {
		//homepage object is initialized using baseclass webdriver
		homePage = new HomePage(driver);
	    NavigationUtil.navigateToHomePage(driver);
	}
	
	@Test
	public void checkLogoHomeRedirection() {
		homePage.clickNumpyNinjaLogo();
		Assert.assertEquals(homePage.getTextLogo().toLowerCase(), "numpyninja", "Not redirected to home page");
		logger.info("Redirected to home page successfully");
	}
	
	@Test
	public void checkDropdown() {
		homePage.clickDataStructuresDropdown();
		Assert.assertTrue(homePage.isDataStructureIntroOptionVisible(), "Expected 'Data Structure Introduction' to be visible, but it was not.");
	}
	

    @DataProvider(name = "dropdownOptions")
    public Object[][] options() {
        return new Object[][] {
            {"Arrays"},
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

	@Test
	public void clickDataStructureGetStarted() {
		NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Data Structures-Introduction");
		Assert.assertTrue(homePage.isDataStructurePageDisplayed(), "Failed to navigate to Data Structure Page");
		NavigationUtil.clickSignout(driver);
	}
	
	
	@Test
	public void clickGraphGetStarted() {
		NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Graph");
		Assert.assertTrue(homePage.isGraphPageDisplayed(), "Failed to navigate to Graph Page");
		NavigationUtil.clickSignout(driver);
	}
	
}