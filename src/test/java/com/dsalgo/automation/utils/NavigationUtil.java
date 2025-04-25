package com.dsalgo.automation.utils;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.tests.LoginPageTest;


public class NavigationUtil {
	// Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(NavigationUtil.class);
	
	//Click getstarted button on DS Algo main portal
	public static void navigateToHomePage(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();    //opens the DSAlgo URL and click on getstarted button
		
	}
	
	
	
	//Test valid login
	public static void performLogin(WebDriver driver) {
		try {
			HomePage homePage = new HomePage(driver);
			LoginPage loginPage = new LoginPage(driver);
			homePage.clickSignin();
			String username = ConfigReader.getProperty("username");
	    	String password = ConfigReader.getProperty("password");
	    	loginPage.enterUsername(username);
	    	loginPage.enterPassword(password);
	    	loginPage.clickLogin();
	    	logger.info("Login performed successfully");
		}catch (Exception e) {
	        logger.error("Login failed: " + e);
		}
		
	}
	
	//Click get started on Data Structure Introduction
	public static void clickModuleGetStarted(WebDriver driver, String moduleName) {
		HomePage homePage = new HomePage(driver);
		homePage.getStartedhome(moduleName);
	}
}
