package org.sdet40.objectRepositiry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class SupplierAddPage {
	
	
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	
	@FindBy(xpath="//a[@data-target='#supplierModal']")
	private WebElement SupplierCompanyAdd;
	
	@FindBy(xpath="//div[@class='form-group']/child::input[@placeholder='Company Name']")
	private WebElement SupplierCompanyName;
	
	@FindBy(xpath="//h5[text()='Add Supplier']/ancestor::div[@class='modal-content']/descendant::select[@id='province']")
	private WebElement SupplierSelectProvince;
	
	
	@FindBy(xpath="//h5[text()='Add Supplier']/ancestor::div[@class='modal-content']/descendant::select[@id='city']")
	private WebElement SupplierSelectCity;
	
	@FindBy(xpath="//form[@action='sup_transac.php?action=add']//input[@placeholder='Phone Number']")
	private WebElement SupplierPhoneNumber;
	
	@FindBy(xpath="//form[@action='sup_transac.php?action=add']//button[@type='submit'][normalize-space()='Save']")
	private WebElement SupplierSave;
	
	@FindBy(xpath="//h4[@class='m-2 font-weight-bold text-primary']")
	private WebElement suppliertext;
	
	
	public SupplierAddPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//business library
	
	
	public void supplierCompany() {
		SupplierCompanyAdd.click();
	}
			public void supplierPageAction(String sn) {
				SupplierCompanyName.sendKeys(sn);
				
			}
			
			public void selectSupplierProvince(String sup)
			{
				SupplierSelectProvince.click();
				 webDriverUtility.select(SupplierSelectProvince, sup);
			}
			
			
             public void selectSupplierCity(String sc) {
				
            	 SupplierSelectCity.click();
				webDriverUtility.select(SupplierSelectCity, sc);
				
			}
				
             public void supplierPhoneNumber(String phn)
             {
            	 SupplierPhoneNumber.sendKeys(phn);
             }
             public void saveSupplier() {
					SupplierSave.click();
				}
			
             public String SupplierText() {
            	 String t=suppliertext.getText();
            	 return t;
             }
	

}
