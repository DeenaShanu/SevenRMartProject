package sevenMartPackage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	public HomePage homePage;
	public FakerUtility fakerUtility = new FakerUtility();

	public AdminUsersPage adminUsersPage;

	@Test(description = "Verify whether user is able to add a user")
//  @Parameters({"meenu","test"})
	// public void addNewUser(String username,String password) throws IOException {
	public void addNewUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		// String usr = ExcelUtility.getStringData(1, 0, "AdminUsers");
		// faker

		String pass_word = ExcelUtility.getStringData(1, 1, "AdminUsers");
		String user_type = ExcelUtility.getStringData(1, 2, "AdminUsers");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homePage = login.clickOnLoginButton();
		adminUsersPage = homePage.clickAdminUsrMenu();
		String fakeData = fakerUtility.getFakeFirstName();
		adminUsersPage.clickNewUserBtn().enterUsername(fakeData).enterPasword(pass_word).selectUserType(user_type)
				.clickOnSaveBtn();
//	  login.enterPasswordOnPasswordField(password);
//	  login.clickOnLoginButton();
//	  
//	  AdminUsersPage adminUser = new AdminUsersPage(driver);
//	 // adminUser.clickAdminUsrMenu();
//	  adminUser.clickNewUserBtn();
//	  adminUser.enterUsername(usr);
//	  adminUser.enterPasword(pass_word);
//	  adminUser.selectUserType(user_type);
//	  adminUser.clickOnSaveBtn();
		boolean alert = adminUsersPage.warningMesageDisplayed();
		Assert.assertTrue(alert, Constant.ALERTS_MISSING);

	}

	@Test(description = "Verify whether user is able to search any user")
	public void searchAnyUser() throws IOException {

		String loginUsername = ExcelUtility.getStringData(0, 0, "LoginPage");
		String loginpaswd = ExcelUtility.getStringData(0, 1, "LoginPage");

		String searchUsername = ExcelUtility.getStringData(1, 0, "AdminUsers");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(loginUsername).enterPasswordOnPasswordField(loginpaswd);
		homePage = login.clickOnLoginButton();
		adminUsersPage = homePage.clickAdminUsrMenu();
		adminUsersPage.clickSearchUserBtn().enterUserNameForSearch(searchUsername).clickOnSearchBtnAction();

//	  login.enterPasswordOnPasswordField(loginpaswd);
//	  login.clickOnLoginButton();

		// AdminUsersPage admin = new AdminUsersPage(driver);
		// admin.clickAdminUsrMenu();
//	  admin.clickSearchUserBtn();
//	  admin.enterUserNameForSearch(searchUsername);
//	  admin.clickOnSearchBtnAction();

		String expected = ".........RESULT NOT FOUND.......";
		String actual = adminUsersPage.getTableValue();
		System.out.println(actual);

		boolean showResults = true;
		if (actual.equals(expected)) {
			showResults = false;
			Assert.assertFalse(showResults, Constant.VALUES_FETCHED);
		} else {
			Assert.assertTrue(showResults, Constant.VALUES_NOT_FETCHED);
		}

	}

	@Test(description = "Verify whether user is able to search a user by passing an argument or parameter in  method")
	public void searchAnyUserMethodWithArgument(String usernameToBeSearched) throws IOException {
		String loginUsername = ExcelUtility.getStringData(0, 0, "LoginPage");
		String loginPassword = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(loginUsername).enterPasswordOnPasswordField(loginPassword);
		homePage = loginPage.clickOnLoginButton();
		adminUsersPage = homePage.clickAdminUsrMenu();
		adminUsersPage.clickSearchUserBtn().enterUserNameForSearch(usernameToBeSearched).clickOnSearchBtnAction();
		String expectedRes = usernameToBeSearched;
		String actualRes = adminUsersPage.getTableValue();
		boolean found = false;
		if (expectedRes.equals(actualRes)) {
			found = true;
			Assert.assertTrue(found, "Data is not found");
		} else {
			Assert.assertFalse(found, "Expected data displayed");
		}

	}
}
