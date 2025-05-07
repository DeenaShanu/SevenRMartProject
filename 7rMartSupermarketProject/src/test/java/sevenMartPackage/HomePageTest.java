package sevenMartPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	
	public HomePage homePage;
	
  @Test(description="Verify whether user is able to go to HomePage and do log out" , retryAnalyzer = retry.Retry.class)
  public void goToHomePageAndLogOut() throws IOException {
	  
	  String username = ExcelUtility.getStringData(0, 0, "LoginPage"); 
	  String passwrd =  ExcelUtility.getStringData(0, 1, "LoginPage");
	  
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(passwrd);
	  homePage = login.clickOnLoginButton();
	  homePage.clickUsernameLink().clickLogOutBtn();
//	  login.enterPasswordOnPasswordField(passwrd);
//	  login.clickOnLoginButton();
//	  
//	  HomePage home = new HomePage(driver);
//	  home.clickUsernameLink();
//	  home.clickLogOutBtn();
	  String expected = "Login | 7rmart supermarket";
	  String actual = driver.getTitle();
	//  System.out.println("actual--" + actual);
	  Assert.assertEquals(expected, actual,Constant.ERR_MSG_WHEN_HOMEPAGE_TESTCASE_FAILS);
	  
  }
}
