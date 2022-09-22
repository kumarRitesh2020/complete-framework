

import java.util.List;
import java.util.Map;

import org.objectrepo.Addcustomer;
import org.objectrepo.Commonpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org_salesandinventory_genericutility.Baseclass;

public class NewcustomerTest extends Baseclass 

{
	//code changes
	@Test
	public void main() {
		
		
		// getDataFromExcel ex = new getDataFromExcel();
//		Fileutility fi=new Fileutility();
//		Webdriverutility wd = new Webdriverutility();
//		String url = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "url");
//		String browser = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "browser1");
//		String username = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "username");
//		String password = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "password");
//		//String time = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "time");
//		WebDriver driver = wd.openbrowsewithappliation(browser,10, url);
		Addcustomer add = new Addcustomer(driver);
//		Loginpage login = new Loginpage(driver);
//		Commonpage com = new Commonpage(driver);
//   	login.loginAction(username, password);
		/*                                    
		 * driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(
		 * username);
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		 * driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		 */        
//		web.alertpopup();
		// create customer
		add.customertab();
//		driver.findElement(By.xpath("//span[text()='Customer']")).click();
//		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
//      
//		String firstname = ex.excelutility(IConstantpath.excel_path, "sales and inventory", 0, 1);
//		String lastname = ex.excelutility(IConstantpath.excel_path, "sales and inventory", 1, 1);
//		String phoneno = ex.excelutility(IConstantpath.excel_path, "sales and inventory", 2, 1);
		Map<String, String> data = ex.getDataFromExcelInMap("sales and inventory");
         System.out.println(data);
		add.createCustomer(data.get("first name"),data.get("last name"),data.get("phone no"));
		/*
		 * driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(
		 * firstname);
		 * driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(
		 * lastname);
		 * driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys
		 * (phoneno);
		 * driver.findElement(By.xpath("//i[@class='fa fa-check fa-fw'][1]")).click();
		 */
		/*
		 * driver.findElement(By.xpath("//a[@type='button'][contains(.,'...')][1]")).
		 * click(); driver.findElement(By.xpath("(//a[@type='button'])[4]")).click();
		 */
//		String firstName1 = ex.excelutility(IConstantpath.excel_path, "update customer", 0, 1);
//		String lastName2 = ex.excelutility(IConstantpath.excel_path, "update customer", 1, 1);
//		String phoneno3 = ex.excelutility(IConstantpath.excel_path, "update customer", 2, 1);      
		ex.getDataFromExcelInMap("update customer");
		System.out.println(data);		
		add.clickOnDetailButton();
		add.clickOnEditButton();
		add.updateCustomer(data.get("first name"),data.get("last name"), data.get("phone no"));
		// update customer
		/*
		 * WebElement
		 * ele=driver.findElement(By.xpath("//input[contains(@value,'admin')]"));
		 * ele.sendKeys(Keys.CONTROL+"a"); ele.sendKeys("firstname1");
		 * 
		 * WebElement ele1=driver.findElement(By.
		 * xpath("//input[contains(@placeholder,'Last Name')][1]"));
		 * ele1.sendKeys(Keys.CONTROL+"a"); ele1.sendKeys("lastname2");
		 * 
		 * 
		 * WebElement ele2=driver.findElement(By.xpath("//input[@value='9738500604']"));
		 * ele2.sendKeys(Keys.CONTROL+"a"); ele2.sendKeys("phoneno3");
		 * 
		 * driver.findElement(By.xpath("//button[@class='btn btn-warning btn-block']")).
		 * click();
		 */
		web.alertpopup();
		// driver.findElement(By.xpath("//*[@id=\"dataTable_paginate\"]/ul/li[8]/a")).click();
		// driver.findElement(By.xpath("//[@id="dataTable_paginate\"]/ul/li[8]/a")).click();
		// String txt
		// =driver.findElement(By.xpath("//*[@id=\"dataTable_paginate\"]/ul/li[8]/a")).getText();
		// validation in table
		// String txt =driver.findElement(By.xpath("//li[@class='paginate_button
		// page-item '][last()]/a")).getText();
		String txt = add.getTabletext();
		int c = Integer.parseInt(txt);
		System.out.println(c);
		int count = 0;
		for (int i = 1; i < c; i++) {
			// List<WebElement> ele3 = driver.findElements(By.xpath("//table//th[text()
			// ='Last Name']/ancestor::thead/following-sibling::tbody//td[2]"));
			List<WebElement> ele3 = add.tableList();
			for (WebElement a : ele3) {
				// System.out.println(a.getText());
				if (a.getText().equalsIgnoreCase("admin reddy")) {
					System.out.println("Tc is pass");
					count++;
					break;
				}
			}
			if (count == 1) {
				break;
			}
			add.nextclick();
			// driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		if (count == 0) {
			System.out.println("TC is Fail");			
		}
		Commonpage profile = new Commonpage(driver);
		profile.Profilelogout();	
		// profile.logoutpop();
	}
}
