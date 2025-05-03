
	package com.dsalgo.automation.pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	//import com.dsalgo.automation.driver.DriverFactory;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import com.dsalgo.automation.utils.*;

import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;

	public class ArrayPage {
		WebDriver driver;
		WaitHelper waitHelper;
		
		 // Initialize logger for this class
	    private static final Logger logger = LogManager.getLogger(HomePage.class);
	   // String url = ConfigReader.getProperty("baseUrl");
		
	 	@FindBy (xpath="//a[@href ='array']") WebElement arrayGetStartedBtn;
	 	@FindBy (xpath="//h4[text()=\"Array\"]") WebElement arrayPageHeading;

	 	
	 	//Arrays in Python
	 	@FindBy (xpath="//*[text()='Arrays in Python']") WebElement arrayPythonLink;
	 	@FindBy (xpath="//a[@href='/tryEditor']") WebElement arrayPythonLinkTryEdit;
	 	@FindBy (css=".CodeMirror") WebElement arrayPythonTextEdit;
	 	@FindBy (xpath="//button[text()='Run']") WebElement arrayPythonTextEditRun;
	 	
	 	//Arrays Using List
	 	@FindBy (xpath="//*[text()='Arrays Using List']") WebElement arrayUsingList;
	 	@FindBy (xpath="//a[@href='/tryEditor']") WebElement arrayUsingListTryEdit;
	 	@FindBy (css=".CodeMirror") WebElement arrayUsingListTextEdit;
	 	@FindBy (xpath="//a[@href='/array/arrays-using-list/']") WebElement arrayUsingListfromLeftMenu;//arrayUsingList
	 	@FindBy (xpath="//a[@href='/array/arrays-in-python/']") WebElement arrayInPythonfromLeftMenu; //arrayPythonLink
		
	 	
	 	//Basic Operations in Lists
	 	@FindBy (xpath="//*[text()='Basic Operations in Lists']") WebElement arrayBasicOperinListLink;
	 	@FindBy (xpath="//a[@href='/tryEditor']") WebElement arrayBasicOperinListTryEdit;
	 	@FindBy (xpath="//a[@href='/array/basic-operations-in-lists/']") WebElement arrayBasicOperationfromLeftMenu;//arrayBasicOperinListLink

	 	//Applications of Array
	 	@FindBy (xpath="//*[text()='Applications of Array']") WebElement applicationOfArraryLink;
	 	@FindBy (xpath="//a[@href='/tryEditor']") WebElement applicationOfArraryTryEdit;
	 	@FindBy (xpath="//a[@href='/array/applications-of-array/']") WebElement arrayApplicationfromLeftMenu;//applicationOfArraryLink
	 	
	 	//practice Questions
	 	
	 	
	 	//*[text()='Search the array']
	 	@FindBy (xpath="//*[text()='Practice Questions']") WebElement arrayPractieceQue;
	 	@FindBy (xpath="//*[text()='Search the array']") WebElement searchArrayPractieceQue;
	 	@FindBy (xpath="//*[text()='Max Consecutive Ones']") WebElement maxConsucutiveOnesPractieceQue;
	 	@FindBy (xpath="//*[text()='Find Numbers with Even Number of Digits']") WebElement findNumwithEvenDigitsPractieceQue;
	 	@FindBy (xpath="//*[text()='Squares of  a Sorted Array']") WebElement squaresOfSortedArrayPractieceQue;

	 	//practice Questions Text Editor
	 	//@FindBy (xpath="//*[@id=\"answer_form\"]/button") WebElement arrayPracticeRun;
	 	@FindBy (xpath="//input[@value='Submit']") WebElement arrayPracticeSubmit;
	 	
	 	//input[@value='Submit']

		@FindBy(xpath = "//pre[text()=\"Error occurred during submission\"]") WebElement outputerror;
		@FindBy(xpath = "//pre [text()=\" No tests were collected\"]") WebElement Blankoutputerror;
		@FindBy(xpath = "//pre[@id='output']") WebElement output;
		//@FindBy(xpath = "//pre[text()=\"[4, 9, 9, 49, 121]\"]") WebElement squaresOfSortedArrayOutput;

		

		
	 	public ArrayPage(WebDriver driver)
	 	{
	 			this.driver = driver;
	 			PageFactory.initElements(driver, this);
	 			waitHelper = new WaitHelper(driver,10);
	 			logger.info("HomePage initialized with WebDriver and waitHelper");
	 		
	 	}
	 	
		public void arrayPythonLink()
		{
			arrayPythonLink.click();
		}
		public void arrayPythonLinkTryEdit()
		{
			arrayPythonLinkTryEdit.click();
		}

		public void verifyCodeEditor(String code) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].CodeMirror.setValue(arguments[1]);", arrayPythonTextEdit, code);
		}

		public String verifyOutput() {
			return output.getText();
		}
		
		public String verifyOutputError() {
			return outputerror.getText();
		}
		
		public String verifyBlankOutputError() {
			return Blankoutputerror.getText();
		}
		
		
		public void arrayUsingListTryEdit()
		{
			arrayUsingListTryEdit.click();
		}
			
		public void arrayPythonTextEditRun()
		{
			arrayPythonTextEditRun.click();
		}
		public String verfyArrayTitle()
		{
	 		return driver.getTitle();
	 
	 	}
		
		public String arrayPageHeading()
		{
	 		return arrayPageHeading.getText();

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
		
		
		public void arrayHome()
		{
		arrayGetStartedBtn.click();
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 public void arrayInPythonfromLeftMenu()
		   {
			 arrayInPythonfromLeftMenu.click();
		   }
		
		public void arrayUsingList()
		{
			arrayUsingList.click();
		}
	   public void arrayUsingListfromLeftMenu()
	   {
		   arrayUsingListfromLeftMenu.click();
	   }
	   public Boolean alertPresent() {
			if (ExpectedConditions.alertIsPresent() != null) {
				return true;
			}
			return false;
		}
	   
	   public void arrayPractieceQue() {
			arrayPractieceQue.click();
	   }

	   public void arrayBasicOperinListLink()
		{
		   arrayBasicOperinListLink.click();
		}
	   public void arrayBasicOperinListTryEdit()
		{
		   arrayBasicOperinListTryEdit.click();
		}
	   
	   public void applicationOfArraryLink()
		{
		   applicationOfArraryLink.click();
		}
	   public void applicationOfArraryTryEdit()
		{
		   applicationOfArraryTryEdit.click();
		}
	   
	   public void searchArrayPractieceQue()
		{
		   searchArrayPractieceQue.click();
		}
	   public void maxConsucutiveOnesPractieceQue()
		{
		   maxConsucutiveOnesPractieceQue.click();
		}
	   public void findNumwithEvenDigitsPractieceQue()
		{
		   findNumwithEvenDigitsPractieceQue.click();
		}
	   public void squaresOfSortedArrayPractieceQue()
		{
		   squaresOfSortedArrayPractieceQue.click();
		}
	   
	 
	     public void arrayPracticeSubmit()
	  	{
	    	 arrayPracticeSubmit.click();
	  	}
	     
	     public void arrayBasicOperationfromLeftMenu()
	     {
	    	 arrayBasicOperationfromLeftMenu.click();
	     }
	   
	    public void arrayApplicationfromLeftMenu()
	    {
	    	arrayApplicationfromLeftMenu.click();
	    }

		
	}
		

