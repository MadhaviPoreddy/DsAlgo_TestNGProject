
	package com.dsalgo.automation.tests;
	import java.util.List;
	import java.util.Map;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.apache.xmlbeans.impl.xb.xsdschema.Public;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
	import com.dsalgo.automation.base.BaseClass;
	import com.dsalgo.automation.driver.DriverFactory;
	import com.dsalgo.automation.pages.*;
	import com.dsalgo.automation.tests.HomePageTest;
import com.dsalgo.automation.utils.ExcelReader;
import com.dsalgo.automation.utils.NavigationUtil;
	//import com.dsalgo.automation.utils.ExcelReader;


	@SuppressWarnings("unused")
	public class LinkedListPageTest  extends BaseClass{

		public HomePageTest homeTest= new HomePageTest();
		private HomePage homePage; // Global declaration for reuse
		private LoginPage loginPage;
		
		
		private LinkedListPage LL; 
		 // Initialize logger for this class
	   private static final Logger logger = LogManager.getLogger(ArrayPageTest.class);
	   
	   @BeforeClass
	   public void setUpPage() {
			
		   LL=new LinkedListPage(driver); 
	   }
		
	   @BeforeMethod
		public void navigateBeforeEachTest() {
		   homePage = new HomePage(driver);
		   loginPage = new LoginPage(driver);
		   NavigationUtil.navigateToHomePage(homePage);
		   NavigationUtil.performLogin(homePage,loginPage);
		   NavigationUtil.clickModuleGetStarted(homePage, "Linked List");
		}
		
		
		@AfterTest
		public void closeBrowser() {
	        DriverFactory.quitDriver();
	    }

	    @DataProvider(name = "pythoncode")
	    public Object[][] getData()
	    {
					
	    	 List<Map<String, String>> allData = ExcelReader.getAllRows("CodeEditor");
	    	 
	    	 Object[][] result =  new Object[allData.size()][1];
	    	 
	 	    for (int i = 0; i < allData.size(); i++) {
	 	    	result[i][0]  = allData.get(i);
	 	    }
	 	        
	    	 return result;
	    }
		    
		@Test(dataProvider="pythoncode")
		public void testcodeEditor(Map<String, String> data)
		{
			
			LL.linkedListIntroductionLink();
			LL.linkedListIntroductionTryEdit();
			String pythonCode = data.get("ValidCode");
		    String expectedOutput = data.get("Output");
		    LL.verifyCodeEditor(pythonCode);
		    LL.linkedListIntroductionTextEditRun();
		    if ("Alert".equalsIgnoreCase(expectedOutput)) {
		        	String alertMessage = (String) LL.readAlert();
		        	Assert.assertEquals(alertMessage,expectedOutput, "Test Case Failed Due to Expected is not matched with Actual: " + expectedOutput);
		            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
		            LL.acceptAlert();
		            
		        }else {
			        String actualOutput = LL.verifyOutput();
			        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Test Case Failed Due to Expected is not matched with Actual:");
		       }
			} 
		
		@Test
		public void checkLinkedListLandingPage() {
			LL.linkedListHeading();
			Assert.assertEquals(LL.verfyPageTitle().toLowerCase(), "linked list", "Not Redirected to page as expected");
			logger.info("Redirected to Linked List Landing page successfully");
		}	
		
		@Test
		public void linkedListIntroductionLink() {
			LL.linkedListIntroductionLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Introduction", "Not Redirected to page as expected");
			logger.info("Redirected to Linked List Introuduction Landing page successfully");
		}	
	
		@Test
		public void linkedListIntroductionTryEdit() {
			LL.linkedListIntroductionLink();
			LL.linkedListIntroductionTryEdit();
			Assert.assertEquals(LL.verfyPageTitle(), "Assessment", "Not Redirected to page as expected");
			logger.info("Redirected to Linked List Introuduction Text Edit Landing page successfully");
		}	
		@Test
		public void creatingLinkedList() {
			LL.creatingLinkedList();
			Assert.assertEquals(LL.verfyPageTitle(), "Creating Linked LIst", "Not Redirected to page as expected");
			logger.info("Redirected to Creating Linked List Landing page successfully");
		}	
		@Test
		public void creatingLinkedListTryEdit() {
			LL.creatingLinkedList();
			LL.creatingLinkedListTryEdit();
			Assert.assertEquals(LL.verfyPageTitle(), "Assessment", "Not Redirected to page as expected");
			logger.info("Redirected to Creating Linked List Text Edit Landing page successfully");
		}	
		
		
		@Test
		public void typesOfListLink() {
			LL.typesOfListLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Types of Linked List", "Not Redirected to page as expected");
			logger.info("Redirected to Types of Linked List Landing page successfully");
		}	
		@Test
		public void typesOfListTryEdit() {
			LL.typesOfListLink();
			LL.typesOfListTryEdit();
			Assert.assertEquals(LL.verfyPageTitle(), "Assessment", "Not Redirected to page as expected");
			logger.info("Redirected to Linked List Introuduction Text Edit Landing page successfully");
		}	
		@Test
		public void TypesOfLL_SinglyLinkedListLink() {
			LL.typesOfListLink();
			LL.TypesOfLL_SinglyLinkedListLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Singly Linked List", "Test Case Failed: Error page is displayed when clicked on the link");
			logger.info("Redirected to Singly Linked List Landing page successfully");
		}
		
		@Test
		public void TypesOfLL_LinkedListLink() {
			LL.typesOfListLink();
			LL.TypesOfLL_LinkedListLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Linked List", "Test Case Failed: Error page is displayed when clicked on the link");
			logger.info("Redirected to Linked List link Landing page successfully");
		}	
		
		@Test
		public void TypesOfLL_DoublyLinkedListLink() {
			LL.typesOfListLink();
			LL.TypesOfLL_DoublyLinkedListLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Doubly Linked List", "Test Case Failed: Error page is displayed when clicked on the link");
			logger.info("Redirected to doubly Linked List Landing page successfully");
		}	
		
		@Test
		public void TypesOfLL_TypesofLinkedListLink() {
			LL.typesOfListLink();
			LL.TypesOfLL_TypesofLinkedListLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Types of Linked List", "Test Case Failed: Error page is displayed when clicked on the link");
			logger.info("Redirected to Types of Linked List Landing page successfully");
		}
				
		@Test
		public void implementLinkedList() {
			LL.implementLinkedList();
			Assert.assertEquals(LL.verfyPageTitle(), "Implement Linked List in Python", "Not Redirected to page as expected");
			logger.info("Redirected to Implement Linked List in Python Landing page successfully");
		}	
		@Test
		public void implementLinkedListTryEdit() {
			LL.implementLinkedList();
			LL.implementLinkedListTryEdit();
			Assert.assertEquals(LL.verfyPageTitle(), "Assessment", "Not Redirected to page as expected");
			logger.info("Redirected to Implement Linked List in Python Text Edit Landing page successfully");
		}	
		
		@Test
		public void traversalLink() {
			LL.traversalLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Traversal", "Not Redirected to page as expected");
			logger.info("Redirected to Traversal Landing page successfully");
		}	
		@Test
		public void traversalTryEdit() {
			LL.traversalLink();
			LL.traversalTryEdit();
			Assert.assertEquals(LL.verfyPageTitle(), "Assessment", "Not Redirected to page as expected");
			logger.info("Redirected to Traversal Text Edit Landing page successfully");
		}	
		
		@Test
		public void insertionLink() {
			LL.insertionLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Insertion", "Not Redirected to page as expected");
			logger.info("Redirected to Insertion Landing page successfully");
		}	
		@Test
		public void insertionTryEdit() {
			LL.insertionLink();
			LL.insertionTryEdit();
			Assert.assertEquals(LL.verfyPageTitle(), "Assessment", "Not Redirected to page as expected");
			logger.info("Redirected to Insertion Text Edit Landing page successfully");
		}	
		
		@Test
		public void deletionLink() {
			LL.deletionLink();
			Assert.assertEquals(LL.verfyPageTitle(), "Deletion", "Not Redirected to page as expected");
			logger.info("Redirected to deletion Landing page successfully");
		}	
		@Test
		public void deletionTryEdit() {
			LL.deletionLink();
			LL.deletionTryEdit();
			Assert.assertEquals(LL.verfyPageTitle(), "Assessment", "Not Redirected to page as expected");
			logger.info("Redirected to deletion Text Edit Landing page successfully");
		}	
		
}
