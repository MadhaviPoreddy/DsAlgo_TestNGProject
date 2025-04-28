package com.dsalgo.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.automation.driver.DriverFactory;

import com.dsalgo.automation.utils.WaitHelper;

public class DataStructure {
	
	public WebDriver driver;
	WaitHelper waitHelper;
	 // Initialize logger for this class
	private static final Logger logger = LogManager.getLogger(DataStructure.class);
	
	
	@FindBy (xpath = "//a[@href ='data-structures-introduction']")
	WebElement getStartedDSintro_link;
	@FindBy (xpath="//a[@href='time-complexity']")
	WebElement timecomplexity_link;
	@FindBy (xpath="//a[@href='/tryEditor']")
	WebElement tryHere_link;
	@FindBy (className = ("CodeMirror-scroll"))
	WebElement textEditor; 
	@FindBy (xpath = "//*[text()='Practice Questions']")
	WebElement practiceQues;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement runBtn;
	@FindBy (xpath = "//body")
	WebElement bodyTag;
	@FindBy (xpath = "//form/div/div/div/textarea")
	WebElement output;
	@FindBy (id = "output")
	WebElement successMsg;
	@FindBy (xpath="//*[text()='NumpyNinja']")
	WebElement numpyninjaLogo;
	
	public DataStructure(WebDriver driver) {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver,10);
		logger.info("Initialized DataStructure page");
	}
	
	public String getTitleofPage() {
		String title = driver.getTitle();
        logger.info("Page title: " + title);
		return title;
	}
	
	public void clickTimeCom() {
		try {
			timecomplexity_link.click();
			logger.info("Clicked on 'Time Complexity' link");
	    } catch (Exception e) {
	        logger.error("Failed to click Time Complexity link");
	    }
	}
	
	
	public void clickPracticeQues() {
		try {
			practiceQues.click();
			logger.info("Clicked on Practice Questions");
	    } catch (Exception e) {
	        logger.error("Failed to click Practice Questions");
	    }
	}
	
	public Boolean isPageBlank() {
		String text = bodyTag.getText().trim();
        return text.isEmpty();
	}

	public void clickTryHere() {
		try {
		tryHere_link.click();
			logger.info("Clicked on Try Here link");
	    } catch (Exception e) {
	    	logger.error("Failed to click Try Here");
	    }
	}
	
	public Boolean isTextEditorVisible() {
		try {
            boolean visible = textEditor.isDisplayed();
            logger.info("Text editor visible: " + visible);
            return visible;
        } catch (Exception e) {
            logger.error("Text editor not visible");
            return false;
    }	}
	
	public Boolean isRunBtnVisible() {
		try {
			boolean visible = runBtn.isDisplayed();
	        logger.info("Run button visible: " + visible);
	        return visible;
	    } catch (Exception e) {
	        logger.error("Run button not visible");
	        return false;
	    }
	}
	
	public String isTextEditorEmpty() {
		String content = output.getText().trim();
        logger.info("Editor content: " + content);
        return content;
	}
	
	public void clickRunButton() {
		try {
			runBtn.click();
			logger.info("Clicked on Run button");
	    } catch (Exception e) {
	        logger.error("Failed to click Run button");
	    }
	}
	
	public String errorMsg() {
		String msg = output.getText().trim();
        logger.info("Error message: " + msg);
        return msg;
	}
	
	public void enterPythonCode(String pythonCode) {
		try {
			output.sendKeys(pythonCode);
			logger.info("Entered Python code into editor: " + pythonCode);
	    } catch (Exception e) {
	        logger.error("Failed to enter Python code");
	    }
	}
	
	public String successMsg() {
		String msg = successMsg.getText();
        logger.info("Success message: " + msg);
        return msg;	
    }
	
	public void clickNumpyninjaLogo() {
		try {
			numpyninjaLogo.click();
			logger.info("Clicked on NumpyNinja logo");
	    } catch (Exception e) {
	        logger.error("Failed to click NumpyNinja logo");
	    }
	}
	public String AlertGetText() {
		 try {
		        Alert alert = waitHelper.waitForAlertIsPresent();
		        String alertText = alert.getText();
		        alert.accept();
		        logger.info("Alert appeared: " + alertText);
		        return alertText;
		  } catch (Exception e) {
		        logger.error("No alert was present or failed to handle alert");
		        return null;
		  }
	}
}


