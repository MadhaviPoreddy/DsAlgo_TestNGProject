package com.dsalgo.automation.tests;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.pages.QueuePage;
import com.dsalgo.automation.pages.TreePage;
import com.dsalgo.automation.utils.TestDataProvider;
import com.dsalgo.automation.utils.HelperUtility;
import com.dsalgo.automation.utils.NavigationUtil;

public class TreePageTest extends BaseClass {

	private static Logger LOGGER = LogManager.getLogger(TreePageTest.class);

	protected WebDriver driver;

	TreePage treePage;
	QueuePage queuePage;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeClass
	public void initialClassSetup() {
		this.driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	    loginPage = new LoginPage(driver);
		treePage = new TreePage();
		queuePage = new QueuePage();

	}
	
	@BeforeMethod
	public void verifyLoginPageTitle() {
		NavigationUtil.navigateToHomePage(homePage);
		NavigationUtil.performLogin(homePage, loginPage);
		NavigationUtil.clickModuleGetStarted(homePage, "Tree");
	}
	
	@AfterMethod
	public void signout() {
		NavigationUtil.clickSignout(homePage);
	}

	@Test(priority = 1)
	public void VerifyOverviewOfTree() {
		treePage.clickOverviewOfTreeslnk();
		String OvrvwOfTreePageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(OvrvwOfTreePageTitle, "Overview of Trees");

	}

