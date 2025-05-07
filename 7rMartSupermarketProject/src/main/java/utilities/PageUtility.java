package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public WebDriver driver;
	
	public PageUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectByVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void dragAndDrop(WebElement dragElement,WebElement dropElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(dragElement).click();
		actions.doubleClick(dragElement).perform();
		actions.dragAndDrop(dragElement, dropElement).build().perform();
	}
	public void executeScript(String script,WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(script, element);
		
	}
}
