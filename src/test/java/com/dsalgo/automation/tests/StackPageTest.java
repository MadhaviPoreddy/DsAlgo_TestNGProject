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

import com.dsalgo.automation.utils.*;


@SuppressWarnings("unused")
public class StackPageTest extends BaseClass{

	//public HomePageTest homeTest= new HomePageTest();
	private HomePage homePage; // Global declaration for reuse
	private GraphPage graphPage;
	private LoginPage loginPage;
	
	private StackPage Stack; 

   private static final Logger logger = LogManager.getLogger(ArrayPageTest.class);
   
   @BeforeClass
   public void setUpPage() {
		
	   Stack=new StackPage(driver); 
   }
	
	@BeforeMethod
	public void navigateBeforeEachTest() {
	    NavigationUtil.navigateToHomePage(homePage);
	    NavigationUtil.performLogin(homePage,loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Stack");
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
		
		Stack.operationsInStackLink();
		Stack.operationsInStackLinkTryEdit();
		String pythonCode = data.get("ValidCode");
	    String expectedOutput = data.get("Output");
	    Stack.verifyCodeEditor(pythonCode);
	    Stack.operationsInStackLinkTextEditRun();
	   	
	    
	        if ("Alert".equalsIgnoreCase(expectedOutput)) {
	        	String alertMessage = (String) Stack.readAlert();
	        	Assert.assertEquals(alertMessage,expectedOutput, "Test Case Failed Due to Expected is not matched with Actual: " + expectedOutput);
	            logger.info("Tested alert with code: " + pythonCode + " | Alert: " + alertMessage);
	            Stack.acceptAlert();
	            
	        }else {
		        String actualOutput = Stack.verifyOutput();
		        Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Test Case Failed Due to Expected is not matched with Actual:");
	       }
		} 
	
	
	@Test
	public void checkStackLandingPage() {
		Stack.stackPageHeading();
		Assert.assertEquals(Stack.verfyPageTitle().toLowerCase(), "stack", "Not Redirected to Array page as expected");
		logger.info("Redirected to Stack Landing page successfully");
	}	
	
	@Test
	public void operationsInStackLink() {
		Stack.operationsInStackLink();
		Assert.assertEquals(Stack.verfyPageTitle(), "Operations in Stack", "Not Redirected to Array page as expected");
		logger.info("Redirected to Operations in Stack Landing page successfully");
	}	
	
	@Test
	public void operationsInStackLinkTryEdit() {
		Stack.operationsInStackLink();
		Stack.operationsInStackLinkTryEdit();
		Assert.assertEquals(Stack.verfyPageTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Operations in Stack Text edit Landing page successfully");
	}	
	
	
	@Test
	public void stackPracticeLink() {
		Stack.operationsInStackLink();
		Stack.stackPracticeLink();
		Assert.assertEquals(Stack.verfyPageTitle(), "Practice Questions", "Not Redirected to Array page as expected");
		logger.info("Redirected to Practice Questions Landing page successfully");
	}	
	

	@Test
	public void stackImplementation() {
		Stack.stackImplementation();
		Assert.assertEquals(Stack.verfyPageTitle(), "Implementation", "Not Redirected to Array page as expected");
		logger.info("Redirected to Operations in Stack Landing page successfully");
	}	
	
	@Test
	public void stackImplementationTryEdit() {
		Stack.stackImplementation();
		Stack.stackImplementationTryEdit();
		Assert.assertEquals(Stack.verfyPageTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to stack Implementation Text edit Landing page successfully");
	}
	
	@Test
	public void stackApplications() {
		Stack.stackApplications();
		Assert.assertEquals(Stack.verfyPageTitle(), "Applications", "Not Redirected to Array page as expected");
		logger.info("Redirected to Stack Applications Landing page successfully");
	}	
	
	@Test
	public void stackApplicationsTryEdit() {
		Stack.stackApplications();
		Stack.stackApplicationsTryEdit();
		Assert.assertEquals(Stack.verfyPageTitle(), "Assessment", "Not Redirected to Array page as expected");
		logger.info("Redirected to Stack Practiece link Text edit Landing page successfully");
	}	
	
}