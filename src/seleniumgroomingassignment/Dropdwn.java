package seleniumgroomingassignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdwn {
	WebDriver driver;

	@BeforeMethod
	public void config() {
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void duplicates() {

		WebElement drpDwn = driver.findElement(By.id("month"));
		Select sel = new Select(drpDwn);
		List<WebElement> lt = sel.getOptions();
		Set<WebElement> s = new HashSet<WebElement>(lt);
		Assert.assertEquals(lt.size(), s.size());
		Reporter.log("validated", true);
	}

	@Test
	public void sorting() {

		WebElement drpDwn = driver.findElement(By.id("month"));
		Select sel = new Select(drpDwn);
		List<WebElement> lt = sel.getOptions();
		List<String> actual = new ArrayList<>();
		for (int i = 0; i < lt.size(); i++) {
			actual.add(lt.get(i).getText());
		}
		Set<String> ts = new TreeSet<String>(actual);
		Assert.assertEquals(lt, ts);
		Reporter.log("sortedcollection", true);
	}

	@Test
	public void allElements() {

		WebElement drpDwn = driver.findElement(By.id("month"));
		Select sel = new Select(drpDwn);
		List<WebElement> options = sel.getOptions();
		List<String> actual = new ArrayList<>();
		for (int i = 0; i < options.size(); i++) {
			actual.add(options.get(i).getText());
		}
		List<String> expected = new ArrayList<String>();
		String[] a = { "Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" };
		for (String ele : a) {
			expected.add(ele);
		}
		Assert.assertEquals(actual, expected);
		Reporter.log("elements presence", true);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
