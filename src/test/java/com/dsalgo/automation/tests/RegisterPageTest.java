package com.dsalgo.automation.tests;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.automation.base.BaseClass;
import com.dsalgo.automation.driver.DriverFactory;
import com.dsalgo.automation.pages.HomePage;
import com.dsalgo.automation.pages.LoginPage;
import com.dsalgo.automation.pages.RegisterPage;
import com.dsalgo.automation.utils.HelperUtility;
import com.dsalgo.automation.utils.NavigationUtil;
import com.dsalgo.automation.utils.TestDataProvider;

@Test(singleThreaded = true)
public class RegisterPageTest extends BaseClass {
	
	private static Logger LOGGER = LogManager.getLogger(RegisterPageTest.class);

	protected WebDriver driver;
	RegisterPage registerPage;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeClass
	public void initialClassSetup() {
		this.driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		registerPage = new RegisterPage();
	}

	@BeforeMethod
	public void verifyLoginPageTitle() {
		NavigationUtil.navigateToHomePage(homePage);
		homePage.clickRegister();
	}

	@Test(priority = 2, dataProvider = "Register", dataProviderClass = TestDataProvider.class)
	public void verifyRegister(Map<String, String> testData) {
		if (testData == null) {
			throw new RuntimeException("No test data found for TC_ID");
		}

		switch (testData.get("TC_ID")) {
		case "TC_01":
			getRegisterData(testData);
			verifyValidRegister(testData);
			break;

		case "TC_02":
			getRegisterData(testData);
			verifyEmptyPwdErrorMsg();
			break;

		case "TC_03":
			getRegisterData(testData);
			verifyEmptyCnPwdErrorMsg();
			break;

		case "TC_04":
			getRegisterData(testData);
			HelperUtility.verifyDisplayMessage(registerPage);
			break;

		case "TC_05":
			getRegisterData(testData);
			verifyEmptyPwdErrorMsg();
			break;

		case "TC_06":
			getRegisterData(testData);
			verifyEmptyUserErrorMsg();
			break;

		case "TC_07":
			getRegisterData(testData);
			HelperUtility.verifyDisplayMessage(registerPage);
			break;

		case "TC_08":
			getRegisterData(testData);
			HelperUtility.verifyDisplayMessage(registerPage);
			break;

		case "TC_09":
			getRegisterData(testData);
			HelperUtility.verifyDisplayMessage(registerPage);
			break;

		case "TC_10":
			getRegisterData(testData);
			HelperUtility.verifyDisplayMessage(registerPage);
			break;

		case "TC_11":
			getRegisterData(testData);
			verifyValidDisplayMessage();
			break;

		case "TC_12":
			verifyUserNameLength(testData);
			break;

		default:

		}
	}

	@Test(priority = 3)
	public void verifyLoginLink() {
		registerPage.clickLoginLnk();
		String actualErrMsg = registerPage.verifyTitleOfPage();
		String loginPageTitle = "Login";
		Assert.assertEquals(actualErrMsg, loginPageTitle);
		driver.navigate().back();
	}

	@Test(priority = 4)
	public void verifySignLink() {
		registerPage.clickSigninLnk();
		String actualErrMsg = registerPage.verifyTitleOfPage();
		String loginPageTitle = "Login";
		Assert.assertEquals(actualErrMsg, loginPageTitle);
		driver.navigate().back();
	}

	@Test(priority = 5)
	public void verifyNumpyNinjaLink() {
		registerPage.clickNumpyNinjaLnk();
		String actualErrMsg = registerPage.verifyTitleOfPage();
		String ninjaPageTitle = "Numpy Ninja";
		Assert.assertEquals(actualErrMsg, ninjaPageTitle);
	}

	private void getRegisterData(Map<String, String> data) {
		registerPage.enterDetails(data.get("Username"), data.get("Password"), data.get("ConfirmPassword"));
		registerPage.clickRegister();
	}

	private void verifyValidRegister(Map<String, String> data) {
		String expectedSuccMsg = "New Account Created. You are logged in as " + data.get("Username");
		String successMesg = registerPage.verifySucces();
		Assert.assertEquals(successMesg, expectedSuccMsg);
	}

	private void verifyEmptyPwdErrorMsg() {
		String message = registerPage.verifyPwdErrorMsg();
		Assert.assertEquals(message, "Please fill out this field.");
	}

	private void verifyEmptyCnPwdErrorMsg() {
		String CPmessage = registerPage.verifyCnPwdErrorMsg();
		Assert.assertEquals(CPmessage, "Please fill out this field.");
	}

	private void verifyEmptyUserErrorMsg() {
		String usrMessage = registerPage.verifyUserErrorMsg();
		Assert.assertEquals(usrMessage, "Please fill out this field.");
	}

	private void verifyValidDisplayMessage() {
		String actualErrMsg = registerPage.verifyErrorMessage();
		String displyedMsg = "password_mismatch:The two password fields didn’t match.";
		Assert.assertEquals(actualErrMsg, displyedMsg);

	}

	private void verifyUserNameLength(Map<String, String> data) {
		registerPage.enterDetails(data.get("Username"), data.get("Password"), data.get("ConfirmPassword"));
		String userName = registerPage.verifyUserNameField();
		int userLength = userName.length();
		Assert.assertEquals(userLength, 150);

	}
}