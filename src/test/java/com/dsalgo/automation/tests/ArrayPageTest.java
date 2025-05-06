package com.dsalgo.automation.tests;
//import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dsalgo.automation.base.BaseClass;
//import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.pages.*;
//import com.dsalgo.automation.tests.HomePageTest;

import com.dsalgo.automation.utils.*;

public class ArrayPageTest extends BaseClass{

	public HomePageTest homeTest= new HomePageTest();
	
	private ArrayPage Array; 
	private HomePage homePage; // Global declaration for reuse
	private LoginPage loginPage;

   private static final Logger logger = LogManager.getLogger(ArrayPageTest.class);

   @BeforeMethod
	public void navigateBeforeEachTest() {
	  Array=new ArrayPage(driver); 
	   homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	    NavigationUtil.navigateToHomePage(homePage);
	    NavigationUtil.performLogin(homePage,loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Array");
	}
	
   @AfterMethod
   public void navigateAfterEachTest()
   {
   
	   driver.navigate().back();
	   NavigationUtil.clickSignout(homePage);
   }
   
		    
		@Test(dataProvider="arrayPractieceCode", dataProviderClass = TestDataProvider.class)
		public void testSearchPractieceCodeRun1(Map<String, String> data)
		{

			String practieceQ = data.get("ValidCode");
		    String expectedOutput = data.get("Output");
		    String button = data.get("Button");
		    Array.arrayUsingList();
			Array.arrayPractieceQue();
			Array.searchArrayPractieceQue();
			Array.verifyCodeEditor(practieceQ);
			
		switch(button)
		{
		case "run1":
			Array.arrayPythonTextEditRun();
			verifyResult(expectedOutput);
			break;
		case "run2":
			Array.arrayPythonTextEditRun();
			verifyResult(expectedOutput);
			break;
		case "run3":
			Array.arrayPythonTextEditRun();
			verifyAlert(expectedOutput);
			break;	    	    
		case "Submit1":
			Array.arrayPracticeSubmit();
			verifyResult(expectedOutput);
			break;
		case "Submit2":
			Array.arrayPracticeSubmit();
			verifyOutputError(expectedOutput);
			break;
		case "Submit3":
			Array.arrayPracticeSubmit();
			verifyOutputError(expectedOutput);
			break;
		default:
			break;
		}	
		    
		}
   
		@Test(dataProvider="arrayPractieceCode1", dataProviderClass = TestDataProvider.class)
		public void testMaxConsecutivePractieceCodeRun(Map<String, String> data)
		{
			String practieceQ = data.get("ValidCode");
		    String expectedOutput = data.get("Output");
		    String button=data.get("Button");
		    Array.arrayPythonLink();
			Array.arrayPractieceQue();
			Array.maxConsucutiveOnesPractieceQue();
			Array.verifyCodeEditor(practieceQ);
			
			 if("run".equalsIgnoreCase(button))
			    {
		 	Array.arrayPythonTextEditRun();    
		 	verifyResult(expectedOutput);
		       }
			 else
			    {
			Array.arrayPracticeSubmit();    
			verifyResult(expectedOutput);
		       }
			}
		@Test(dataProvider="arrayPractieceCode2", dataProviderClass = TestDataProvider.class)
		public void testFindEvenPractieceCodeRun(Map<String, String> data)
		{

			String practieceQ = data.get("ValidCode");
		    String expectedOutput = data.get("Output");
		    String button=data.get("Button");
		    Array.arrayBasicOperinListLink();
			Array.arrayPractieceQue();
			Array.findNumwithEvenDigitsPractieceQue();
			Array.verifyCodeEditor(practieceQ);
			switch(button)
			{
			case "run":
				Array.arrayPythonTextEditRun();
				verifyResult(expectedOutput);
				break;   	    
			case "Submit":
				Array.arrayPracticeSubmit();
				verifyResult(expectedOutput);
				break;
					
			default:
				break;
			}	
			
		}        
		 @Test(dataProvider="arrayPractieceCode3", dataProviderClass = TestDataProvider.class)
			public void testSoertedArrayPractieceCodeRun(Map<String, String> data)
			{
				String practieceQ = data.get("ValidCode");
			    String expectedOutput = data.get("Output");
			    String button=data.get("Button");
			    Array.arrayBasicOperinListLink();
				Array.arrayPractieceQue();
				Array.squaresOfSortedArrayPractieceQue();
				Array.verifyCodeEditor(practieceQ);
				switch(button)
				{
				case "run":
					Array.arrayPythonTextEditRun();
					verifyResult(expectedOutput);
					break;   	    
				case "Submit1":
					Array.arrayPracticeSubmit();
					verifyBlankOutputError(expectedOutput);
					break;
				case "Submit2":
					Array.arrayPracticeSubmit();
					verifyBlankOutputError(expectedOutput);
					break;
				
				default:
					break;
				}	

		       }
	    
	@Test(dataProvider="pythoncode", dataProviderClass = TestDataProvider.class)
	public void testcodeEditor(Map<String, String> data)
	{
		Array.arrayPythonLink();
		Array.arrayPythonLinkTryEdit();
		String pythonCode = data.get("ValidCode");
	    String expectedOutput = data.get("Output");
	    Array.verifyCodeEditor(pythonCode);
	    Array.arrayPythonTextEditRun();
	       if ("Alert".equalsIgnoreCase(expectedOutput)) {
	        	verifyTxtEditAlert(expectedOutput);
	        }
	        else {
	        	verifyResult(expectedOutput);
	       }
		} 
		    
	@Test
	public void checkArrayLandingPage() {
		Array.arrayPageHeading();
		Assert.assertEquals(Array.verfyArrayTitle().toLowerCase(), "array", "Not Redirected to Array page as expected");
		logger.info("Redirected to Array Landing page successfully");
	}	
	
	@Test
	public void arrayPythonLink() {
		Array.arrayPythonLink();
		Assert.assertEquals(Array.verfyArrayTitle(), "Arrays in Python", "Not Redirected to Array page as expected");
		logger.info("Redirected to arrays-in-python Landing page successfully");
	}	
	
	@Test
	public void arrayPythonLinkTryEdit() {
		Array.arrayPythonLink();
		Array.arrayPythonLinkTryEdit();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to arrays-in-python Text Editor page successfully");
	}	
	
	@Test
	public void arrayUsingList() {
		Array.arrayUsingList();
		Assert.assertEquals(Array.verfyArrayTitle(), "Arrays Using List", "Not Redirected to Array page as expected");
		logger.info("Redirected to arrays Using List Text Editor page successfully");
	}
	
	@Test
	public void arrayUsingListTryEdit() {
		Array.arrayUsingList();
		Array.arrayPythonLinkTryEdit();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Arrays Using List Text Editor page successfully");
		//getAllRows()
	}	

	
	@Test
	public void arrayBasicOperinListLink() {
		Array.arrayBasicOperinListLink();
		Assert.assertEquals(Array.verfyArrayTitle(), "Basic Operations in Lists", "Not Redirected to Array page as expected");
		logger.info("Redirected to arrays Basic Operations page successfully");
	}	
	
	
	@Test
	public void basicOperinListTryEdit() {
		Array.arrayBasicOperinListLink();
		Array.arrayPythonLinkTryEdit();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to BasicOperinList Text Editor page successfully");
		//getAllRows()
	}	
	
	@Test
	public void applicationOfArraryLink() {
		Array.applicationOfArraryLink();
		Assert.assertEquals(Array.verfyArrayTitle(), "Applications of Array", "Not Redirected to Array page as expected");
		logger.info("Redirected to Applications of Array page successfully");
	}
	
	@Test
	public void applicationOfArraryTryEdit() {
		Array.applicationOfArraryLink();
		Array.arrayPythonLinkTryEdit();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Applications of Array Text Editor page successfully");
		//getAllRows()
	}
	
	@Test
	public void arrayPractieceQue() {
		Array.applicationOfArraryLink();
		Array.arrayPractieceQue();
		Assert.assertEquals(Array.verfyArrayTitle(), "Practice Questions", "Not Redirected to Array page as expected");
		logger.info("Redirected to Practiece Questions of Array page successfully");
	}
	
	@Test
	public void arrayUsingListfromLeftMenu() {
		Array.arrayBasicOperinListLink();
		Array.arrayUsingListfromLeftMenu();
		Assert.assertEquals(Array.verfyArrayTitle(), "Arrays Using List", "Not Redirected to Array page as expected");
		logger.info("Redirected to Arrays Using List of Array page from left side menu successfully");
	}
	
	@Test
	public void searchTheArrayPractieceQue() {
		Array.arrayUsingList();
		Array.arrayPractieceQue();
		Array.searchArrayPractieceQue();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Search the Array Practiece Questions of Array page successfully");
	}
	
	@Test
	public void maxPractieceQPractieceQue() {
		Array.arrayPythonLink();
		Array.arrayPractieceQue();
		Array.maxConsucutiveOnesPractieceQue();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Max practiece questions of the Array Practiece Questions of Array page successfully");
	}
	@Test
	public void findWithEvenDigitPractieceQue() {
		Array.arrayBasicOperinListLink();
		Array.arrayPractieceQue();
		Array.findNumwithEvenDigitsPractieceQue();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Find with Even Digits of the Array Practiece Questions of Array page successfully");
	}
	
	@Test
	public void squaredOfSortedArrayPractieceQue() {
		Array.arrayBasicOperinListLink();
		Array.arrayPractieceQue();
		Array.squaresOfSortedArrayPractieceQue();
		Assert.assertEquals(Array.verfyArrayTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Squared of the Sorted Array Practiece Questions of Array page successfully");
	}
	
 
	public void verifyResult(String expectedOutput)
	{
	        	String actualOutput = Array.verifyOutput();
		        Assert.assertEquals(actualOutput,expectedOutput, "TestCase Failed: Output is mismatched : "+ expectedOutput);
		        logger.info("Actual Output upon clicking Run is " + actualOutput );
        }
	public void verifyAlert(String expectedOutput)
	{
		String alertMessage = (String) Array.readAlert();
      	Assert.assertEquals(alertMessage,"SyntaxError: bad input on line 2", "TestCase Failed: Actual Output is not matched with Expected: " + expectedOutput);
          Array.acceptAlert();
	}
	
	public void verifyTxtEditAlert(String expectedOutput)
	{
		String alertMessage = (String) Array.readAlert();
		Assert.assertEquals(alertMessage,"NameError: name 'System' is not defined on line 1", "Testcase Failed: Mismatched! expected output is: " + expectedOutput);
		logger.info("Tested alert with code:| Alert: " + alertMessage);
      	Array.acceptAlert();
	}
	public void verifyOutputError(String expectedOutput)
	{  
     	String actualOutput = Array.verifyOutputError();
      	Assert.assertEquals(actualOutput,expectedOutput, "Test Case Failed: Actual output is not same as expected output: " + expectedOutput);
      	logger.info("Actual Output upon clicking Submit is " + actualOutput );        
	}
	
	public void verifyBlankOutputError(String expectedOutput)
	{  
     	String actualOutput = Array.verifyBlankOutputError();
      	Assert.assertEquals(actualOutput.trim(),expectedOutput.trim(), "Test Case Failed: Actual output is not same as expected output: " + expectedOutput);
      	logger.info("Actual Output upon clicking Submit is " + actualOutput );        
	}
	
	
}
