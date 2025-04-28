package com.dsalgo.automation.tests;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.pages.*;
import com.dsalgo.automation.tests.HomePageTest;

import com.dsalgo.automation.utils.NavigationUtil;

@SuppressWarnings("unused")
public class ArrayPageTest extends BaseClass{

	public HomePageTest homeTest= new HomePageTest();
	
	private ArrayPage Array; 
	
	 // Initialize logger for this class
   private static final Logger logger = LogManager.getLogger(ArrayPageTest.class);
   
   @BeforeClass
   public void setUpPage() {
		
	   Array=new ArrayPage(driver); 
   }
	
	@BeforeMethod
	public void navigateBeforeEachTest() {
	    NavigationUtil.navigateToHomePage(driver);
	    NavigationUtil.performLogin(driver);
		NavigationUtil.clickModuleGetStarted(driver, "Array");
		//NavigationUtil.clickSignout(driver);	
	}
	
	@AfterTest
	public void closeBrowser() {
        DriverFactory.quitDriver();
    }


	@Test
	public void checkArrayLandingPage() {
		Array.arrayPageHeading();
		Assert.assertEquals(Array.verfyArrayTitle().toLowerCase(), "array", "Not Redirected to Array page as expected");
		logger.info("Redirected to Array Landing page successfully");
	}	
	
	@Test
	public void arrayPythonLink() {
		Array.arrayPythonLink();
		Assert.assertEquals(Array.verfyArrayTitle(), "Arrays in Python", "Not Redirected to Array page as expected");
		logger.info("Redirected to arrays-in-python Landing page successfully");
	}	
	
	@Test
	public void arrayPythonLinkTryEdit() {
		Array.arrayPythonLink();
		Array.arrayPythonLinkTryEdit();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to arrays-in-python Text Editor page successfully");
	}	
	
	@Test
	public void arrayPythonLinkTryEdit() {
		Array.arrayPythonLink();
		Array.arrayPythonLinkTryEdit();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to arrays-in-python Text Editor page successfully");
	}	
}
