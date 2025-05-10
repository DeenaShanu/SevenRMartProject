package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {

	public WebDriver driver;

	PageUtility pageUtility;

	WaitUtility waitUtility;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// moved this to HomePage for chaining of methods and classes
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")private
	// WebElement manageNews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement addnew_News;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	private WebElement enterNews;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement clickSearchBtn;
	@FindBy(xpath = "//input[@placeholder='Title']")
	private WebElement searchField;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[@data-dismiss='alert']")
	private WebElement alertMsg;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	private WebElement tableData;

//	public ManageNewsPage clickManageNews() {
//		manageNews.click();
//		return this;
//	}
	public ManageNewsPage clickOnAddNews() {
		waitUtility = new WaitUtility();
		waitUtility.waitForElementToBeClickable(driver, addnew_News);
		pageUtility = new PageUtility(driver);
		pageUtility.executeScript("arguments[0].click();", addnew_News, driver);
		// addnew_News.click();
		return this;

	}

	public ManageNewsPage enterNews(String news) {
		enterNews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickOnSaveNews() {
		saveBtn.click();
		return this;
	}

	public ManageNewsPage clickOnSearch() {
		clickSearchBtn.click();
		return this;
	}

	public ManageNewsPage enterNewsToBeSearched(String newsToSearch) {
		searchField.sendKeys(newsToSearch);
		return this;
	}

	public ManageNewsPage clickSearchAction() {
		searchBtn.click();
		return this;
	}

	public boolean isAlertCameonSaveNews() {
		return alertMsg.isDisplayed();
	}

	public String getTableValue() {
		return tableData.getText();

	}
}
