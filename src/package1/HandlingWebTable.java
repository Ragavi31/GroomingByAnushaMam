package package1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingWebTable 
{
@Test
public void verify()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Drm%26ogbl&osid=1&service=mail&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	WebElement userNmTxBx =	driver.findElement(By.xpath("//input[@name='identifier']"));
	userNmTxBx.clear();
	userNmTxBx.sendKeys("ragavivenkatt@gmail.com");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	WebElement pwdTxBx = driver.findElement(By.xpath("//input[@name='password']"));
	pwdTxBx.clear();
	pwdTxBx.sendKeys("91biomedical");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.findElement(By.xpath("//div[text()='Social']")).click();
	List<WebElement> lists = driver.findElements(By.xpath("//table[@id=':nb']//tr/td[5]"));
	for(int i=0;i<lists.size();i++)
	{
		 
	}
}

}
