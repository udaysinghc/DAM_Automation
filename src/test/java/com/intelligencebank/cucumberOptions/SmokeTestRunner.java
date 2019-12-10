package com.intelligencebank.cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/com/intelligencebank/features/",
		glue = {"com/intelligencebank/stepDefinitions/"},
		tags = "@smoke",
//		tags = "@runme",
	    plugin = {"pretty","html:target/report/cucumber","json:target/report/json/login.json", "unused:target/unused.log"})
public class SmokeTestRunner extends AbstractTestNGCucumberTests {
	
}