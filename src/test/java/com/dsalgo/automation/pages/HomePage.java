package com.dsalgo.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.automation.utils.ConfigReader;
import com.dsalgo.automation.utils.WaitHelper;

public class HomePage {
	WebDriver driver;
	WaitHelper waitHelper;
	
	 // Initialize logger for this class
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    String url = ConfigReader.getProperty("baseUrl");
    
	// Get Started Button
	@FindBy(xpath = "//button[@class='btn']")
	WebElement getStartedbtn;

	// alertmessage
	@FindBy(xpath = "//div[contains(text(),'You are not logged in')]")
	WebElement alertMessage;

	// Home Page
	@FindBy(xpath = "//a[@href ='data-structures-introduction']")
	WebElement getStartedDSintro;
	@FindBy(xpath = "//a[@href = 'array']")
	WebElement getStartedArray;
	@FindBy(xpath = "//a[@href = 'linked-list']")
	WebElement getStartedLinkedlist;
	@FindBy(xpath = "//a[@href = 'stack']")
	WebElement getStartedStack;
	@FindBy(xpath = "//a[@href = 'queue']")
	WebElement getStartedQueue;
	@FindBy(xpath = "//a[@href = 'tree']")
	WebElement getStartedTree;
	@FindBy(xpath = "//a[@href = 'graph']")
	WebElement getStartedGraph;

	// NumpyNinja Logo
	@FindBy(xpath = "//a[@href='/home']")
	WebElement numpyNinjaLogo;

	// dropdown
	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement dropDown;
	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement dropDownArrays;
	@FindBy(xpath = "//a[text()='Linked List']")
	WebElement dropDownLinkedlist;
	@FindBy(xpath = "//a[text()='Stack']")
	WebElement dropDownStack;
	@FindBy(xpath = "//a[text()='Queue']")
	WebElement dropDownQueue;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement dropDownTree;
	@FindBy(xpath = "//a[text()='Graph']")
	WebElement dropDownGraph;

	// SignIn
	@FindBy(xpath = "//a[@href ='/login']")
	WebElement signin;

	// Register
	@FindBy(xpath = "//a[@href ='/register']")
	WebElement register;
	
	//Dropdown itmes
	@FindBy(css = ".dropdown-menu .dropdown-item")
	private List<WebElement> dropdownItems;

	
	//AlertMessage
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	WebElement successLogin;
	
	@FindBy(xpath = "//a[text()='Data Structures']/../div")
	List<WebElement> dropdownMenu;

	@FindBy(xpath = "//*[text()='Sign out']")
	WebElement signOut;
	
