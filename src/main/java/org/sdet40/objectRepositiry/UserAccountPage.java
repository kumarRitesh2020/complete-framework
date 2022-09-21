package org.sdet40.objectRepositiry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class UserAccountPage {
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement AccountAddClick;
	
	@FindBy(name="empid")
	private WebElement SelectEmployee;
	
	@FindBy(xpath="//div[@class='form-group']/input[@name='username']")
	private WebElement AccountUserNameEnter;
	
	@FindBy(xpath="//div[@class='form-group']/input[@name='password']")
	private WebElement AccountPasswordEnter;
	
	@FindBy(xpath="(//button[@type='submit'])[5]")
	private WebElement AccountSave;
	
	@FindBy(xpath="(//h4[@class='m-2 font-weight-bold text-primary'])[2]")
	private WebElement UserAccountText;
	

	
	
	//initialization all element variable
		public UserAccountPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
		//business library
		public void accountPageAction(String una,String pa) {
			AccountAddClick.click();
			AccountUserNameEnter.sendKeys(una);
			AccountPasswordEnter.sendKeys(pa);
			
			
		}
		
		public void selectAccount(String customer) {
			
			webDriverUtility.select(SelectEmployee, customer);
			
		}
			public void saveAccount() {
				AccountSave.click();
			}
		
		public String userAccountValidate() {
			
			String t=UserAccountText.getText();
			return t;
		}
		
}
