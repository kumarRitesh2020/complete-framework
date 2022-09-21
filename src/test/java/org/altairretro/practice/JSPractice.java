package org.altairretro.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPractice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		driver.manage().window().maximize();
		webDriverUtility.jsInitialization(driver);
		webDriverUtility.openApplicationUsingJS("https://www.makemytrip.com");
		//webDriverUtility.sendKeysUsingJS(null, null);
		//webDriverUtility.sendKeysUsingJS(null, null);
		//webDriverUtility.clickUsingJS(null);
		webDriverUtility.scrollTillElementUsingJS(driver.findElement(By.xpath("//p[text()='About the Site']")));
	}

}