	@FindBy(xpath = "//*[contains(text(),'Logged out successfully')]")
	WebElement signoutAlert;
		
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver,10);
		logger.info("HomePage initialized with WebDriver and waitHelper");
	}
	
	//return dropdown options 
	public List<String> getDropdownOptionTexts() {
	    return dropdownItems.stream()
	            .map(WebElement::getText)
	            .collect(Collectors.toList());
	}
	
	//Click getstarted button
	public void navigateToHomePage() {
		driver.navigate().to(url);
		logger.info("Navigated to DSAlgo portal: " + url);
		try {
			getStartedbtn.click();
			logger.info("Clicked on Get Started button in DSAlgo Portal.");
		} catch (NoSuchElementException e) {
		    logger.error("Element not found: Get Started button. ");
		} catch (InvalidSelectorException e) {
		    logger.error("Invalid XPath used for Get Started button. ");
		} catch (Exception e) {
		    logger.error("Unexpected error while clicking on Get Started button. ");
		}
	}
	
	//Get value of logo
	public String getTextLogo() {
		return numpyNinjaLogo.getText();
	}
	
	public void clickDataStructuresDropdown() {
		dropDown.click();
		logger.info("Clicked on Data Structures dropdown.");
	}
	
	
	public void selectDropdown(String string) {
		try {
			dropDown.click();
			switch (string) {
			case "Array":
				logger.info("User click on " + string + "dropdown");
				dropDownArrays.click();
				break;
			case "Linked List":
				logger.info("User click on " + string + "dropdown");
				dropDownLinkedlist.click();
				break;
			case "Stack":
				logger.info("User click on " + string + "dropdown");
				dropDownStack.click();
				break;
			case "Queue":
				logger.info("User click on " + string + "dropdown");
				dropDownQueue.click();
				break;
			case "Tree":
				logger.info("User click on " + string + "dropdown");
				dropDownTree.click();
				break;
			case "Graph":
				logger.info("User click on " + string + "dropdown");
				dropDownGraph.click();
				break;
			}
		} catch (StaleElementReferenceException e) {
            logger.warn("StaleElementReferenceException caught, retrying...");
            PageFactory.initElements(driver, this); // Reinitialize PageFactory elements
            dropDown.click();
		}catch (Exception e) {
			logger.error("Failed to select dropdown option: " + string + e);
		}

	}
	
	// Method to get the warning message "You are not logged in"
    public String getWarningMessage() {
    	try {
            waitHelper.waitForElementVisible(alertMessage);
            return alertMessage.getText();
    	} catch (TimeoutException e) {
    		return "No message";
    	}
    }
    
    // Method to check if the warning message is visible
    public boolean isWarningMessageVisible() {
    	try {
            waitHelper.waitForElementVisible(alertMessage);
            return alertMessage.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
	
	public void getStartedhome(String string) {
		try {
			switch (string) {
			case "Data Structures-Introduction":
				logger.info("clicked " + getStartedDSintro.getText() + "link on  DataStructures ");
				getStartedDSintro.click();
				break;
			case "Array":
				logger.info("clicked " + getStartedArray.getText() + "link on Array ");
				getStartedArray.click();
				break;
			case "Linked List":
				logger.info("clicked " + getStartedLinkedlist.getText() + "link on LinkedList");
				getStartedLinkedlist.click();
				break;
			case "Stack":
				logger.info("clicked " + getStartedStack.getText() + "link on stack");
				getStartedStack.click();
				break;
			case "Queue":
				logger.info("clicked " + getStartedQueue.getText() + "link on queue ");
				getStartedQueue.click();
				break;
			case "Tree":
				logger.info("clicked " + getStartedTree.getText() + "link on Tree ");
				getStartedTree.click();
				break;
			case "Graph":
				logger.info("clicked " + getStartedGraph.getText() + "link on Graph ");
				getStartedGraph.click();
				break;
			}
		}catch (Exception e) {
			logger.error("Failed to click Get Started link for: " + string);
		}
		
	}
	
	public void clickNumpyNinjaLogo() {
		try {
			numpyNinjaLogo.click();
			logger.info("Clicked on NumpyNinja Logo link.");
		}catch (Exception e) {
			logger.error("Failed to click on NumpyNinja Logo link" + e);
		}
	}
	
	//Sign In
	public void clickSignin() {
		try {
			waitHelper.waitForElementVisible(signin);
			signin.click();
			logger.info("Clicked on Signin link.");
		}catch (Exception e) {
			logger.error("Failed to click on Signin link" + e);
		}
	}
	
	//Sign out
	public void clickSignout() {
		try {
			signOut.click();
			logger.info("Clicked on Sign out link.");
		}catch (Exception e) {
			logger.error("Failed to click on Sign out link");
		}
	}
	
	public Boolean isSignoutLinkVisible() {
		 try {
			 return signOut.isDisplayed(); // assume you have a logout WebElement
		    } catch (Exception e) {
		     return false;
		    }
		
	}

	// Register
	public void clickRegister() {
		try {
			register.click();
			logger.info("Clicked on Register link.");
		}catch (Exception e) {
			logger.error("Failed to click on Register link" + e);
		}
	}
	
	public boolean isRegisterPageDisplayed() {
	    return driver.getTitle().contains("Registration");
	}
	
	public boolean isSignInPageDisplayed() {
	    return driver.getTitle().contains("Login");
	}
	
	public boolean isDataStructurePageDisplayed() {
		return driver.getTitle().contains("Data Structures-Introduction");
	}
	
	
	public boolean isGraphPageDisplayed() {
		return driver.getTitle().contains("Graph");
	}
	
	public boolean isPageDisplayed(String expectedTitle) {
		return driver.getTitle().contains(expectedTitle);
	}
}
