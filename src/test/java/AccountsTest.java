

import java.util.List;
import java.util.Map;

import org.objectrepo.AddAccounts;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import org_salesandinventory_genericutility.Baseclass;
import org_salesandinventory_genericutility.Fileutility;
import org_salesandinventory_genericutility.Webdriverutility;
import org_salesandinventory_genericutility.getDataFromExcel;

public class AccountsTest extends Baseclass
{
	//private Useracc ac;
	@Test
	public void addUserAccTest()
	{
		getDataFromExcel ex = new getDataFromExcel();
         	Fileutility fi=new Fileutility();
		Webdriverutility web=new Webdriverutility();
		 AddAccounts acc = new AddAccounts(driver);	  
		acc.userAccTab();
		String Admintext = acc.adminAcc();
		Assert.assertEquals(Admintext, "Admin Account(s)");
		acc.clickonadduser();
		Map<String, String> map = ex.getDataFromExcelInMap("acconts");
		acc.Empl();
		web.selectclass(acc.getEmpAddress(), map.get("Employee"));
		acc.us_name(map.get("Username"));
		acc.pass_name(map.get("userpasword"));
		acc.submitt();
		List<WebElement> elements = acc.lisoff();
		System.out.println(elements);
		int count = 0;
		for (WebElement ele : elements) {
			String eList = ele.getText();
			// System.out.println(eList);
			if (eList.equalsIgnoreCase(map.get("User_name"))) {
				System.out.println("TC is Passed");
				count++;
				break;
			}
			if (count == 1) {
				break;

			}
		}
		if (count == 0) {
			Assert.fail("user account is not present");
		}

	}



//		getDataFromExcel excel = new getDataFromExcel();
//		Fileutility fi=new Fileutility();
//		Webdriverutility wd=new Webdriverutility();
//
//		String url =fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH,"url");
//		String browser= fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH,"browser1");
//		String username =fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "username");
//		String password = fi.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "password");
//		WebDriver driver=wd.openbrowsewithappliation(browser, 20, url);  
//		
//		
//		Loginpage login = new Loginpage(driver);
//		Commonpage com = new Commonpage(driver);
//       login.loginAction(username, password);
//		
//		/*driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
//		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();*/
//
//	wd.alertpopup();
//		
//		
//		
//		
//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
//		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
//
//		wd.alertpopup();
//		driver.findElement(By.xpath("//span[text()='Accounts']")).click();
//		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
//		WebElement dropdown=driver.findElement(By.xpath("//select[@name='empid']"));
//		dropdown.click();
//		wd.slectclass(dropdown,"reddy, rakesh - Manager");
//		
//		driver.findElement(By.xpath("(//input[@placeholder='Username'])[2]")).sendKeys("rakesh");
//		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("raki");
//		driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
//		
//		
		
	
}

