package sevenMartPackage;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {

	public HomePage homePage;
	public SubCategoryPage subCategoryPage;

	@Test(description = "Verify whether user is able to add a new Subcategory")
	public void addNewSubCategoryWithSendKeysFileUpLoadInSubCategoryModule() throws IOException {
		// sendKeysForFileUpload
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		String category = ExcelUtility.getStringData(1, 0, "CategoryPage");
		String subcategory = ExcelUtility.getStringData(1, 1, "CategoryPage");
		// String img = ExcelUtility.getStringData(1, 2, "CategoryPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();

		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategoryModule();
		subCategory.clickOnNewSubcategory();
		subCategory.selectCategory(category);
		subCategory.enterNewSubCategory("RADDUUUUD");

		subCategory.chooseImageWithSendKeys();

		subCategory.clickOnSaveBtn();
		boolean alertAppeared = subCategoryPage.alertComing();
		Assert.assertSame(true, alertAppeared, Constant.ALERT_NOT_COMING);

	}

	@Test(description = "Verify whether user is able to edit a subcategory details")
	public void editSubCategorywithSendKeysFileUpload() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();

		SubCategoryPage subCatPage = new SubCategoryPage(driver);
		subCatPage.clickOnSubCategoryModule();
		subCatPage.clickOnEditBtn();
		subCatPage.chooseImageWithSendKeys();
		subCatPage.clickOnUpdateBtn();

		// boolean alertPresent = subCategoryPage.updateAlertComing();
		// Assert.assertTrue(alertPresent, Constant.ALERT_NOT_COMING);

	}

	@Test(description = "Verify whether user able to add subCategory and file upload with robot class")
	public void addSubCategoryWithRobotClassFileUpload() throws IOException, AWTException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnLoginButton();

		String category = ExcelUtility.getStringData(1, 0, "CategoryPage");
		String subcategory = ExcelUtility.getStringData(1, 1, "CategoryPage");

		SubCategoryPage subCatPage = new SubCategoryPage(driver);
		subCatPage.clickOnSubCategoryModule();
		subCatPage.clickOnNewSubcategory();
		subCatPage.selectCategory(category);
		subCatPage.enterNewSubCategory("JUICE");
		// subCatPage.chooseImgBtRobot();
		subCatPage.chooseImageWithRobotClass();
		subCatPage.clickOnSaveBtn();
		// boolean alertPresent = subCategoryPage.updateAlertComing();
		// Assert.assertTrue(alertPresent, Constant.ALERT_NOT_COMING);
	}

	@Test(description = "Verify whether user is able to edit subcategory with robot class file upload")
	public void editSubCategoryWithRobotClassFileUpload() throws IOException, AWTException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String pasword = ExcelUtility.getStringData(0, 0, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(pasword);
		login.clickOnLoginButton();

		SubCategoryPage subCatPg = new SubCategoryPage(driver);
		subCatPg.clickOnSubCategoryModule();
		subCatPg.clickOnEditBtn();
		subCatPg.chooseImageWithRobotClassforEdit();
		// subCatPg.clickOnUpdateBtn();
		// boolean alertPresent = subCategoryPage.updateAlertComing();
		// Assert.assertTrue(alertPresent, Constant.ALERT_NOT_COMING);

	}

}
