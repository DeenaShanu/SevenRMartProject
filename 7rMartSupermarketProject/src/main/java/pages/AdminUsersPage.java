package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;
	PageUtility pageUtility = new PageUtility(driver);
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")private WebElement adminUsersMenu;
	@FindBy(xpath="//a[text()=' New']")private WebElement newUser;
	@FindBy(id="username")private WebElement usernameField;
	@FindBy(id="password")private WebElement paswdField;
	@FindBy(xpath="//select[@name='user_type']")private WebElement UserType;
	@FindBy(xpath="//button[@name='Create']")private WebElement saveBtn;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement searchUser;
	@FindBy(xpath="//input[@name='un']")private WebElement searchUsernme;
	@FindBy(xpath="//button[@name='Search']")private WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement warnignMessagePresent;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")private WebElement tableValue;
	
	
	public AdminUsersPage clickNewUserBtn() {
		newUser.click();
		return this;
	}
	public AdminUsersPage enterUsername(String user_name) {
		usernameField.sendKeys(user_name);
		return this;
	}
	public AdminUsersPage enterPasword(String paswd) {
		paswdField.sendKeys(paswd);
		return this;
	}
	public AdminUsersPage selectUserType(String usertype) {
		pageUtility.selectByVisibleText(UserType, usertype);
		return this;
	}
	public AdminUsersPage clickOnSaveBtn() {
		saveBtn.click();
		return this;
	}
	//search
	public AdminUsersPage clickSearchUserBtn() {
		searchUser.click();
		return this;
	}
	public AdminUsersPage enterUserNameForSearch(String usr) {
		searchUsernme.sendKeys(usr);
		return this;
	}
	public AdminUsersPage clickOnSearchBtnAction() {
		searchBtn.click();
		return this;
	}
	public boolean warningMesageDisplayed() {
		return warnignMessagePresent.isDisplayed();
	}
	public String getTableValue() {
		return tableValue.getText();
	}
}
