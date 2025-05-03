package com.dsalgo.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.automation.driver.DriverFactory;

public class TreePage {

	WebDriver driver ;
	QueuePage queuepage = new QueuePage();
	
	@FindBy (xpath = "//a[@href='tree']")
	WebElement treeBtn;
	
	@FindBy (xpath = "//a[contains(text(),'Overview')]")
	private WebElement overviewOfTreesLnk;
	
	@FindBy (xpath = "//a[contains(text(),'Terminologies')]")
	private WebElement terminologiesLnk;
	
	@FindBy (xpath = "//a[contains(text(),'Types of')]")
	private WebElement typesOfTreesPageLnk;
	
	@FindBy (xpath = "//a[text()='Tree Traversals']")
	private WebElement treeTraversalsLnk;
	
	@FindBy (xpath = "//a[text()='Traversals-Illustration']")
	private WebElement traversalsIllustrationLnk;
	
	@FindBy (xpath = "//a[text()='Binary Trees']")
	private WebElement binaryTreesLnk;
	
	@FindBy (xpath = "//a[text()='Types of Binary Trees']")
	private WebElement typesOfBinaryTreesLnk;
	
	@FindBy (xpath = "//a[text()='Implementation in Python']")
	private WebElement implementationInPythonLnk;
	
	@FindBy (xpath = "//a[text()='Binary Tree Traversals']")
	private WebElement binaryTreeTraversalsLnk;
	
	@FindBy (xpath = "//a[text()='Implementation of Binary Trees']")
	private WebElement implementationOfBinaryTreesLnk;
	
	@FindBy (xpath = "//a[text()='Applications of Binary trees']")
	private WebElement applicationsOfBinaryTreesLnk;
	
	@FindBy (xpath = "//a[text()='Binary Search Trees']")
	private WebElement binarySearchTreesLnk;
	
	@FindBy (xpath = "//a[text()='Implementation Of BST']")
	private WebElement implementationOfBSTLnk;
	
	@FindBy(css = "img[src='/media/ckupload/Trees_Overview.jpg']")
	private WebElement treeOverviewImage;
	
	@FindBy(xpath = "//img[@src='/media/ckupload/Level_order_traversal.jpg']")
	private WebElement levelOrderTraversalImage;
	
	@FindBy(xpath = "//img[@src='/media/ckupload/Tree_traversals.jpg\']")
	private WebElement depthFirstTraversalImage;
	
	@FindBy(xpath = "//img[@src='/media/ckupload/Binary%20Trees.jpg\']")
	private WebElement binaryTreeImage;
	
	@FindBy(xpath = "//img[@src='/media/ckupload/Complete%20Binary%20Tree.jpg']")
	private WebElement completteBinaryTreeImage;
	
	@FindBy(xpath = "//img[@src='/media/ckupload/Full%20Binary%20Tree.jpg']")
	private WebElement fullBinaryTreeImage;
	
	@FindBy(xpath = "//img[@src='/media/ckupload/tree_traversal_diagram.jpg']")
	private WebElement binaryTreeDataImage;
	
	@FindBy(xpath = "//img[contains(@src,'content.com')]")
	private WebElement binarySearchTreeImage;
	
	@FindBy (xpath = "//table[@border=\"1\"]")
	private WebElement terminologiesTable;
	
	@FindBy (xpath = "//table//tr[8]//td[2]/p")
	private WebElement termTableLastRow;
	
	@FindBy (xpath = "//table[@class='Table']")
	private WebElement treeTraversalTable;
	
	
	public TreePage() {
		this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
	}
	
	public void clickTree() {
		treeBtn.click();
	}	

	public void clickOverviewOfTreeslnk() {
		overviewOfTreesLnk.click();
	}
	
	public boolean verifyOverviewImage() {
		return treeOverviewImage.isDisplayed();
	}
	
	public void clickTerminologieslnk() {
		terminologiesLnk.click();
	}
	
	public void clickTypesOfTreeslnk() {
		typesOfTreesPageLnk.click();
	}
	
	public void clickTreeTraversalsLnk() {
		treeTraversalsLnk.click();
	}
	
	public boolean verifyTreeTraversalImage() {
		return levelOrderTraversalImage.isDisplayed();
	}
	
	public void clickTraversalsIllustrationLnk() {
		traversalsIllustrationLnk.click();
	}
	
	public boolean verifyDepthFirstTraversalImage() {
		return depthFirstTraversalImage.isDisplayed();
	}
	
	public void clickBinaryTreesLnk() {
		binaryTreesLnk.click();
	}
	
	public boolean verifyBinaryTreeImage() {
		return binaryTreeImage.isDisplayed();
	}
	
	public void clickTypesOfBinaryTreesLnk() {
		typesOfBinaryTreesLnk.click();
	}
	
	public boolean verifyCompletteBinaryTreeImage() {
		return completteBinaryTreeImage.isDisplayed();
	}
	
	public boolean verifyFullBinaryTreeImage() {
		return fullBinaryTreeImage.isDisplayed();
	}	
	
	public void clickImplementationInPythonLnk() {
		implementationInPythonLnk.click();
	}
	
	public void clickBinaryTreeTraversalsLnk() {
		binaryTreeTraversalsLnk.click();
	}
	
	public boolean verifyBinaryTreeDataImage() {
		return binaryTreeDataImage.isDisplayed();
	}	
	
	public void clickImplementationOfBinaryTreesLnk() {
		implementationOfBinaryTreesLnk.click();
	}
	
	public void clickApplicationsOfBinaryTreesLnk() {
		applicationsOfBinaryTreesLnk.click();
	}
	
	public void clickBinarySearchTreesLnk() {
		binarySearchTreesLnk.click();
	}
	
	public boolean verifyBinarySearchTreeImage() {
		return binarySearchTreeImage.isDisplayed();
	}	
	
	public void clickImplementationOfBSTLnk() {
		implementationOfBSTLnk.click();
	}
	
	public void practiceQuestions() {
		queuepage.runBtn.click();
	}

	public void tryCodeEditor() {
		queuepage.tryHereBtn.click();
	}
	
	public void verifyCodeEditor(String code) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].CodeMirror.setValue(arguments[1]);", queuepage.codeEditor, code);
	}
	
	public void runCode() {
		queuepage.runBtn.click();
	}
	
	public String verifyOutput() {
		return queuepage.output.getText();
	}
	
	public void handleAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
	
	}
	
	public String verifyTitleOfPage() {
		return driver.getTitle();
	}
	
	public boolean verifyTerminologiesTable() {
		return terminologiesTable.isDisplayed();		
	}
	
	public String verifyTermTableLastRow() {
		return termTableLastRow.getText();		
	}
	
	public boolean verifyTreeTraversalTable() {
		return treeTraversalTable.isDisplayed();
		
	}

		
	
}