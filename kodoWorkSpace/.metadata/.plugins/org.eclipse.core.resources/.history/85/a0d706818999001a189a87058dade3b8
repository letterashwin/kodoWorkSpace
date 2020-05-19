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
//Reporter reporter = new Reporter();
	
	
	
	@Before
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
	
	//@Before
	 public void beforeScenario(Scenario scenario) {
	     Reporter.assignAuthor("ASHWIN PT");
	 }
	
	@After
	public void closeBrowser(){
		driver.close();
	}
	
	

}


