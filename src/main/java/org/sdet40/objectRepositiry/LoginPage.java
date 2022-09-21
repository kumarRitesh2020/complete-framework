package org.sdet40.objectRepositiry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(name="user")
	private WebElement userNameTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginButton;
	
	//initialization all element variable
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business library
	public void loginAction(String username,String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}
	


}
