package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class fetch 
{
	public static void main(String[] args) throws IOException
	{
	FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");	
	Properties prop=new Properties();
	prop.load(fis);
	
	String url=prop.getProperty("url").trim();
	String browser=prop.getProperty("browser").trim();
	String username=prop.getProperty("username").trim();
	String password=prop.getProperty("password").trim();
	
	System.out.println(url);
	System.out.println(browser);
	System.out.println(username);
	System.out.println(password);
	
	String key="webdriver.chrome.driver";
	String value="C:\\Users\\User\\Downloads\\browser\\chromedriver.exe";
  	System.setProperty(key, value);
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.findElement(By.name("user")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Alert alt=driver.switchTo().alert();
	alt.accept();
	/*driver.findElement(By.xpath("//span[text()='Accounts']")).click();
	driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
	WebElement nameList=driver.findElement(By.name("empid"));
	nameList.click();
	Select s=new Select(nameList);
	s.selectByIndex(6);
	driver.findElement(By.xpath("//div[@class='form-group']/input[@name='username']")).sendKeys("test");
	driver.findElement(By.xpath("//div[@class='form-group']/input[@name='password']")).sendKeys("test");
	driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
	driver.findElement(By.xpath("//*[@id=\"userDropdown\"]/img")).click();*/
	
}
}
