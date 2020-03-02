package package1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * wait for element status based on visibility
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementStatus(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * wait for page title based on availability
	 * 
	 * @param driver
	 * @param title
	 */

	public void waitForPageTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * wait for element to load
	 * 
	 * @param driver
	 */

	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * used to select the content of the dropdown based on text
	 * 
	 * @param element
	 * @param text
	 */

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to select the content of the dropdown based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to select the content of the dropdown based on value
	 * @param value
	 * @param element
	 */
	public void select(String value,WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * used to take mouse cursor on the element
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();;
	}
	/**
	 * used to hold the webelement by mouse
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * used to move the pointer of range slider 
	 * @param driver
	 * @param element
	 * @param xoffset
	 * @param yoffset
	 */
	public void rangeSlider(WebDriver driver, WebElement element,int xoffset,int yoffset) {
		Actions act = new Actions(driver);
		clickAndHold(driver,element);
		act.moveByOffset(xoffset, yoffset).perform();
	}
/**
 * used to move the webelement from one place to another place
 * @param driver
 * @param source
 * @param target
 */
	public void dragAndDrop(WebDriver driver, WebElement source,WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
		
	}
	/**
	 * used to swiitch to any window based on pagetitle
	 * 
	 * @param driver
	 * @param pageTitle
	 */

	public void switchToNewTab(WebDriver driver, String pageTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String actualTitle = driver.getTitle();
			if (actualTitle.contains(pageTitle))
			{
				break;
			}

		}

	}

	/**
	 * used to click ok on alert
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to click dismiss on alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	

}
