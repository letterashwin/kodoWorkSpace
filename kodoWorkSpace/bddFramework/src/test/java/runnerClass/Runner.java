package runnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "G:/eclipseWorkspace/bddFramework/bddFramework/src/test/resources/feature", glue = {"stepDefinition"},plugin={"html:target/cucumber-html-report"})

public class Runner {
	
	}
