package com.dsalgo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dsalgo.automation.driver.DriverFactory;
//import org.openqa.selenium.JavascriptExecutor;


public class StackPage {

	WebDriver driver;

	@FindBy (xpath="//a [@href='stack']") WebElement stackGetStartedBtn;
	
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

	
	public StackPage()
 	{
 	
		//this.driver=driver;
 		this.driver=DriverFactory.getDriver();
		PageFactory.initElements( driver, this);
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
}