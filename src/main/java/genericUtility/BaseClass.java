package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sdet40.objectRepositiry.CommonPage;
import org.sdet40.objectRepositiry.CustomerPage;
import org.sdet40.objectRepositiry.LoginPage;
import org.sdet40.objectRepositiry.ProductAddPage;
import org.sdet40.objectRepositiry.SupplierAddPage;
import org.sdet40.objectRepositiry.TabNames;
import org.sdet40.objectRepositiry.UserAccountPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass
{
	
	protected String username;
	protected String password;
	protected WebDriver driver;
	protected WebDriverUtility webDriverUtility;
	protected LoginPage lp;
	protected CommonPage cp;
	protected ProductAddPage p;
	protected ExcelUtility excelUtility;
	protected	int randomNumber;
	protected FileUtility fileUtility;
	protected JavaUtility javaUtility; 
	private CustomerPage c;
	protected UserAccountPage u;
	protected SupplierAddPage sap;
	public static WebDriver sdriver;
	 public static JavaUtility sjavaUtility;

	//changes done in base class
		
		/**
		 * Initialize the all utility class
		 * open the excel,property file
		 * read the common data
		 * create the instance for browser(launch browser)
		 * maximize,implicit wait
		 * open the application
		 * initialize jsexecutor,actions,webdriverwait
		 * create the instance for common object repo
		 * @throws IOException 
		 */
	   
		@BeforeClass
		public void classSetUp() throws IOException {
			//create the instance for the Generic Utility
			
		    excelUtility=new ExcelUtility();
		    fileUtility=new FileUtility();
		    javaUtility=new JavaUtility();
		    sjavaUtility=javaUtility;
		    webDriverUtility=new WebDriverUtility();
			
			//initialize the property file and excel file
			fileUtility.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
			excelUtility.openExcel(IConstantPath.EXCEL_PATH);
			
			//fetch data from property file
			 String browser=fileUtility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");
			 String url=fileUtility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
			  username=fileUtility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
			  password=fileUtility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
			 String timeouts=fileUtility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"timeout");
			 
			
			 
			//convert string to long
			long longTimeout=(long) javaUtility.convertStringtoAnyDatatype(timeouts, DataType.LONG);
			
			//launching browser and doing some browser setting
			 driver=webDriverUtility.openBrowserWithApplication(browser, longTimeout, url);
			 sdriver=driver;
			 webDriverUtility.jsInitialization(driver);
			 
			 
			 
			 //create object for common pom repo
			  lp=new LoginPage(driver);
			 cp=new CommonPage(driver);
			 p=new ProductAddPage(driver);
			 u=new UserAccountPage(driver);
			 sap=new SupplierAddPage(driver);
	}
		
		//login to the application
		/**
		 * 
		 */
		
		@BeforeMethod
		public void methodSetUp() 
		{
			lp.loginAction(username, password);
		}
			
			@AfterMethod
			public void methodTearDown() 
			{
			//	logout from the application
				cp.logoutlink(webDriverUtility);
			}
			
			
}

		
		


