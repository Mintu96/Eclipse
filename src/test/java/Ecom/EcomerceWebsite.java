package Ecom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EcomerceWebsite {

	@Test
public void flipkart()
{
	
	String currentdir=System.getProperty("user.dir");
	System.out.println(currentdir);
	System.setProperty("webdriver.chrome.driver", currentdir+"\\Drivers\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	
	
	driver.get("https://www.flipkart.com/");
	
	driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	WebElement ele1=driver.findElement(By.xpath("//span[text()='Electronics']"));
	
	Actions action=new Actions(driver);
	
	action.moveToElement(ele1).build().perform();
	driver.findElement(By.xpath("//a[@title='Apple']")).click();
	
	driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("iph");
	List<WebElement> ele3=driver.findElements(By.xpath("//li[@class='_1va75j']"));
	
	ele3.get(3).click();
	
	
	
}




}
