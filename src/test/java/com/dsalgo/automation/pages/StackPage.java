package com.dsalgo.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.utils.*;


public class StackPage {

	WebDriver driver;
	WaitHelper waitHelper;
	private static final Logger logger = LogManager.getLogger(HomePage.class);

	@FindBy (xpath="//a [@href='stack']") WebElement stackGetStartedBtn;
	@FindBy (xpath="//h4[text()=\"Stack\"]") WebElement stackPageHeading;

	//Operations in stack
	@FindBy (xpath="//*[text()='Operations in Stack']") WebElement operationsInStackLink;
	@FindBy (xpath="//a[@href='/tryEditor']") WebElement operationsInStackLinkTryEdit;
	@FindBy (css=".CodeMirror") WebElement operationsInStackLinkTextEdit;
	@FindBy (xpath="//button[text()='Run']") WebElement operationsInStackLinkTextEditRun;
	

	//Implementation 
	@FindBy (xpath="//*[text()='Implementation']") WebElement stackImplementation;
	@FindBy (xpath="//a[@href='/tryEditor']") WebElement stackImplementationTryEdit;
	@FindBy (css=".CodeMirror") WebElement stackImplementationTextEdit;
	@FindBy (xpath="//button[text()='Run']") WebElement stackImplementationTextEditRun;
	
	//Applications
	@FindBy (xpath="//a [@href='stack-applications']") WebElement stackApplications;
	@FindBy (xpath="//a[@href='/tryEditor']") WebElement stackApplicationsTryEdit;
	@FindBy (css=".CodeMirror") WebElement stackApplicationsTextEdit;
	@FindBy (xpath="//button[text()='Run']") WebElement traversalTextEditRun;
	
	//practice Questions
	@FindBy (xpath="//*[text()='Practice Questions']") WebElement stackPracticeLink;
	
	@FindBy(xpath = "//pre[@id='output']") WebElement output;

	
	public StackPage(WebDriver driver)
 	{
 	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver,10);
		logger.info("HomePage initialized with WebDriver and waitHelper");	
	 	
 	}
	
	public String verifyOutput() {
		return output.getText();
	}
	
	public void stackGetStartedBtn()
	{
		stackGetStartedBtn.click();
	}
	public String verfyPageTitle()
	{
 		return driver.getTitle();
 
 	}
	
	public String stackPageHeading()
	{
 		return stackPageHeading.getText();

 	}
	public void operationsInStackLink()
	{
		operationsInStackLink.click();
	}
	public void operationsInStackLinkTryEdit()
	{
		operationsInStackLinkTryEdit.click();
	}
	public void operationsInStackLinkTextEditRun()
	{
		operationsInStackLinkTextEditRun.click();
	}
	
	public void stackPracticeLink()
	{
		stackPracticeLink.click();
	}
	
	public void stackImplementation()
	{
		stackImplementation.click();
	}
	public void stackImplementationTryEdit()
	{
		stackImplementationTryEdit.click();
	}
	public void stackApplications()
	{
		stackApplications.click();
	}
	public void stackApplicationsTryEdit()
	{
		stackApplicationsTryEdit.click();
	}
	
	public String readAlert()
	{
		
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		String alertText=alert.getText(); // Get the alert text
		System.out.println(alertText);
		return alertText;

	}
	
	public void acceptAlert()
	{
		
		driver.switchTo().alert().accept();
	}

	public void verifyCodeEditor(String code) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].CodeMirror.setValue(arguments[1]);", operationsInStackLinkTextEdit, code);
	}
}