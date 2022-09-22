package org.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import bsh.This;
import org_salesandinventory_genericutility.Fileutility;

public class Addproduct {

	@FindBy(xpath = "//span[text()='Product']")
	private WebElement producttab;
	
	@FindBy(xpath = "//h5[text()='Add Product']")
	private WebElement addproductgettext;
	
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement plusebutton;
	
	@FindBy(xpath = "//input[@placeholder='Product Code']")
	private WebElement productcode1;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement name1;
	
	@FindBy(xpath = "//textarea[@placeholder='Description']")
	private WebElement Description1;
	
	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement Quantity1;
	
	@FindBy(xpath = "//input[@placeholder='On Hand']")
	private WebElement onhand1;
	
	@FindBy(xpath = "//input[@name='price']")
	private WebElement price1;
	
	@FindBy(xpath = "//select[@name='category']")
	private WebElement category1;
	
	@FindBy(xpath = "//select[@name='supplier']")
	private WebElement supplier1;
	
	@FindBy(xpath = "//input[@placeholder='Date Stock In']")
	private WebElement calander1;
	
	@FindBy(xpath = "//h5[.='Add Product']/following::button[@type='submit']")
	private WebElement submit1;
	
	public Addproduct(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
	}
	  
	public void addProduct(String productcode,String name, String Description, String Quantity,String onhand,String price) 
	{
		productcode1.sendKeys(productcode);
		name1.sendKeys(name);
		Description1.sendKeys(Description);
		Quantity1.sendKeys(Quantity);
		onhand1.sendKeys(onhand);
		price1.sendKeys(price);
		
		
	}
	
	public WebElement category() 
	{
		 return category1;
		 
}
	public void clickCategory()
	{
		 category1.click();
	}
	
public  WebElement supplier1()

{
	return supplier1;
}
		
	public void clicksupplier1()
	{
		supplier1.click();
	}
	
	
	public WebElement calander1() 
	{
		return calander1;
	}
	  
	public void clickcalender1() 
	{

		calander1.click();
	}
	public void calender1(String datestock )
	{
		calander1.sendKeys(datestock);
	}
	
	public void  submitbutton()
	{
		submit1.click();
	}
	
	public String addproductgettext()
	{
		return(addproductgettext.getText());
		
	}
}
	 
 