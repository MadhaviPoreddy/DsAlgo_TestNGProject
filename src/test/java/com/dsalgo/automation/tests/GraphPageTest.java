package com.dsalgo.automation.tests;

import java.io.IOException;
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
import com.dsalgo.automation.pages.GraphPage;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.utils.ExcelReader;
import com.dsalgo.automation.utils.NavigationUtil;

public class GraphPageTest extends BaseClass{
	private HomePage homePage; // Global declaration for reuse
	private GraphPage graphPage;
	private LoginPage loginPage;

	 // Initialize logger for this class
	private static final Logger logger = LogManager.getLogger(GraphPageTest.class);
	
	@BeforeMethod
	public void navigateBeforeEachTest() {
		//homepage object is initialized using baseclass webdriver
		homePage = new HomePage(driver);
		//datastructure page object is initialized using baseclass webdriver
		graphPage = new GraphPage(driver);
		loginPage = new LoginPage(driver);
	    NavigationUtil.navigateToHomePage(homePage);
	}
	
	@AfterMethod
	public void afterEachTest() {
		 driver.navigate().back();
	     NavigationUtil.clickSignout(homePage);
	}
	
	@DataProvider(name = "pythoncodeData")
	public static Object[][] getPythoncodeData() {
	    List<Map<String, String>> allData = ExcelReader.getAllRows("Try Here");

	    Object[][] result = new Object[allData.size()][1];
	    for (int i = 0; i < allData.size(); i++) {
	        result[i][0] = allData.get(i);
	    }
	    return result;
	}
	
	
	@Test(dataProvider = "pythoncodeData")
	public void graphValidInvalidPythonCode(Map<String, String> data) {
		NavigationUtil.performLogin(homePage, loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Graph");
		Assert.assertTrue(homePage.isGraphPageDisplayed(), "Failed to navigate to Graph Page");
		graphPage.clickGraphLink();
		Assert.assertEquals(graphPage.getTitleofPage(), "Graph", "Failed to navigate to Graph Page");
		graphPage.clickTryHere();
		Assert.assertEquals(graphPage.getTitleofPage(), "Assessment", "Failed to navigate to Assessment Page");
	
		String pythonCode = data.get("PythonCode");
        String expectedOutput = data.get("Output");
        String expectedType = data.get("Type");
        graphPage.enterPythonCode(pythonCode);
        logger.info("Entered Python Code: " + pythonCode);
        graphPage.clickRunButton();
        logger.info("Clicked Run Button");

        if ("Alert".equalsIgnoreCase(expectedType)) {
        	String alertMessage = graphPage.AlertGetText();
        	Assert.assertEquals(alertMessage,expectedOutput, "Mismatch! expected output is: " + expectedOutput);
            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
        }else {
	        String actualOutput = graphPage.successMsg();
	        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Not the correct Answer!!Mismatch in Try Editor Output!");
	        logger.info("Verified Output message successfully." + pythonCode + "Output Message:" + actualOutput);
        }
        
	}
	
	@Test
	public void testGraphRepPageLayout() throws IOException {
		NavigationUtil.performLogin(homePage, loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Graph");
		Assert.assertTrue(homePage.isGraphPageDisplayed(), "Failed to navigate to Graph Page");
		graphPage.clickGraphRep();
		Assert.assertEquals(graphPage.getTitleofPage(), "Graph Representations", "Failed to navigate to Graph Representations Page");
		
		//overlap check
		boolean isOverlapping = graphPage.isOverlapping();
		graphPage.getOverlapImage();
		Assert.assertFalse(isOverlapping, "Image and paragraph are overlapping on the Graph Representations page!");
	}
	
	@Test(dataProvider = "pythoncodeData")
	public void graphrepValidInvalidPythonCode(Map<String, String> data) {
		NavigationUtil.performLogin(homePage, loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Graph");
		Assert.assertTrue(homePage.isGraphPageDisplayed(), "Failed to navigate to Graph Page");
		graphPage.clickGraphRep();
		Assert.assertEquals(graphPage.getTitleofPage(), "Graph Representations", "Failed to navigate to Graph Representations Page");

		graphPage.clickTryHere();
		Assert.assertEquals(graphPage.getTitleofPage(), "Assessment", "Failed to navigate to Assessment Page");
		
			String pythonCode = data.get("PythonCode");
	        String expectedOutput = data.get("Output");
	        String expectedType = data.get("Type");
	        graphPage.enterPythonCode(pythonCode);
	        logger.info("Entered Python Code: " + pythonCode);
	        graphPage.clickRunButton();
	        logger.info("Clicked Run Button");
	        if ("Alert".equalsIgnoreCase(expectedType)) {
	        	String alertMessage = graphPage.AlertGetText();
	        	Assert.assertEquals(alertMessage,expectedOutput, "Mismatch! expected output is: " + expectedOutput);
	            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
	        }else {
		        String actualOutput = graphPage.successMsg();
		        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Not the correct Answer!!Mismatch in Try Editor Output!");
		        logger.info("Verified Output message successfully." + pythonCode + "Output Message:" + actualOutput);
	        }   
	}
}
