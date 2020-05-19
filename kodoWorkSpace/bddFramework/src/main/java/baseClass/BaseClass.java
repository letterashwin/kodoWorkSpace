package baseClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import rootClass.Rootclass;
import utility.Utility;

public class BaseClass extends Rootclass {
	
	Utility ut =new Utility();
	
	
	/**
	* Method:initialSetup() will initiate the Web-driver and launch browser for executing scripts
	* Browser name is parameterized from config.properties
	* @return      Void
	*/
	@Before	
	public void initialSetup() {
		System.out.println("initialSetup() is getting executed");
		String browserIE = ut.readProperty("ie", "config");
		String browserChrome = ut.readProperty("chrome", "config");
		String browserFirefox = ut.readProperty("firefox", "config");

		if (browserIE.equalsIgnoreCase("Yes")) {

			System.setProperty("webdriver.ie.driver", "src//test//resources//Drivers//IEDriverServer.exe");

			// Initialize browser
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		} else if (browserChrome.equalsIgnoreCase("Yes")) {
			System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");

			// Initialize browser
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		} else if (browserFirefox.equalsIgnoreCase("Yes")) {

			System.setProperty("webdriver.firefox.marionette", "src//test//resources//Drivers//geckodriver.exe");

			// Initialize browser
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
	}
	
	/**
	* Method:closeBrowser()  is used to close the browser after execution
	* @return     Void
	*/
	@After
	public void closeBrowser(){
		driver.close();
	}
	
	

}


