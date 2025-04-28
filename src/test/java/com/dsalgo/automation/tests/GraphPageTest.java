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
import com.dsalgo.automation.pages.GraphPage;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.utils.ExcelReader;
import com.dsalgo.automation.utils.NavigationUtil;

public class GraphPageTest extends BaseClass{
	private HomePage homePage; // Global declaration for reuse
	private GraphPage graphPage;
	 // Initialize logger for this class
	private static final Logger logger = LogManager.getLogger(GraphPageTest.class);
	
	@BeforeMethod
	public void navigateBeforeEachTest() {
		//homepage object is initialized using baseclass webdriver
		homePage = new HomePage(driver);
		//datastructure page object is initialized using baseclass webdriver
		graphPage = new GraphPage(driver);
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
	
	
	@Test(dataProvider = "pythoncodeData" , dataProviderClass = GraphPageTest.class)
	public void graphValidInvalidPythonCode(Map<String, String> data) {
		NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Graph");
		Assert.assertTrue(homePage.isGraphPageDisplayed(), "Failed to navigate to Graph Page");
		graphPage.clickGraphLink();
		Assert.assertEquals(graphPage.getTitleofPage(), "Graph", "Failed to navigate to Graph Page");
		graphPage.clickTryHere();
		Assert.assertEquals(graphPage.getTitleofPage(), "Assessment", "Failed to navigate to Assessment Page");
		try {
			String pythonCode = data.get("PythonCode");
	        String expectedOutput = data.get("Output");
	        String expectedType = data.get("Type");
	        graphPage.enterPythonCode(pythonCode);
	        graphPage.clickRunButton();
	        if ("Alert".equalsIgnoreCase(expectedType)) {
	        	String alertMessage = graphPage.AlertGetText();
	        	Assert.assertEquals(alertMessage,expectedOutput, "Mismatch! expected output is: " + expectedOutput);
	            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
	        }else {
		        String actualOutput = graphPage.successMsg();
		        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Not the correct Answer!!Mismatch in Try Editor Output!");
	        }
        	
        }catch (Exception e) {
	        logger.error("Test failed due to exception: ", e);
	        throw e;  // Re-throw the caught exception to fail the test
		} finally {
	        driver.navigate().back();
	        NavigationUtil.clickSignout(driver);
	    }
        
	}
	
	@Test
	public void testGraphRepPageLayout() {
		NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Graph");
		Assert.assertTrue(homePage.isGraphPageDisplayed(), "Failed to navigate to Graph Page");
		graphPage.clickGraphRep();
		Assert.assertEquals(graphPage.getTitleofPage(), "Graph Representations", "Failed to navigate to Graph Representations Page");
		
		//overlap check
		boolean isOverlapping = graphPage.isOverlapping();
		Assert.assertFalse(isOverlapping, "Image and paragraph are overlapping on the Graph Representations page!");
		driver.navigate().back();
	    NavigationUtil.clickSignout(driver);
	}
	
	@Test(dataProvider = "pythoncodeData" , dataProviderClass = GraphPageTest.class)
	public void graphrepValidInvalidPythonCode(Map<String, String> data) {
		NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Graph");
		Assert.assertTrue(homePage.isGraphPageDisplayed(), "Failed to navigate to Graph Page");
		graphPage.clickGraphRep();
		Assert.assertEquals(graphPage.getTitleofPage(), "Graph Representations", "Failed to navigate to Graph Representations Page");

		graphPage.clickTryHere();
		Assert.assertEquals(graphPage.getTitleofPage(), "Assessment", "Failed to navigate to Assessment Page");
		try {
			String pythonCode = data.get("PythonCode");
	        String expectedOutput = data.get("Output");
	        String expectedType = data.get("Type");
	        graphPage.enterPythonCode(pythonCode);
	        graphPage.clickRunButton();
	        if ("Alert".equalsIgnoreCase(expectedType)) {
	        	String alertMessage = graphPage.AlertGetText();
	        	Assert.assertEquals(alertMessage,expectedOutput, "Mismatch! expected output is: " + expectedOutput);
	            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
	        }else {
		        String actualOutput = graphPage.successMsg();
		        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Not the correct Answer!!Mismatch in Try Editor Output!");
	        }
        	
        }catch (Exception e) {
	        logger.error("Test failed due to exception: ", e);
	        throw e;  // Re-throw the caught exception to fail the test
		} finally {
	        driver.navigate().back();
	        NavigationUtil.clickSignout(driver);
	    }
        
	}
}
