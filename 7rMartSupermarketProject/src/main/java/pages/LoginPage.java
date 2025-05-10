package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	WaitUtility wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginBtn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashBoard;

	public LoginPage enterUsernameOnUsernameField(String userName) {
		username.sendKeys(userName);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String PassWord) {
		password.sendKeys(PassWord);
		return this;
	}

	public HomePage clickOnLoginButton() {
		wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, loginBtn);
		loginBtn.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashBoard.isDisplayed();
	}

}
