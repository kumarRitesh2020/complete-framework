package genericUtility;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists all webdriver common actions
 * 
 * @author User
 *
 */

public class WebDriverUtility {
	WebDriver driver;

	/**
	 * This method is used to launch the browser
	 * 
	 * @return
	 * 
	 * 
	 */
	public WebDriver launchBrowser(String browser) {

		switch (browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("please enter valid browser");
			break;
		}
		return driver;

	}

	/**
	 * This method is used to maximize the browser
	 * 
	 * 
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait till page load
	 */
	public void waitTillPageLoad(WebDriver driver, Long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	public void waitTillElementVisible(WebDriver driver, Long longTimeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to open the application
	 * 
	 */
	public void navigateApplication(WebDriver driver, String url) {
		driver.get(url);
		/**
		 * This method is used to launch browser,Maximize browser,wait page
		 * implicitly,and navigate application.
		 */
	}

	public WebDriver openBrowserWithApplication(String browser, Long longTimeout, String url) {

		WebDriver driver = launchBrowser(browser);
		maximizeBrowser(driver);
		waitTillPageLoad(driver, longTimeout);
		navigateApplication(driver, url);

		return driver;
	}

	/**
	 * This method is used to do mouse hover action
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	/**
	 * This method is used to double click on webelement
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	/**
	 * This Method is used to close the Browser instances
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * This method is used to handle browser popup
	 */
	public void handlePopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used for handling drop down by visible text
	 */
	public void select(WebElement element, String text) {
		Select s1 = new Select(element);
		s1.selectByVisibleText(text);
	}

	/**
	 * This method is used for handling drop down by index
	 */
	public void select(WebElement element, int index) {
		Select s2 = new Select(element);
		s2.selectByIndex(index);

	}

	public String takeScreenshot(WebDriver driver, JavaUtility javaUtility, String className) {
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File("./screenshot/" + className + "_" + currentTime + ".PNG");
		try {
			Files.copy(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return desc.getAbsolutePath();
	}

	public String takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
		return tempPath;
	}

	private JavascriptExecutor jsExecutor;

	/**
	 * This method is used to handle through java script executor
	 */
	public void jsInitialization(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
	}

	public void openApplicationUsingJS(String url) {
		jsExecutor.executeScript("window.location=arguments[0]", url);
	}

	public void sendKeysUsingJS(WebElement element, String data) {
		jsExecutor.executeScript("arguments[0].value=arguments[1]", element, data);
	}

	public void clickUsingJS(WebElement element) {
		jsExecutor.executeScript("arguments[0].click()", element);

	}

	public void scrollTillElementUsingJS(WebElement Element) {
		jsExecutor.executeScript("arguments[0].scrollIntoView()", Element);

	}

	public WebElement convertDynamicXpathIntoWebElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;
	}

	/**
	 * This method is used to convert the dynamic xpath into By locator
	 * 
	 */
	public By convertDynamicXpathIntoByClass(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		By element = By.xpath(requiredXpath);
		return element;
	}

	/**
	 * This method is used for validating webpage
	 */

	public void verifyWebpage(WebElement element, WebDriver driver, long longTimeout, String expectedText) {
		for (;;) {
			try {
				Assert.assertEquals(element.getText(), expectedText);
				break;
			} catch (Exception e) {
				waitTillElementVisible(driver, longTimeout, element);
			}
		}
	}

	/**
	 * This method is used to verify result
	 */
	public void verifyResult(String actualresult, String expectedresult) {
		assertEquals(actualresult, expectedresult);
	}

	public void verifyResult(boolean condition) {
		assertTrue(condition);
	}
}
