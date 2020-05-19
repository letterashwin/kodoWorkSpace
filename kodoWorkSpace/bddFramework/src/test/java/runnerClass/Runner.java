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
	
	
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	Reporter.setSystemInfo("User Name", "ASHWIN PT");
	Reporter.setSystemInfo("Application Name", "Test App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	
	}
	
	
	
//	public static void writeExtentReport() {
//		Reporter.loadXMLConfig("G:/eclipseWorkspace/KodoGit/kodoWorkSpace/kodoWorkSpace/bddFramework/src/test/resources/extent-config.xml");
//		
//		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
//	     Reporter.setSystemInfo("Selenium", "3.7.0");
//	     Reporter.setSystemInfo("Maven", "3.5.2");
//	     Reporter.setSystemInfo("Java Version", "1.8.0_151");
//		
//	}
	}

//plugin={"com.cucumber.listner.ExtentCucumberFormatter:target/cucumber-html-report/report.html"}ss
//plugin={"html:target/cucumber-html-report"}
//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}