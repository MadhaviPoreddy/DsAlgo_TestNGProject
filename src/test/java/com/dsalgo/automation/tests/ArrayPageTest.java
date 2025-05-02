package com.dsalgo.automation.tests;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.pages.*;
//import com.dsalgo.automation.tests.HomePageTest;

import com.dsalgo.automation.utils.*;

public class ArrayPageTest extends BaseClass{

	public HomePageTest homeTest= new HomePageTest();
	
	private ArrayPage Array; 
	private HomePage homePage; // Global declaration for reuse
	private LoginPage loginPage;
	

   private static final Logger logger = LogManager.getLogger(ArrayPageTest.class);

   
   @BeforeClass
   public void setUpPage() {
		
	   Array=new ArrayPage(driver); 
   }
   

   @BeforeMethod
	public void navigateBeforeEachTest() {
	   homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	    NavigationUtil.navigateToHomePage(homePage);
	    NavigationUtil.performLogin(homePage,loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Array");
	}
	
	
	@AfterTest
	public void closeBrowser() {
        DriverFactory.quitDriver();
    }
	
	   @DataProvider(name = "arrayPractieceCode")
	    public Object[][] PractieceCode()
	    {
					
	    	 List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_SearchArray");
	    	 
	    	 Object[][] result1 =  new Object[allData1.size()][1];
	    	 
	 	    for (int i = 0; i < allData1.size(); i++) {
	 	    	result1[i][0]  = allData1.get(i);
	 	    }
	 	        
	    	 return result1;
	    }
		    
		@Test(dataProvider="arrayPractieceCode")
		public void testSearchPractieceCode(Map<String, String> data)
		{

			String practieceQ = data.get("ValidCode");
		    String expectedOutput = data.get("Output");
		    String button = data.get("Button");


		    Array.arrayUsingList();
			Array.arrayPractieceQue();
			Array.searchArrayPractieceQue();
			Array.verifyCodeEditor(practieceQ);
						   	
		    if("run".equalsIgnoreCase(button))
		    {
			    Array.arrayPythonTextEditRun();
			    	    
		        if ("Alert".equalsIgnoreCase(expectedOutput)) {
		        	String alertMessage = (String) Array.readAlert();
		        	Assert.assertEquals(alertMessage,"SyntaxError: bad input on line 2", "TestCase Failed: Actual Output is not matched with Expected: " + expectedOutput);
		            logger.info("Tested alert with code: " + practieceQ + " | Alert: " + alertMessage);
		            Array.acceptAlert();
		            
		        }
		        else {
		        	 String actualOutput = Array.verifyOutput();
				        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "TestCase Failed: Output is mismatched : "+ expectedOutput);
		        }
			} 
		    
		    else if("Submit".equalsIgnoreCase(button))
		    {

			    Array.arrayPracticeSubmit();
			    	    
		        if ("Submission Successful".equalsIgnoreCase(expectedOutput)) {
		        
			        String actualOutput = Array.verifyOutput();

		        	Assert.assertEquals(actualOutput,expectedOutput, "Mismatch! expected output is: " + expectedOutput);
		            
		            
		        }else if("Error occurred during submission".equalsIgnoreCase(expectedOutput)) {
			        String actualOutput = Array.verifyOutput();
			        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Test Case Failed: Actual output is not same as expected output");
		       }
		        else {
		        	 String actualOutput = Array.verifyOutput();
				        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Test Case Failed: Actual output is not same as expected output");
		        }
		    }
		    else
		    {
		    	
		    	    System.out.println("Page name is incorrect.");
		    	    //driver.close();
		    	   return;
		    }
		    
		
   } 		
		  @DataProvider(name = "arrayPractieceCode1")
		    public Object[][] PractieceCode1()
		    {
						
		    	 List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_MaxConse");
		    	 
		    	 Object[][] result1 =  new Object[allData1.size()][1];
		    	 
		 	    for (int i = 0; i < allData1.size(); i++) {
		 	    	result1[i][0]  = allData1.get(i);
		 	    }
		 	        
		    	 return result1;
		    }
			
