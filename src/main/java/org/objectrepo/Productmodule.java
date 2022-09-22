package org.objectrepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Productmodule { 
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Product']")
	private WebElement producttab;
	
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement plusebutton;
	
	@FindBy(xpath = "//li[@class='paginate_button page-item '][last()]/a")
	private WebElement  table;

	@FindBy(xpath = "/th[text()='Name']/ancestor::thead/following-sibling::tbody//td[2]")
	private List<WebElement>tablelist;
	
	@FindBy(xpath = "//a[text()='Next']")
	private WebElement tablenextbutton;
	// pos
	
	@FindBy(xpath = "//span[text()='POS']")
	private WebElement poslink;
	
	@FindBy(xpath = "//a[text()='Keyboard']")
	private WebElement keyboard;
	
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	private WebElement addbutton;
	
	@FindBy(xpath = "//select[@name='customer']")
	private WebElement selectecustomerdropdown;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitbutton;
	
	@FindBy(xpath = "//input[@name='cash']")
	private WebElement cash;
	
	@FindBy(xpath = "//button[text()='PROCEED TO PAYMENT']")
	private WebElement proceedpaymentbutton;
	

public Productmodule(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void productModulebutton()
{
	producttab.click();
	plusebutton.click();
}

public String getTableText()

{
	String tabletxt= table.getText();
	return tabletxt;
	
}
public List<WebElement> tablelist()
{
	return tablelist;
}

public void tableNextButton()
{
	tablenextbutton.click();
}

public void pospage()
{
	poslink.click();
	keyboard.click();
	addbutton.click();
	
}
public void selectecustomerdropdown(WebElement element,String customer)
{
  Select s= new Select(element);
  s.selectByVisibleText(customer);
}
public void paymentpage()
{
	submitbutton.click();
	cash.click();
	proceedpaymentbutton.click();
	
}
public WebElement customerdd()
{
	return selectecustomerdropdown;
}

public void submitbutton(String cash1)
{
	submitbutton.click();
	cash.sendKeys(cash1);
	proceedpaymentbutton.click();
	
}


}



