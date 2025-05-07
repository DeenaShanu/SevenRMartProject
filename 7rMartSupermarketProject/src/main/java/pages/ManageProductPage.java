package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	
	public WebDriver driver;
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement SearchBtn;
	@FindBy(xpath="//input[@placeholder='Title']")private WebElement titleField;
	@FindBy(xpath="//button[@name='Search']")private WebElement searchAction;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")private WebElement tabData;
	
	
	public ManageProductPage clickSearch() {
		SearchBtn.click();
		return this;
	}
	public ManageProductPage enterTitleForSearch(String title) {
		titleField.sendKeys(title);
		return this;
	}
	public ManageProductPage clickSearchAction() {
		searchAction.click();
		return this;
	}
	public String getTableData() {
		return tabData.getText();
	}

}