		@Test(dataProvider="arrayPractieceCode1")
		public void testMaxConsecutivePractieceCodeRun(Map<String, String> data)
		{

			 String practieceQ = data.get("ValidCode");
		    String expectedOutput = data.get("Output");
		    Array.arrayPythonLink();
			Array.arrayPractieceQue();
			Array.maxConsucutiveOnesPractieceQue();
			Array.verifyCodeEditor(practieceQ);
		 	Array.arrayPythonTextEditRun();    
		 	String actualOutput = Array.verifyOutput();
			Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "TestCase Failed: Output is mismatched : "+ expectedOutput);
		}        
	 @Test(dataProvider="arrayPractieceCode1")
		public void testMaxConsecutivePractieceCodeSubmit(Map<String, String> data)
		{
		String practieceQ = data.get("ValidCode");
		 String expectedOutput = data.get("Output");
		    Array.arrayPythonLink();
			Array.arrayPractieceQue();
			Array.maxConsucutiveOnesPractieceQue();
			Array.verifyCodeEditor(practieceQ);  	
			Array.arrayPracticeSubmit();
 			String actualOutput = Array.verifyOutput();
			Assert.assertEquals(actualOutput,expectedOutput, "TestCase Failed: Output is mismatched:  " + expectedOutput);
				   		   
		}

	 @DataProvider(name = "arrayPractieceCode2")
	    public Object[][] PractieceCode2()
	    {
					
	    	 List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_FindEvenNum");
	    	 
	    	 Object[][] result1 =  new Object[allData1.size()][1];
	    	 
	 	    for (int i = 0; i < allData1.size(); i++) {
	 	    	result1[i][0]  = allData1.get(i);
	 	    }
	 	        
	    	 return result1;
	    }	 
	 
	 
		@Test(dataProvider="arrayPractieceCode2")
		public void testFindEvenPractieceCodeRun(Map<String, String> data)
		{

			String practieceQ = data.get("ValidCode");
		    String expectedOutput = data.get("Output");
		    Array.arrayBasicOperinListLink();
			Array.arrayPractieceQue();
			Array.findNumwithEvenDigitsPractieceQue();
			Array.verifyCodeEditor(practieceQ);
		    Array.arrayPythonTextEditRun();	
		 	String actualOutput = Array.verifyOutput();
			Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "TestCase Failed: Output is mismatched : "+ expectedOutput);
		}        

	 
		 @DataProvider(name = "arrayPractieceCode3")
		    public Object[][] PractieceCode3()
		    {
						
		    	 List<Map<String, String>> allData1 = ExcelReader.getAllRows("Arrays_SquaresOfSortedArray");
		    	 
		    	 Object[][] result1 =  new Object[allData1.size()][1];
		    	 
		 	    for (int i = 0; i < allData1.size(); i++) {
		 	    	result1[i][0]  = allData1.get(i);
		 	    }
		 	        
		    	 return result1;
		    }	 
		 
		 
			@Test(dataProvider="arrayPractieceCode3")
			public void testSoertedArrayPractieceCodeRun(Map<String, String> data)
			{

				String practieceQ = data.get("ValidCode");
			    String expectedOutput = data.get("Output");
			    Array.arrayBasicOperinListLink();
				Array.arrayPractieceQue();
				Array.squaresOfSortedArrayPractieceQue();
				Array.verifyCodeEditor(practieceQ);
				Array.arrayPythonTextEditRun();	    
			 	String actualOutput = Array.verifyOutput();
				Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "TestCase Failed: Output is mismatched : "+ expectedOutput);
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
		
		Array.arrayPythonLink();
		Array.arrayPythonLinkTryEdit();
		String pythonCode = data.get("ValidCode");
	    String expectedOutput = data.get("Output");
	    Array.verifyCodeEditor(pythonCode);
	    Array.arrayPythonTextEditRun();
	   	
	    
	        if ("Alert".equalsIgnoreCase(expectedOutput)) {
	        	String alertMessage = (String) Array.readAlert();
	        	Assert.assertEquals(alertMessage,"NameError: name 'System' is not defined on line 1", "Mismatched! expected output is: " + expectedOutput);
	            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
	            Array.acceptAlert();
	            
	        }else {
		        String actualOutput = Array.verifyOutput();
		        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Mismatch in Try Editor Output!");
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
	
 
	
}
