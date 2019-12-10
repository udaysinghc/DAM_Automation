package com.IB.cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/features/",
	    glue="stepDefinations",
	    tags = "@test and not @ignore",
	    plugin = {"pretty","html:target/report/cucumber","json:target/report/json/login.json"})
public class TestRunner extends AbstractTestNGCucumberTests  {
	
}