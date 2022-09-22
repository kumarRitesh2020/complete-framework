package org.objectrepo;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import bsh.This;

public class Addcustomer {

	//private static final String String = null;
    @FindBy(xpath = "//span[text()='Customer']")
    private WebElement customertab;
    
    @FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
    private WebElement plusebutton;
    
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement firstname1;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastname1;
	
	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement phonenumber1;
	
	@FindBy(xpath = "//i[@class='fa fa-check fa-fw'][1]")
	private WebElement savebutton;	
	
	@FindBy(xpath = "//a[@type='button'][contains(.,'...')][1]")
	private WebElement detailbutton;
	
	@FindBy(xpath = "(//a[@type='button'])[4]")
	private WebElement editbutton;
	
	@FindBy(xpath = "//input[contains(@value,'admin')]")
	private WebElement updatefirstname;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Last Name')][1]")
	private WebElement updatelastname;
	
	
	@FindBy(xpath = "//input[@value='9738500604']")
	private WebElement updatephoneno;
	
	@FindBy(xpath = "//button[@class='btn btn-warning btn-block']")
	private WebElement saveupdate;
   
	@FindBy(xpath="//li[@class='paginate_button page-item '][last()]/a")
	private WebElement table;
	
	@FindBy(xpath="//table//th[text()='Last Name']/ancestor::thead/following-sibling::tbody//td[2]")
	private List<WebElement> tablelist;
	
	@FindBy(xpath="//a[text()='Next']")
	private WebElement nextbutton;

public Addcustomer(WebDriver driver)
{
	PageFactory.initElements(driver,this);	
}
public void createCustomer(String firstname,String Lastname ,String phonenumber )
{
	firstname1.sendKeys(firstname);
	lastname1.sendKeys(Lastname);
	phonenumber1.sendKeys(phonenumber);	
	savebutton.click();
	
}
public void clickOnDetailButton()
{
	detailbutton.click();
}
 public void clickOnEditButton()
 {
	 editbutton.click();
 }
 public void updateCustomer(String firstname,String lastname,String phoneno)
 {
	updatefirstname.sendKeys(Keys.CONTROL+ "a");
	updatefirstname.sendKeys(firstname);
	updatelastname.sendKeys(Keys.CONTROL+ "a");
	updatelastname.sendKeys(lastname);
	updatephoneno.sendKeys(Keys.CONTROL+ "a");
	updatephoneno.sendKeys(phoneno);
	saveupdate.click();
	
 }
 public String getTabletext()
 {
	 String tabletxt=table.getText();
	 return tabletxt;
 }
 public List<WebElement> tableList() {
	 return tablelist;
 }
 public void nextclick()
 {
	 nextbutton.click();
 }
   
 public void customertab() 
 {
	 customertab.click();
	 plusebutton.click();
 }
 
 
 }
  

	