	@Test(priority = 2)
	public void VerifyOverviewOfTreeImage() {
		treePage.clickOverviewOfTreeslnk();
		Boolean isDisplayed = treePage.verifyOverviewImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 3)
	public void verifyOverviewOfTreePracticeQ() {
		treePage.clickOverviewOfTreeslnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 4, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyOverviewOfTreeCodeEditor(Map<String, String> testData) {
		treePage.clickOverviewOfTreeslnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 5)
	public void VerifyTerminologiesPage() {
		treePage.clickTerminologieslnk();
		String terminologiesPage = treePage.verifyTitleOfPage();
		Assert.assertEquals(terminologiesPage, "Terminologies");

	}

	@Test(priority = 6)
	public void VerifyTerminologiesPageTable() {
		treePage.clickTerminologieslnk();
		Boolean isDisplayed = treePage.verifyTerminologiesTable();
		Assert.assertTrue(isDisplayed);
		String rowData = treePage.verifyTermTableLastRow();

		try {
			Assert.assertEquals(rowData, " ");
			throw new AssertionError("Test failed: Column Value is blank");
		} catch (AssertionError e) {
			LOGGER.error("Assertion failed: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 7)
	public void verifyTerminologiesPracticeQ() {
		treePage.clickTerminologieslnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 8, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyTerminologiesCodeEditor(Map<String, String> testData) {
		treePage.clickTerminologieslnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 9)
	public void verifyTypesofTreesPage() {
		treePage.clickTypesOfTreeslnk();
		String typesOfTreePageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(typesOfTreePageTitle, "Types of Trees");

	}

	@Test(priority = 10)
	public void verifyTypesofTreesPracticeQ() {
		treePage.clickTypesOfTreeslnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 11, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyTypesofTreesCodeEditor(Map<String, String> testData) {
		treePage.clickTypesOfTreeslnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 12)
	public void verifyTreeTraversalsPage() {
		treePage.clickTreeTraversalsLnk();
		String treeTraversalPageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(treeTraversalPageTitle, "Tree Traversals");

	}

	@Test(priority = 13)
	public void verifyTreeTraversalsImage() {
		treePage.clickTreeTraversalsLnk();
		Boolean isDisplayed = treePage.verifyTreeTraversalImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 14)
	public void verifyDepthFirstTraversalTypesTable() {
		treePage.clickTreeTraversalsLnk();
		Boolean isDisplayed = treePage.verifyTreeTraversalTable();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 15)
	public void verifyTreeTraversalsPracticeQ() {
		treePage.clickTreeTraversalsLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 16, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyTreeTraversalsCodeEditor(Map<String, String> testData) {
		treePage.clickTreeTraversalsLnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 17)
	public void verifyTraversalsIllustrationPage() {
		treePage.clickTraversalsIllustrationLnk();
		String traversalIllsPageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(traversalIllsPageTitle, "Traversals-Illustration");

	}

	@Test(priority = 18)
	public void verifyDepthFirstTraversalDiagram() {
		treePage.clickTraversalsIllustrationLnk();
		Boolean isDisplayed = treePage.verifyDepthFirstTraversalImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 19)
	public void verifyTraversalsIllustrationPracticeQ() {
		treePage.clickTraversalsIllustrationLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 20, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyTraversalsIllustrationCodeEditor(Map<String, String> testData) {
		treePage.clickTraversalsIllustrationLnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 21)
	public void verifyBinaryTreesPage() {
		treePage.clickBinaryTreesLnk();
		String binaryTreePageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(binaryTreePageTitle, "Binary Trees");

	}

	@Test(priority = 22)
	public void verifyBinaryTreesDiagram() {
		treePage.clickBinaryTreesLnk();
		Boolean isDisplayed = treePage.verifyBinaryTreeImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 23)
	public void verifyBinaryTreesPracticeQ() {
		treePage.clickBinaryTreesLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 24, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyBinaryTreesCodeEditor(Map<String, String> testData) {
		treePage.clickBinaryTreesLnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 25)
	public void verifyTypesOfBinaryTreesPage() {
		treePage.clickTypesOfBinaryTreesLnk();
		String typesOfBinaryPageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(typesOfBinaryPageTitle, "Types of Binary Trees");

	}

	@Test(priority = 26)
	public void verifyCompleteBinaryTreeDiagram() {
		treePage.clickTypesOfBinaryTreesLnk();
		Boolean isDisplayed = treePage.verifyCompletteBinaryTreeImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 27)
	public void verifyFullBinaryTreeDiagram() {
		treePage.clickTypesOfBinaryTreesLnk();
		Boolean isDisplayed = treePage.verifyFullBinaryTreeImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 28)
	public void verifyTypesOfBinaryTreesPracticeQ() {
		treePage.clickTypesOfBinaryTreesLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 29, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyTypesOfBinaryTreesCodeEditor(Map<String, String> testData) {
		treePage.clickTypesOfBinaryTreesLnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 30)
	public void verifyImplementationInPython() {
		treePage.clickImplementationInPythonLnk();
		String impOfPythonPageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(impOfPythonPageTitle, "Implementation in Python");

	}

	@Test(priority = 31)
	public void verifyImplementationInPythonPracticeQ() {
		treePage.clickImplementationInPythonLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 32, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyImplementationInPythonCodeEditor(Map<String, String> testData) {
		treePage.clickImplementationInPythonLnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 33)
	public void verifyBinaryTreeTraversalsPage() {
		treePage.clickBinaryTreeTraversalsLnk();
		String binTreeTravPageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(binTreeTravPageTitle, "Binary Tree Traversals");

	}

	@Test(priority = 34)
	public void verifyBinaryTreeDatadiagram() {
		treePage.clickBinaryTreeTraversalsLnk();
		Boolean isDisplayed = treePage.verifyBinaryTreeDataImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 35)
	public void verifyBinaryTreeTraversalsPracticeQ() {
		treePage.clickBinaryTreeTraversalsLnk();
		verifyPracticeQuestion(); 
	}

	@Test(priority = 36, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyBinaryTreeTraversalsCodeEditor(Map<String, String> testData) {
		treePage.clickBinaryTreeTraversalsLnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 37)
	public void verifyImplementationOfBinaryTreesPage() {
		treePage.clickImplementationOfBinaryTreesLnk();
		String impBinTreePageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(impBinTreePageTitle, "Implementation of Binary Trees");

	}

	@Test(priority = 38)
	public void verifyImplementationOfBinaryTreesPracticeQ() {
		treePage.clickImplementationOfBinaryTreesLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 39, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyImplementationOfBinaryTreesCodeEditor(Map<String, String> testData) {
		treePage.clickImplementationOfBinaryTreesLnk();
		codeEditorDataTest(testData);	
	}

	@Test(priority = 40)
	public void verifyApplicationsOfBinaryTreesPage() {
		treePage.clickApplicationsOfBinaryTreesLnk();
		String appOfBinaryPageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(appOfBinaryPageTitle, "Applications of Binary trees");

	}

	@Test(priority = 41)
	public void verifyApplicationsOfBinaryTreesPracticeQ() {
		treePage.clickApplicationsOfBinaryTreesLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 42, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyApplicationsOfBinaryTreesCodeEditor(Map<String, String> testData) {
		treePage.clickApplicationsOfBinaryTreesLnk();
		codeEditorDataTest(testData);
	}

	@Test(priority = 43)
	public void verifyBinarySearchTreesPage() {
		treePage.clickBinarySearchTreesLnk();
		String binSrcTreePageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(binSrcTreePageTitle, "Binary Search Trees");

	}

	@Test(priority = 44)
	public void verifyBinarySearchTreeDiagram() {
		treePage.clickBinarySearchTreesLnk();
		Boolean isDisplayed = treePage.verifyBinarySearchTreeImage();
		Assert.assertTrue(isDisplayed);

	}

	@Test(priority = 45)
	public void verifyBinarySearchTreePracticeQ() {
		treePage.clickBinarySearchTreesLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 46, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyBinarySearchTreeCodeEditor(Map<String, String> testData) {
		treePage.clickBinarySearchTreesLnk();
		codeEditorDataTest(testData);
		}
	

	@Test(priority = 47)
	public void verifyImplementationOfBSTPage() {
		treePage.clickImplementationOfBSTLnk();
		String impOfBSTPageTitle = treePage.verifyTitleOfPage();
		Assert.assertEquals(impOfBSTPageTitle, "Implementation Of BST");

	}

	@Test(priority = 48)
	public void verifyImplementationOfBSTPracticeQ() {
		treePage.clickImplementationOfBSTLnk();
		verifyPracticeQuestion();
	}

	@Test(priority = 49, dataProvider = "CodeEditor", dataProviderClass = TestDataProvider.class)
	public void verifyImplementationOfBSTCodeEditor(Map<String, String> testData) {
		treePage.clickImplementationOfBSTLnk();
		codeEditorDataTest(testData);
	}
	
	private void codeEditorDataTest(Map<String, String> testData) {
		if (testData == null) {
			throw new RuntimeException("No test data found for TC_ID");
		}
		switch (testData.get("Scenario")) {

		case "EmptyCode":
			String codeOutput = HelperUtility.verifyEditorWithEmptyCode(queuePage, testData);
			Assert.assertEquals(codeOutput, "");
			driver.navigate().back();
			break;

		case "ValidCode":
			String validCodeOutput = HelperUtility.verifyEditorWithValidCode(queuePage, testData);
			String expectedOutput = testData.get("Output");
			Assert.assertEquals(validCodeOutput, expectedOutput);
			driver.navigate().back();
			break;

		case "InvalidCode":
			Boolean isAlertPresent = HelperUtility.verifyEditorWithInvalidCode(queuePage, testData);
			Assert.assertTrue(isAlertPresent);
			queuePage.handleAlert();
			driver.navigate().back();
			break;

		default:
			break;
		}}
	
	private void verifyPracticeQuestion() {
		boolean pageContentPresent = HelperUtility.verifyPracticeQuestionPage(queuePage, "Practice Questions");
		try {
			Assert.assertTrue(pageContentPresent);
			throw new AssertionError("Test failed: Incorrect error message displayed.");
		} catch (AssertionError e) {
			LOGGER.error("Assertion failed: " + e.getMessage());
			throw e;
		}
}}
