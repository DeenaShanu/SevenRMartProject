package sevenMartPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
public HomePage homePage;
public ManageNewsPage manageNewsPage;
	
  @Test(description="Verify whether user is able to add news in ManageNews module",retryAnalyzer = retry.Retry.class)
  public void addNewsInManageNewsModule() throws IOException {
	  String login_username = ExcelUtility.getStringData(0, 0, "LoginPage");
	  String login_paswd = ExcelUtility.getStringData(0, 1, "LoginPage");
	  String newsToEnter = ExcelUtility.getStringData(0, 0, "ManageNews");
	  
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField(login_username).enterPasswordOnPasswordField(login_paswd);
	  homePage = login.clickOnLoginButton();
	  manageNewsPage = homePage.clickManageNews();
	  manageNewsPage.clickOnAddNews().enterNews(newsToEnter).clickOnSaveNews();
	  
//	  login.enterPasswordOnPasswordField(login_paswd);
//	  login.clickOnLoginButton();
//	  
//	  ManageNewsPage news = new ManageNewsPage(driver);
//	  news.clickManageNews();
//	  news.clickOnAddNews();
//	  news.enterNews(newsToEnter);
//	  news.clickOnSaveNews();
	  Boolean alertPresent = manageNewsPage.isAlertCameonSaveNews();
	  Assert.assertTrue(alertPresent, Constant.ALERT_NOT_COMING);
	  
  }
  @Test(description="Verify whether user is able to search any news in ManageNews module")
  public void searchAnyNews() throws IOException {
	  String loginUsername = ExcelUtility.getStringData(0, 0, "LoginPage");
	  String loginPswd = ExcelUtility.getStringData(0, 1, "LoginPage");
	  
	  String searchNews = ExcelUtility.getStringData(0, 0, "ManageNews");
	  
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameOnUsernameField(loginUsername).enterPasswordOnPasswordField(loginPswd);
	  homePage = login.clickOnLoginButton();
	  manageNewsPage = homePage.clickManageNews();
	  manageNewsPage.clickOnSearch().enterNewsToBeSearched(searchNews).clickSearchAction();
	  String expectedNews = manageNewsPage.getTableValue();
	  System.out.println("Expected news--> " + expectedNews);
	  Assert.assertEquals(searchNews, expectedNews,Constant.DATA_IS_NOT_DISPLAYED);
//	  login.enterPasswordOnPasswordField(loginPswd);
//	  login.clickOnLoginButton();
//	  
//	  ManageNewsPage news = new ManageNewsPage(driver);
//	  news.clickManageNews();
//	  news.clickOnSearch();
//	  news.enterNewsToBeSearched(searchNews);
//	  news.clickSearchAction();
//	  
	  
	  
  }
}
