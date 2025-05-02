package com.dsalgo.automation.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.automation.utils.WaitHelper;

public class GraphPage {
	
	WebDriver driver;
	WaitHelper waitHelper;
	
	// Initialize logger for this class
	private static final Logger logger = LogManager.getLogger(GraphPage.class);
	
	@FindBy (xpath ="//a[@href ='graph']")
	WebElement getStartedgraph;
	@FindBy (linkText="Graph")
	WebElement graphLink;
	@FindBy (xpath ="//*[text()='Graph Representations']")
	WebElement graphRep_link;
	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	WebElement graphPracticeQues;
	@FindBy (xpath = "//a[@href='/tryEditor']")
	WebElement try_here;
	@FindBy (className = ("CodeMirror-scroll"))
	WebElement textEditor; 
	@FindBy(xpath ="//button[text()='Run']")
	WebElement runBtn;
	@FindBy (id = "output")
	WebElement successMsg;
	@FindBy (xpath = "//form/div/div/div/textarea")
	WebElement output;
	@FindBy (xpath="//*[text()='NumpyNinja']")
	WebElement numpyninjaLogo;
	@FindBy (xpath = "//body")
	WebElement bodyTag;
	@FindBy (xpath = "(//*[text()='Graph Representations'])[3]/../../p[15]")
	WebElement paragraph;
	@FindBy (xpath = "(//*[text()='Graph Representations'])[3]/../../p[15]/img")
	WebElement table;
	
	public GraphPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver,10);
		logger.info("GraphPage initialized");
	}
	
	public String getTitleofPage() {
		String title = driver.getTitle();
		logger.info("Page title: " + title);
		return title;
	}
	
	public void clickGraphLink() {
		try {
			graphLink.click();
			logger.info("Clicked on Graph link");
		} catch (Exception e) {
			logger.error("Failed to click Graph link");
		}
	}
	

	public void clickTryHere() {
		try {
			try_here.click();
			logger.info("Clicked on Try Here");
		} catch (Exception e) {
			logger.error("Failed to click Try Here");
		}
	}
	
	public Boolean isTextEditorVisible() {
		try {
			boolean visible = textEditor.isDisplayed();
			logger.info("Text editor visibility: " + visible);
			return visible;
		} catch (Exception e) {
			logger.error("Text editor not visible");
			return false;
		}
	}
	
	public Boolean isRunBtnVisible() {
		try {
			boolean visible = runBtn.isDisplayed();
			logger.info("Run button visibility: " + visible);
			return visible;
		} catch (Exception e) {
			logger.error("Run button not visible");
			return false;
		}
	}
	
	public String isTextEditorEmpty() {
		return output.getText().trim();
	}
	
	public void clickRunButton() {
		try {
			runBtn.click();
			logger.info("Clicked Run button");
		} catch (Exception e) {
			logger.error("Failed to click Run button");
		}
	}
	
	public String errorMsg() {
	    return output.getText().trim();

	}
	
	public void enterPythonCode(String pythonCode) {
		try {
			output.sendKeys(pythonCode);
			logger.info("Entered Python code: " + pythonCode);
		} catch (Exception e) {
			logger.error("Failed to enter Python code");
		}
	}
	
	public String successMsg() {
		waitHelper.waitForElementVisible(successMsg);
		return successMsg.getText();
	}
	
	public void clickGraphRep() {
		try {
			graphRep_link.click();
			logger.info("Clicked Graph Representation link");
		} catch (Exception e) {
			logger.error("Failed to click Graph Representation link");
		}
	}
	
	public void clickNumpyninjaLogo() {
		try {
			numpyninjaLogo.click();
			logger.info("Clicked on NumpyNinja logo");
		} catch (Exception e) {
			logger.error("Failed to click NumpyNinja logo");
		}
	}
	
	public void clickPracticeQues() {
		try {
			graphPracticeQues.click();
			logger.info("Clicked on Practice Questions link");
		} catch (Exception e) {
			logger.error("Failed to click Practice Questions link");
		}
	}
	
	public String bodyText() {
		String text = bodyTag.getText().trim();
		logger.info("Body text: " + text);
		return text;
	}
	
    
    public boolean isOverlapping() {
        Rectangle paraRect = paragraph.getRect();
        Rectangle tableRect = table.getRect();
        //checking whether image and paragraph are overlapped
        boolean overlapping = paraRect.x < tableRect.x + tableRect.width &&
                paraRect.x + paraRect.width > tableRect.x &&
                paraRect.y < tableRect.y + tableRect.height &&
                paraRect.y + paraRect.height > tableRect.y;
        logger.info("Paragraph and table overlapping: " + overlapping);
        return overlapping;
    }
    
    public void getOverlapImage() throws IOException {
		File screenshot = paragraph.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/overlappingImage.png";
		File destination = new File(path);
		FileUtils.copyFile(screenshot, destination);
		logger.info("Overlapped Image saved at: " + path);
    }
    
    //get Alert message text 
    public String AlertGetText() {
		 try {
		        Alert alert = waitHelper.waitForAlertIsPresent();
		        String alertText = alert.getText();
		        alert.accept();
		        logger.info("Alert appeared: " + alertText);
		        return alertText;
		 } catch (NoAlertPresentException e) {
		        logger.error("No alert was present.");
		        return null;
		 } catch (Exception e) {
		        logger.error("Unexpected error while handling alert: " + e.getMessage());
		        return null;
		 }
    }
}
