package org.sdet40.objectRepositiry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class ProductAddPage {
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	
	@FindBy(xpath="//span[text()='Product']") private WebElement clickOnProduct;
	@FindBy(xpath="//i[contains(@class,'fas fa-fw fa-plus')]") private WebElement addProduct;
	@FindBy(xpath="//input[@name='prodcode']") private WebElement productCode ;
	@FindBy(xpath="//input[@name='name']") private WebElement productName ;
	@FindBy(xpath="//textarea[@name='description']") private WebElement productDescription;
	@FindBy(xpath="//input[@name='quantity']") private WebElement productQuantity ;
	@FindBy(xpath="//input[@type='number' and @placeholder='On Hand']") private WebElement productOnHand;
	@FindBy(xpath="//h5[text()='Add Product']/following::input[@type='number' and @name='price']") private WebElement productPrice ;
	@FindBy(name="category") private  WebElement productSelectCategory;
	@FindBy(xpath="//select[@name='supplier']") private  WebElement productSelectSupplier;
	@FindBy(xpath="//input[@placeholder='Date Stock In']") private  WebElement productSelectDateOfStock;
	@FindBy(xpath="(//button[@type='submit'])[5]") private  WebElement productSaveClick;
	@FindBy(xpath="//h4[@class='m-2 font-weight-bold text-primary']")
	private WebElement producttext;


public ProductAddPage(WebDriver driver) {
	PageFactory.initElements(driver,this );
}

public void ProductPageAction(String productcode,String productname,String productdescription,String productquantity,String productonhand,String productprice,String productdateinstock ) {

	clickOnProduct.click();
	addProduct.click();
	productCode.sendKeys(productcode);
	productName.sendKeys(productname);
	productDescription.sendKeys(productdescription);
	productQuantity.sendKeys(productquantity);
	productOnHand.sendKeys(productonhand);
	productPrice.sendKeys(productprice);
	productSelectCategory.click();
	productSelectDateOfStock.click();
	productSelectDateOfStock.sendKeys(productdateinstock);
	

	

	
	

}
public void selectcat()

{
	webDriverUtility.select(productSelectCategory, "Others");
	webDriverUtility.select(productSelectSupplier,"Asus");
}

	
	public void saveAction()
	{
		productSaveClick.click();
	}
	
	public String ProductText() {
		String pt=producttext.getText();
		return pt;
	}
	
	

}
