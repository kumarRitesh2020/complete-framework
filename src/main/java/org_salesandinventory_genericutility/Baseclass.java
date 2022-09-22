package org_salesandinventory_genericutility;

import java.util.Random;

import org.objectrepo.Commonpage;
import org.objectrepo.Loginpage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Baseclass
{
	//changes in baseclass 
	protected  Loginpage login;
	protected String Username;
	protected String Password;
	protected String url;
	protected Commonpage com;
	protected WebDriver driver;
	protected Webdriverutility web;
	protected getDataFromExcel ex;
	protected int randomNumber;
	protected long random ;
	protected Fileutility file;
	protected Javautility jv;
	public static WebDriver sDriver;
	public static Javautility sJavautility;
	/**
 * intialize the all utility class
 * open the excel,propertyfile
 * read the common data
 * create the instance for browser(lunch browser)
 * maximize,implicite wait
 * open the applictaion
 * intailize the javaexecutor,action,webdriver
 * create the instance for coomon object repo
 * @throws Ioexceoption.
 */
	@BeforeClass
	public void setupApp()
	{
		//create instance for the Generic Utility

		web = new Webdriverutility();
		file = new Fileutility();
		jv = new Javautility();
		ex=new getDataFromExcel();
		
		//intiallize the property file and excelfile
		ex.openExcelpage(IConstantpath.excel_path);
		file.intializePropertyFile(IConstantpath.PROPERTY_FILE_PATH);
		String Time = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "time" );
		String url=file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "url" );
		String browser = file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "browser" );
		Username=file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "username" );
		Password=file.getDataFromProperty(IConstantpath.PROPERTY_FILE_PATH, "password" );
		
		//fetch the data from property file
		url=file.getDataFromPropertyAfterIntialize("url");
		String browser1 = file.getDataFromPropertyAfterIntialize("browser");
		
		//launching the browser and doing some browser setting
		driver = web.openbrowsewithappliation(browser1, 15, url);
		sDriver=driver;
		
		//create object for common pom repo
		login=new Loginpage(driver);
		com = new Commonpage(driver);
	}
	// login to the application
	/**
	 * when ever we create the testscrpit class for module and test annotation method for testcase
	 * create the insurance for browser(launch browser)
	 * maximize, implicit wait
	 * intailize jsexcutor,actions,webdriverwait
	 * create the instance for common object repo (driver)
	 */
	@BeforeMethod
	public void methodSetup()
	{
	   login.loginAction(Username, Password);
	   web.alertpopup();
	}
	
	@AfterMethod
	public void methodTearDown() 
	{
		// logout from the application
		
		com.Profilelogout();
		
	//save the data into 
		ex.saveData(IConstantpath.excel_path);	
	}
	
	@AfterClass
	public void clastearDown()
	{
		web.closeBrowser(driver);
		ex.closeExcelBook();
	
	{
	
		driver.quit();
	}
	   
	}
	 
		
	}
	 






