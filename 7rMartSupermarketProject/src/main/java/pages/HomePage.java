package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item dropdown']")
	private WebElement usrNameLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logOutBtn;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	private WebElement adminUsersMenu;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subCategoryModule;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[3]")
	private WebElement manageProductTile;

	public HomePage clickUsernameLink() {
		usrNameLink.click();
		return this;
	}

	public HomePage clickLogOutBtn() {
		logOutBtn.click();
		return this; // since redirecting to same HomePage
	}

	public AdminUsersPage clickAdminUsrMenu() {
		adminUsersMenu.click();
		return new AdminUsersPage(driver); // since redirecting to AdminUsersPage
	}

	public ManageNewsPage clickManageNews() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}

//	public SubCategoryPage clickOnSubCategoryModule() {
//		subCategoryModule.click();
//		return new SubCategoryPage(driver);
//	}
	public ManageProductPage clickManageProductTile() {
		manageProductTile.click();
		return new ManageProductPage(driver);

	}
}
