

import java.util.List;
import java.util.Map;

import org.objectrepo.Addproduct;
import org.objectrepo.Commonpage;
import org.objectrepo.Productmodule;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org_salesandinventory_genericutility.Baseclass;
import org_salesandinventory_genericutility.IConstantpath;

public class NewproductTest extends Baseclass
{
	//new work1
	@Test
	public void main() 
	{
//		getDataFromExcel ex = new getDataFromExcel();
//		Fileutility fi=new Fileutility();
//		Webdriverutility web=new Webdriverutility();         
//		String url = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "url");
//		String browser = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "browser1");
//		String username = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "username");
//		String password = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "password");
		//String time = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "time");
	//  WebDriver driver = wd.openbrowsewithappliation(browser,10, url);
//		 Addcustomer add = new Addcustomer(driver);
//		Loginpage login = new Loginpage(driver);
//		Commonpage com = new Commonpage(driver);
//        login.loginAction(username, password);		
		/*driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();*/
//		web.alertpopup();
		Addproduct pro = new Addproduct(driver);
//		String productcode=ex.excelutility(IConstantpath.excel_path,"product module", 0,1);
//		String name =ex.excelutility(IConstantpath.excel_path,"product module", 1,1);
//		String description= ex.excelutility(IConstantpath.excel_path,"product module", 2,1);
//		String quantity=ex.excelutility(IConstantpath.excel_path,"product module", 3,1);
//		String onhand=ex.excelutility(IConstantpath.excel_path,"product module", 4,1);
//		String price= ex.excelutility(IConstantpath.excel_path,"product module", 5,1);
		String selectcategory=ex.excelutility(IConstantpath.excel_path,"product module", 6,1);		
		System.out.println(selectcategory);
		String selectsupplier =ex.excelutility(IConstantpath.excel_path,"product module", 7,1);
		String datestock= ex.excelutility(IConstantpath.excel_path,"product module", 8,1);
		Map<String, String> data = ex.getDataFromExcelInMap("product module");
		System.out.println(data);
		//product module
		Productmodule promodule = new Productmodule(driver);
		promodule.productModulebutton();
		//driver1.findElement(By.xpath("//span[text()='Product']")).click();
		//driver1.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();		
		// add product	
		//String text = driver.findElement(By.xpath("//h5[text()='Add Product']")).getText();
	    String text1 = pro.addproductgettext();	
//	assertEquals(text1, "Add Product");		
pro.addProduct(data.get("product code"), data.get("name"), data.get("description"), data.get("quantity"), data.get("on hand"), data.get("price"));
		//driver1.findElement(By.xpath("//input[@placeholder='Product Code']")).sendKeys(productcode);
		//driver1.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		//driver1.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys(description);
		//driver1.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys(quantity);
		//driver1.findElement(By.xpath("//input[@placeholder='On Hand']")).sendKeys(onhand);
		//driver1.findElement(By.xpath("//input[@name='price']")).sendKeys(price);
		
	    //WebElement dropdown = driver1.findElement(By.xpath("//select[@name='category']"));
	    WebElement dropdown = pro.category();
		//dropdown.click();
	    pro.clickCategory();
		web.selectclass(dropdown, selectcategory);		
		 WebElement dropdown1 = pro.supplier1();
		//WebElement dropdown1 = driver1.findElement(By.xpath("//select[@name='supplier']"));
		pro.clicksupplier1();
		dropdown.click();
		web.selectclass(dropdown1, selectsupplier);		
		pro.calander1();
		//WebElement clander = driver1.findElement(By.xpath("//input[@placeholder='Date Stock In']"));
		pro.clickcalender1();
		//clander.click();
		//clander.sendKeys(datestock);
		pro.calender1(datestock);		
		pro.submitbutton();
		//driver1.findElement(By.xpath("//h5[.='Add Product']/following::button[@type='submit']")).click();		
		String text = promodule.getTableText();		
		//String txt = driver1.findElement(By.xpath("//li[@class='paginate_button page-item '][last()]/a")).getText();
		int c = Integer.parseInt(text);
		System.out.println(c);
		int count=0;		 
	for(int i=1;i<c;i++) 			
		{
	//List<WebElement> ele = driver1.findElements(By.xpath("//th[text()='Name']/ancestor::thead/following-sibling::tbody//td[2]"));
	    List<WebElement> ele = promodule.tablelist();
	   for(WebElement a:ele)
	    {
	    	System.out.print(a.getText());
	    	
	    	if(a.getText().equalsIgnoreCase("bike"));
	    	{
	    		System.out.println("Tc is pass");
				count++;
				break;
	    	}
	    }    
	   if(count==1) {
			break;
	   }
	    	//driver1.findElement(By.xpath("//a[text()='Next']")).click();
	   promodule.tableNextButton();
	    }
    	
	   if(count==0)
	   {
			System.out.println("TC is Fail");
	   }
	   Commonpage profile = new Commonpage(driver);  
	   
		//profile.Profilelogout();	   
	   /*driver1.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	   driver1.findElement(By.xpath("//a[@class='dropdown-item']/following::a[@class='dropdown-item']")).click();
	   driver1.findElement(By.xpath("//a[text()='Logout']")).click();*/
	   
	   //admin login
       
//     login.loginAction(Username, Password);
	    
	   /*driver1.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver1.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver1.findElement(By.xpath("//button[contains(@type,'submit')]")).click();*/
//		web.alertpopup();
		 promodule.pospage();
		//driver.findElement(By.xpath("//span[text()='POS']")).click();
		//driver.findElement(By.xpath("//a[text()='Keyboard']")).click();
		//String productname = "bike";
		//String productcategory = "keyboard";	
		//driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		 
		//WebElement dropdown11=driver.findElement(By.xpath("//select[@name='customer']"));
		 promodule.selectecustomerdropdown(promodule.customerdd(),"admin reddy");
		/*dropdown11.click();
		web.slectclass(dropdown11, "admin reddy");*/	 
		promodule.submitbutton("150000");
//		driver.findElement(By.xpath("//button[text()='SUBMIT']")).click();
//		driver.findElement(By.xpath("//input[@name='cash']")).sendKeys("150000");
//		driver.findElement(By.xpath("//button[text()='PROCEED TO PAYMENT']")).click();
		
		web.alertpopup();
		
//	Commonpage Profile = new Commonpage(driver);
	    com.Profilelogout();
		/*profile.logoutapplication1(
		profile.logoutpop();*/
	/*String productname = "bike";
		String productcategory = "keyboard";	
		driver.findElement(By.xpath("//a[text()='Mouse']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='row']/following::h6[.='"+productname+"']/ancestor::div[@id='"+productcategory+"']"));
		String product = ele1.getText();
		String[] str=product.split("\n");
		if(str[0].toString().equalsIgnoreCase(productname))
		{
			System.out.println("TEstCAse is pass");
		}
		else
		{
			System.out.println("TC IS FAIL");*/
		}	
	}
		

