package Spice.Jet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SpiceJet {
	
	
	@Test
	public void flight() throws InterruptedException
	{
		
		String currentDir = System.getProperty("user.dir");
		
		System.out.println(currentDir);
		
		System.setProperty("webdriver.chrome.driver", currentDir+"\\Drivers\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	driver.manage().deleteAllCookies();
	
	driver.get("https://www.spicejet.com");
	
 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
// WebElement ele6= driver.findElement(By.xpath("//a[@value='BLR']"));
	WebDriverWait wait=new WebDriverWait(driver,6000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@value='BLR']")))).click();
	
	
	driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
	List<WebElement> ele= driver.findElements(By.xpath("//a[@class='ui-state-default']"));
     int count=ele.size();
     
     for(int i=0;i<count;i++) {
    	 String text=driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).getText();
    	 if(text.equalsIgnoreCase("2"))
    	 {
    		 driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).click();
    		 
    		 break;
    	 }
     }
    	 
     driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
     WebElement ele1=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']"));
     ele1.click();
         Select s=new Select(ele1);
         s.selectByIndex(3);

        WebElement ele2= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        ele2.click();
        Select s1=new Select(ele2);
        s1.selectByIndex(3);
	
	List<WebElement> ele3= driver.findElements(By.xpath("//input[@type='checkbox']"));
	int sizeofChecklist=ele3.size();
	
	System.out.println(sizeofChecklist);
	
	 WebElement ele4=driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
	
	if(ele4.isDisplayed()&&ele4.isEnabled()) {
		
		ele4.click();
		
		
	}
	
	
	System.out.println(ele4.isSelected());
	
	
	}

}
