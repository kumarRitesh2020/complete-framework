package org.altairretro.practice;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.sdet40.objectRepositiry.TabNames;
import org.sdet40.objectRepositiry.UserAccountPage;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DataType;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.IConstantPath;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountAddTest extends BaseClass {
	@Test
	public void AccountAction() throws EncryptedDocumentException, IOException {

		// fetching the data from Excel file

		String customer = excelUtility.getDataFromExcelInKey("Account", "SELECTEMPLOYEE");
		String una = excelUtility.getDataFromExcelInKey("Account", "USERNAME");
     	String pa = excelUtility.getDataFromExcelInKey("Account", "PASSWORD");
		
		
		
		webDriverUtility.handlePopup(driver);
		UserAccountPage u=new UserAccountPage(driver);
		cp.clickRequiredTab(TabNames.ACCOUNTS, webDriverUtility);
		u.accountPageAction(una, pa);
		u.selectAccount(customer);
		u.saveAccount();
		
		
		String t=u.userAccountValidate();
		System.out.println(t);
		assertEquals(t, "User Accounts ");
		
		

	}
}
