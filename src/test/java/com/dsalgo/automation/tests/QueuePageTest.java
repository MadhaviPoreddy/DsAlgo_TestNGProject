package com.dsalgo.automation.tests;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.pages.QueuePage;
import com.dsalgo.automation.utils.TestDataProvider;
import com.dsalgo.automation.utils.HelperUtility;
import com.dsalgo.automation.utils.NavigationUtil;

public class QueuePageTest extends BaseClass {

	private static Logger LOGGER = LogManager.getLogger(QueuePageTest.class);
	private WebDriver driver;
	QueuePage queuePage;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void verifyLoginPageTitle() {
		this.driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	    loginPage = new LoginPage(driver);
		NavigationUtil.navigateToHomePage(homePage);
		NavigationUtil.performLogin(homePage, loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Queue");
		
		
		queuePage = new QueuePage();

	}
	
	@AfterMethod
	public void signout() {
		NavigationUtil.clickSignout(homePage);
	}

	@Test(priority = 1)
	public void verifyImplOfQueueInPyPage() {
		queuePage.clickimpOfQPy();
		String impQPyTitle = queuePage.verifyTitleOfPage();
		Assert.assertEquals(impQPyTitle, "Implementation of Queue in Python");
	}

	@Test(priority = 2)
	public void verifyImplOfQueueInPyPracticeQ() {
		queuePage.clickimpOfQPy();
		try {
			HelperUtility.verifyPracticeQuestionPage(queuePage, "Practice Questions");
		} catch (AssertionError e) {
			LOGGER.error("Verification failed: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 3, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyImplOfQueueInPyCodeEditor(Map<String, String> data) {
		queuePage.clickimpOfQPy();
		if (data == null) {
			throw new RuntimeException("No test data found for TC_ID");
		}
		switch (data.get("Scenario")) {

		case "EmptyCode":
			HelperUtility.verifyEditorWithEmptyCode(queuePage, data);
			driver.navigate().back();
			break;

		case "ValidCode":
			HelperUtility.verifyEditorWithValidCode(queuePage, data);
			driver.navigate().back();
			break;

		case "InvalidCode":
			HelperUtility.verifyEditorWithInvalidCode(queuePage, data);
			driver.navigate().back();
			break;

		default:

		}
	}

	@Test(priority = 4)
	public void verifyImplUsngCollctnDqPage() {
		queuePage.clickimpOfCollectionDq();
		String impQPyTitle = queuePage.verifyTitleOfPage();
		Assert.assertEquals(impQPyTitle, "Implementation using collections.deque");
	}

	@Test(priority = 5)
	public void verifyImplUsngCollctnDqPracticeQ() {
		queuePage.clickimpOfCollectionDq();
		try {
			HelperUtility.verifyPracticeQuestionPage(queuePage, "Practice Questions");
		} catch (AssertionError e) {
			LOGGER.error("Verification failed: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 6, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyImplUsngCollctnDqCodeEditor(Map<String, String> data) {
		queuePage.clickimpOfCollectionDq();
		if (data == null) {
			throw new RuntimeException("No test data found for TC_ID");
		}
		switch (data.get("Scenario")) {

		case "EmptyCode":
			HelperUtility.verifyEditorWithEmptyCode(queuePage, data);
			driver.navigate().back();
			break;

		case "ValidCode":
			HelperUtility.verifyEditorWithValidCode(queuePage, data);
			driver.navigate().back();
			break;

		case "InvalidCode":
			HelperUtility.verifyEditorWithInvalidCode(queuePage, data);
			driver.navigate().back();
			break;

		default:

		}
	}

	@Test(priority = 7)
	public void verifyImplUsngArrayPage() {
		queuePage.clickImplementationUsingArray();
		String impQPyTitle = queuePage.verifyTitleOfPage();
		Assert.assertEquals(impQPyTitle, "Implementation using array");
	}

	@Test(priority = 8)
	public void verifyImplUsngArrayPracticeQ() {
		queuePage.clickImplementationUsingArray();
		try {
			HelperUtility.verifyPracticeQuestionPage(queuePage, "Practice Questions");
		} catch (AssertionError e) {
			LOGGER.error("Verification failed: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 9, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyImplUsngArrayCodeEditor(Map<String, String> data) {
		queuePage.clickImplementationUsingArray();
		if (data == null) {
			throw new RuntimeException("No test data found for TC_ID");
		}
		switch (data.get("Scenario")) {

		case "EmptyCode":
			HelperUtility.verifyEditorWithEmptyCode(queuePage, data);
			driver.navigate().back();
			break;

		case "ValidCode":
			HelperUtility.verifyEditorWithValidCode(queuePage, data);
			driver.navigate().back();
			break;

		case "InvalidCode":
			HelperUtility.verifyEditorWithInvalidCode(queuePage, data);
			driver.navigate().back();
			break;

		default:

		}
	}

	@Test(priority = 10)
	public void verifyQueueOperationsPage() {
		queuePage.clickQueueOperation();
		String impQPyTitle = queuePage.verifyTitleOfPage();
		Assert.assertEquals(impQPyTitle, "Queue Operations");
	}

	@Test(priority = 11)
	public void verifyQueueOperationsPracticeQ() {
		queuePage.clickQueueOperation();
		try {
			HelperUtility.verifyPracticeQuestionPage(queuePage, "Practice Questions");
		} catch (AssertionError e) {
			LOGGER.error("Verification failed: " + e.getMessage());
			throw e;
		} 
	}

	@Test(priority = 12, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyQueueOperationsCodeEditor(Map<String, String> data) {
		queuePage.clickQueueOperation();
		if (data == null) {
			throw new RuntimeException("No test data found for TC_ID");
		}
		switch (data.get("Scenario")) {

		case "EmptyCode":
			HelperUtility.verifyEditorWithEmptyCode(queuePage, data);
			driver.navigate().back();
			break;

		case "ValidCode":
			HelperUtility.verifyEditorWithValidCode(queuePage, data);
			driver.navigate().back();
			break;

		case "InvalidCode":
			HelperUtility.verifyEditorWithInvalidCode(queuePage, data);
			driver.navigate().back();
			break;

		default:

		}
	}
}