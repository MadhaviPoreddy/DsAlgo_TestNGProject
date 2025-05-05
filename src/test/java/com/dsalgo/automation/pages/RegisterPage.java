package com.dsalgo.automation.pages;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.dsalgo.automation.driver.DriverFactory;

	
	public class RegisterPage {
		WebDriver driver;
		
		@FindBy (xpath = "//a[@href=\"/register\"]")
		private WebElement register;
		
		@FindBy (xpath = "//a[@href=\"/logout\"]")
		private WebElement logoutLnk;

		@FindBy(id = "id_username")
		private WebElement userId;

		@FindBy(id = "id_password1")
		private WebElement userPassword;
		
		@FindBy(id = "id_password2")
		private WebElement confirmPassword;

		@FindBy(xpath = "//input[@type='submit']")
		private WebElement registerButton;
		
		@FindBy (xpath = "//div[contains(text(),'The two password fields')]")
		private WebElement errorMessage;
		
		@FindBy (xpath = "//div[@class='alert alert-primary']")
		private WebElement successMsg;
		
		@FindBy (xpath = "//a[text()='NumpyNinja']")
		WebElement numpyNinjaLnk;
		
		@FindBy (xpath = "//a[text()='Sign in']")
		WebElement signInLnk;
		
		@FindBy (xpath = "//a[text()='Login ']")
		WebElement loginLnk;
		
		public RegisterPage() {
			this.driver = DriverFactory.getDriver();
			PageFactory.initElements(driver, this);
		}
		
		public void goToRegister() {
			register.click();
			
		}
		public String verifyTitleOfPage() {
			return driver.getTitle();
		}

		public void enterDetails(String username, String password, String confirmPwd) {
			userId.sendKeys(username);
			userPassword.sendKeys(password);
			confirmPassword.sendKeys(confirmPwd);
		}
		
		public void clickRegister() {
			registerButton.click();
		}

		public String verifySucces() {
			return successMsg.getText();
		}

		public String verifyUserErrorMsg() {
			return getMessage(userId);
		}

		public String verifyPwdErrorMsg() {
			return getMessage(userPassword);
		}

		public String verifyCnPwdErrorMsg() {
			return getMessage(confirmPassword);
		}

		public String verifyErrorMessage() {
			return errorMessage.getText();
		}

		public String verifyUserNameField() {
			return userId.getDomProperty("value");
		}
		
		private String getMessage(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return (String) js.executeScript("return arguments[0].validationMessage;", element);
		}
		
		public void clickNumpyNinjaLnk() {
			numpyNinjaLnk.click();
		}
		
		public void clickLoginLnk() {
			loginLnk.click();
		}
		
		public void clickSigninLnk() {
			signInLnk.click();
		}
	}
	

