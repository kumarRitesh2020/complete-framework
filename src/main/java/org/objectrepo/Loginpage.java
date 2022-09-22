package org.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	@FindBy(xpath = "//input[@placeholder='Username']")
	private  WebElement usernametextfield;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordtextfield;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement loginbutton;
	
	//intaialzation
	
	public  Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//bussiness library
	

public  void loginAction(String username,String password )
{
	
	usernametextfield.sendKeys(username);
	passwordtextfield.sendKeys(password);
	loginbutton.click();
	
}
	
}
