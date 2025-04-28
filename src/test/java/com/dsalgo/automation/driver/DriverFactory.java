package com.dsalgo.automation.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	//Parallel execution, each thread gets its own webdriver instance
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver initializeDriver(String browser) {
		//Handles multiple browser
        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }

}
