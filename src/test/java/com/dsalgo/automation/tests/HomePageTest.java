package com.dsalgo.automation.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.HomePage;

public class HomePageTest extends BaseClass {
	private HomePage homePage; // Global declaration for reuse
	 // Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    
	@BeforeClass
    public void setUpPage() {
		//homepage object is initialized using baseclass webdriver
        homePage = new HomePage(driver);
    }
	
	@BeforeMethod
	public void navigateBeforeEachTest() {
	    homePage.navigateToHomePage();
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

}
