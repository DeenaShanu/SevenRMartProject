package sevenMartPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductPageTest extends Base {
	public HomePage homePage;
	public ManageProductPage manageProductPage;

	@Test(description = "Verify whether user is able to search a product")
	public void searchProduct() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		String title = ExcelUtility.getStringData(0, 0, "ManageProductPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homePage = loginPage.clickOnLoginButton();
		manageProductPage = homePage.clickManageProductTile();
		manageProductPage.clickSearch().enterTitleForSearch(title).clickSearchAction();
//	  loginPage.enterPasswordOnPasswordField(password);
//	  loginPage.clickOnLoginButton();

//	  ManageProductPage manageProductPage = new ManageProductPage(driver);
//	  manageProductPage.clickManageProductTile();
//	  manageProductPage.clickSearch();
//	  manageProductPage.enterTitleForSearch(title);
//	  manageProductPage.clickSearchAction();
		boolean found = false;
		if (manageProductPage.getTableData().contains(title)) {
			found = true;
			System.out.println("Found data");
			Assert.assertTrue(found, Constant.DATA_IS_NOT_DISPLAYED);
		} else {
			System.out.println("NOt Found data");
			Assert.assertFalse(found, Constant.DATA_IS_NOT_DISPLAYED);
		}

	}
}
