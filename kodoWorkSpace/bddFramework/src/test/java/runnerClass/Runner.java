package runnerClass;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "G:/eclipseWorkspace/KodoGit/kodoWorkSpace/kodoWorkSpace/bddFramework/src/test/resources",
glue = {"stepDefinition","baseClass"},
plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
)

public class Runner {
	
	/**
	* Method: ExtentReportsetup() is used to manage the Extent report attributes
	* @return  Void
	*/
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	Reporter.setSystemInfo("User Name", "ASHWIN PT");
	Reporter.setSystemInfo("Application Name", "http://automationpractice.com/index.php");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Test Environment");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	
	}

	}
