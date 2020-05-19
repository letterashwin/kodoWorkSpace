package utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Log;
import com.cucumber.listener.Reporter;

import rootClass.Rootclass;

public class ActionsClass extends Rootclass{
	
	
	Utility ut = new  Utility();
	
	
	public String getText(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return ele.getText();
	}

	// Get attribute for the web element
	public String getAttribute(String attribute, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return ele.getAttribute(attribute);
	}

	// Verify the element is enable and displayed
	
	/**
	* Returns an Image object that can then be painted on the screen. 
	* The url argument must specify an absolute <a href="#{@link}">{@link URL}</a>. The name
	* argument is a specifier that is relative to the url argument. 
	* <p>
	* This method always returns immediately, whether or not the 
	* image exists. When this applet attempts to draw the image on
	* the screen, the data will be loaded. The graphics primitives 
	* that draw the image will incrementally paint on the screen. 
	*
	* @param  url  an absolute URL giving the base location of the image
	* @param  name the location of the image, relative to the url argument
	* @return      the image at the specified URL
	* @see         Image
	*/

	public boolean isEnbleAndDisplay(WebElement ele) {
		
		boolean status = false;
		try {
			WebDriverWait wait=new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			if (ele.isDisplayed() && ele.isEnabled()) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println("Element is not enabled and displayed");
		}

		return status;
	}

	public void clickOnElement(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	public void javascriptClick(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public List<String> getTheListOfStringFromFindElements(String xpath) {
		List<String> list = new ArrayList<String>();
		List<WebElement> we = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < we.size(); i++) {
			list.add(we.get(i).getText());
		}
		return list;
	}

	// Switch to child window

	public void switchToChildWindow() {

		String parentWindow = driver.getWindowHandle();
		for (String s : driver.getWindowHandles()) {
			if (!s.equals(parentWindow)) {
				driver.switchTo().window(s);
			}
		}
	}
	
	public void launchUrl() {
		driver.get(ut.readProperty("url", "config"));

//		try {
//			driver.get(ut.readProperty("url", "config"));
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
	}
	
	
	



}