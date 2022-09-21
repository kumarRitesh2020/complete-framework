package org.sdet40.objectRepositiry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CommonPage {
	
	WebDriver driver;
	//declaration
	private String dynamicXpath="//span[.='%s']"; 

	//	@FindBy(xpath="//span[text()='POS']")
//	private WebElement posTab;
	@FindBy(xpath="//img[@class='img-profile rounded-circle']")
	private  WebElement LogoutLink;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	private WebElement LogoutClick;
	
	@FindBy(linkText="Logout")
	private WebElement LogoutClick1;
	
//	@FindBy(xpath="//span[text()='Home']")
	// private WebElement HomepageTab;
	
//	@FindBy(xpath="//span[text()='Customer']")
	//private WebElement CustomerTab;
	
//	@FindBy(xpath="//span[text()='Employee']")
//	private WebElement EmployeeTab;
	
//	@FindBy(xpath="//span[text()='Product']")
//	private WebElement ProductTab;
	
//	@FindBy(xpath="//span[text()='Inventory']")
//	private WebElement InventoryTab;
	
//	@FindBy(xpath="//span[text()='Transaction']")
//	private WebElement TransactionTab;
	
//	@FindBy(xpath="//span[text()='Supplier']")
//	private WebElement SupplierTab;
	
//	@FindBy(xpath="//span[text()='Accounts']")
//	private WebElement AccountsTab;
	
	@FindBy(xpath="//button[@class='rounded-circle border-0']")
	private WebElement ArrowTab;
	
	@FindBy(xpath="//div[text()='Sales and Inventory System']")
	private WebElement SalesInventoryLogo;
	
	//initialization all element variable
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//business Library
	/**
	 * @return 
	 * 
	 */
	public WebElement clickRequiredTab(TabNames tabName,WebDriverUtility webDriverUtility){
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath, tabName.getTabName(), driver).click();
		return null;
	}
	{
		
	}
	
	
	//public void clickPosLink() {
	//	posTab.click();
	//}
	
	public void logoutlink(WebDriverUtility webDriverUtility) {
		LogoutLink.click();
		LogoutClick.click();
		LogoutClick1.click();
		
	}
	
	/*
	 * public void homepagetab() { HomepageTab.click(); }
	 * 
	 * public void customertab() { CustomerTab.click(); }
	 * 
	 * public void employeetab() { EmployeeTab.click(); }
	 * 
	 * public void producttab() { ProductTab.click(); }
	 * 
	 * public void inventorytab() { InventoryTab.click(); }
	 * 
	 * public void transactiontab() { TransactionTab.click(); }
	 * 
	 * public void suppliertab() { SupplierTab.click(); }
	 * 
	 * public void accounttab() { AccountsTab.click(); }
	 */
	
	public void arrowtab() {
         ArrowTab.click();
	}
	
	public void salesinventorylogo() {
		SalesInventoryLogo.click();
	}


}
