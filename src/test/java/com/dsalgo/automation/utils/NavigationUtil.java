package com.dsalgo.automation.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;

public class NavigationUtil {
	// Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(NavigationUtil.class);
	
	//Click getstarted button on DS Algo main portal
	public static void navigateToHomePage(HomePage homePage) {
        homePage.navigateToHomePage();    //opens the DSAlgo URL and click on getstarted button
        logger.info("Navigated to DS Algo Home Page");
	}
	
	//Test valid login
	public static void performLogin(HomePage homePage, LoginPage loginPage) {
		try {
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
	
	//Click get started on Data Structure options after sign in
	public static void clickModuleGetStarted(HomePage homePage, String moduleName) {
		homePage.getStartedhome(moduleName);
	}
	
	//Click sign out
	public static void clickSignout(HomePage homePage) {
		homePage.clickSignout();
	}
	
}