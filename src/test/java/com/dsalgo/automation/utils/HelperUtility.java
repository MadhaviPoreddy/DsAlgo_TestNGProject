package com.dsalgo.automation.utils;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.pages.QueuePage;
import com.dsalgo.automation.pages.RegisterPage;

public class HelperUtility {
	
	
	public static  WebDriver driver = DriverFactory.getDriver();

	public static boolean verifyPracticeQuestionPage(QueuePage queuePage, String expectedTitle) {
		queuePage.practiceQuestions();
		String content = queuePage.verifyContent();
		if (content.isEmpty()) {
			return false;
		}
		return true;
	}

	public static String verifyEditorWithEmptyCode(QueuePage queuePage, Map<String, String> data) {
		queuePage.tryCodeEditor();
		queuePage.runCode();
        return queuePage.verifyOutput();		
	}

	public static String verifyEditorWithValidCode(QueuePage queuePage, Map<String, String> data) {
		queuePage.tryCodeEditor();
    	queuePage.verifyCodeEditor(data.get("Code"));
    	queuePage.runCode();
        return queuePage.verifyOutput();
	}

	public static Boolean verifyEditorWithInvalidCode(QueuePage queuePage, Map<String, String> data) {
		queuePage.tryCodeEditor();
    	String invalidCode = data.get("Code");
    	queuePage.verifyCodeEditor(invalidCode);
		queuePage.runCode();
    	return queuePage.alertPresent();		
	}	
}

