package org.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;
//declartion


public class Commonpage {
 @FindBy(xpath = "//img[@class='img-profile rounded-circle']")
 private WebElement profile;
 @FindBy(xpath = "//a[@class='dropdown-item']/following::a[@class='dropdown-item']")
 private WebElement logout;
 
 @FindBy(xpath = "//a[text()='Logout']")
 private WebElement logoutpop;
 

 @FindBy(xpath = "//span[text()='Customer']")
	private WebElement customermodule;	 
 
 //intialization 
public Commonpage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);	 
 }

 public void Profilelogout() {
	 profile.click();
	 logout.click();
	logoutpop.click();
 }


}

	/*
	@FindBy(xpath = "//span[text()='Employee']")
	private WebElement Employeemodule;
	
	@FindBy(xpath = "//span[text()='Product']")
	private WebElement productmodule;
	
	@FindBy(xpath = "//span[text()='Inventory']")
	private WebElement Inventorymodule;
	
	@FindBy(xpath = "//span[text()='Transaction']")
	private WebElement Transactiomodule;
	
	@FindBy(xpath = "//span[text()='Supplier']")
	private WebElement Suppliermodule;*/
	

	

