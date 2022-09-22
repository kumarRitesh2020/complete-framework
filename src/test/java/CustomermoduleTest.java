

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomermoduleTest {
	
public static void main(String[]args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/index.php");
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("unguardable");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
	driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	
	
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//span[text()='Customer']")).click();
	driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("reddy");
	driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9738500604");
	driver.findElement(By.xpath("//i[@class='fa fa-check fa-fw'][1]")).click();
	
	driver.findElement(By.xpath("//a[@type='button'][contains(.,'...')][1]")).click();
	driver.findElement(By.xpath("(//a[@type='button'])[4]")).click();
	
	WebElement ele=driver.findElement(By.xpath("//input[contains(@value,'admin')]"));
	ele.sendKeys(Keys.CONTROL+"a");
	ele.sendKeys("admin rakesh");
	
	WebElement ele1=driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')][1]"));
	ele1.sendKeys(Keys.CONTROL+"a");
	ele1.sendKeys("admin reddy");
	

	WebElement ele2=driver.findElement(By.xpath("//input[@value='9738500604']"));
	ele2.sendKeys(Keys.CONTROL+"a");
	ele2.sendKeys("9535998817");
	
	driver.findElement(By.xpath("//button[@class='btn btn-warning btn-block']")).click();
	
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//*[@id=\"dataTable_paginate\"]/ul/li[8]/a")).click();
	//driver.findElement(By.xpath("//[@id="dataTable_paginate\"]/ul/li[8]/a")).click();
	String txt =driver.findElement(By.xpath("//*[@id=\"dataTable_paginate\"]/ul/li[8]/a")).getText();
	int c = Integer.parseInt(txt);
	System.out.println(c);
	for(int i=1;i<c;i++) 
	{
		driver.findElement(By.xpath("//a[text()='Next']")).click();
		List<WebElement> ele3 = driver.findElements(By.xpath("//table//th[text()='Last Name']/ancestor::thead/following-sibling::tbody//td[2]"));
    for(WebElement a:ele3)   
{
    	System.out.println(a.getText());
    	if(a.getText().equalsIgnoreCase("admin reddy"))
    	{
    		
    		System.out.println("Tc is pass");
break;
    	}
    }
    }

}


}
