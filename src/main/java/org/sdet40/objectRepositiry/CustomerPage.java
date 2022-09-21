package org.sdet40.objectRepositiry;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CustomerPage {
	
	//declaration
	@FindBy(xpath="//a[@data-target='#customerModal']")
	private WebElement customerAddTab;

	@FindBy(xpath="//form[@action='cust_transac.php?action=add']//input[@placeholder='First Name']")
	private WebElement customerFirstName;
	@FindBy(xpath="//form[@action='cust_transac.php?action=add']//input[@placeholder='Last Name']")
	private WebElement customerLastName; 
	@FindBy(xpath="//form[@action='cust_transac.php?action=add']//input[@placeholder='Phone Number']")
	private WebElement contactNumber;
	@FindBy(xpath="//form[@action='cust_transac.php?action=add']//button[@type='submit'][normalize-space()='Save']")
    private WebElement contactSave;
	@FindBy(xpath="//h4[@class='m-2 font-weight-bold text-primary']")
	private WebElement customerText;
	@FindBy(xpath="(//h5[text()='Add Customer'])[1]")
	private WebElement addcustomertext;
	
	//initialization all element variable
		public CustomerPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//business library
		

		public void customerAction(String customer,String phone,String LastName) {
			
	         customerAddTab.click();
			 customerFirstName.sendKeys(customer);
			 customerLastName.sendKeys(LastName);
			 contactNumber .sendKeys(phone);
			 contactSave.click();
			
		}
		
		public String CustomerText()
		{
			String text = customerText.getText();
			return text;
		}
		
		public String AddCustomerText()
		{
			String act=addcustomertext.getText();
			return act;
		}

		
		
}
