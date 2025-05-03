package com.dsalgo.automation.utils;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.dsalgo.automation.pages.QueuePage;
import com.dsalgo.automation.pages.RegisterPage;

public class HelperUtility {
	
	private static Logger LOGGER = LogManager.getLogger(HelperUtility.class);
	
	public static void verifyPracticeQuestionPage(QueuePage queuePage, String expectedTitle) {
		queuePage.practiceQuestions();
		String actualTitle = queuePage.verifyTitleOfPage();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
		String content = queuePage.verifyContent();
		if (content.isEmpty()) {
			String errorMsg = "Test failed: Page is Empty.";
			throw new AssertionError(errorMsg);
		}
	}

	public static void verifyEditorWithEmptyCode(QueuePage queuePage, Map<String, String> data) {
		queuePage.tryCodeEditor();
		queuePage.runCode();
        String codeOutput = queuePage.verifyOutput();
        Assert.assertEquals(codeOutput, "");
		
	}

	public static void verifyEditorWithValidCode(QueuePage queuePage, Map<String, String> data) {
		queuePage.tryCodeEditor();
    	queuePage.verifyCodeEditor(data.get("Code"));
    	queuePage.runCode();
    	String expectedOutput = data.get("Output");
        String codeOutput = queuePage.verifyOutput();
        Assert.assertEquals(codeOutput, expectedOutput);
		
	}

	public static void verifyEditorWithInvalidCode(QueuePage queuePage, Map<String, String> data) {
		queuePage.tryCodeEditor();
    	String invalidCode = data.get("Code");
    	queuePage.verifyCodeEditor(invalidCode);
		queuePage.runCode();
    	Boolean isDisplayed = queuePage.alertPresent();
    	Assert.assertTrue(isDisplayed);
    	queuePage.handleAlert();
		
	}
	
	public static void verifyDisplayMessage(RegisterPage registerPage) {
	String actualErrMsg = registerPage.verifyErrorMessage();
	String displyedMsg = "password_mismatch:The two password fields didn’t match.";
	try {
		Assert.assertEquals(actualErrMsg, displyedMsg);
		throw new AssertionError("Test failed: Incorrect error message displayed.");
	} catch (AssertionError e) {
		LOGGER.error("Assertion failed: " + e.getMessage());
		throw e;
	}
 }
}
