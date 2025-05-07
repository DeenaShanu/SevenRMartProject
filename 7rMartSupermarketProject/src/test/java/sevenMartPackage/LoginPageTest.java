package sevenMartPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base{
	
	public HomePage homePage;
  @Test(description="Verify whether user is able to login with valid credentials",priority=1,groups = {"SmokeTest"})
  public void verifyUserLoginWithValidCredentials() throws IOException {
	  
	  
	  String user_name = ExcelUtility.getStringData(0, 0, "LoginPage");
	  String pass_word = ExcelUtility.getStringData(0, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  //---chaining of methods done below
	  loginPage.enterUsernameOnUsernameField(user_name).enterPasswordOnPasswordField(pass_word);
	//  loginPage.enterPasswordOnPasswordField(pass_word);
	  //---chaining of class done here
	  homePage = loginPage.clickOnLoginButton();
	  boolean isHomePageLoaded = loginPage.isDashboardDisplayed();
	  Assert.assertTrue(isHomePageLoaded, Constant.ERR_MSG_FOR_VALID_CREDENTIALS_LOGIN_CLK);
	  System.out.println(driver.getTitle());//dashboard title
  }
  @Test(description="Verify whether user is able to login with Valid username and invalid paswrd",priority=2,groups = {"SmokeTest"})
  public void verifyUserLoginWithValidUsernameAndInvalidPaswd() throws IOException {
	  String username = ExcelUtility.getStringData(1, 0, "LoginPage");
	  String paswrd = ExcelUtility.getStringData(1, 1, "LoginPage");
	  
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(paswrd);
	  //loginPage.enterPasswordOnPasswordField(paswrd);
	  homePage = loginPage.clickOnLoginButton();
	  String actualLogintitle = driver.getTitle();
	  System.out.println("actualLogintitle--> " + actualLogintitle);
	  String expectedLoginTitle = "Dashboard | 7rmart supermarket";
	  Assert.assertNotSame(actualLogintitle, expectedLoginTitle,Constant.ERR_MSG_FOR_VLD_USR_INVLD_PSWD_LOGIN_CLK);
	  
  }
  @Test(description="Verify whether user is able to login with invalid username and valid paswd",priority=3)
  public void verifyUserLoginWithInvalidUsrnameAndValidPaswd() throws IOException {
	  String username = ExcelUtility.getStringData(2, 0, "LoginPage");
	  String pswrd = ExcelUtility.getStringData(2, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(pswrd);
	 // loginPage.enterPasswordOnPasswordField(pswrd);
	  
	  homePage = loginPage.clickOnLoginButton();
	  System.out.println("LoginPage url is " +  driver.getCurrentUrl());
	  String actualUrl = "https://groceryapp.uniqassosiates.com/admin/login";
	  Assert.assertEquals(actualUrl, driver.getCurrentUrl(), Constant.ERR_MSG_FOR_INVLD_USR_VLD_PSWD_LOGIN_CLK);
  }
  @Test(description="Verify whether user is able to login with invalid credentials",priority=4)
  public void verifyUserLoginWithInvalidCredentials() throws IOException {
	  String user_name = ExcelUtility.getStringData(3, 0, "LoginPage");
	  String passwrd = ExcelUtility.getStringData(3, 1, "LoginPage");
	  
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterUsernameOnUsernameField(user_name).enterPasswordOnPasswordField(passwrd);
	  //loginPage.enterPasswordOnPasswordField(passwrd);
	  homePage = loginPage.clickOnLoginButton();
	  boolean loginTitleNotAppear = false;
	  if (!driver.getTitle().equals("Login | 7rmart supermarket")) {
		  loginTitleNotAppear = true;
	  }
	  System.out.println(driver.getTitle());
	  Assert.assertFalse(loginTitleNotAppear, Constant.ERR_MSG_FOR_INVALID_CREDENTIALS_LOGIN_CLK);
  }
}
