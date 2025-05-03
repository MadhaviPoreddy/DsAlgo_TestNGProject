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

	public class LinkedListPage {

		WebDriver driver;
		WaitHelper waitHelper;
		private static final Logger logger = LogManager.getLogger(HomePage.class);
		
		@FindBy (xpath="//a[@href ='linked-list']") WebElement linkedListGetStartedBtn;
		@FindBy (xpath="//h4[text()=\"Linked List\"]") WebElement linkedListHeading;
		
		
		//Introduction
		@FindBy (xpath="//*[text()='Introduction']") WebElement linkedListIntroductionLink;
		@FindBy (xpath="//a[@href='/tryEditor']") WebElement linkedListIntroductionTryEdit;
		@FindBy (css=".CodeMirror") WebElement linkedListIntroductionTextEdit;
		@FindBy (xpath="//button[text()='Run']") WebElement linkedListIntroductionTextEditRun;
		@FindBy (xpath="//a[@href='/linked-list/introduction/']") WebElement linkedListIntroductionFromLeftMenu;
		
		//Creating Linked List
		@FindBy (xpath="//*[text()='Creating Linked LIst']") WebElement creatingLinkedList;
		@FindBy (xpath="//a[@href='/tryEditor']") WebElement creatingLinkedListTryEdit;
		@FindBy (xpath=".CodeMirror") WebElement creatingLinkedListTextEdit;
		@FindBy (xpath="//button[text()='Run']") WebElement creatingLinkedListTextEditRun;
		@FindBy (xpath="//a[@href='/linked-list/creating-linked-list/']") WebElement creatingLinkedListFromLeftMenu;

		//Types of Linked Lists
		@FindBy (xpath="//*[text()='Types of Linked List']") WebElement typesOfListLink;
		@FindBy (xpath="//a[@href='/tryEditor']") WebElement typesOfListTryEdit;
		@FindBy (xpath=".CodeMirror") WebElement typesOfListTextEdit;
		@FindBy (xpath="//button[text()='Run']") WebElement typesOfListTextEditRun;
		@FindBy (xpath="//a[@href='/linked-list/types-of-linked-list/']") WebElement typesOfListLinkFromLeftMenu;
		@FindBy (xpath="//a [text()='singly linked list']") WebElement TypesOfLL_SinglyLinkedListLink;
		@FindBy (xpath="//a [text()='linked list']") WebElement TypesOfLL_LinkedListLink;
		@FindBy (xpath="//a [text()='doubly linked list']") WebElement TypesOfLL_DoublyLinkedListLink;
		@FindBy (xpath="//a [text()='type of the linked list']") WebElement TypesOfLL_TypesofLinkedListLink;


		//Implement Linked List in Python
		@FindBy (xpath="//*[text()='Implement Linked List in Python']") WebElement implementLinkedList;
		@FindBy (xpath="//a[@href='/tryEditor']") WebElement implementLinkedListTryEdit;
		@FindBy (xpath=".CodeMirror") WebElement implementLinkedListTextEdit;
		@FindBy (xpath="//button[text()='Run']") WebElement implementLinkedListTextEditRun;
		@FindBy (xpath="//a[@href='/linked-list/implement-linked-list-in-python/']") WebElement implementLinkedListFromLeftMenu;

		//Traversal
		@FindBy (xpath="//*[text()='Traversal']") WebElement traversalLink;
		@FindBy (xpath="//a[@href='/tryEditor']") WebElement traversalTryEdit;
		@FindBy (xpath=".CodeMirror") WebElement traversalTextEdit;
		@FindBy (xpath="//button[text()='Run']") WebElement traversalTextEditRun;
		@FindBy (xpath="//a[@href='/linked-list/traversal/']") WebElement traversalLinkedListFromLeftMenu;

		//Insertion
		@FindBy (xpath="//*[text()='Insertion']") WebElement insertionLink;
		@FindBy (xpath="//a[@href='/tryEditor']") WebElement insertionTryEdit;
		@FindBy (xpath=".CodeMirror") WebElement insertionTextEdit;
		@FindBy (xpath="//button[text()='Run']") WebElement insertionTextEditRun;
		@FindBy (xpath="//a[@href='/linked-list/insertion-in-linked-list/']") WebElement insertionLinkedListFromLeftMenu;

		//Deletion
		@FindBy (xpath="//*[text()='Deletion']") WebElement deletionLink;
		@FindBy (xpath="//a[@href='/tryEditor']") WebElement deletionTryEdit;
		@FindBy (xpath=".CodeMirror") WebElement deletionTextEdit;
		@FindBy (xpath="//button[text()='Run']") WebElement deletionTextEditRun;
		@FindBy (xpath="//a[@href='/linked-list/deletion-in-linked-list/']") WebElement deletionLinkedListFromLeftMenu;
		
		
		
		//practice Questions
		@FindBy (xpath="//a [text()='Practice Questions']") WebElement linkedListPracticeLink;
		
		@FindBy(xpath = "//pre[@id='output']") WebElement output;
		
		
		public LinkedListPage(WebDriver driver)
	 	{
			this.driver=driver;
				PageFactory.initElements(driver, this);
				waitHelper = new WaitHelper(driver,10);
				logger.info("HomePage initialized with WebDriver and waitHelper");	
			 	
		
	 	}
		public void linkedListGetStartedBtn()
		{
			linkedListGetStartedBtn.click();
		}
		public String verfyPageTitle()
		{
	 		return driver.getTitle();
	 
	 	}
		
		public String linkedListHeading()
		{
	 		return linkedListHeading.getText();

	 	}
		
		public void linkedListIntroductionLink()
		{
		linkedListIntroductionLink.click();
		}
		
		public void linkedListIntroductionTryEdit()
		{
			linkedListIntroductionTryEdit.click();
		}
		public void linkedListIntroductionTextEdit()
		{
			linkedListIntroductionTextEdit.click();
		}
		
		public void linkedListIntroductionTextEditRun()
		{
			linkedListIntroductionTextEditRun.click();
		}
		public void linkedListIntroductionFromLeftMenu()
		{
			linkedListIntroductionFromLeftMenu.click();
		}
		
		
		//2nd link
		public void creatingLinkedList()
		{
			creatingLinkedList.click();
		}
		
		public void creatingLinkedListTryEdit()
		{
			creatingLinkedListTryEdit.click();
		}
		public String verifyOutput() {
			return output.getText();
		}
		
		//3rd link
		public void typesOfListLink()
		{
			typesOfListLink.click();
		}
		
		public void typesOfListTryEdit()
		{
			typesOfListTryEdit.click();
		}
		public void TypesOfLL_SinglyLinkedListLink()
		{
			TypesOfLL_SinglyLinkedListLink.click();
		}
		
		public void TypesOfLL_LinkedListLink()
		{
			TypesOfLL_LinkedListLink.click();
		}
		public void TypesOfLL_DoublyLinkedListLink()
		{
			TypesOfLL_DoublyLinkedListLink.click();
		}
		
		public void TypesOfLL_TypesofLinkedListLink()
		{
			TypesOfLL_TypesofLinkedListLink.click();
		}
		
		//4th link
		public void implementLinkedList()
		{
			implementLinkedList.click();
		}
		
		public void implementLinkedListTryEdit()
		{
			implementLinkedListTryEdit.click();
		}
		
		//5th link
		public void traversalLink()
		{
			traversalLink.click();
		}
		
		public void traversalTryEdit()
		{
			traversalTryEdit.click();
		}
		
		
		//6th link
		public void insertionLink()
		{
			insertionLink.click();
		}
		
		public void insertionTryEdit()
		{
			insertionTryEdit.click();
		}
		
		//7th link
		public void deletionLink()
		{
			deletionLink.click();
		}
		public void deletionTryEdit()
		{
			deletionTryEdit.click();
		}
		public void linkedListPracticeLink()
		{
			linkedListPracticeLink.click();
		}
		 
		   public void testAssertFalseWithMessage() {
		        // Assertion with a message to provide context
		       assert false : "This test is designed to fail";
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
				js.executeScript("arguments[0].CodeMirror.setValue(arguments[1]);", linkedListIntroductionTextEdit, code);
			}   
	}