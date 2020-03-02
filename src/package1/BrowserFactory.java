package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * 
 * @author Ragavi
 *
 */
public class BrowserFactory
{
	/**
	 * for getting browsers
	 * @param browserName
	 * @return
	 */
	public static WebDriver launchBrowser(String browserName)
	{
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver=new FirefoxDriver();
		}
		return driver;
		
	}

}
