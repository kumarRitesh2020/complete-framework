
package org.altairretro.practice;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.objectRepositiry.CommonPage;
import org.sdet40.objectRepositiry.CustomerPage;
import org.sdet40.objectRepositiry.LoginPage;
import org.sdet40.objectRepositiry.ProductAddPage;
import org.sdet40.objectRepositiry.TabNames;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DataType;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.IConstantPath;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class CustomerTest extends BaseClass {

	@Test
	public void CustomerADDAction() throws EncryptedDocumentException, IOException, InterruptedException {

		// fetching the data from Excel file

		String customer = excelUtility.getDataFromExcelInKey("Customer", "FIRSTNAME");
		String LastName = excelUtility.getDataFromExcelInKey("Customer", "LASTNAME");
		String phone = excelUtility.getDataFromExcelInKey("Customer", "MOBILE");
		
		webDriverUtility.handlePopup(driver);
		cp.clickRequiredTab(TabNames.CUSTOMER, webDriverUtility);
		Thread.sleep(3000);

		CustomerPage c = new CustomerPage(driver);
		c.customerAction(customer, phone, LastName);
		

		String customertext = c.CustomerText();
		System.out.println(customertext);
		assertEquals(customertext, "Customer ");
		
        String er= c.AddCustomerText();
        System.out.println(er);
        assertEquals(er, er);
        
		
		

	}

}
