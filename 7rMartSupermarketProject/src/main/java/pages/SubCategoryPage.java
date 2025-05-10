package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constant.Constant;
import utilities.FileUpLoadUtility;
import utilities.PageUtility;

public class SubCategoryPage {

	public WebDriver driver;

	PageUtility pageUtility = new PageUtility(driver);

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement SubCategoryModule;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	private WebElement newSubcategoryBtn;
	@FindBy(id = "cat_id")
	private WebElement selectCategory;
	@FindBy(id = "subcategory")
	private WebElement subCategory;

	@FindBy(id = "main_img")
	private WebElement image;
	@FindBy(xpath = "//input[@type='file']")
	private WebElement imageRobotEdit;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertPresent;

	// edit
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3701&page_ad=1']")
	private WebElement edit;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement updateAlert;

	public void clickOnSubCategoryModule() { // move to homePage class
		SubCategoryModule.click();
	}

	public void clickOnNewSubcategory() {
		newSubcategoryBtn.click();
		// return this;

	}

	public void selectCategory(String category) {
		pageUtility.selectByVisibleText(selectCategory, category);
//		Select select = new Select(selectCategory);
//		select.selectByVisibleText(category);
		// return this;
	}

	public void enterNewSubCategory(String subcategory) {
		subCategory.sendKeys(subcategory);
		// return this;
	}

	public void chooseImageWithSendKeys() {
		// image.sendKeys(imgSrc);
		FileUpLoadUtility fileUpload = new FileUpLoadUtility();
		fileUpload.sendKeysForFileUpload(image, Constant.IMGPATH);
		// return this;
	}

	public void chooseImageWithRobotClass() throws AWTException {

		pageUtility.executeScript("arguments[0].click();", image, driver);
		FileUpLoadUtility fileUpload = new FileUpLoadUtility();
		fileUpload.robotClassForFileUpload(image, Constant.IMGPATH);
		// return this;
	}

	public void chooseImageWithRobotClassforEdit() throws AWTException {

		pageUtility.executeScript("arguments[0].click();", image, driver);
		// imageRobotEdit.click();
		FileUpLoadUtility fileUpload = new FileUpLoadUtility();
		fileUpload.robotClassForFileUpload(image, Constant.IMGPATH);
		// return this;
	}

	public void clickOnSaveBtn() {
		saveBtn.click();
		// return this;
	}

	public boolean alertComing() {
		return alertPresent.isDisplayed();
	}

	public boolean updateAlertComing() {
		return updateAlert.isDisplayed();
	}

	public void clickOnEditBtn() {
		pageUtility.executeScript("arguments[0].click();", edit, driver);
		// edit.click();
		// return this;
	}

	public void clickOnUpdateBtn() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.executeScript("arguments[0].click();", updateBtn, driver);
		// updateBtn.click();
		// return this;
	}

}
