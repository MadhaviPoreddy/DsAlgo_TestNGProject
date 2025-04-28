package com.dsalgo.automation.tests;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.pages.DataStructure;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.utils.ExcelReader;
import com.dsalgo.automation.utils.NavigationUtil;

public class DataStructureTest extends BaseClass {
	private HomePage homePage; // Global declaration for reuse
	private DataStructure dataStructure;
	 // Initialize logger for this class
	private static final Logger logger = LogManager.getLogger(DataStructureTest.class);
	
	@BeforeMethod
	public void navigateBeforeEachTest() {
		//homepage object is initialized using baseclass webdriver
		homePage = new HomePage(driver);
		//datastructure page object is initialized using baseclass webdriver
		dataStructure = new DataStructure(driver);
	    NavigationUtil.navigateToHomePage(driver);
	}
	
	@DataProvider(name = "pythoncodeData")
	public static Object[][] getRunnableData() {
	    List<Map<String, String>> allData = ExcelReader.getAllRows("Try Here");

	    // Filter rows where Execute column is YES
	    List<Map<String, String>> pythoncodeData = allData.stream()
	            .filter(row -> "Yes".equalsIgnoreCase(row.get("Execute")))
	            .collect(Collectors.toList());

	    Object[][] result = new Object[pythoncodeData.size()][1];
	    for (int i = 0; i < pythoncodeData.size(); i++) {
	        result[i][0] = pythoncodeData.get(i);
	    }
	    return result;
	}
	
	@Test(dataProvider = "pythoncodeData")
	public void testValidInvalidPythonCode(Map<String, String> data) {
		NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Data Structures-Introduction");
		Assert.assertTrue(homePage.isDataStructurePageDisplayed(), "Failed to navigate to Data Structure Page");
		dataStructure.clickTimeCom();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Time Complexity", "Failed to navigate to Time Complexity Page");
		dataStructure.clickTryHere();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Assessment", "Failed to navigate to Try Editor Page");
		try {
			String pythonCode = data.get("PythonCode");
	        String expectedOutput = data.get("Output");
	        String expectedType = data.get("Type");
	        dataStructure.enterPythonCode(pythonCode);
	        dataStructure.clickRunButton();
	        
	        if ("Alert".equalsIgnoreCase(expectedType)) {
	        	String alertMessage = dataStructure.AlertGetText();
	        	Assert.assertEquals(alertMessage,expectedOutput, "Mismatch! expected output is: " + expectedOutput);
	            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
	        }else {
		        String actualOutput = dataStructure.successMsg();
		        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Mismatch in Try Editor Output!");
	       }
		} catch (Exception e) {
	        logger.error("Test failed due to exception: ", e);
	        throw e;  // Re-throw the caught exception to fail the test
		} finally {
	        driver.navigate().back();
	        NavigationUtil.clickSignout(driver);
	    }
	}
	
	@Test
	public void practiceQues() {
		NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Data Structures-Introduction");
		Assert.assertTrue(homePage.isDataStructurePageDisplayed(), "Failed to navigate to Data Structure Page");
		dataStructure.clickTimeCom();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Time Complexity", "Failed to navigate to Time Complexity Page");
		dataStructure.clickPracticeQues();
		Assert.assertEquals(dataStructure.getTitleofPage(), "Practice Questions", "Failed to navigate to Practice Questions Page");
		
		try {
			Assert.assertTrue(dataStructure.isPageBlank(), "The Practice Questions page is unexpectedly blank!");
		} catch (AssertionError e) {
		    logger.error("Assertion failed: " + e.getMessage());
		    throw e;  // Re-throw so TestNG still marks test as failed
	    } finally {
	        driver.navigate().back();
	        NavigationUtil.clickSignout(driver);
	    }
		
	}
}
