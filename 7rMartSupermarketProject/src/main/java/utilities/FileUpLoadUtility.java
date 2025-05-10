package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUpLoadUtility {

	public void sendKeysForFileUpload(WebElement element, String path) {
		element.sendKeys(path);
	}

	public void robotClassForFileUpload(WebElement element, String path) throws AWTException {
		StringSelection selection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);// copy to clipboard
		Robot robot = new Robot();

		robot.delay(1000);

		// for pasting file--
		robot.keyPress(KeyEvent.VK_CONTROL);// VK-virtual Keys
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER); // to upload
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
