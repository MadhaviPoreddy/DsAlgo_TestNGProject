package com.dsalgo.automation.tests;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.DataStructure;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.utils.TestDataProvider;
import com.dsalgo.automation.utils.ExcelReader;
import com.dsalgo.automation.utils.NavigationUtil;

public class DataStructureTest extends BaseClass {
	private HomePage homePage; // Global declaration for reuse
	private LoginPage loginPage;
	private DataStructure dataStructure;
	 // Initialize logger for this class
	private static final Logger logger = LogManager.getLogger(DataStructureTest.class);
	
	@BeforeMethod
	public void navigateBeforeEachTest() {
		//homepage object is initialized using baseclass webdriver
		homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
		//datastructure page object is initialized using baseclass webdriver
		dataStructure = new DataStructure(driver);
	    NavigationUtil.navigateToHomePage(homePage);
	}
	
	@AfterMethod
	public void afterEachTest() {
		driver.navigate().back();
        NavigationUtil.clickSignout(homePage);
	}
	
	
	@Test(dataProvider = "pythoncodeData", dataProviderClass = TestDataProvider.class)
	public void testValidInvalidPythonCode(Map<String, String> data) {
		NavigationUtil.performLogin(homePage,loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Data Structures-Introduction");
		Assert.assertTrue(homePage.isDataStructurePageDisplayed(), "Failed to navigate to Data Structure Page");
		dataStructure.clickTimeCom();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Time Complexity", "Failed to navigate to Time Complexity Page");
		dataStructure.clickTryHere();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Assessment", "Failed to navigate to Try Editor Page");
	
		String pythonCode = data.get("PythonCode");
        String expectedOutput = data.get("Output");
        String expectedType = data.get("Type");
        dataStructure.enterPythonCode(pythonCode);
        logger.info("Entered Python Code: " + pythonCode);
        dataStructure.clickRunButton();
        logger.info("Clicked Run Button");

        if ("Alert".equalsIgnoreCase(expectedType)) {
        	String alertMessage = dataStructure.AlertGetText();
        	Assert.assertEquals(alertMessage,expectedOutput, "Mismatch! expected output is: " + expectedOutput);
            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
        }else {
	        String actualOutput = dataStructure.successMsg();
	        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Mismatch in Try Editor Output!");
	        logger.info("Verified Output message successfully." + pythonCode + "Output Message:" + actualOutput);
       }
		
	}
	
	@Test
	public void practiceQues() {
		NavigationUtil.performLogin(homePage, loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Data Structures-Introduction");
		Assert.assertTrue(homePage.isDataStructurePageDisplayed(), "Failed to navigate to Data Structure Page");
		dataStructure.clickTimeCom();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Time Complexity", "Failed to navigate to Time Complexity Page");
		dataStructure.clickPracticeQues();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Practice Questions", "Failed to navigate to Practice Questions Page");
		Assert.assertTrue(dataStructure.isPageBlank(), "The Practice Questions page is unexpectedly blank!");
		
	}
}
