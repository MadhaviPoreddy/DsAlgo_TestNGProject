package com.dsalgo.automation.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
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

	// DataStructure Introduction
	@FindBy(xpath = "//*[text()='Data Structure Introduction']")
	WebElement dataStructureIntroOption;
	
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
	
	//Click getstarted button
	public void navigateToHomePage() {
		driver.get(url);
		logger.info("Navigated to DSAlgo portal: " + url);
		try {
			getStartedbtn.click();
			logger.info("Clicked on Get Started button.");
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
	
	public boolean isDataStructureIntroOptionVisible() {
		
		try {
			return dataStructureIntroOption.isDisplayed();
		} catch (NoSuchElementException e) {
			logger.error("Failed while verifying visibility of Data Structure Introduction in the drop down");
			return false; // Element is not in the DOM
		}

	}
	public void selectDropdown(String string) {
		try {
			dropDown.click();
			switch (string) {
			case "Arrays":
				logger.info("User click on " + string);
				dropDownArrays.click();
				break;
			case "Linked List":
				logger.info("User click on " + string);
				dropDownLinkedlist.click();
				break;
			case "Stack":
				logger.info("User click on " + string);
				dropDownStack.click();
				break;
			case "Queue":
				logger.info("User click on " + string);
				dropDownQueue.click();
				break;
			case "Tree":
				logger.info("User click on " + string);
				dropDownTree.click();
				break;
			case "Graph":
				logger.info("User click on " + string);
				dropDownGraph.click();
				break;
			}
		}catch (Exception e) {
			logger.error("Failed to select dropdown option: " + string);
		}

	}
	
	public void getStartedhome(String string) {
		try {
			switch (string) {
			case "Data Structures-Introduction":
				logger.info("click " + getStartedDSintro.getText() + "link on  DataStructures ");
				getStartedDSintro.click();
				break;
			case "Arrays":
				logger.info("click " + getStartedArray.getText() + "link on Array ");
				getStartedArray.click();
				break;
			case "Linked List":
				logger.info("click " + getStartedLinkedlist.getText() + "link on LinkedList");
				getStartedLinkedlist.click();
				break;
			case "Stack":
				logger.info("click " + getStartedStack.getText() + "link on stack");
				getStartedStack.click();
				break;
			case "Queue":
				logger.info("click " + getStartedQueue.getText() + "link on queue ");
				getStartedQueue.click();
				break;
			case "Tree":
				logger.info("click " + getStartedTree.getText() + "link on Tree ");
				getStartedTree.click();
				break;
			case "Graph":
				logger.info("click " + getStartedGraph.getText() + "link on Graph ");
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
			logger.error("Failed to click on Sign out link");
		}
	}
}
