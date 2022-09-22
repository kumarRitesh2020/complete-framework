package org_salesandinventory_genericutility;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.lang.model.element.Element;
import javax.swing.JScrollBar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.github.dockerjava.api.model.Driver;
import com.google.common.io.Files;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Admin
 *
 */
public class Webdriverutility {
	JavascriptExecutor js;
	SoftAssert soft;
	Javautility java;
    
	WebDriver driver;
    
	/**
	 * 
	 * @param browser
	 * @return
	 */
public WebDriver launchBrowser(String browser) {
	
	
	switch (browser) 
	{
	case "chrome" :
	
	    WebDriverManager.chromedriver().setup();// method chaining
	    driver=new ChromeDriver();//Abstraction
	     break;
	     
	case "firefox":
	WebDriverManager.chromedriver().setup();
	new FirefoxDriver();
	break;
	
	case "ie":
	WebDriverManager.iedriver().setup();
	driver=new InternetExplorerDriver();
	break;
	}
		return driver;
		
		
	}
	
/**
 * this method is used to  maximizeBrowser 
 * @param driver
 */
	
	public void maximizeBrowser (WebDriver driver)	{
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to wait the controller implicitly till load
	 * @param driver
	 * @param i
	 */
	public void waitTillpageload(WebDriver driver,long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
	}
		/**
		 * this method use to open the application
		 * @param driver
		 * @param url
		 */
	public void navigateApplication(WebDriver driver,String url) 
	{
	driver.get(url);	
	}
	
	/**
	 * 
	 * @param browser
	 * @param i
	 * @param url
	 * @return
	 */
	public WebDriver openbrowsewithappliation(String browser,long time,String url) {
		launchBrowser(browser);
		maximizeBrowser(driver);
		waitTillpageload(driver,time);
		navigateApplication(driver, url);
		return driver;
		
	}

	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mousehoverAction(WebDriver driver,WebElement element) {
		
		new Actions(driver).moveToElement(element).perform();
	}
		
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver,WebElement element) {
		new Actions(driver).doubleClick(element).perform();
		
	}
	/**
	 * 
	 * @param driver
	 */
	public void  closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public void selectclass(WebElement element, String selection) 
	{
		Select s=new Select(element);
		s.selectByVisibleText(selection);
	}
	 
	public void alertpopup() {
		
	
	driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
public void intailizeJavascriptExecutor(WebDriver driver) 
{	
        js = (JavascriptExecutor) driver;

}
/**
 * 
 * @param url
 */
public void launchApplication(String url) 
{
 js.executeScript("argument[0].value=argument[1]", url);
}
	/**
	 * 
	 * @param element
	 * @param data
	 */
public void sendkeysUsingJS(WebElement element,String data) 
{
	js.executeAsyncScript("argument[0].value=argument[1]",element, data);
	
}
/**
 * 
 * @param element
 */
public void clickUsingJS(WebElement element) 
{
	js.executeScript("argument[0].value=argument[1]",element);
	
}
/**
 * 
 * @param element
 */
public void scrollTillElementUsingJS(WebElement element) 
{
	js.executeScript("argument[0].value=argument[1]",element);
	
}
public void alertaAccpet() 
{
	driver.switchTo().alert().accept();
}

public void toPerformVerficationByAssertEquals(String r,String g)

{
	Assert.assertEquals(r, g);
	
}
public void toPerformVerficationByAssertNotEquals(String d,String e)
{
	Assert.assertNotEquals(d, e);
}

public void verifyWebPage(WebElement element,String expectedText,WebDriver driver,WebElement element1)
{

	for(;;)
	{
		try {
			Assert.assertEquals(element.getText(), expectedText);
			break;
		}
		catch(Exception e)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element1));
		}
	}

}
     public void softAssertIntiallize()
     {
    	 soft = new SoftAssert();
     }
     public void compareBySsoftAssert(String e,String f)
     {
    	 assertEquals(e, f);
     }
     
     public void softAssertAll()
     {
    	soft.assertAll();

     }
     
     public void screenShot(WebDriver driver,Javautility javautility,String className)
     {
       String currentTime = java.currentTime();
       TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
      File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
		try {
			Files.copy(dst, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
		 public String screenShot(WebDriver driver)
		 {
			 TakesScreenshot ts = (TakesScreenshot)driver;
		        String src = ts.getScreenshotAs(OutputType.BASE64);
		        return  src;
		 }
      public void closeBrowser()
      {
    	  driver.quit();
      }
     
}






