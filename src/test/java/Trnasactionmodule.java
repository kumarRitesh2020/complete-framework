

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org_salesandinventory_genericutility.Fileutility;
import org_salesandinventory_genericutility.IConstantpath;
import org_salesandinventory_genericutility.Webdriverutility;


public class Trnasactionmodule {
	public static void main(String[]args) {

		//getDataFromExcel exc = new getDataFromExcel();
		Fileutility fi=new Fileutility();
		Webdriverutility wd=new Webdriverutility();
		
		String url =fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH,"url");
		String browser= fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "browser1");
		String username =fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "username");
		String password = fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "password");
		WebDriver driver=wd.openbrowsewithappliation(browser, 20, url); 
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

		wd.alertpopup();
		
		driver.findElement(By.xpath("//span[text()='Transaction']")).click();
		
		
	}
	
}

