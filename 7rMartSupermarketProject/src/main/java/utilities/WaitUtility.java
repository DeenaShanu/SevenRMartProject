package utilities;

import java.time.Duration; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	//public WebDriver driver;
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public void waitForElementToBeSelected(WebDriver driver,WebElement element) {
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		
	}
	public void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
	public void textToBePresentInElement(WebDriver driver, WebElement element,String text) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void waitForAlertIsPresent(WebDriver driver) {
		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
}
