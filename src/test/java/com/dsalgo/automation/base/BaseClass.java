package com.dsalgo.automation.base;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.utils.ConfigReader;


public class BaseClass {
	protected WebDriver driver;   //driver variable is available to all the extended class

    
	//CrossBrowser Tesing
//	@Parameters("browser")
//	@BeforeClass
//	public void setUp(String browser) {
//        driver = DriverFactory.initializeDriver(browser);  //Launch the browser
//    }
	
	
	
	@BeforeClass
	public void setUp() {
		String browser = ConfigReader.getProperty("browser");
        driver = DriverFactory.initializeDriver(browser);  //Launch the browser
    }
	
    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
